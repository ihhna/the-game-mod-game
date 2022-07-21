
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thegameofmodgame.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.thegameofmodgame.entity.PiglessPigEntity;
import net.mcreator.thegameofmodgame.entity.FunctionalEntity;
import net.mcreator.thegameofmodgame.entity.CorruptedCreeperEntity;
import net.mcreator.thegameofmodgame.TheGameOfModGameMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheGameOfModGameModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, TheGameOfModGameMod.MODID);
	public static final RegistryObject<EntityType<CorruptedCreeperEntity>> CORRUPTED_CREEPER = register("corrupted_creeper",
			EntityType.Builder.<CorruptedCreeperEntity>of(CorruptedCreeperEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CorruptedCreeperEntity::new).fireImmune().sized(0.6f, 1.7f));
	public static final RegistryObject<EntityType<PiglessPigEntity>> PIGLESS_PIG = register("pigless_pig",
			EntityType.Builder.<PiglessPigEntity>of(PiglessPigEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PiglessPigEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<FunctionalEntity>> FUNCTIONAL = register("functional",
			EntityType.Builder.<FunctionalEntity>of(FunctionalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FunctionalEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			CorruptedCreeperEntity.init();
			PiglessPigEntity.init();
			FunctionalEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(CORRUPTED_CREEPER.get(), CorruptedCreeperEntity.createAttributes().build());
		event.put(PIGLESS_PIG.get(), PiglessPigEntity.createAttributes().build());
		event.put(FUNCTIONAL.get(), FunctionalEntity.createAttributes().build());
	}
}
