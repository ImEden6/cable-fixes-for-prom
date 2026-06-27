package com.mervyn.adastracablefix.mixin;

import com.simibubi.create.content.decoration.copycat.FilteredBlockAndTintGetter;
import net.fabricmc.fabric.api.rendering.data.v1.RenderAttachedBlockView;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
@Mixin(value = FilteredBlockAndTintGetter.class, remap = false)
public abstract class FilteredBlockAndTintGetterMixin implements RenderAttachedBlockView {

    @Shadow
    private BlockAndTintGetter wrapped;

    @Override
    public @Nullable Object getBlockEntityRenderAttachment(BlockPos pos) {
        if (wrapped instanceof RenderAttachedBlockView renderAttachedBlockView) {
            return renderAttachedBlockView.getBlockEntityRenderAttachment(pos);
        }
        return null;
    }
}
