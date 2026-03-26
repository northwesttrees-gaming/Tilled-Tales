package net.nwt.tilledtales.procedures;

import net.nwt.tilledtales.init.TilledTalesModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

public class BlueberryPiePlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(TilledTalesModMobEffects.SUGAR_RUSH, 3600, 0));
	}
}