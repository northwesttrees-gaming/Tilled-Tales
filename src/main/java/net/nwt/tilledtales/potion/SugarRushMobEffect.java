package net.nwt.tilledtales.potion;

import net.nwt.tilledtales.init.TilledTalesModParticleTypes;
import net.nwt.tilledtales.TilledTalesMod;

import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;

public class SugarRushMobEffect extends MobEffect {
	public SugarRushMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -2763297);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(TilledTalesMod.MODID, "effect.sugar_rush_0"), 0.03, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(NeoForgeMod.SWIM_SPEED, ResourceLocation.fromNamespaceAndPath(TilledTalesMod.MODID, "effect.sugar_rush_1"), 0.03, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.FLYING_SPEED, ResourceLocation.fromNamespaceAndPath(TilledTalesMod.MODID, "effect.sugar_rush_2"), 0.03, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public ParticleOptions createParticleOptions(MobEffectInstance mobEffectInstance) {
		return (SimpleParticleType) (TilledTalesModParticleTypes.SUGAR_RUSH_PARTICLE.get());
	}
}