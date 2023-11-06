package re.domi.fastchest.mixin;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.block.entity.TrappedChestBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import re.domi.fastchest.config.Config;

@Mixin(BlockEntityRenderDispatcher.class)
public class BlockEntityRenderDispatcherMixin
{
    @Inject(method = "get", at = @At("HEAD"), cancellable = true)
    private <E extends BlockEntity> void removeBlockEntityRenderer(E blockEntity, CallbackInfoReturnable<BlockEntityRenderer<E>> cir)
    {
        if (Config.simplifiedChest)
        {
            Class<?> beClass = blockEntity.getClass();

            if (beClass == ChestBlockEntity.class ||
                beClass == TrappedChestBlockEntity.class ||
                beClass == EnderChestBlockEntity.class ||
                beClass.getSuperclass().getName().equals("io.github.cyberanner.ironchests.blocks.blockentities.GenericChestEntity"))
            {
                cir.setReturnValue(null);
            }
        }
    }
}
