package net.nwt.tilledtales.procedures;

import net.nwt.tilledtales.init.TilledTalesModItems;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.Direction;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DiamondPlanterRightclickedOnBlockProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getFace(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity) {
		execute(null, world, x, y, z, direction, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Direction direction, Entity entity) {
		if (direction == null || entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TilledTalesModItems.DIAMOND_PLANTER.get()) {
			PlacePlanterFromItemProcedure.execute(world, x, y, z, direction, entity, "diamond");
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TilledTalesModItems.GOLDEN_PLANTER.get()) {
			PlacePlanterFromItemProcedure.execute(world, x, y, z, direction, entity, "golden");
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TilledTalesModItems.IRON_PLANTER.get()) {
			PlacePlanterFromItemProcedure.execute(world, x, y, z, direction, entity, "iron");
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TilledTalesModItems.STONE_PLANTER.get()) {
			PlacePlanterFromItemProcedure.execute(world, x, y, z, direction, entity, "stone");
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TilledTalesModItems.WOODEN_PLANTER.get()) {
			PlacePlanterFromItemProcedure.execute(world, x, y, z, direction, entity, "wooden");
		}
	}
}