
package net.mcreator.thegameofmodgame.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.thegameofmodgame.entity.CorruptedCreeperEntity;
import net.mcreator.thegameofmodgame.client.model.Modelcorcreeper;

public class CorruptedCreeperRenderer extends MobRenderer<CorruptedCreeperEntity, Modelcorcreeper<CorruptedCreeperEntity>> {
	public CorruptedCreeperRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcorcreeper(context.bakeLayer(Modelcorcreeper.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CorruptedCreeperEntity entity) {
		return new ResourceLocation("the_game_of_mod_game:textures/entities/corcreeper.png");
	}
}
