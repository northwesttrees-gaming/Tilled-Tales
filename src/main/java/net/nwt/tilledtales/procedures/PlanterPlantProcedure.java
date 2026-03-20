package net.nwt.tilledtales.procedures;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

public class PlanterPlantProcedure {
	public static void execute(LevelAccessor world, Entity entity, double blockX, double blockY, double blockZ) {
		if (entity == null)
			return;
		double bX = 0;
		double bY = 0;
		double bZ = 0;
		ItemStack mainHand = ItemStack.EMPTY;
		boolean runScript = false;
		bX = blockX;
		bY = blockY;
		bZ = blockZ;
		mainHand = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
		if (mainHand.is(ItemTags.create(ResourceLocation.parse("tilled_tales:seeds/wheat")))) {
			PlanterPlantAddProcedure.execute(world, bX, bY, bZ, 12, 6, 4, 2, "wheat");
			runScript = true;
		} else if (mainHand.is(ItemTags.create(ResourceLocation.parse("tilled_tales:seeds/blueberries")))) {
			PlanterPlantAddProcedure.execute(world, bX, bY, bZ, 8, 4, 8, 4, "blueberry");
			runScript = true;
		}
		if (runScript) {
			if ((getBlockNBTString(world, BlockPos.containing(bX, bY, bZ), "lastCrop1")).isEmpty()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(bX, bY, bZ);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putString("lastCrop1", "none");
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((getBlockNBTString(world, BlockPos.containing(bX, bY, bZ), "lastCrop2")).isEmpty()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(bX, bY, bZ);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putString("lastCrop2", "none");
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((getBlockNBTString(world, BlockPos.containing(bX, bY, bZ), "lastCrop3")).isEmpty()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(bX, bY, bZ);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putString("lastCrop3", "none");
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(bX, bY, bZ);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putString("lastCrop3", (getBlockNBTString(world, BlockPos.containing(bX, bY, bZ), "lastCrop2")));
					_blockEntity.getPersistentData().putString("lastCrop2", (getBlockNBTString(world, BlockPos.containing(bX, bY, bZ), "lastCrop1")));
					_blockEntity.getPersistentData().putString("lastCrop1",
							((world.getBlockState(BlockPos.containing(bX, bY, bZ))).getBlock().getStateDefinition().getProperty("crop") instanceof EnumProperty _getep14
									? (world.getBlockState(BlockPos.containing(bX, bY, bZ))).getValue(_getep14).toString()
									: "").toLowerCase());
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (entity instanceof LivingEntity && (entity instanceof Player || entity instanceof ServerPlayer ? !(getEntityGameType(entity) == GameType.CREATIVE) : true)) {
				if (world instanceof ServerLevel _level) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
					});
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.COMPOSTER, (Math.floor(bX) + 0.5), (Math.floor(bY) + 1), (Math.floor(bZ) + 0.5), 8, 0.5, 0.5, 0.5, 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(Math.floor(bX) + 0.5, Math.floor(bY) + 0.5, Math.floor(bZ) + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.crop.plant")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound((Math.floor(bX) + 0.5), (Math.floor(bY) + 0.5), (Math.floor(bZ) + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.crop.plant")), SoundSource.BLOCKS, 1, 1, false);
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

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}