package net.nwt.tilledtales.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class ShapedCrafting3x3Procedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, ItemStack item1, ItemStack item2, ItemStack item3, ItemStack item4, ItemStack item5, ItemStack item6, ItemStack item7, ItemStack item8, ItemStack item9) {
		ItemStack iSlot8 = ItemStack.EMPTY;
		ItemStack iSlot7 = ItemStack.EMPTY;
		ItemStack iStack1 = ItemStack.EMPTY;
		ItemStack iStack2 = ItemStack.EMPTY;
		ItemStack iStack3 = ItemStack.EMPTY;
		ItemStack iStack4 = ItemStack.EMPTY;
		ItemStack iStack5 = ItemStack.EMPTY;
		ItemStack iStack6 = ItemStack.EMPTY;
		ItemStack iStack7 = ItemStack.EMPTY;
		ItemStack iSlot0 = ItemStack.EMPTY;
		ItemStack iStack8 = ItemStack.EMPTY;
		ItemStack iStack9 = ItemStack.EMPTY;
		ItemStack iSlot2 = ItemStack.EMPTY;
		ItemStack iSlot1 = ItemStack.EMPTY;
		ItemStack iSlot4 = ItemStack.EMPTY;
		ItemStack iSlot3 = ItemStack.EMPTY;
		ItemStack iSlot6 = ItemStack.EMPTY;
		ItemStack iSlot5 = ItemStack.EMPTY;
		return (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == item1.getItem() && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == item2.getItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == item3.getItem() && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == item4.getItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == item5.getItem() && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == item6.getItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).copy()).getItem() == item7.getItem() && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).copy()).getItem() == item8.getItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 8).copy()).getItem() == item9.getItem();
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}