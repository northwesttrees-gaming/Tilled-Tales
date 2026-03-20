package net.nwt.tilledtales.procedures;

import net.minecraft.network.chat.Component;

public class WheatGrainTooltipProcedure {
	public static String execute() {
		return "\u00A76" + Component.translatable("tooltip.tilled_tales.what_grain_0").getString();
	}
}