package com.simibubi.create.content.decoration.copycat;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public abstract class CopycatBlock extends Block {
    public CopycatBlock(Properties pProperties) {
        super(pProperties);
    }

    public BlockState getAcceptedBlockState(Level pLevel, BlockPos pPos, ItemStack item, Direction face) {
        return null;
    }
}
