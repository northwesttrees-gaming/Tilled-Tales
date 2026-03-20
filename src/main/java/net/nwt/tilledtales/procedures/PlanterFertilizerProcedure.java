package net.nwt.tilledtales.procedures;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class PlanterFertilizerProcedure {
	public static void execute(LevelAccessor world, BlockState blockstate, Entity entity, double blockX, double blockY, double blockZ) {
		if (entity == null)
			return;
		ItemStack mainHand = ItemStack.EMPTY;
		double bX = 0;
		double bY = 0;
		double bZ = 0;
		if (!((blockstate.getBlock().getStateDefinition().getProperty("crop") instanceof EnumProperty _getep1 ? blockstate.getValue(_getep1).toString() : "").equals("NONE"))) {
			bX = blockX;
			bY = blockY;
			bZ = blockZ;
			{
				BlockPos _pos = BlockPos.containing(bX, bY, bZ);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("fertilizer") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("tilled_tales:fertilizer/premium")))) {
				if (world instanceof ServerLevel _level) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
					});
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(bX, bY, bZ);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putString("fertilizerType", "Premium");
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				if (world instanceof ServerLevel _level) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
					});
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(bX, bY, bZ);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putString("fertilizerType", "Basic");
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
	}
}