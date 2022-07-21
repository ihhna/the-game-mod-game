
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thegameofmodgame.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.thegameofmodgame.client.renderer.PiglessPigRenderer;
import net.mcreator.thegameofmodgame.client.renderer.FunctionalRenderer;
import net.mcreator.thegameofmodgame.client.renderer.CorruptedCreeperRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheGameOfModGameModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TheGameOfModGameModEntities.CORRUPTED_CREEPER.get(), CorruptedCreeperRenderer::new);
		event.registerEntityRenderer(TheGameOfModGameModEntities.PIGLESS_PIG.get(), PiglessPigRenderer::new);
		event.registerEntityRenderer(TheGameOfModGameModEntities.FUNCTIONAL.get(), FunctionalRenderer::new);
	}
}
