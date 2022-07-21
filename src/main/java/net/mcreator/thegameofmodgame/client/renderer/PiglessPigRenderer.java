
package net.mcreator.thegameofmodgame.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.thegameofmodgame.entity.PiglessPigEntity;
import net.mcreator.thegameofmodgame.client.model.Modelgeometry;

public class PiglessPigRenderer extends MobRenderer<PiglessPigEntity, Modelgeometry<PiglessPigEntity>> {
	public PiglessPigRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgeometry(context.bakeLayer(Modelgeometry.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PiglessPigEntity entity) {
		return new ResourceLocation("the_game_of_mod_game:textures/pig.png");
	}
}
