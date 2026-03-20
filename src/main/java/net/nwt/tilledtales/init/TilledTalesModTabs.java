/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.nwt.tilledtales.init;

import net.nwt.tilledtales.TilledTalesMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class TilledTalesModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TilledTalesMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TILLED_TALES_BLOCKS = REGISTRY.register("tilled_tales_blocks",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.tilled_tales.tilled_tales_blocks")).icon(() -> new ItemStack(TilledTalesModBlocks.SALT_BLOCK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TilledTalesModBlocks.SALT_BLOCK.get().asItem());
				tabData.accept(TilledTalesModBlocks.COUNTER.get().asItem());
				tabData.accept(TilledTalesModBlocks.MILLSTONE.get().asItem());
				tabData.accept(TilledTalesModBlocks.OAK_ICE_BOX.get().asItem());
				tabData.accept(TilledTalesModBlocks.OAK_DASH_CHURN.get().asItem());
				tabData.accept(TilledTalesModBlocks.SPRINKLER.get().asItem());
				tabData.accept(TilledTalesModItems.WOODEN_PLANTER.get());
				tabData.accept(TilledTalesModItems.STONE_PLANTER.get());
				tabData.accept(TilledTalesModItems.IRON_PLANTER.get());
				tabData.accept(TilledTalesModItems.GOLDEN_PLANTER.get());
				tabData.accept(TilledTalesModItems.DIAMOND_PLANTER.get());
				tabData.accept(TilledTalesModBlocks.WHITE_MIXING_BOWL.get().asItem());
				tabData.accept(TilledTalesModBlocks.LIGHT_GRAY_MIXING_BOWL.get().asItem());
				tabData.accept(TilledTalesModBlocks.GRAY_MIXING_BOWL.get().asItem());
				tabData.accept(TilledTalesModBlocks.BLACK_MIXING_BOWL.get().asItem());
				tabData.accept(TilledTalesModBlocks.BROWN_MIXING_BOWL.get().asItem());
				tabData.accept(TilledTalesModBlocks.RED_MIXING_BOWL.get().asItem());
				tabData.accept(TilledTalesModBlocks.ORANGE_MIXING_BOWL.get().asItem());
				tabData.accept(TilledTalesModBlocks.YELLOW_MIXING_BOWL.get().asItem());
				tabData.accept(TilledTalesModBlocks.LIME_MIXING_BOWL.get().asItem());
				tabData.accept(TilledTalesModBlocks.GREEN_MIXING_BOWL.get().asItem());
				tabData.accept(TilledTalesModBlocks.CYAN_MIXING_BOWL.get().asItem());
				tabData.accept(TilledTalesModBlocks.LIGHT_BLUE_MIXING_BOWL.get().asItem());
				tabData.accept(TilledTalesModBlocks.BLUE_MIXING_BOWL.get().asItem());
				tabData.accept(TilledTalesModBlocks.PURPLE_MIXING_BOWL.get().asItem());
				tabData.accept(TilledTalesModBlocks.MAGENTA_MIXING_BOWL.get().asItem());
				tabData.accept(TilledTalesModBlocks.PINK_MIXING_BOWL.get().asItem());
			}).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TILLED_TALES_ITEMS = REGISTRY.register("tilled_tales_items",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.tilled_tales.tilled_tales_items")).icon(() -> new ItemStack(TilledTalesModItems.CHURNED_BUTTER.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TilledTalesModItems.BASIC_FERTILIZER.get());
				tabData.accept(TilledTalesModItems.PREMIUM_FERTILIZER.get());
				tabData.accept(TilledTalesModItems.WHEAT_SEEDS.get());
				tabData.accept(TilledTalesModItems.WHEAT_GRAIN.get());
				tabData.accept(TilledTalesModItems.SALT.get());
				tabData.accept(TilledTalesModItems.FLOUR.get());
				tabData.accept(TilledTalesModItems.CHURNED_BUTTER.get());
				tabData.accept(TilledTalesModItems.PIE_CRUST.get());
				tabData.accept(TilledTalesModItems.BLUEBERRY_SEEDS.get());
				tabData.accept(TilledTalesModItems.BLUE_BERRIES.get());
				tabData.accept(TilledTalesModItems.STRAWBERRIES.get());
			}).withTabsBefore(TILLED_TALES_BLOCKS.getId()).build());
}