package com.skniro.growable_ores_create_compat.mixin;


import com.simibubi.create.content.kinetics.saw.TreeCutter;
import com.skniro.growableores.block.init.GrowableOreCaneBlock;
import net.minecraft.block.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TreeCutter.class)
public class MixinCreateTreeCutter {

    @Inject(method = "isVerticalPlant", at = @At("RETURN"), cancellable = true)
    private static void isVerticalPlant(BlockState stateAbove, CallbackInfoReturnable<Boolean> cir) {
        if(stateAbove.getBlock() instanceof GrowableOreCaneBlock){
            cir.setReturnValue(true);
        }
    }
}
