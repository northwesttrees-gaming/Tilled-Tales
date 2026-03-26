package net.nwt.tilledtales.procedures;

import net.nwt.tilledtales.init.TilledTalesModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

public class SugarRushEffectExpiresProcedure {
	public static void execute(Entity entity, double amplifier) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(TilledTalesModMobEffects.SUGAR_CRASH, 1800, (int) amplifier));
	}
}