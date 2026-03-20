package net.nwt.tilledtales.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
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
		block = blockstate;
		cropDrop = cropLoot.copy();
		seedDrop = seedLoot.copy();
		seedDropMin = getBlockNBTNumber(world, BlockPos.containing(blockX, blockY, blockZ), "seedDropMin");
		seedDropMax = getBlockNBTNumber(world, BlockPos.containing(blockX, blockY, blockZ), "seedDropMax");
		seedAmount = Mth.nextInt(RandomSource.create(), (int) seedDropMin, (int) seedDropMax);
		cropDropMin = getBlockNBTNumber(world, BlockPos.containing(blockX, blockY, blockZ), "cropDropMin");
		cropDropMax = getBlockNBTNumber(world, BlockPos.containing(blockX, blockY, blockZ), "cropDropMax");
		cropAmount = Mth.nextInt(RandomSource.create(), (int) cropDropMin, (int) cropDropMax);
		dropX = Math.floor(blockX) + 0.5;
		dropY = Math.floor(blockY) + 0.5;
		dropZ = Math.floor(blockZ) + 0.5;
		if (block.getBlock().getStateDefinition().getProperty("fertilizer") instanceof BooleanProperty _getbp7 && block.getValue(_getbp7)) {
			fertilizerType = getBlockNBTString(world, BlockPos.containing(blockX, blockY, blockZ), "fertilizerType");
			if ((fertilizerType).equals("Basic")) {
				cropAmount = Math.max(cropAmount * 2, 1);
				seedAmount = Math.max(seedAmount * 2, 1);
			} else if ((fertilizerType).equals("Premium")) {
				cropAmount = Math.max(cropAmount * 3, 1);
				seedAmount = Math.max(seedAmount * 3, 1);
			}
		}
		if (block.getBlock().getStateDefinition().getProperty("weeds") instanceof BooleanProperty _getbp9 && block.getValue(_getbp9)) {
			cropAmount = Math.max(cropAmount / 2, 1);
			seedAmount = Math.max(seedAmount / 2, 1);
		}
		cropAmount = Math.max(cropDropMin, Math.min(cropAmount, cropDropMax));
		seedAmount = Math.max(seedDropMin, Math.min(seedAmount, seedDropMax));
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