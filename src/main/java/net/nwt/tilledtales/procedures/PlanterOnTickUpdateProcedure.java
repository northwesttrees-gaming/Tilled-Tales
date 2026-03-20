package net.nwt.tilledtales.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class PlanterOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		BlockState block = Blocks.AIR.defaultBlockState();
		String crop = "";
		String soil = "";
		boolean weeds = false;
		boolean quicklime = false;
		double age = 0;
		double sameCropPenalty = 0;
		block = blockstate;
		soil = block.getBlock().getStateDefinition().getProperty("soil") instanceof EnumProperty _getep1 ? block.getValue(_getep1).toString() : "";
		crop = block.getBlock().getStateDefinition().getProperty("crop") instanceof EnumProperty _getep2 ? block.getValue(_getep2).toString() : "";
		age = block.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip3 ? block.getValue(_getip3) : -1;
		weeds = block.getBlock().getStateDefinition().getProperty("weeds") instanceof BooleanProperty _getbp4 && block.getValue(_getbp4);
		quicklime = block.getBlock().getStateDefinition().getProperty("quicklime") instanceof BooleanProperty _getbp5 && block.getValue(_getbp5);
		if (!(crop).equals("NONE") && age < 7) {
			if ((soil).equals("WET")) {
				sameCropPenalty = 0;
				if (!quicklime) {
					sameCropPenalty = sameCropPenalty + 2;
				}
				if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "lastCrop3")).equals(getBlockNBTString(world, BlockPos.containing(x, y, z), "lastCrop1"))) {
					sameCropPenalty = sameCropPenalty + 1;
				}
				if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "lastCrop2")).equals(getBlockNBTString(world, BlockPos.containing(x, y, z), "lastCrop1"))) {
					sameCropPenalty = sameCropPenalty + 1;
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("maxGrowthSteps", sameCropPenalty);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "growthStep") >= getBlockNBTNumber(world, BlockPos.containing(x, y, z), "maxGrowthSteps")) {
					{
						int _value = (int) (age + 1);
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("growthStep", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("growthStep", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "growthStep") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
			if (!getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isWeeded") && !weeds && age == 0) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("weeds") instanceof BooleanProperty _booleanProp)
						world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
				}
			}
			if ((soil).equals("WET") && (age == 0 || age == 2 || age == 4)) {
				{
					String _value = "dry";
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("soil") instanceof EnumProperty _enumProp && _enumProp.getValue(_value).isPresent())
						world.setBlock(_pos, _bs.setValue(_enumProp, (Enum) _enumProp.getValue(_value).get()), 3);
				}
			}
		}
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}
}