package com.simibubi.create.content.decoration.copycat;

import net.minecraft.world.level.BlockAndTintGetter;

public abstract class FilteredBlockAndTintGetter implements BlockAndTintGetter {
    protected BlockAndTintGetter wrapped;
}
