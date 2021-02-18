package re.domi.fastchest.mixin;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.EnderChestBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import re.domi.fastchest.config.Configs;

@Mixin(EnderChestBlock.class)
public class EnderChestBlockMixin
{
    @Inject(method = "getRenderType", at = @At("HEAD"), cancellable = true)
    private void onGetRenderType(BlockState state, CallbackInfoReturnable<BlockRenderType> cir) {
        if (Configs.simplifiedChestRendering) {
            cir.setReturnValue(BlockRenderType.MODEL);
            cir.setReturnValue(BlockRenderType.MODEL);
        }
    }
}
