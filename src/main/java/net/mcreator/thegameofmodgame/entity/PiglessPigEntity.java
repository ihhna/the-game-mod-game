
package net.mcreator.thegameofmodgame.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.common.DungeonHooks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.thegameofmodgame.init.TheGameOfModGameModEntities;
import net.mcreator.thegameofmodgame.init.TheGameOfModGameModBlocks;

@Mod.EventBusSubscriber
public class PiglessPigEntity extends PathfinderMob {
	@SubscribeEvent
	public static void addLivingEntityToBiomes(BiomeLoadingEvent event) {
		event.getSpawns().getSpawner(MobCategory.CREATURE)
				.add(new MobSpawnSettings.SpawnerData(TheGameOfModGameModEntities.PIGLESS_PIG.get(), 20, 1, 2));
	}

	public PiglessPigEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TheGameOfModGameModEntities.PIGLESS_PIG.get(), world);
	}

	public PiglessPigEntity(EntityType<PiglessPigEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setCustomName(new TextComponent("driven by code and misery"));
		setCustomNameVisible(true);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return (double) (4.0 + entity.getBbWidth() * entity.getBbWidth());
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this).setAlertOthers());
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(TheGameOfModGameModBlocks.PIGLESS_HEAD.get()));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source.getDirectEntity() instanceof AbstractArrow)
			return false;
		if (source.getDirectEntity() instanceof Player)
			return false;
		if (source.getMsgId().equals("trident"))
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level.isClientSide());
		super.mobInteract(sourceentity, hand);
		sourceentity.startRiding(this);
		return retval;
	}

	@Override
	public void travel(Vec3 dir) {
		Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
		if (this.isVehicle()) {
			this.setYRot(entity.getYRot());
			this.yRotO = this.getYRot();
			this.setXRot(entity.getXRot() * 0.5F);
			this.setRot(this.getYRot(), this.getXRot());
			this.flyingSpeed = this.getSpeed() * 0.15F;
			this.yBodyRot = entity.getYRot();
			this.yHeadRot = entity.getYRot();
			this.maxUpStep = 1.0F;
			if (entity instanceof LivingEntity passenger) {
				this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
				float forward = passenger.zza;
				float strafe = passenger.xxa;
				super.travel(new Vec3(strafe, 0, forward));
			}
			this.animationSpeedOld = this.animationSpeed;
			double d1 = this.getX() - this.xo;
			double d0 = this.getZ() - this.zo;
			float f1 = (float) Math.sqrt(d1 * d1 + d0 * d0) * 4;
			if (f1 > 1.0F)
				f1 = 1.0F;
			this.animationSpeed += (f1 - this.animationSpeed) * 0.4F;
			this.animationPosition += this.animationSpeed;
			return;
		}
		this.maxUpStep = 0.5F;
		this.flyingSpeed = 0.02F;
		super.travel(dir);
	}

	public static void init() {
		SpawnPlacements.register(TheGameOfModGameModEntities.PIGLESS_PIG.get(), SpawnPlacements.Type.ON_GROUND,
				Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos,
						random) -> (world.getBlockState(pos.below()).getMaterial() == Material.GRASS && world.getRawBrightness(pos, 0) > 8));
		DungeonHooks.addDungeonMob(TheGameOfModGameModEntities.PIGLESS_PIG.get(), 180);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
