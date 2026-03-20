package net.nwt.tilledtales.procedures;

import net.minecraft.network.chat.Component;

public class IronPlanterBlockTooltipProcedure {
	public static String execute() {
		return "\u00A76" + Component.translatable("tooltip.tilled_tales.iron_planter_0").getString();
	}
}