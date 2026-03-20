/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.nwt.tilledtales.init;

import net.nwt.tilledtales.TilledTalesMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

public class TilledTalesModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, TilledTalesMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CHURNING_EFFECT = REGISTRY.register("churning_effect", () -> new SimpleParticleType(false));
}