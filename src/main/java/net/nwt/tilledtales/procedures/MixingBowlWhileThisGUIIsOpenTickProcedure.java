package net.nwt.tilledtales.procedures;

import net.minecraft.world.level.LevelAccessor;

public class MixingBowlWhileThisGUIIsOpenTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		PieCrustMixingBowlProcedure.execute(world, x, y, z);
	}
}