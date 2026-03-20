/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.nwt.tilledtales.init;

import net.nwt.tilledtales.block.entity.*;
import net.nwt.tilledtales.TilledTalesMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

@EventBusSubscriber
public class TilledTalesModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, TilledTalesMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<OakDashChurnBlockEntity>> OAK_DASH_CHURN = register("oak_dash_churn", TilledTalesModBlocks.OAK_DASH_CHURN, OakDashChurnBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<OakDashChurnUpBlockEntity>> OAK_DASH_CHURN_UP = register("oak_dash_churn_up", TilledTalesModBlocks.OAK_DASH_CHURN_UP, OakDashChurnUpBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<OakIceBoxBlockEntity>> OAK_ICE_BOX = register("oak_ice_box", TilledTalesModBlocks.OAK_ICE_BOX, OakIceBoxBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<OakIceBox1BlockEntity>> OAK_ICE_BOX_1 = register("oak_ice_box_1", TilledTalesModBlocks.OAK_ICE_BOX_1, OakIceBox1BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<OakIceBox2BlockEntity>> OAK_ICE_BOX_2 = register("oak_ice_box_2", TilledTalesModBlocks.OAK_ICE_BOX_2, OakIceBox2BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MillstoneBlockEntity>> MILLSTONE = register("millstone", TilledTalesModBlocks.MILLSTONE, MillstoneBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Millstone1BlockEntity>> MILLSTONE_1 = register("millstone_1", TilledTalesModBlocks.MILLSTONE_1, Millstone1BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Millstone2BlockEntity>> MILLSTONE_2 = register("millstone_2", TilledTalesModBlocks.MILLSTONE_2, Millstone2BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Millstone3BlockEntity>> MILLSTONE_3 = register("millstone_3", TilledTalesModBlocks.MILLSTONE_3, Millstone3BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Millstone4BlockEntity>> MILLSTONE_4 = register("millstone_4", TilledTalesModBlocks.MILLSTONE_4, Millstone4BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Millstone5BlockEntity>> MILLSTONE_5 = register("millstone_5", TilledTalesModBlocks.MILLSTONE_5, Millstone5BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Millstone6BlockEntity>> MILLSTONE_6 = register("millstone_6", TilledTalesModBlocks.MILLSTONE_6, Millstone6BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Millstone7BlockEntity>> MILLSTONE_7 = register("millstone_7", TilledTalesModBlocks.MILLSTONE_7, Millstone7BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Millstone8BlockEntity>> MILLSTONE_8 = register("millstone_8", TilledTalesModBlocks.MILLSTONE_8, Millstone8BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Millstone9BlockEntity>> MILLSTONE_9 = register("millstone_9", TilledTalesModBlocks.MILLSTONE_9, Millstone9BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CounterBlockEntity>> COUNTER = register("counter", TilledTalesModBlocks.COUNTER, CounterBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WhiteMixingBowlBlockEntity>> WHITE_MIXING_BOWL = register("white_mixing_bowl", TilledTalesModBlocks.WHITE_MIXING_BOWL, WhiteMixingBowlBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<LightGrayMixingBowlBlockEntity>> LIGHT_GRAY_MIXING_BOWL = register("light_gray_mixing_bowl", TilledTalesModBlocks.LIGHT_GRAY_MIXING_BOWL, LightGrayMixingBowlBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GrayMixingBowlBlockEntity>> GRAY_MIXING_BOWL = register("gray_mixing_bowl", TilledTalesModBlocks.GRAY_MIXING_BOWL, GrayMixingBowlBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlackMixingBowlBlockEntity>> BLACK_MIXING_BOWL = register("black_mixing_bowl", TilledTalesModBlocks.BLACK_MIXING_BOWL, BlackMixingBowlBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BrownMixingBowlBlockEntity>> BROWN_MIXING_BOWL = register("brown_mixing_bowl", TilledTalesModBlocks.BROWN_MIXING_BOWL, BrownMixingBowlBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RedMixingBowlBlockEntity>> RED_MIXING_BOWL = register("red_mixing_bowl", TilledTalesModBlocks.RED_MIXING_BOWL, RedMixingBowlBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<OrangeMixingBowlBlockEntity>> ORANGE_MIXING_BOWL = register("orange_mixing_bowl", TilledTalesModBlocks.ORANGE_MIXING_BOWL, OrangeMixingBowlBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<YellowMixingBowlBlockEntity>> YELLOW_MIXING_BOWL = register("yellow_mixing_bowl", TilledTalesModBlocks.YELLOW_MIXING_BOWL, YellowMixingBowlBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<LimeMixingBowlBlockEntity>> LIME_MIXING_BOWL = register("lime_mixing_bowl", TilledTalesModBlocks.LIME_MIXING_BOWL, LimeMixingBowlBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GreenMixingBowlBlockEntity>> GREEN_MIXING_BOWL = register("green_mixing_bowl", TilledTalesModBlocks.GREEN_MIXING_BOWL, GreenMixingBowlBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CyanMixingBowlBlockEntity>> CYAN_MIXING_BOWL = register("cyan_mixing_bowl", TilledTalesModBlocks.CYAN_MIXING_BOWL, CyanMixingBowlBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<LightBlueMixingBowlBlockEntity>> LIGHT_BLUE_MIXING_BOWL = register("light_blue_mixing_bowl", TilledTalesModBlocks.LIGHT_BLUE_MIXING_BOWL, LightBlueMixingBowlBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlueMixingBowlBlockEntity>> BLUE_MIXING_BOWL = register("blue_mixing_bowl", TilledTalesModBlocks.BLUE_MIXING_BOWL, BlueMixingBowlBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PurpleMixingBowlBlockEntity>> PURPLE_MIXING_BOWL = register("purple_mixing_bowl", TilledTalesModBlocks.PURPLE_MIXING_BOWL, PurpleMixingBowlBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MagentaMixingBowlBlockEntity>> MAGENTA_MIXING_BOWL = register("magenta_mixing_bowl", TilledTalesModBlocks.MAGENTA_MIXING_BOWL, MagentaMixingBowlBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PinkMixingBowlBlockEntity>> PINK_MIXING_BOWL = register("pink_mixing_bowl", TilledTalesModBlocks.PINK_MIXING_BOWL, PinkMixingBowlBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SprinklerBlockEntity>> SPRINKLER = register("sprinkler", TilledTalesModBlocks.SPRINKLER, SprinklerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WoodenPlanterBlockBlockEntity>> WOODEN_PLANTER_BLOCK = register("wooden_planter_block", TilledTalesModBlocks.WOODEN_PLANTER_BLOCK, WoodenPlanterBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StonePlanterBlockBlockEntity>> STONE_PLANTER_BLOCK = register("stone_planter_block", TilledTalesModBlocks.STONE_PLANTER_BLOCK, StonePlanterBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<IronPlanterBlockBlockEntity>> IRON_PLANTER_BLOCK = register("iron_planter_block", TilledTalesModBlocks.IRON_PLANTER_BLOCK, IronPlanterBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GoldenPlanterBlockBlockEntity>> GOLDEN_PLANTER_BLOCK = register("golden_planter_block", TilledTalesModBlocks.GOLDEN_PLANTER_BLOCK, GoldenPlanterBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DiamondPlanterBlockBlockEntity>> DIAMOND_PLANTER_BLOCK = register("diamond_planter_block", TilledTalesModBlocks.DIAMOND_PLANTER_BLOCK, DiamondPlanterBlockBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, OAK_DASH_CHURN.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, OAK_DASH_CHURN_UP.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, OAK_ICE_BOX.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, OAK_ICE_BOX_1.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, OAK_ICE_BOX_2.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MILLSTONE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MILLSTONE_1.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MILLSTONE_2.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MILLSTONE_3.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MILLSTONE_4.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MILLSTONE_5.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MILLSTONE_6.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MILLSTONE_7.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MILLSTONE_8.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MILLSTONE_9.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, COUNTER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WHITE_MIXING_BOWL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LIGHT_GRAY_MIXING_BOWL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GRAY_MIXING_BOWL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BLACK_MIXING_BOWL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BROWN_MIXING_BOWL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, RED_MIXING_BOWL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ORANGE_MIXING_BOWL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, YELLOW_MIXING_BOWL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LIME_MIXING_BOWL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GREEN_MIXING_BOWL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CYAN_MIXING_BOWL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LIGHT_BLUE_MIXING_BOWL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BLUE_MIXING_BOWL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PURPLE_MIXING_BOWL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MAGENTA_MIXING_BOWL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PINK_MIXING_BOWL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SPRINKLER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WOODEN_PLANTER_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, STONE_PLANTER_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, IRON_PLANTER_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GOLDEN_PLANTER_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DIAMOND_PLANTER_BLOCK.get(), SidedInvWrapper::new);
	}
}