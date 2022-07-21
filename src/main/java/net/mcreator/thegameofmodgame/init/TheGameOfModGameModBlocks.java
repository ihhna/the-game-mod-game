
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thegameofmodgame.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.thegameofmodgame.block.YouShouldntBeHerePortalBlock;
import net.mcreator.thegameofmodgame.block.Type3WorldAbstractionBlock;
import net.mcreator.thegameofmodgame.block.Type2WorldAbstractionBlock;
import net.mcreator.thegameofmodgame.block.Type1WorldAbstractionBlock;
import net.mcreator.thegameofmodgame.block.PureCorruptionBlock;
import net.mcreator.thegameofmodgame.block.PiglessHeadBlock;
import net.mcreator.thegameofmodgame.block.CorruptedOreBlock;
import net.mcreator.thegameofmodgame.block.CorruptedBlockBlock;
import net.mcreator.thegameofmodgame.TheGameOfModGameMod;

public class TheGameOfModGameModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TheGameOfModGameMod.MODID);
	public static final RegistryObject<Block> TYPE_1_WORLD_ABSTRACTION = REGISTRY.register("type_1_world_abstraction",
			() -> new Type1WorldAbstractionBlock());
	public static final RegistryObject<Block> TYPE_2_WORLD_ABSTRACTION = REGISTRY.register("type_2_world_abstraction",
			() -> new Type2WorldAbstractionBlock());
	public static final RegistryObject<Block> TYPE_3_WORLD_ABSTRACTION = REGISTRY.register("type_3_world_abstraction",
			() -> new Type3WorldAbstractionBlock());
	public static final RegistryObject<Block> YOU_SHOULDNT_BE_HERE_PORTAL = REGISTRY.register("you_shouldnt_be_here_portal",
			() -> new YouShouldntBeHerePortalBlock());
	public static final RegistryObject<Block> PURE_CORRUPTION = REGISTRY.register("pure_corruption", () -> new PureCorruptionBlock());
	public static final RegistryObject<Block> PIGLESS_HEAD = REGISTRY.register("pigless_head", () -> new PiglessHeadBlock());
	public static final RegistryObject<Block> CORRUPTED_ORE = REGISTRY.register("corrupted_ore", () -> new CorruptedOreBlock());
	public static final RegistryObject<Block> CORRUPTED_BLOCK = REGISTRY.register("corrupted_block", () -> new CorruptedBlockBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			Type1WorldAbstractionBlock.registerRenderLayer();
		}
	}
}
