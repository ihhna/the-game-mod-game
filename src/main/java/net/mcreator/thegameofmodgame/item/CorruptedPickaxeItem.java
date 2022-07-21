
package net.mcreator.thegameofmodgame.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.thegameofmodgame.init.TheGameOfModGameModTabs;
import net.mcreator.thegameofmodgame.init.TheGameOfModGameModItems;

public class CorruptedPickaxeItem extends PickaxeItem {
	public CorruptedPickaxeItem() {
		super(new Tier() {
			public int getUses() {
				return 250;
			}

			public float getSpeed() {
				return 6f;
			}

			public float getAttackDamageBonus() {
				return 0f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 14;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TheGameOfModGameModItems.CORRUPTED_INGOT.get()));
			}
		}, 1, -3f, new Item.Properties().tab(TheGameOfModGameModTabs.TAB_RESEARCHED));
	}
}
