package net.nwt.tilledtales.procedures;

import net.nwt.tilledtales.init.TilledTalesModItems;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class PlanterHarvestProcedure {
	public static void execute(LevelAccessor world, BlockState blockstate, double blockX, double blockY, double blockZ, String crop) {
		if (crop == null)
			return;
		BlockState block = Blocks.AIR.defaultBlockState();
		double bX = 0;
		double bY = 0;
		double bZ = 0;
		boolean runScript = false;
		bX = blockX;
		bY = blockY;
		bZ = blockZ;
		if ((crop).equals("WHEAT")) {
			PlanterHarvestDropsProcedure.execute(world, blockstate, new ItemStack(TilledTalesModItems.WHEAT_GRAIN.get()), new ItemStack(TilledTalesModItems.WHEAT_GRAIN.get()), bX, bY, bZ);
			runScript = true;
		} else if ((crop).equals("BLUEBERRY")) {
			PlanterHarvestDropsProcedure.execute(world, blockstate, new ItemStack(TilledTalesModItems.BLUE_BERRIES.get()), new ItemStack(TilledTalesModItems.BLUE_BERRIES.get()), bX, bY, bZ);
			runScript = true;
		}
		if (runScript) {
			{
				String _value = "none";
				BlockPos _pos = BlockPos.containing(bX, bY, bZ);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("crop") instanceof EnumProperty _enumProp && _enumProp.getValue(_value).isPresent())
					world.setBlock(_pos, _bs.setValue(_enumProp, (Enum) _enumProp.getValue(_value).get()), 3);
			}
			{
				String _value = "dry";
				BlockPos _pos = BlockPos.containing(bX, bY, bZ);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("soil") instanceof EnumProperty _enumProp && _enumProp.getValue(_value).isPresent())
					world.setBlock(_pos, _bs.setValue(_enumProp, (Enum) _enumProp.getValue(_value).get()), 3);
			}
			{
				BlockPos _pos = BlockPos.containing(bX, bY, bZ);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("weeds") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
			}
			{
				BlockPos _pos = BlockPos.containing(bX, bY, bZ);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("fertilizer") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
			}
			{
				BlockPos _pos = BlockPos.containing(bX, bY, bZ);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("quicklime") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
			}
			{
				int _value = 0;
				BlockPos _pos = BlockPos.containing(bX, bY, bZ);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(bX, bY, bZ);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("seedDropMin", 0);
					_blockEntity.getPersistentData().putDouble("seedDropMax", 0);
					_blockEntity.getPersistentData().putDouble("cropDropMin", 0);
					_blockEntity.getPersistentData().putDouble("cropDropMax", 0);
					_blockEntity.getPersistentData().putString("fertilizerType", "none");
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.COMPOSTER, (Math.floor(bX) + 0.5), (Math.floor(bY) + 1), (Math.floor(bZ) + 0.5), 8, 0.5, 0.5, 0.5, 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(Math.floor(bX) + 0.5, Math.floor(bY) + 0.5, Math.floor(bZ) + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.crop.break")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound((Math.floor(bX) + 0.5), (Math.floor(bY) + 0.5), (Math.floor(bZ) + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.crop.break")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}