package net.nwt.tilledtales.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class PlanterWeedProcedure {
	public static void execute(LevelAccessor world, double blockX, double blockY, double blockZ) {
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
				_blockEntity.getPersistentData().putBoolean("isWeeded", true);
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		{
			BlockPos _pos = BlockPos.containing(bX, bY, bZ);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("weeds") instanceof BooleanProperty _booleanProp)
				world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.COMPOSTER, (Math.floor(bX) + 0.5), (Math.floor(bY) + 0.5), (Math.floor(bZ) + 0.5), 8, 0.5, 0.5, 0.5, 1);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(Math.floor(bX) + 0.5, Math.floor(bY) + 0.5, Math.floor(bZ) + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.crop.break")), SoundSource.BLOCKS, 1, 1);
			} else {
				_level.playLocalSound((Math.floor(bX) + 0.5), (Math.floor(bY) + 0.5), (Math.floor(bZ) + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.crop.break")), SoundSource.BLOCKS, 1, 1, false);
			}
		}
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, (Math.floor(bX) + 0.5), (Math.floor(bY) + 0.5), (Math.floor(bZ) + 0.5), new ItemStack((BuiltInRegistries.ITEM
					.getOrCreateTag(ItemTags.create(ResourceLocation.parse("tilled_tales:planter_weed_flowers"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
			entityToSpawn.setPickUpDelay(10);
			_level.addFreshEntity(entityToSpawn);
		}
	}
}