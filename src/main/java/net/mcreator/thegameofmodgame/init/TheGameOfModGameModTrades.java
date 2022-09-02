
/*
*    MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.thegameofmodgame.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TheGameOfModGameModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.LIBRARIAN) {
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(TheGameOfModGameModItems.UNASSIGNED.get(), 2),

					new ItemStack(TheGameOfModGameModItems.NONEXISTANCE.get()), 10, 5, 0.05f));
		}
	}
}
