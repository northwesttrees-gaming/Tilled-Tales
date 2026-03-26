/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.nwt.tilledtales.init;

import net.nwt.tilledtales.procedures.SugarRushEffectExpiresProcedure;
import net.nwt.tilledtales.potion.SugarRushMobEffect;
import net.nwt.tilledtales.potion.SugarCrashMobEffect;
import net.nwt.tilledtales.TilledTalesMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber
public class TilledTalesModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, TilledTalesMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> SUGAR_RUSH = REGISTRY.register("sugar_rush", () -> new SugarRushMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SUGAR_CRASH = REGISTRY.register("sugar_crash", () -> new SugarCrashMobEffect());

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(SUGAR_RUSH)) {
			SugarRushEffectExpiresProcedure.execute(entity, effectInstance.getAmplifier());
		}
	}
}