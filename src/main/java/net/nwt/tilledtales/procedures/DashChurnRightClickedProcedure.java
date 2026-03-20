package net.nwt.tilledtales.procedures;

import net.nwt.tilledtales.init.TilledTalesModParticleTypes;
import net.nwt.tilledtales.init.TilledTalesModItems;
import net.nwt.tilledtales.init.TilledTalesModBlocks;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DashChurnRightClickedProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getLevel().getBlockState(event.getPos()), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		ItemStack iHand = ItemStack.EMPTY;
		ItemStack iBlock0 = ItemStack.EMPTY;
		ItemStack iBlock1 = ItemStack.EMPTY;
		if (blockstate.getBlock() == TilledTalesModBlocks.OAK_DASH_CHURN.get() || blockstate.getBlock() == TilledTalesModBlocks.OAK_DASH_CHURN_UP.get()) {
			iHand = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
			iBlock0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
			iBlock1 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).copy();
			if (iHand.getItem() == Items.MILK_BUCKET && iBlock0.getItem() == ItemStack.EMPTY.getItem() && iBlock1.getItem() == ItemStack.EMPTY.getItem()) {
				if (!(getEntityGameType(entity) == GameType.CREATIVE)) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(Items.MILK_BUCKET).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(0, _setstack);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Stage", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.barrel.close")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound((x + 0.5), (y + 0.5), (z + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.barrel.close")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
				}
			} else if (iHand.getItem() == ItemStack.EMPTY.getItem() && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem() && iBlock0.getItem() == Items.MILK_BUCKET
					&& iBlock1.getItem() == ItemStack.EMPTY.getItem()) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Stage", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Stage") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (blockstate.getBlock().getStateDefinition().getProperty("up") instanceof BooleanProperty _getbp30 && blockstate.getValue(_getbp30)) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("up") instanceof BooleanProperty _booleanProp)
							world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
					}
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("down") instanceof BooleanProperty _booleanProp)
							world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
					}
					{
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockState _bs = TilledTalesModBlocks.OAK_DASH_CHURN.get().defaultBlockState();
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
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("up") instanceof BooleanProperty _booleanProp)
							world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
					}
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("down") instanceof BooleanProperty _booleanProp)
							world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
					}
					{
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockState _bs = TilledTalesModBlocks.OAK_DASH_CHURN_UP.get().defaultBlockState();
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
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Stage") == 16) {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
						_setstack.setCount(1);
						_itemHandlerModifiable.setStackInSlot(0, _setstack);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(TilledTalesModItems.CHURNED_BUTTER.get()).copy();
						_setstack.setCount(1);
						_itemHandlerModifiable.setStackInSlot(1, _setstack);
					}
				}
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.cow.milk")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound((x + 0.5), (y + 0.5), (z + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.cow.milk")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (TilledTalesModParticleTypes.CHURNING_EFFECT.get()), (x + 0.5), (y + 0.5), (z + 0.5), 4, 0.25, 0.25, 0.25, 0);
				}
			} else if (iBlock0.getItem() == Items.BUCKET && iBlock1.getItem() == TilledTalesModItems.CHURNED_BUTTER.get()) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = iBlock1.copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item_frame.remove_item")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound((x + 0.5), (y + 0.5), (z + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item_frame.remove_item")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
				}
			} else if (iBlock0.getItem() == Items.BUCKET && iBlock1.getItem() == ItemStack.EMPTY.getItem()) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (!(getEntityGameType(entity) == GameType.CREATIVE)) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = iBlock0.copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item_frame.remove_item")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound((x + 0.5), (y + 0.5), (z + 0.5), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item_frame.remove_item")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
				}
			}
		}
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}