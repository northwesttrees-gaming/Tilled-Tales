package net.nwt.tilledtales.procedures;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class PlanterPlantAddProcedure {
	public static void execute(LevelAccessor world, double blockX, double blockY, double blockZ, double cropDropMax, double cropDropMin, double seedDropMax, double seedDropMin, String cropProperty) {
		if (cropProperty == null)
			return;
		double bX = 0;
		double bY = 0;
		double bZ = 0;
		bX = blockX;
		bY = blockY;
		bZ = blockZ;
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(bX, bY, bZ);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("cropDropMin", cropDropMin);
				_blockEntity.getPersistentData().putDouble("cropDropMax", cropDropMax);
				_blockEntity.getPersistentData().putDouble("seedDropMin", seedDropMin);
				_blockEntity.getPersistentData().putDouble("seedDropMax", seedDropMax);
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		{
			String _value = cropProperty;
			BlockPos _pos = BlockPos.containing(bX, bY, bZ);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("crop") instanceof EnumProperty _enumProp && _enumProp.getValue(_value).isPresent())
				world.setBlock(_pos, _bs.setValue(_enumProp, (Enum) _enumProp.getValue(_value).get()), 3);
		}
	}
}