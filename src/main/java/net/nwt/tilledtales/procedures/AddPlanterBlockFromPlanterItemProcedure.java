package net.nwt.tilledtales.procedures;

import net.nwt.tilledtales.init.TilledTalesModBlocks;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

public class AddPlanterBlockFromPlanterItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity, String material) {
		if (direction == null || entity == null || material == null)
			return;
		String bMaterial = "";
		BlockState bBlock = Blocks.AIR.defaultBlockState();
		boolean itemAction = false;
		Direction bDirection = Direction.NORTH;
		bMaterial = (material).toLowerCase();
		if ((bMaterial).equals("diamond")) {
			bBlock = (blockStateWithDirection(TilledTalesModBlocks.DIAMOND_PLANTER_BLOCK.get().defaultBlockState(), ((entity.getDirection()).getOpposite())));
		} else if ((bMaterial).equals("golden")) {
			bBlock = (blockStateWithDirection(TilledTalesModBlocks.GOLDEN_PLANTER_BLOCK.get().defaultBlockState(), ((entity.getDirection()).getOpposite())));
		} else if ((bMaterial).equals("iron")) {
			bBlock = (blockStateWithDirection(TilledTalesModBlocks.IRON_PLANTER_BLOCK.get().defaultBlockState(), ((entity.getDirection()).getOpposite())));
		} else if ((bMaterial).equals("copper")) {
			bBlock = (blockStateWithDirection(TilledTalesModBlocks.COPPER_PLANTER_BLOCK.get().defaultBlockState(), ((entity.getDirection()).getOpposite())));
		} else if ((bMaterial).equals("stone")) {
			bBlock = (blockStateWithDirection(TilledTalesModBlocks.STONE_PLANTER_BLOCK.get().defaultBlockState(), ((entity.getDirection()).getOpposite())));
		} else if ((bMaterial).equals("wooden")) {
			bBlock = (blockStateWithDirection(TilledTalesModBlocks.WOODEN_PLANTER_BLOCK.get().defaultBlockState(), ((entity.getDirection()).getOpposite())));
		}
		bDirection = direction;
		if (bDirection == Direction.UP && (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:replaceable")))) {
			world.setBlock(BlockPos.containing(x, y + 1, z), bBlock, 3);
			PlayPlanterSoundWhenPlanterPlacedProcedure.execute(world, x, y, z, 0, 1, 0, bMaterial);
			itemAction = true;
		} else if (bDirection == Direction.NORTH && (world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:replaceable")))) {
			world.setBlock(BlockPos.containing(x, y, z - 1), bBlock, 3);
			PlayPlanterSoundWhenPlanterPlacedProcedure.execute(world, x, y, z, 0, 0, -1, bMaterial);
			itemAction = true;
		} else if (bDirection == Direction.EAST && (world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:replaceable")))) {
			world.setBlock(BlockPos.containing(x + 1, y, z), bBlock, 3);
			PlayPlanterSoundWhenPlanterPlacedProcedure.execute(world, x, y, z, 1, 0, 0, bMaterial);
			itemAction = true;
		} else if (bDirection == Direction.SOUTH && (world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:replaceable")))) {
			world.setBlock(BlockPos.containing(x, y, z + 1), bBlock, 3);
			PlayPlanterSoundWhenPlanterPlacedProcedure.execute(world, x, y, z, 0, 0, 1, bMaterial);
			itemAction = true;
		} else if (bDirection == Direction.WEST && (world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:replaceable")))) {
			world.setBlock(BlockPos.containing(x - 1, y, z), bBlock, 3);
			PlayPlanterSoundWhenPlanterPlacedProcedure.execute(world, x, y, z, -1, 0, 0, bMaterial);
			itemAction = true;
		} else if (bDirection == Direction.DOWN && (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:replaceable")))) {
			world.setBlock(BlockPos.containing(x, y - 1, z), bBlock, 3);
			PlayPlanterSoundWhenPlanterPlacedProcedure.execute(world, x, y, z, 0, -1, 0, bMaterial);
			itemAction = true;
		}
		if (itemAction) {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (!(getEntityGameType(entity) == GameType.CREATIVE)) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			}
		}
	}

	private static BlockState blockStateWithDirection(BlockState blockState, Direction newValue) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (prop instanceof DirectionProperty dp && dp.getPossibleValues().contains(newValue))
			return blockState.setValue(dp, newValue);
		prop = blockState.getBlock().getStateDefinition().getProperty("axis");
		return prop instanceof EnumProperty ep && ep.getPossibleValues().contains(newValue.getAxis()) ? blockState.setValue(ep, newValue.getAxis()) : blockState;
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