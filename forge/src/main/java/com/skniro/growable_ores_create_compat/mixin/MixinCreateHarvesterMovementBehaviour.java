package com.skniro.growable_ores_create_compat.mixin;


import com.simibubi.create.content.contraptions.actors.harvester.HarvesterMovementBehaviour;
import com.skniro.growableores.block.init.GrowableOreCaneBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = HarvesterMovementBehaviour.class, remap = false)
public class MixinCreateHarvesterMovementBehaviour {

    @Inject(method = "isValidOther", at = @At("RETURN"), cancellable = true)
    private void isValidOther(Level world, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        Block block = state.getBlock();
        if(block instanceof GrowableOreCaneBlock){
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "cutCrop", at = @At("HEAD"), cancellable = true)
    private void cutCrop(Level world, BlockPos pos, BlockState state, CallbackInfoReturnable<BlockState> cir) {
        Block block = state.getBlock();
        if (block instanceof GrowableOreCaneBlock) {
            if (!state.getFluidState().isEmpty()) {
                cir.setReturnValue(Blocks.AIR.defaultBlockState());
            }
            cir.setReturnValue(state.getFluidState().createLegacyBlock());
        }
    }
}
