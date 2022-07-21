
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

import net.minecraft.world.level.biome.Biome;

import net.mcreator.thegameofmodgame.world.biome.TrapBiome;
import net.mcreator.thegameofmodgame.TheGameOfModGameMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheGameOfModGameModBiomes {
	public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, TheGameOfModGameMod.MODID);
	public static final RegistryObject<Biome> TRAP = REGISTRY.register("trap", () -> TrapBiome.createBiome());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			TrapBiome.init();
		});
	}
}
