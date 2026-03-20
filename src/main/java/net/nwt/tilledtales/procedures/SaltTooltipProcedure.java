package net.nwt.tilledtales.procedures;

import net.minecraft.network.chat.Component;

public class SaltTooltipProcedure {
	public static String execute() {
		return "\u00A76" + Component.translatable("tooltip.tilled_tales.salt_0").getString();
	}
}