package net.nwt.tilledtales.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlanterRightClickedProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getLevel().getBlockState(event.getPos()), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		String crop = "";
		BlockState block = Blocks.AIR.defaultBlockState();
		double age = 0;
		double bX = 0;
		double bY = 0;
		double bZ = 0;
		ItemStack mainHand = ItemStack.EMPTY;
		boolean weeds = false;
		boolean fertilizer = false;
		block = blockstate;
		if (block.is(BlockTags.create(ResourceLocation.parse("tilled_tales:planters")))) {
			crop = block.getBlock().getStateDefinition().getProperty("crop") instanceof EnumProperty _getep2 ? block.getValue(_getep2).toString() : "";
			age = block.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip3 ? block.getValue(_getip3) : -1;
			weeds = block.getBlock().getStateDefinition().getProperty("weeds") instanceof BooleanProperty _getbp4 && block.getValue(_getbp4);
			fertilizer = block.getBlock().getStateDefinition().getProperty("fertilizer") instanceof BooleanProperty _getbp5 && block.getValue(_getbp5);
			mainHand = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
			bX = x;
			bY = y;
			bZ = z;
			if (age == 0 && (crop).equals("NONE")) {
				PlanterPlantProcedure.execute(world, entity, bX, bY, bZ);
			} else if (age < 7) {
				if (weeds && mainHand.getItem() == ItemStack.EMPTY.getItem()) {
					PlanterWeedProcedure.execute(world, bX, bY, bZ);
				} else if (!fertilizer && (mainHand.is(ItemTags.create(ResourceLocation.parse("tilled_tales:fertilizer/basic"))) || mainHand.is(ItemTags.create(ResourceLocation.parse("tilled_tales:fertilizer/premium"))))) {
					PlanterFertilizerProcedure.execute(world, blockstate, entity, bX, bY, bZ);
				}
			} else if (age == 7 && mainHand.getItem() == ItemStack.EMPTY.getItem()) {
				PlanterHarvestProcedure.execute(world, blockstate, bX, bY, bZ, crop);
			}
		}
	}
}