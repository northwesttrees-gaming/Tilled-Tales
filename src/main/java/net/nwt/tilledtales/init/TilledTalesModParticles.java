/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.nwt.tilledtales.init;

import net.nwt.tilledtales.client.particle.SugarRushParticleParticle;
import net.nwt.tilledtales.client.particle.SugarCrashParticleParticle;
import net.nwt.tilledtales.client.particle.ChurningEffectParticle;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(Dist.CLIENT)
public class TilledTalesModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(TilledTalesModParticleTypes.CHURNING_EFFECT.get(), ChurningEffectParticle::provider);
		event.registerSpriteSet(TilledTalesModParticleTypes.SUGAR_RUSH_PARTICLE.get(), SugarRushParticleParticle::provider);
		event.registerSpriteSet(TilledTalesModParticleTypes.SUGAR_CRASH_PARTICLE.get(), SugarCrashParticleParticle::provider);
	}
}