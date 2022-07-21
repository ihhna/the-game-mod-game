
package net.mcreator.thegameofmodgame.item;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.thegameofmodgame.init.TheGameOfModGameModTabs;

public class CorruptedIngotItem extends Item {
	public CorruptedIngotItem() {
		super(new Item.Properties().tab(TheGameOfModGameModTabs.TAB_RESEARCHED).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
