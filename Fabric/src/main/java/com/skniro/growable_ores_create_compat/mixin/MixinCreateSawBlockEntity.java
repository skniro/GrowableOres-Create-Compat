package com.skniro.growable_ores_create_compat.mixin;


import com.simibubi.create.content.kinetics.saw.SawBlockEntity;
import com.skniro.growableores.block.init.GrowableOreCaneBlock;
import net.minecraft.block.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SawBlockEntity.class)
public class MixinCreateSawBlockEntity {

    @Inject(method = "isSawable", at = @At("RETURN"), cancellable = true)
    private static void isSawable(BlockState stateToBreak, CallbackInfoReturnable<Boolean> cir) {
        if(stateToBreak.getBlock() instanceof GrowableOreCaneBlock){
            cir.setReturnValue(true);
        }
    }
}
