package net.nwt.tilledtales.procedures;

import net.minecraft.network.chat.Component;

public class ChurnedButterTooltipProcedure {
	public static String execute() {
		return (FormatTooltipTitleProcedure.execute() + "" + Component.translatable("tooltip.tilled_tales.title.description").getString() + "\n") + ""
				+ (FormatTooltipDescriptionProcedure.execute() + "" + Component.translatable("tooltip.tilled_tales.description.churned_butter").getString() + "\n")
				+ (FormatTooltipTitleProcedure.execute() + "" + Component.translatable("tooltip.tilled_tales.title.stats").getString() + "\n")
				+ (FormatTooltipListProcedure.execute() + "" + FormatTooltipTextProcedure.execute() + Component.translatable("tooltip.tilled_tales.none").getString() + "\n")
				+ (FormatTooltipTitleProcedure.execute() + "" + Component.translatable("tooltip.tilled_tales.title.effects").getString() + "\n")
				+ (FormatTooltipListProcedure.execute() + "" + FormatTooltipTextProcedure.execute() + Component.translatable("tooltip.tilled_tales.none").getString());
	}
}