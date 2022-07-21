
package net.mcreator.thegameofmodgame.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.thegameofmodgame.entity.FunctionalEntity;
import net.mcreator.thegameofmodgame.client.model.Modelcustom_model;

public class FunctionalRenderer extends MobRenderer<FunctionalEntity, Modelcustom_model<FunctionalEntity>> {
	public FunctionalRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcustom_model(context.bakeLayer(Modelcustom_model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(FunctionalEntity entity) {
		return new ResourceLocation("the_game_of_mod_game:textures/villagerskin.png");
	}
}
