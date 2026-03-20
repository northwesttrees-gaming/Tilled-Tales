package net.nwt.tilledtales.block;

import net.nwt.tilledtales.procedures.OakIceBoxTooltipProcedure;
import net.nwt.tilledtales.procedures.OakIceBoxOnTickUpdateProcedure;
import net.nwt.tilledtales.init.TilledTalesModBlocks;
import net.nwt.tilledtales.block.entity.OakIceBox1BlockEntity;

import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Containers;
import net.minecraft.util.StringRepresentable;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.Minecraft;

import java.util.List;

public class OakIceBox1Block extends Block implements SimpleWaterloggedBlock, EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final IntegerProperty PHASE = IntegerProperty.create("phase", 0, 2);
	public static final EnumProperty<MaterialProperty> MATERIAL = EnumProperty.create("material", MaterialProperty.class);

	public OakIceBox1Block() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.GRAVEL).strength(2f, 3f).noOcclusion().randomTicks().isRedstoneConductor((bs, br, bp) -> false).instrument(NoteBlockInstrument.BASS));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(PHASE, 0).setValue(MATERIAL, MaterialProperty.OAK).setValue(WATERLOGGED, false));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		Entity entity = itemstack.getEntityRepresentation() != null ? itemstack.getEntityRepresentation() : Minecraft.getInstance().player;
		String hoverText = OakIceBoxTooltipProcedure.execute();
		if (hoverText != null) {
			for (String line : hoverText.split("\n")) {
				list.add(Component.literal(line));
			}
		}
	}

	@Override
	public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter world, BlockPos pos, FluidState fluidstate) {
		return true;
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(0, 0, 2, 16, 2, 14), box(1, 2, 12, 15, 6, 13), box(1, 2, 3, 15, 6, 4), box(14, 2, 4, 15, 6, 12), box(1, 2, 4, 2, 6, 12), box(0, 6, 12, 16, 8, 14), box(0, 6, 2, 16, 8, 4), box(14, 6, 4, 16, 8, 12),
					box(0, 6, 4, 2, 8, 12));
			case NORTH -> Shapes.or(box(0, 0, 2, 16, 2, 14), box(1, 2, 3, 15, 6, 4), box(1, 2, 12, 15, 6, 13), box(1, 2, 4, 2, 6, 12), box(14, 2, 4, 15, 6, 12), box(0, 6, 2, 16, 8, 4), box(0, 6, 12, 16, 8, 14), box(0, 6, 4, 2, 8, 12),
					box(14, 6, 4, 16, 8, 12));
			case EAST -> Shapes.or(box(2, 0, 0, 14, 2, 16), box(12, 2, 1, 13, 6, 15), box(3, 2, 1, 4, 6, 15), box(4, 2, 1, 12, 6, 2), box(4, 2, 14, 12, 6, 15), box(12, 6, 0, 14, 8, 16), box(2, 6, 0, 4, 8, 16), box(4, 6, 0, 12, 8, 2),
					box(4, 6, 14, 12, 8, 16));
			case WEST -> Shapes.or(box(2, 0, 0, 14, 2, 16), box(3, 2, 1, 4, 6, 15), box(12, 2, 1, 13, 6, 15), box(4, 2, 14, 12, 6, 15), box(4, 2, 1, 12, 6, 2), box(2, 6, 0, 4, 8, 16), box(12, 6, 0, 14, 8, 16), box(4, 6, 14, 12, 8, 16),
					box(4, 6, 0, 12, 8, 2));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, PHASE, MATERIAL, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(PHASE, 0).setValue(MATERIAL, MaterialProperty.OAK).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.randomTick(blockstate, world, pos, random);
		OakIceBoxOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new OakIceBox1BlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof OakIceBox1BlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof OakIceBox1BlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}

	@OnlyIn(Dist.CLIENT)
	public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
		event.getBlockColors().register((bs, world, pos, index) -> {
			return world != null && pos != null ? BiomeColors.getAverageWaterColor(world, pos) : -1;
		}, TilledTalesModBlocks.OAK_ICE_BOX_1.get());
	}

	@OnlyIn(Dist.CLIENT)
	public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
		event.getItemColors().register((stack, index) -> {
			return 3694022;
		}, TilledTalesModBlocks.OAK_ICE_BOX_1.get());
	}

	public enum MaterialProperty implements StringRepresentable {
		OAK("oak"), SPRUCE("spruce"), BIRCH("birch"), JUNGLE("jungle"), ACACIA("acacia"), DARK_OAK("dark_oak"), MANGROVE("mangrove"), CHERRY("cherry"), PALE_OAK("pale_oak"), CRIMSON("crimson"), WARPED("warped");

		private final String name;

		private MaterialProperty(String name) {
			this.name = name;
		}

		@Override
		public String getSerializedName() {
			return this.name;
		}
	}
}