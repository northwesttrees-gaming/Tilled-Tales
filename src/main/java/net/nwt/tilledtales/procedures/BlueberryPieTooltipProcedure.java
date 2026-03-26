package net.nwt.tilledtales.procedures;

import net.minecraft.network.chat.Component;

public class BlueberryPieTooltipProcedure {
	public static String execute() {
		return (FormatTooltipTitleProcedure.execute() + "" + Component.translatable("tooltip.tilled_tales.title.description").getString() + "\n") + ""
				+ (FormatTooltipDescriptionProcedure.execute() + "" + Component.translatable("tooltip.tilled_tales.description.buleberry_pie").getString() + "\n")
				+ (FormatTooltipTitleProcedure.execute() + "" + Component.translatable("tooltip.tilled_tales.title.stats").getString() + "\n")
				+ (FormatTooltipListProcedure.execute() + "" + FormatTooltipTextProcedure.execute() + Component.translatable("tooltip.tilled_tales.stats.nutrients").getString() + ": " + FormatTooltipPositiveProcedure.execute() + "8" + "\n")
				+ (FormatTooltipListProcedure.execute() + "" + FormatTooltipTextProcedure.execute() + Component.translatable("tooltip.tilled_tales.stats.saturation").getString() + ": " + FormatTooltipPositiveProcedure.execute() + "4.8" + "\n")
				+ (FormatTooltipTitleProcedure.execute() + "" + Component.translatable("tooltip.tilled_tales.title.effects").getString() + "\n")
				+ (FormatTooltipListProcedure.execute() + "" + FormatTooltipTextProcedure.execute() + Component.translatable("effect.tilled_tales.sugar_rush").getString() + " I " + FormatTooltipPositiveProcedure.execute() + "(3:00)" + "\n")
				+ (FormatTooltipListProcedure.execute() + "" + FormatTooltipTextProcedure.execute() + Component.translatable("effect.tilled_tales.sugar_crash").getString() + " I " + FormatTooltipNegativeProcedure.execute() + "(1:30)");
	}
}