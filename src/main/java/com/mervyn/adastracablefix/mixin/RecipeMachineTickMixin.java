package com.mervyn.adastracablefix.mixin;

import earth.terrarium.adastra.common.blockentities.base.RecipeMachineBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RecipeMachineBlockEntity.class, remap = false)
public abstract class RecipeMachineTickMixin {

    @Shadow
    public abstract void updateSlots();

    @Inject(method = "internalServerTick", at = @At("TAIL"))
    private void adastra_tickDeferredFluidTransfers(ServerLevel level, long time, BlockState state, BlockPos pos,
            CallbackInfo ci) {
        this.updateSlots();
    }
}
