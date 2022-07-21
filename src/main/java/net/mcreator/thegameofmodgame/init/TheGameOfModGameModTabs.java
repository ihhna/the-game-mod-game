
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thegameofmodgame.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class TheGameOfModGameModTabs {
	public static CreativeModeTab TAB_RESEARCHED;

	public static void load() {
		TAB_RESEARCHED = new CreativeModeTab("tabresearched") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(TheGameOfModGameModBlocks.TYPE_1_WORLD_ABSTRACTION.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
