package de.eltigere.extraordinaryblocks.blocks;

import com.google.common.collect.ImmutableMap;
import de.eltigere.extraordinaryblocks.blockentities.FogBlockBE;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Function;

public class FogBlock extends Block implements EntityBlock {
    public FogBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState blockState) {
        return new FogBlockBE(pos, blockState);
    }

    /*@Override
    protected ImmutableMap<BlockState, VoxelShape> getShapeForEachState(Function<BlockState, VoxelShape> p_152459_) {
        return ImmutableMap.<BlockState, VoxelShape>builder().build();
    }*/

    /*@Override
    public RenderShape getRenderShape(BlockState p_60550_) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }*/
}
