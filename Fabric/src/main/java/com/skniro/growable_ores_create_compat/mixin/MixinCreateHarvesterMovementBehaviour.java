package com.skniro.growable_ores_create_compat.mixin;


import com.simibubi.create.content.contraptions.actors.harvester.HarvesterMovementBehaviour;
import com.skniro.growableores.block.init.GrowableOreCaneBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HarvesterMovementBehaviour.class)
public class MixinCreateHarvesterMovementBehaviour {

    @Inject(method = "isValidOther", at = @At("RETURN"), cancellable = true)
    private static void isValidOther(World world, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        Block block = state.getBlock();
        if(block instanceof GrowableOreCaneBlock){
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "cutCrop", at = @At("HEAD"), cancellable = true)
    private static void cutCrop(World world, BlockPos pos, BlockState state, CallbackInfoReturnable<BlockState> cir) {
        Block block = state.getBlock();
        if (block instanceof GrowableOreCaneBlock) {
            if (!state.getFluidState().isEmpty()) {
                cir.setReturnValue(Blocks.AIR.getDefaultState());
            }
            cir.setReturnValue(state.getFluidState().getBlockState());
        }
    }
}
