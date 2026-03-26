/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.nwt.tilledtales.init;

import net.nwt.tilledtales.item.*;
import net.nwt.tilledtales.TilledTalesMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

public class TilledTalesModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(TilledTalesMod.MODID);
	public static final DeferredItem<Item> OAK_DASH_CHURN;
	public static final DeferredItem<Item> OAK_DASH_CHURN_UP;
	public static final DeferredItem<Item> CHURNED_BUTTER;
	public static final DeferredItem<Item> SALT_BLOCK;
	public static final DeferredItem<Item> SALT;
	public static final DeferredItem<Item> OAK_ICE_BOX;
	public static final DeferredItem<Item> OAK_ICE_BOX_1;
	public static final DeferredItem<Item> OAK_ICE_BOX_2;
	public static final DeferredItem<Item> MILLSTONE;
	public static final DeferredItem<Item> MILLSTONE_1;
	public static final DeferredItem<Item> FLOUR;
	public static final DeferredItem<Item> MILLSTONE_2;
	public static final DeferredItem<Item> MILLSTONE_3;
	public static final DeferredItem<Item> MILLSTONE_4;
	public static final DeferredItem<Item> MILLSTONE_5;
	public static final DeferredItem<Item> MILLSTONE_6;
	public static final DeferredItem<Item> MILLSTONE_7;
	public static final DeferredItem<Item> MILLSTONE_8;
	public static final DeferredItem<Item> MILLSTONE_9;
	public static final DeferredItem<Item> PIE_CRUST;
	public static final DeferredItem<Item> COUNTER;
	public static final DeferredItem<Item> WHITE_MIXING_BOWL;
	public static final DeferredItem<Item> LIGHT_GRAY_MIXING_BOWL;
	public static final DeferredItem<Item> GRAY_MIXING_BOWL;
	public static final DeferredItem<Item> BLACK_MIXING_BOWL;
	public static final DeferredItem<Item> BROWN_MIXING_BOWL;
	public static final DeferredItem<Item> RED_MIXING_BOWL;
	public static final DeferredItem<Item> ORANGE_MIXING_BOWL;
	public static final DeferredItem<Item> YELLOW_MIXING_BOWL;
	public static final DeferredItem<Item> LIME_MIXING_BOWL;
	public static final DeferredItem<Item> GREEN_MIXING_BOWL;
	public static final DeferredItem<Item> CYAN_MIXING_BOWL;
	public static final DeferredItem<Item> LIGHT_BLUE_MIXING_BOWL;
	public static final DeferredItem<Item> BLUE_MIXING_BOWL;
	public static final DeferredItem<Item> PURPLE_MIXING_BOWL;
	public static final DeferredItem<Item> MAGENTA_MIXING_BOWL;
	public static final DeferredItem<Item> PINK_MIXING_BOWL;
	public static final DeferredItem<Item> WHEAT_SEEDS;
	public static final DeferredItem<Item> BASIC_FERTILIZER;
	public static final DeferredItem<Item> PREMIUM_FERTILIZER;
	public static final DeferredItem<Item> SPRINKLER;
	public static final DeferredItem<Item> WHEAT_GRAIN;
	public static final DeferredItem<Item> DIAMOND_PLANTER;
	public static final DeferredItem<Item> GOLDEN_PLANTER;
	public static final DeferredItem<Item> IRON_PLANTER;
	public static final DeferredItem<Item> STONE_PLANTER;
	public static final DeferredItem<Item> WOODEN_PLANTER;
	public static final DeferredItem<Item> WOODEN_PLANTER_BLOCK;
	public static final DeferredItem<Item> STONE_PLANTER_BLOCK;
	public static final DeferredItem<Item> IRON_PLANTER_BLOCK;
	public static final DeferredItem<Item> GOLDEN_PLANTER_BLOCK;
	public static final DeferredItem<Item> DIAMOND_PLANTER_BLOCK;
	public static final DeferredItem<Item> BLUEBERRY_SEEDS;
	public static final DeferredItem<Item> STRAWBERRIES;
	public static final DeferredItem<Item> COPPER_PLANTER_BLOCK;
	public static final DeferredItem<Item> COPPER_PLANTER;
	public static final DeferredItem<Item> STRAWBERRY_SEEDS;
	public static final DeferredItem<Item> BLUEBERRY_PIE;
	public static final DeferredItem<Item> BLUEBERRIES;
	static {
		OAK_DASH_CHURN = block(TilledTalesModBlocks.OAK_DASH_CHURN);
		OAK_DASH_CHURN_UP = block(TilledTalesModBlocks.OAK_DASH_CHURN_UP);
		CHURNED_BUTTER = REGISTRY.register("churned_butter", ChurnedButterItem::new);
		SALT_BLOCK = block(TilledTalesModBlocks.SALT_BLOCK);
		SALT = REGISTRY.register("salt", SaltItem::new);
		OAK_ICE_BOX = block(TilledTalesModBlocks.OAK_ICE_BOX);
		OAK_ICE_BOX_1 = block(TilledTalesModBlocks.OAK_ICE_BOX_1);
		OAK_ICE_BOX_2 = block(TilledTalesModBlocks.OAK_ICE_BOX_2);
		MILLSTONE = block(TilledTalesModBlocks.MILLSTONE);
		MILLSTONE_1 = block(TilledTalesModBlocks.MILLSTONE_1);
		FLOUR = REGISTRY.register("flour", FlourItem::new);
		MILLSTONE_2 = block(TilledTalesModBlocks.MILLSTONE_2);
		MILLSTONE_3 = block(TilledTalesModBlocks.MILLSTONE_3);
		MILLSTONE_4 = block(TilledTalesModBlocks.MILLSTONE_4);
		MILLSTONE_5 = block(TilledTalesModBlocks.MILLSTONE_5);
		MILLSTONE_6 = block(TilledTalesModBlocks.MILLSTONE_6);
		MILLSTONE_7 = block(TilledTalesModBlocks.MILLSTONE_7);
		MILLSTONE_8 = block(TilledTalesModBlocks.MILLSTONE_8);
		MILLSTONE_9 = block(TilledTalesModBlocks.MILLSTONE_9);
		PIE_CRUST = REGISTRY.register("pie_crust", PieCrustItem::new);
		COUNTER = block(TilledTalesModBlocks.COUNTER);
		WHITE_MIXING_BOWL = block(TilledTalesModBlocks.WHITE_MIXING_BOWL);
		LIGHT_GRAY_MIXING_BOWL = block(TilledTalesModBlocks.LIGHT_GRAY_MIXING_BOWL);
		GRAY_MIXING_BOWL = block(TilledTalesModBlocks.GRAY_MIXING_BOWL);
		BLACK_MIXING_BOWL = block(TilledTalesModBlocks.BLACK_MIXING_BOWL);
		BROWN_MIXING_BOWL = block(TilledTalesModBlocks.BROWN_MIXING_BOWL);
		RED_MIXING_BOWL = block(TilledTalesModBlocks.RED_MIXING_BOWL);
		ORANGE_MIXING_BOWL = block(TilledTalesModBlocks.ORANGE_MIXING_BOWL);
		YELLOW_MIXING_BOWL = block(TilledTalesModBlocks.YELLOW_MIXING_BOWL);
		LIME_MIXING_BOWL = block(TilledTalesModBlocks.LIME_MIXING_BOWL);
		GREEN_MIXING_BOWL = block(TilledTalesModBlocks.GREEN_MIXING_BOWL);
		CYAN_MIXING_BOWL = block(TilledTalesModBlocks.CYAN_MIXING_BOWL);
		LIGHT_BLUE_MIXING_BOWL = block(TilledTalesModBlocks.LIGHT_BLUE_MIXING_BOWL);
		BLUE_MIXING_BOWL = block(TilledTalesModBlocks.BLUE_MIXING_BOWL);
		PURPLE_MIXING_BOWL = block(TilledTalesModBlocks.PURPLE_MIXING_BOWL);
		MAGENTA_MIXING_BOWL = block(TilledTalesModBlocks.MAGENTA_MIXING_BOWL);
		PINK_MIXING_BOWL = block(TilledTalesModBlocks.PINK_MIXING_BOWL);
		WHEAT_SEEDS = REGISTRY.register("wheat_seeds", WheatSeedsItem::new);
		BASIC_FERTILIZER = REGISTRY.register("basic_fertilizer", BasicFertilizerItem::new);
		PREMIUM_FERTILIZER = REGISTRY.register("premium_fertilizer", PremiumFertilizerItem::new);
		SPRINKLER = block(TilledTalesModBlocks.SPRINKLER);
		WHEAT_GRAIN = REGISTRY.register("wheat_grain", WheatGrainItem::new);
		DIAMOND_PLANTER = REGISTRY.register("diamond_planter", DiamondPlanterItem::new);
		GOLDEN_PLANTER = REGISTRY.register("golden_planter", GoldenPlanterItem::new);
		IRON_PLANTER = REGISTRY.register("iron_planter", IronPlanterItem::new);
		STONE_PLANTER = REGISTRY.register("stone_planter", StonePlanterItem::new);
		WOODEN_PLANTER = REGISTRY.register("wooden_planter", WoodenPlanterItem::new);
		WOODEN_PLANTER_BLOCK = block(TilledTalesModBlocks.WOODEN_PLANTER_BLOCK);
		STONE_PLANTER_BLOCK = block(TilledTalesModBlocks.STONE_PLANTER_BLOCK);
		IRON_PLANTER_BLOCK = block(TilledTalesModBlocks.IRON_PLANTER_BLOCK);
		GOLDEN_PLANTER_BLOCK = block(TilledTalesModBlocks.GOLDEN_PLANTER_BLOCK);
		DIAMOND_PLANTER_BLOCK = block(TilledTalesModBlocks.DIAMOND_PLANTER_BLOCK);
		BLUEBERRY_SEEDS = REGISTRY.register("blueberry_seeds", BlueberrySeedsItem::new);
		STRAWBERRIES = REGISTRY.register("strawberries", StrawberriesItem::new);
		COPPER_PLANTER_BLOCK = block(TilledTalesModBlocks.COPPER_PLANTER_BLOCK);
		COPPER_PLANTER = REGISTRY.register("copper_planter", CopperPlanterItem::new);
		STRAWBERRY_SEEDS = REGISTRY.register("strawberry_seeds", StrawberrySeedsItem::new);
		BLUEBERRY_PIE = REGISTRY.register("blueberry_pie", BlueberryPieItem::new);
		BLUEBERRIES = REGISTRY.register("blueberries", BlueberriesItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}