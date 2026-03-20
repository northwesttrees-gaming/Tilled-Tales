/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.nwt.tilledtales.init;

import net.nwt.tilledtales.block.*;
import net.nwt.tilledtales.TilledTalesMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

public class TilledTalesModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(TilledTalesMod.MODID);
	public static final DeferredBlock<Block> OAK_DASH_CHURN;
	public static final DeferredBlock<Block> OAK_DASH_CHURN_UP;
	public static final DeferredBlock<Block> SALT_BLOCK;
	public static final DeferredBlock<Block> OAK_ICE_BOX;
	public static final DeferredBlock<Block> OAK_ICE_BOX_1;
	public static final DeferredBlock<Block> OAK_ICE_BOX_2;
	public static final DeferredBlock<Block> MILLSTONE;
	public static final DeferredBlock<Block> MILLSTONE_1;
	public static final DeferredBlock<Block> MILLSTONE_2;
	public static final DeferredBlock<Block> MILLSTONE_3;
	public static final DeferredBlock<Block> MILLSTONE_4;
	public static final DeferredBlock<Block> MILLSTONE_5;
	public static final DeferredBlock<Block> MILLSTONE_6;
	public static final DeferredBlock<Block> MILLSTONE_7;
	public static final DeferredBlock<Block> MILLSTONE_8;
	public static final DeferredBlock<Block> MILLSTONE_9;
	public static final DeferredBlock<Block> COUNTER;
	public static final DeferredBlock<Block> WHITE_MIXING_BOWL;
	public static final DeferredBlock<Block> LIGHT_GRAY_MIXING_BOWL;
	public static final DeferredBlock<Block> GRAY_MIXING_BOWL;
	public static final DeferredBlock<Block> BLACK_MIXING_BOWL;
	public static final DeferredBlock<Block> BROWN_MIXING_BOWL;
	public static final DeferredBlock<Block> RED_MIXING_BOWL;
	public static final DeferredBlock<Block> ORANGE_MIXING_BOWL;
	public static final DeferredBlock<Block> YELLOW_MIXING_BOWL;
	public static final DeferredBlock<Block> LIME_MIXING_BOWL;
	public static final DeferredBlock<Block> GREEN_MIXING_BOWL;
	public static final DeferredBlock<Block> CYAN_MIXING_BOWL;
	public static final DeferredBlock<Block> LIGHT_BLUE_MIXING_BOWL;
	public static final DeferredBlock<Block> BLUE_MIXING_BOWL;
	public static final DeferredBlock<Block> PURPLE_MIXING_BOWL;
	public static final DeferredBlock<Block> MAGENTA_MIXING_BOWL;
	public static final DeferredBlock<Block> PINK_MIXING_BOWL;
	public static final DeferredBlock<Block> SPRINKLER;
	public static final DeferredBlock<Block> WOODEN_PLANTER_BLOCK;
	public static final DeferredBlock<Block> STONE_PLANTER_BLOCK;
	public static final DeferredBlock<Block> IRON_PLANTER_BLOCK;
	public static final DeferredBlock<Block> GOLDEN_PLANTER_BLOCK;
	public static final DeferredBlock<Block> DIAMOND_PLANTER_BLOCK;
	static {
		OAK_DASH_CHURN = REGISTRY.register("oak_dash_churn", OakDashChurnBlock::new);
		OAK_DASH_CHURN_UP = REGISTRY.register("oak_dash_churn_up", OakDashChurnUpBlock::new);
		SALT_BLOCK = REGISTRY.register("salt_block", SaltBlockBlock::new);
		OAK_ICE_BOX = REGISTRY.register("oak_ice_box", OakIceBoxBlock::new);
		OAK_ICE_BOX_1 = REGISTRY.register("oak_ice_box_1", OakIceBox1Block::new);
		OAK_ICE_BOX_2 = REGISTRY.register("oak_ice_box_2", OakIceBox2Block::new);
		MILLSTONE = REGISTRY.register("millstone", MillstoneBlock::new);
		MILLSTONE_1 = REGISTRY.register("millstone_1", Millstone1Block::new);
		MILLSTONE_2 = REGISTRY.register("millstone_2", Millstone2Block::new);
		MILLSTONE_3 = REGISTRY.register("millstone_3", Millstone3Block::new);
		MILLSTONE_4 = REGISTRY.register("millstone_4", Millstone4Block::new);
		MILLSTONE_5 = REGISTRY.register("millstone_5", Millstone5Block::new);
		MILLSTONE_6 = REGISTRY.register("millstone_6", Millstone6Block::new);
		MILLSTONE_7 = REGISTRY.register("millstone_7", Millstone7Block::new);
		MILLSTONE_8 = REGISTRY.register("millstone_8", Millstone8Block::new);
		MILLSTONE_9 = REGISTRY.register("millstone_9", Millstone9Block::new);
		COUNTER = REGISTRY.register("counter", CounterBlock::new);
		WHITE_MIXING_BOWL = REGISTRY.register("white_mixing_bowl", WhiteMixingBowlBlock::new);
		LIGHT_GRAY_MIXING_BOWL = REGISTRY.register("light_gray_mixing_bowl", LightGrayMixingBowlBlock::new);
		GRAY_MIXING_BOWL = REGISTRY.register("gray_mixing_bowl", GrayMixingBowlBlock::new);
		BLACK_MIXING_BOWL = REGISTRY.register("black_mixing_bowl", BlackMixingBowlBlock::new);
		BROWN_MIXING_BOWL = REGISTRY.register("brown_mixing_bowl", BrownMixingBowlBlock::new);
		RED_MIXING_BOWL = REGISTRY.register("red_mixing_bowl", RedMixingBowlBlock::new);
		ORANGE_MIXING_BOWL = REGISTRY.register("orange_mixing_bowl", OrangeMixingBowlBlock::new);
		YELLOW_MIXING_BOWL = REGISTRY.register("yellow_mixing_bowl", YellowMixingBowlBlock::new);
		LIME_MIXING_BOWL = REGISTRY.register("lime_mixing_bowl", LimeMixingBowlBlock::new);
		GREEN_MIXING_BOWL = REGISTRY.register("green_mixing_bowl", GreenMixingBowlBlock::new);
		CYAN_MIXING_BOWL = REGISTRY.register("cyan_mixing_bowl", CyanMixingBowlBlock::new);
		LIGHT_BLUE_MIXING_BOWL = REGISTRY.register("light_blue_mixing_bowl", LightBlueMixingBowlBlock::new);
		BLUE_MIXING_BOWL = REGISTRY.register("blue_mixing_bowl", BlueMixingBowlBlock::new);
		PURPLE_MIXING_BOWL = REGISTRY.register("purple_mixing_bowl", PurpleMixingBowlBlock::new);
		MAGENTA_MIXING_BOWL = REGISTRY.register("magenta_mixing_bowl", MagentaMixingBowlBlock::new);
		PINK_MIXING_BOWL = REGISTRY.register("pink_mixing_bowl", PinkMixingBowlBlock::new);
		SPRINKLER = REGISTRY.register("sprinkler", SprinklerBlock::new);
		WOODEN_PLANTER_BLOCK = REGISTRY.register("wooden_planter_block", WoodenPlanterBlockBlock::new);
		STONE_PLANTER_BLOCK = REGISTRY.register("stone_planter_block", StonePlanterBlockBlock::new);
		IRON_PLANTER_BLOCK = REGISTRY.register("iron_planter_block", IronPlanterBlockBlock::new);
		GOLDEN_PLANTER_BLOCK = REGISTRY.register("golden_planter_block", GoldenPlanterBlockBlock::new);
		DIAMOND_PLANTER_BLOCK = REGISTRY.register("diamond_planter_block", DiamondPlanterBlockBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	@EventBusSubscriber(Dist.CLIENT)
	public static class BlocksClientSideHandler {
		@SubscribeEvent
		public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
			OakIceBox1Block.blockColorLoad(event);
		}

		@SubscribeEvent
		public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
			OakIceBox1Block.itemColorLoad(event);
		}
	}
}