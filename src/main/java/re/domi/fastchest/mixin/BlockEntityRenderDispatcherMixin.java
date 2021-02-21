package re.domi.fastchest.mixin;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.block.ChestAnimationProgress;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import re.domi.fastchest.config.Config;

@Mixin(BlockEntityRenderDispatcher.class)
public class BlockEntityRenderDispatcherMixin
{
    @Inject(method = "get", at = @At("HEAD"), cancellable = true)
    private <E extends BlockEntity> void onGetRenderer(E blockEntity, CallbackInfoReturnable<@Nullable BlockEntityRenderer<E>> cir)
    {
        if (Config.simplifiedChestRendering && blockEntity instanceof ChestAnimationProgress)
        {
            cir.setReturnValue(null);
        }
    }
}
