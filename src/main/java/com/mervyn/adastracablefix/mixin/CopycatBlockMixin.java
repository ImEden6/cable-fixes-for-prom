package com.mervyn.adastracablefix.mixin;

import com.simibubi.create.content.decoration.copycat.CopycatBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = CopycatBlock.class, remap = false)
public class CopycatBlockMixin {

    @Inject(method = "getAcceptedBlockState", at = @At("HEAD"), cancellable = true)
    private void adastracablefix_allowAE2Cables(Level pLevel, BlockPos pPos, ItemStack item, Direction face, CallbackInfoReturnable<BlockState> cir) {
        if (item.getItem() instanceof BlockItem bi) {
            Block block = bi.getBlock();
            if (block.getClass().getName().equals("appeng.block.networking.CableBusBlock")) {
                cir.setReturnValue(block.defaultBlockState());
            }
        }
    }
}
