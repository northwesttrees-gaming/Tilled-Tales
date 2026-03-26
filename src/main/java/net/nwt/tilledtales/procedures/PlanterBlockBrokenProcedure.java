package net.nwt.tilledtales.procedures;

import net.nwt.tilledtales.init.TilledTalesModItems;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlanterBlockBrokenProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		execute(null, world, x, y, z, blockstate);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		String material = "";
		BlockState block = Blocks.AIR.defaultBlockState();
		block = blockstate;
		if (block.is(BlockTags.create(ResourceLocation.parse("tilled_tales:planters")))) {
			material = (block.getBlock().getStateDefinition().getProperty("material") instanceof EnumProperty _getep2 ? block.getValue(_getep2).toString() : "").toLowerCase();
			if ((material).equals("diamond")) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (Math.floor(x) + 0.5), (Math.floor(y) + 0.5), (Math.floor(z) + 0.5), new ItemStack(TilledTalesModItems.DIAMOND_PLANTER.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(Math.floor(x) + 0.5, Math.floor(y) + 0.5, Math.floor(z) + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.metal.break")), SoundSource.BLOCKS, 1,
									(float) 1.2);
						} else {
							_level.playLocalSound((Math.floor(x) + 0.5), (Math.floor(y) + 0.5), (Math.floor(z) + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.metal.break")), SoundSource.BLOCKS, 1, (float) 1.2, false);
						}
					}
				}
			} else if ((material).equals("golden")) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (Math.floor(x) + 0.5), (Math.floor(y) + 0.5), (Math.floor(z) + 0.5), new ItemStack(TilledTalesModItems.GOLDEN_PLANTER.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(Math.floor(x) + 0.5, Math.floor(y) + 0.5, Math.floor(z) + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.metal.break")), SoundSource.BLOCKS, 1,
									(float) 1.2);
						} else {
							_level.playLocalSound((Math.floor(x) + 0.5), (Math.floor(y) + 0.5), (Math.floor(z) + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.metal.break")), SoundSource.BLOCKS, 1, (float) 1.2, false);
						}
					}
				}
			} else if ((material).equals("iron")) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (Math.floor(x) + 0.5), (Math.floor(y) + 0.5), (Math.floor(z) + 0.5), new ItemStack(TilledTalesModItems.IRON_PLANTER.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(Math.floor(x) + 0.5, Math.floor(y) + 0.5, Math.floor(z) + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.metal.break")), SoundSource.BLOCKS, 1,
									(float) 1.2);
						} else {
							_level.playLocalSound((Math.floor(x) + 0.5), (Math.floor(y) + 0.5), (Math.floor(z) + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.metal.break")), SoundSource.BLOCKS, 1, (float) 1.2, false);
						}
					}
				}
			} else if ((material).equals("copper")) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (Math.floor(x) + 0.5), (Math.floor(y) + 0.5), (Math.floor(z) + 0.5), new ItemStack(TilledTalesModItems.COPPER_PLANTER.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(Math.floor(x) + 0.5, Math.floor(y) + 0.5, Math.floor(z) + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.copper.break")), SoundSource.BLOCKS, 1,
									(float) 0.8);
						} else {
							_level.playLocalSound((Math.floor(x) + 0.5), (Math.floor(y) + 0.5), (Math.floor(z) + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.copper.break")), SoundSource.BLOCKS, 1, (float) 0.8, false);
						}
					}
				}
			} else if ((material).equals("stone")) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (Math.floor(x) + 0.5), (Math.floor(y) + 0.5), (Math.floor(z) + 0.5), new ItemStack(TilledTalesModItems.STONE_PLANTER.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(Math.floor(x) + 0.5, Math.floor(y) + 0.5, Math.floor(z) + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone.break")), SoundSource.BLOCKS, 1,
									(float) 0.8);
						} else {
							_level.playLocalSound((Math.floor(x) + 0.5), (Math.floor(y) + 0.5), (Math.floor(z) + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone.break")), SoundSource.BLOCKS, 1, (float) 0.8, false);
						}
					}
				}
			} else if ((material).equals("wooden")) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (Math.floor(x) + 0.5), (Math.floor(y) + 0.5), (Math.floor(z) + 0.5), new ItemStack(TilledTalesModItems.WOODEN_PLANTER.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(Math.floor(x) + 0.5, Math.floor(y) + 0.5, Math.floor(z) + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.wood.break")), SoundSource.BLOCKS, 1, (float) 0.8);
						} else {
							_level.playLocalSound((Math.floor(x) + 0.5), (Math.floor(y) + 0.5), (Math.floor(z) + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.wood.break")), SoundSource.BLOCKS, 1, (float) 0.8, false);
						}
					}
				}
			}
		}
	}
}