package net.nwt.tilledtales.procedures;

import net.minecraft.network.chat.Component;

public class CounterTooltipProcedure {
	public static String execute() {
		return "\u00A76" + Component.translatable("tooltip.tilled_tales.counter_0").getString();
	}
}