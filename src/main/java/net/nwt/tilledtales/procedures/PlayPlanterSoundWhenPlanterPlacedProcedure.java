package net.nwt.tilledtales.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class PlayPlanterSoundWhenPlanterPlacedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double offsetX, double offsetY, double offsetZ, String material) {
		if (material == null)
			return;
		BlockState block = Blocks.AIR.defaultBlockState();
		String bMaterial = "";
		bMaterial = (material).toLowerCase();
		if ((bMaterial).equals("diamond") || (bMaterial).equals("golden") || (bMaterial).equals("iron")) {
			if (!world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(Math.floor(x) + 0.5 + offsetX, Math.floor(y) + 0.5 + offsetY, Math.floor(z) + 0.5 + offsetZ), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.metal.place")),
								SoundSource.BLOCKS, 1, (float) 1.2);
					} else {
						_level.playLocalSound((Math.floor(x) + 0.5 + offsetX), (Math.floor(y) + 0.5 + offsetY), (Math.floor(z) + 0.5 + offsetZ), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.metal.place")), SoundSource.BLOCKS, 1,
								(float) 1.2, false);
					}
				}
			}
		} else if ((bMaterial).equals("copper")) {
			if (!world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(Math.floor(x) + 0.5 + offsetX, Math.floor(y) + 0.5 + offsetY, Math.floor(z) + 0.5 + offsetZ), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.copper.place")),
								SoundSource.BLOCKS, 1, (float) 0.8);
					} else {
						_level.playLocalSound((Math.floor(x) + 0.5 + offsetX), (Math.floor(y) + 0.5 + offsetY), (Math.floor(z) + 0.5 + offsetZ), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.copper.place")), SoundSource.BLOCKS, 1,
								(float) 0.8, false);
					}
				}
			}
		} else if ((bMaterial).equals("stone")) {
			if (!world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(Math.floor(x) + 0.5 + offsetX, Math.floor(y) + 0.5 + offsetY, Math.floor(z) + 0.5 + offsetZ), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone.place")),
								SoundSource.BLOCKS, 1, (float) 0.8);
					} else {
						_level.playLocalSound((Math.floor(x) + 0.5 + offsetX), (Math.floor(y) + 0.5 + offsetY), (Math.floor(z) + 0.5 + offsetZ), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone.place")), SoundSource.BLOCKS, 1,
								(float) 0.8, false);
					}
				}
			}
		} else if ((bMaterial).equals("wooden")) {
			if (!world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(Math.floor(x) + 0.5 + offsetX, Math.floor(y) + 0.5 + offsetY, Math.floor(z) + 0.5 + offsetZ), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.wood.place")),
								SoundSource.BLOCKS, 1, (float) 0.8);
					} else {
						_level.playLocalSound((Math.floor(x) + 0.5 + offsetX), (Math.floor(y) + 0.5 + offsetY), (Math.floor(z) + 0.5 + offsetZ), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.wood.place")), SoundSource.BLOCKS, 1,
								(float) 0.8, false);
					}
				}
			}
		}
	}
}