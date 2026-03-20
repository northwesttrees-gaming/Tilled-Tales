package net.nwt.tilledtales.procedures;

import net.nwt.tilledtales.init.TilledTalesModBlocks;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class OakIceBoxOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 1, z))) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("c:is_icy")))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("c:is_snowy")))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("c:is_aquatic_icy")))) {
				if ((blockstate.getBlock().getStateDefinition().getProperty("state") instanceof EnumProperty _getep5 ? blockstate.getValue(_getep5).toString() : "").equals("water")) {
					{
						String _value = "ice";
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("state") instanceof EnumProperty _enumProp && _enumProp.getValue(_value).isPresent())
							world.setBlock(_pos, _bs.setValue(_enumProp, (Enum) _enumProp.getValue(_value).get()), 3);
					}
					{
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockState _bs = TilledTalesModBlocks.OAK_ICE_BOX_2.get().defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Property<?> _propertyOld : _bso.getProperties()) {
							Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
							if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
								try {
									_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
								} catch (Exception e) {
								}
						}
						BlockEntity _be = world.getBlockEntity(_bp);
						CompoundTag _bnbt = null;
						if (_be != null) {
							_bnbt = _be.saveWithFullMetadata(world.registryAccess());
							_be.setRemoved();
						}
						world.setBlock(_bp, _bs, 3);
						if (_bnbt != null) {
							_be = world.getBlockEntity(_bp);
							if (_be != null) {
								try {
									_be.loadWithComponents(_bnbt, world.registryAccess());
								} catch (Exception ignored) {
								}
							}
						}
					}
				}
			} else {
				if (world.getLevelData().isRaining() && (blockstate.getBlock().getStateDefinition().getProperty("state") instanceof EnumProperty _getep10 ? blockstate.getValue(_getep10).toString() : "").equals("empty")) {
					{
						String _value = "water";
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("state") instanceof EnumProperty _enumProp && _enumProp.getValue(_value).isPresent())
							world.setBlock(_pos, _bs.setValue(_enumProp, (Enum) _enumProp.getValue(_value).get()), 3);
					}
					{
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockState _bs = TilledTalesModBlocks.OAK_ICE_BOX_1.get().defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Property<?> _propertyOld : _bso.getProperties()) {
							Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
							if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
								try {
									_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
								} catch (Exception e) {
								}
						}
						BlockEntity _be = world.getBlockEntity(_bp);
						CompoundTag _bnbt = null;
						if (_be != null) {
							_bnbt = _be.saveWithFullMetadata(world.registryAccess());
							_be.setRemoved();
						}
						world.setBlock(_bp, _bs, 3);
						if (_bnbt != null) {
							_be = world.getBlockEntity(_bp);
							if (_be != null) {
								try {
									_be.loadWithComponents(_bnbt, world.registryAccess());
								} catch (Exception ignored) {
								}
							}
						}
					}
				}
			}
		}
	}
}