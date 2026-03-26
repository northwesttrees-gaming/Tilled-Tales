package net.nwt.tilledtales.potion;

import net.nwt.tilledtales.init.TilledTalesModParticleTypes;
import net.nwt.tilledtales.TilledTalesMod;

import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.EffectCures;
import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;

import java.util.Set;

public class SugarCrashMobEffect extends MobEffect {
	public SugarCrashMobEffect() {
		super(MobEffectCategory.HARMFUL, -2763297);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(TilledTalesMod.MODID, "effect.sugar_crash_0"), -0.03, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(NeoForgeMod.SWIM_SPEED, ResourceLocation.fromNamespaceAndPath(TilledTalesMod.MODID, "effect.sugar_crash_1"), -0.03, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.FLYING_SPEED, ResourceLocation.fromNamespaceAndPath(TilledTalesMod.MODID, "effect.sugar_crash_2"), -0.03, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public ParticleOptions createParticleOptions(MobEffectInstance mobEffectInstance) {
		return (SimpleParticleType) (TilledTalesModParticleTypes.SUGAR_CRASH_PARTICLE.get());
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
		cures.add(EffectCures.MILK);
		cures.add(EffectCures.PROTECTED_BY_TOTEM);
		cures.add(EffectCures.HONEY);
	}
}