package net.nwt.tilledtales.procedures;

import net.minecraft.network.chat.Component;

public class BlueberriesTooltipProcedure {
	public static String execute() {
		return (FormatTooltipTitleProcedure.execute() + "" + Component.translatable("tooltip.tilled_tales.title.description").getString() + "\n") + ""
				+ (FormatTooltipDescriptionProcedure.execute() + "" + Component.translatable("tooltip.tilled_tales.description.blueberries").getString() + "\n")
				+ (FormatTooltipTitleProcedure.execute() + "" + Component.translatable("tooltip.tilled_tales.title.stats").getString() + "\n")
				+ (FormatTooltipListProcedure.execute() + "" + FormatTooltipTextProcedure.execute() + Component.translatable("tooltip.tilled_tales.stats.nutrients").getString() + ": " + FormatTooltipPositiveProcedure.execute() + "1" + "\n")
				+ (FormatTooltipListProcedure.execute() + "" + FormatTooltipTextProcedure.execute() + Component.translatable("tooltip.tilled_tales.stats.saturation").getString() + ": " + FormatTooltipPositiveProcedure.execute() + "0.2" + "\n")
				+ (FormatTooltipTitleProcedure.execute() + "" + Component.translatable("tooltip.tilled_tales.title.effects").getString() + "\n")
				+ (FormatTooltipListProcedure.execute() + "" + FormatTooltipTextProcedure.execute() + Component.translatable("tooltip.tilled_tales.effects.none").getString());
	}
}