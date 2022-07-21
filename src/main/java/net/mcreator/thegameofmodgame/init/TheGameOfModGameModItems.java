
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thegameofmodgame.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.thegameofmodgame.item.YouShouldntBeHereItem;
import net.mcreator.thegameofmodgame.item.UnassignedItem;
import net.mcreator.thegameofmodgame.item.NonexistanceItem;
import net.mcreator.thegameofmodgame.item.CorruptedSwordItem;
import net.mcreator.thegameofmodgame.item.CorruptedShovelItem;
import net.mcreator.thegameofmodgame.item.CorruptedPickaxeItem;
import net.mcreator.thegameofmodgame.item.CorruptedIngotItem;
import net.mcreator.thegameofmodgame.item.CorruptedHoeItem;
import net.mcreator.thegameofmodgame.item.CorruptedAxeItem;
import net.mcreator.thegameofmodgame.item.CorruptedArmorItem;
import net.mcreator.thegameofmodgame.TheGameOfModGameMod;

public class TheGameOfModGameModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TheGameOfModGameMod.MODID);
	public static final RegistryObject<Item> TYPE_1_WORLD_ABSTRACTION = block(TheGameOfModGameModBlocks.TYPE_1_WORLD_ABSTRACTION,
			TheGameOfModGameModTabs.TAB_RESEARCHED);
	public static final RegistryObject<Item> TYPE_2_WORLD_ABSTRACTION = block(TheGameOfModGameModBlocks.TYPE_2_WORLD_ABSTRACTION,
			TheGameOfModGameModTabs.TAB_RESEARCHED);
	public static final RegistryObject<Item> TYPE_3_WORLD_ABSTRACTION = block(TheGameOfModGameModBlocks.TYPE_3_WORLD_ABSTRACTION,
			TheGameOfModGameModTabs.TAB_RESEARCHED);
	public static final RegistryObject<Item> NONEXISTANCE = REGISTRY.register("nonexistance", () -> new NonexistanceItem());
	public static final RegistryObject<Item> YOU_SHOULDNT_BE_HERE = REGISTRY.register("you_shouldnt_be_here", () -> new YouShouldntBeHereItem());
	public static final RegistryObject<Item> PURE_CORRUPTION = block(TheGameOfModGameModBlocks.PURE_CORRUPTION,
			TheGameOfModGameModTabs.TAB_RESEARCHED);
	public static final RegistryObject<Item> UNASSIGNED = REGISTRY.register("unassigned", () -> new UnassignedItem());
	public static final RegistryObject<Item> CORRUPTED_CREEPER = REGISTRY.register("corrupted_creeper_spawn_egg",
			() -> new ForgeSpawnEggItem(TheGameOfModGameModEntities.CORRUPTED_CREEPER, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> PIGLESS_PIG = REGISTRY.register("pigless_pig_spawn_egg",
			() -> new ForgeSpawnEggItem(TheGameOfModGameModEntities.PIGLESS_PIG, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> PIGLESS_HEAD = block(TheGameOfModGameModBlocks.PIGLESS_HEAD, TheGameOfModGameModTabs.TAB_RESEARCHED);
	public static final RegistryObject<Item> CORRUPTED_INGOT = REGISTRY.register("corrupted_ingot", () -> new CorruptedIngotItem());
	public static final RegistryObject<Item> CORRUPTED_ORE = block(TheGameOfModGameModBlocks.CORRUPTED_ORE, TheGameOfModGameModTabs.TAB_RESEARCHED);
	public static final RegistryObject<Item> CORRUPTED_BLOCK = block(TheGameOfModGameModBlocks.CORRUPTED_BLOCK,
			TheGameOfModGameModTabs.TAB_RESEARCHED);
	public static final RegistryObject<Item> CORRUPTED_PICKAXE = REGISTRY.register("corrupted_pickaxe", () -> new CorruptedPickaxeItem());
	public static final RegistryObject<Item> CORRUPTED_AXE = REGISTRY.register("corrupted_axe", () -> new CorruptedAxeItem());
	public static final RegistryObject<Item> CORRUPTED_SWORD = REGISTRY.register("corrupted_sword", () -> new CorruptedSwordItem());
	public static final RegistryObject<Item> CORRUPTED_SHOVEL = REGISTRY.register("corrupted_shovel", () -> new CorruptedShovelItem());
	public static final RegistryObject<Item> CORRUPTED_HOE = REGISTRY.register("corrupted_hoe", () -> new CorruptedHoeItem());
	public static final RegistryObject<Item> CORRUPTED_ARMOR_HELMET = REGISTRY.register("corrupted_armor_helmet",
			() -> new CorruptedArmorItem.Helmet());
	public static final RegistryObject<Item> CORRUPTED_ARMOR_CHESTPLATE = REGISTRY.register("corrupted_armor_chestplate",
			() -> new CorruptedArmorItem.Chestplate());
	public static final RegistryObject<Item> CORRUPTED_ARMOR_LEGGINGS = REGISTRY.register("corrupted_armor_leggings",
			() -> new CorruptedArmorItem.Leggings());
	public static final RegistryObject<Item> CORRUPTED_ARMOR_BOOTS = REGISTRY.register("corrupted_armor_boots", () -> new CorruptedArmorItem.Boots());
	public static final RegistryObject<Item> FUNCTIONAL = REGISTRY.register("functional_spawn_egg",
			() -> new ForgeSpawnEggItem(TheGameOfModGameModEntities.FUNCTIONAL, -1, -1,
					new Item.Properties().tab(TheGameOfModGameModTabs.TAB_RESEARCHED)));

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
