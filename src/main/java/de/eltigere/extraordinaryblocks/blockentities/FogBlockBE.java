package de.eltigere.extraordinaryblocks.blockentities;

import com.mojang.logging.LogUtils;
import de.eltigere.extraordinaryblocks.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FogBlockBE extends BlockEntity {
    public FogBlockBE(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.FOG_BET.get(), pos, blockState);
    }
}
