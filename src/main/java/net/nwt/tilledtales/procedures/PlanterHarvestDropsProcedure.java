package net.nwt.tilledtales.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class PlanterHarvestDropsProcedure {
	public static void execute(LevelAccessor world, BlockState blockstate, ItemStack cropLoot, ItemStack seedLoot, double blockX, double blockY, double blockZ) {
		ItemStack cropDrop = ItemStack.EMPTY;
		ItemStack seedDrop = ItemStack.EMPTY;
		BlockState block = Blocks.AIR.defaultBlockState();
		boolean weeds = false;
		String fertilizerType = "";
		double cropAmount = 0;
		double seedAmount = 0;
		double dropY = 0;
		double dropZ = 0;
		double dropX = 0;
		double seedDropMin = 0;
		double seedDropMax = 0;
		double cropDropMin = 0;
		double cropDropMax = 0;
		double cropTotal = 0;
		double seedTotal = 0;
		block = blockstate;
		cropDrop = cropLoot.copy();
		seedDrop = seedLoot.copy();
		cropAmount = getBlockNBTNumber(world, BlockPos.containing(blockX, blockY, blockZ), "cropDropAmount");
		cropDropMin = getBlockNBTNumber(world, BlockPos.containing(blockX, blockY, blockZ), "cropDropMin");
		cropDropMax = getBlockNBTNumber(world, BlockPos.containing(blockX, blockY, blockZ), "cropDropMax");
		seedAmount = getBlockNBTNumber(world, BlockPos.containing(blockX, blockY, blockZ), "seedDropAmount");
		seedDropMin = getBlockNBTNumber(world, BlockPos.containing(blockX, blockY, blockZ), "seedDropMin");
		seedDropMax = getBlockNBTNumber(world, BlockPos.containing(blockX, blockY, blockZ), "seedDropMax");
		dropX = Math.floor(blockX) + 0.5;
		dropY = Math.floor(blockY) + 0.5;
		dropZ = Math.floor(blockZ) + 0.5;
		cropTotal = cropAmount;
		seedTotal = seedAmount;
		if (block.getBlock().getStateDefinition().getProperty("fertilizer") instanceof BooleanProperty _getbp7 && block.getValue(_getbp7)) {
			fertilizerType = getBlockNBTString(world, BlockPos.containing(blockX, blockY, blockZ), "fertilizerType");
			if ((fertilizerType).equals("Basic")) {
				cropTotal = Math.max(cropTotal * 2, 1);
				seedTotal = Math.max(seedTotal * 2, 1);
			} else if ((fertilizerType).equals("Premium")) {
				cropTotal = Math.max(cropTotal * 4, 1);
				seedTotal = Math.max(seedTotal * 4, 1);
			}
		}
		if (block.getBlock().getStateDefinition().getProperty("weeds") instanceof BooleanProperty _getbp9 && block.getValue(_getbp9)) {
			cropTotal = cropTotal - Math.max(cropAmount / 2, 1);
			seedTotal = seedTotal - Math.max(seedAmount / 2, 1);
		}
		cropTotal = Math.min(cropDropMax, Math.max(cropTotal, cropDropMin));
		seedTotal = Math.min(seedDropMax, Math.max(seedTotal, seedDropMin));
		cropDrop.setCount((int) cropAmount);
		seedDrop.setCount((int) seedAmount);
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, dropX, dropY, dropZ, cropDrop);
			entityToSpawn.setPickUpDelay(10);
			_level.addFreshEntity(entityToSpawn);
		}
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, dropX, dropY, dropZ, seedDrop);
			entityToSpawn.setPickUpDelay(10);
			_level.addFreshEntity(entityToSpawn);
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}
}