package net.nwt.tilledtales.block;

import net.nwt.tilledtales.procedures.PlanterOnTickUpdateProcedure;
import net.nwt.tilledtales.procedures.CopperPlanterBlockTooltipProcedure;
import net.nwt.tilledtales.init.TilledTalesModItems;
import net.nwt.tilledtales.block.entity.CopperPlanterBlockBlockEntity;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.util.StringRepresentable;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import java.util.List;

public class CopperPlanterBlockBlock extends Block implements SimpleWaterloggedBlock, EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final EnumProperty<SoilProperty> SOIL = EnumProperty.create("soil", SoilProperty.class);
	public static final BooleanProperty FERTILIZER = BooleanProperty.create("fertilizer");
	public static final BooleanProperty QUICKLIME = BooleanProperty.create("quicklime");
	public static final BooleanProperty WEEDS = BooleanProperty.create("weeds");
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 7);
	public static final EnumProperty<CropProperty> CROP = EnumProperty.create("crop", CropProperty.class);

	public CopperPlanterBlockBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.COPPER).strength(3f, 6f).requiresCorrectToolForDrops().noOcclusion().randomTicks().pushReaction(PushReaction.BLOCK)
				.isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(SOIL, SoilProperty.DRY).setValue(FERTILIZER, false).setValue(QUICKLIME, false).setValue(WEEDS, false).setValue(AGE, 0)
				.setValue(CROP, CropProperty.NONE).setValue(WATERLOGGED, false));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		Entity entity = itemstack.getEntityRepresentation() != null ? itemstack.getEntityRepresentation() : Minecraft.getInstance().player;
		String hoverText = CopperPlanterBlockTooltipProcedure.execute();
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
			default -> Shapes.or(box(1, 0, 1, 15, 6, 15), box(1, 0, 15, 15, 8, 16), box(1, 0, 0, 15, 8, 1), box(15, 0, 0, 16, 8, 16), box(0, 0, 0, 1, 8, 16));
			case NORTH -> Shapes.or(box(1, 0, 1, 15, 6, 15), box(1, 0, 0, 15, 8, 1), box(1, 0, 15, 15, 8, 16), box(0, 0, 0, 1, 8, 16), box(15, 0, 0, 16, 8, 16));
			case EAST -> Shapes.or(box(1, 0, 1, 15, 6, 15), box(15, 0, 1, 16, 8, 15), box(0, 0, 1, 1, 8, 15), box(0, 0, 0, 16, 8, 1), box(0, 0, 15, 16, 8, 16));
			case WEST -> Shapes.or(box(1, 0, 1, 15, 6, 15), box(0, 0, 1, 1, 8, 15), box(15, 0, 1, 16, 8, 15), box(0, 0, 15, 16, 8, 16), box(0, 0, 0, 16, 8, 1));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, SOIL, FERTILIZER, QUICKLIME, WEEDS, AGE, CROP, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(SOIL, SoilProperty.DRY).setValue(FERTILIZER, false).setValue(QUICKLIME, false).setValue(WEEDS, false).setValue(AGE, 0)
				.setValue(CROP, CropProperty.NONE).setValue(WATERLOGGED, flag);
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
	public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
		return new ItemStack(TilledTalesModItems.COPPER_PLANTER.get());
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.randomTick(blockstate, world, pos, random);
		PlanterOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new CopperPlanterBlockBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
	}

	public enum SoilProperty implements StringRepresentable {
		DRY("dry"), WET("wet");

		private final String name;

		private SoilProperty(String name) {
			this.name = name;
		}

		@Override
		public String getSerializedName() {
			return this.name;
		}
	}

	public enum CropProperty implements StringRepresentable {
		NONE("none"), BLUEBERRY("blueberry"), STRAWBERRY("strawberry"), WHEAT("wheat");

		private final String name;

		private CropProperty(String name) {
			this.name = name;
		}

		@Override
		public String getSerializedName() {
			return this.name;
		}
	}
}