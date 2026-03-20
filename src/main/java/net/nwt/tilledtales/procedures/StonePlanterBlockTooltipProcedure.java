package net.nwt.tilledtales.procedures;

import net.minecraft.network.chat.Component;

public class StonePlanterBlockTooltipProcedure {
	public static String execute() {
		return "\u00A76" + Component.translatable("tooltip.tilled_tales.stone_planter_0").getString();
	}
}