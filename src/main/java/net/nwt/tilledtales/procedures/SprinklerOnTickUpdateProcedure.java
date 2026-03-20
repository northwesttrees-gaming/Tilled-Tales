package net.nwt.tilledtales.procedures;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class SprinklerOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double distanceY = 0;
		double waterTimer = 0;
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "waterPlanter")) {
			waterTimer = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "waterTimer");
			if (waterTimer >= 200) {
				distanceY = 1;
				for (int index0 = 0; index0 < 8; index0++) {
					distanceY = distanceY + 1;
					if ((world.getBlockState(BlockPos.containing(x, y - distanceY, z))).is(BlockTags.create(ResourceLocation.parse("tilled_tales:planters")))
							&& ((world.getBlockState(BlockPos.containing(x, y - distanceY, z))).getBlock().getStateDefinition().getProperty("soil") instanceof EnumProperty _getep5
									? (world.getBlockState(BlockPos.containing(x, y - distanceY, z))).getValue(_getep5).toString()
									: "").equals("DRY")
							&& !(((world.getBlockState(BlockPos.containing(x, y - distanceY, z))).getBlock().getStateDefinition().getProperty("crop") instanceof EnumProperty _getep7
									? (world.getBlockState(BlockPos.containing(x, y - distanceY, z))).getValue(_getep7).toString()
									: "").equals("NONE"))) {
						{
							String _value = "wet";
							BlockPos _pos = BlockPos.containing(x, y - distanceY, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("soil") instanceof EnumProperty _enumProp && _enumProp.getValue(_value).isPresent())
								world.setBlock(_pos, _bs.setValue(_enumProp, (Enum) _enumProp.getValue(_value).get()), 3);
						}
						break;
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("waterPlanter", false);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FALLING_WATER, (Math.floor(x) + 0.5), (Math.floor(y) + 0.5), (Math.floor(z) + 0.5), 5, 0.25, 0.25, 0.25, 0);
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("waterTimer", (waterTimer + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			distanceY = 1;
			for (int index1 = 0; index1 < 8; index1++) {
				distanceY = distanceY + 1;
				if ((world.getBlockState(BlockPos.containing(x, y - distanceY, z))).is(BlockTags.create(ResourceLocation.parse("tilled_tales:planters")))
						&& ((world.getBlockState(BlockPos.containing(x, y - distanceY, z))).getBlock().getStateDefinition().getProperty("soil") instanceof EnumProperty _getep15
								? (world.getBlockState(BlockPos.containing(x, y - distanceY, z))).getValue(_getep15).toString()
								: "").equals("DRY")
						&& !(((world.getBlockState(BlockPos.containing(x, y - distanceY, z))).getBlock().getStateDefinition().getProperty("crop") instanceof EnumProperty _getep17
								? (world.getBlockState(BlockPos.containing(x, y - distanceY, z))).getValue(_getep17).toString()
								: "").equals("NONE"))) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("waterTimer", 0);
							_blockEntity.getPersistentData().putBoolean("waterPlanter", true);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					break;
				}
			}
		}
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}