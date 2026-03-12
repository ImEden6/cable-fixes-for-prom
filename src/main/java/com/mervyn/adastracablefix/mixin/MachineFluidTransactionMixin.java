package com.mervyn.adastracablefix.mixin;

import earth.terrarium.adastra.common.blockentities.machines.CryoFreezerBlockEntity;
import earth.terrarium.adastra.common.blockentities.machines.FuelRefineryBlockEntity;
import earth.terrarium.adastra.common.blockentities.machines.OxygenDistributorBlockEntity;
import earth.terrarium.adastra.common.blockentities.machines.OxygenLoaderBlockEntity;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = {
        CryoFreezerBlockEntity.class,
        FuelRefineryBlockEntity.class,
        OxygenDistributorBlockEntity.class,
        OxygenLoaderBlockEntity.class
}, remap = false)
public class MachineFluidTransactionMixin {

    @Inject(method = "updateSlots", at = @At("HEAD"), cancellable = true)
    private void adastra_cancelNestedTransactions(CallbackInfo ci) {
        if (Transaction.isOpen()) {
            ci.cancel();
        }
    }
}
