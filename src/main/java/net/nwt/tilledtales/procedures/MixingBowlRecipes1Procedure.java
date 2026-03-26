package net.nwt.tilledtales.procedures;

import net.nwt.tilledtales.init.TilledTalesModItems;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class MixingBowlRecipes1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack iStack1 = ItemStack.EMPTY;
		ItemStack iStack2 = ItemStack.EMPTY;
		ItemStack iStack3 = ItemStack.EMPTY;
		ItemStack iStack4 = ItemStack.EMPTY;
		ItemStack iStack5 = ItemStack.EMPTY;
		ItemStack iStack6 = ItemStack.EMPTY;
		ItemStack iStack7 = ItemStack.EMPTY;
		ItemStack iStack8 = ItemStack.EMPTY;
		ItemStack iStack9 = ItemStack.EMPTY;
		ItemStack iSlot0 = ItemStack.EMPTY;
		ItemStack iSlot1 = ItemStack.EMPTY;
		ItemStack iSlot2 = ItemStack.EMPTY;
		ItemStack iSlot3 = ItemStack.EMPTY;
		ItemStack iSlot4 = ItemStack.EMPTY;
		ItemStack iSlot5 = ItemStack.EMPTY;
		ItemStack iSlot6 = ItemStack.EMPTY;
		ItemStack iSlot7 = ItemStack.EMPTY;
		ItemStack iSlot8 = ItemStack.EMPTY;
		if (ShapedCrafting3x3Procedure.execute(world, x, y, z, ItemStack.EMPTY, new ItemStack(TilledTalesModItems.CHURNED_BUTTER.get()), ItemStack.EMPTY, new ItemStack(TilledTalesModItems.FLOUR.get()), new ItemStack(TilledTalesModItems.SALT.get()),
				new ItemStack(TilledTalesModItems.FLOUR.get()), ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY)
				|| ShapedCrafting3x3Procedure.execute(world, x, y, z, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, new ItemStack(TilledTalesModItems.CHURNED_BUTTER.get()), ItemStack.EMPTY,
						new ItemStack(TilledTalesModItems.FLOUR.get()), new ItemStack(TilledTalesModItems.SALT.get()), new ItemStack(TilledTalesModItems.FLOUR.get()))) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(TilledTalesModItems.PIE_CRUST.get()).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(9, _setstack);
			}
		} else if (ShapedCrafting3x3Procedure.execute(world, x, y, z, new ItemStack(TilledTalesModItems.BLUEBERRIES.get()), new ItemStack(TilledTalesModItems.BLUEBERRIES.get()), new ItemStack(TilledTalesModItems.BLUEBERRIES.get()), ItemStack.EMPTY,
				new ItemStack(TilledTalesModItems.PIE_CRUST.get()), ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY)
				|| ShapedCrafting3x3Procedure.execute(world, x, y, z, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, new ItemStack(TilledTalesModItems.BLUEBERRIES.get()), new ItemStack(TilledTalesModItems.BLUEBERRIES.get()),
						new ItemStack(TilledTalesModItems.BLUEBERRIES.get()), ItemStack.EMPTY, new ItemStack(TilledTalesModItems.PIE_CRUST.get()), ItemStack.EMPTY)) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(TilledTalesModItems.BLUEBERRY_PIE.get()).copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(9, _setstack);
			}
		} else {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
				_itemHandlerModifiable.setStackInSlot(9, ItemStack.EMPTY);
		}
	}
}