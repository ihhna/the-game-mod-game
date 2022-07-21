
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thegameofmodgame.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.thegameofmodgame.client.model.Modelgeometry;
import net.mcreator.thegameofmodgame.client.model.Modelcustom_model;
import net.mcreator.thegameofmodgame.client.model.Modelcorcreeper;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TheGameOfModGameModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelcorcreeper.LAYER_LOCATION, Modelcorcreeper::createBodyLayer);
		event.registerLayerDefinition(Modelcustom_model.LAYER_LOCATION, Modelcustom_model::createBodyLayer);
		event.registerLayerDefinition(Modelgeometry.LAYER_LOCATION, Modelgeometry::createBodyLayer);
	}
}
