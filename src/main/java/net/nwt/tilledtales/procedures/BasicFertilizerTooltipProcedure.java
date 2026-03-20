package net.nwt.tilledtales.procedures;

import net.minecraft.network.chat.Component;

public class BasicFertilizerTooltipProcedure {
	public static String execute() {
		return ("\u00A76" + Component.translatable("tooltip.tilled_tales.basic_fertilizer_0").getString()) + "" + ("\u00A7a" + Component.translatable("tooltip.tilled_tales.basic_fertilizer_1").getString());
	}
}