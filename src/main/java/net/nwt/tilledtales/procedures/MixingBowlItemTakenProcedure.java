package net.nwt.tilledtales.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class MixingBowlItemTakenProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
			int _slotid = 0;
			ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
			_stk.shrink(1);
			_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
		}
		if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
			int _slotid = 1;
			ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
			_stk.shrink(1);
			_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
		}
		if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
			int _slotid = 2;
			ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
			_stk.shrink(1);
			_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
		}
		if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
			int _slotid = 3;
			ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
			_stk.shrink(1);
			_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
		}
		if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
			int _slotid = 4;
			ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
			_stk.shrink(1);
			_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
		}
		if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
			int _slotid = 5;
			ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
			_stk.shrink(1);
			_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
		}
		if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
			int _slotid = 6;
			ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
			_stk.shrink(1);
			_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
		}
		if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
			int _slotid = 7;
			ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
			_stk.shrink(1);
			_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
		}
		if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
			int _slotid = 8;
			ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
			_stk.shrink(1);
			_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
		}
	}
}