package re.domi.fastchest.mixin;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import re.domi.fastchest.config.Config;

import java.util.function.Supplier;

@Mixin(value = ChestBlock.class, priority = 1500)
public abstract class ChestBlockMixin extends AbstractChestBlock<ChestBlockEntity>
{
    @Override
    @Unique(silent = true)
    protected BlockRenderType getRenderType(BlockState state)
    {
        return super.getRenderType(state);
    }

    @SuppressWarnings({ "MixinAnnotationTarget", "UnresolvedMixinReference" })
    @Inject(method = {"getRenderType", "method_9604"}, at = @At("HEAD"), cancellable = true, remap = false)
    private void replaceRenderType(BlockState state, CallbackInfoReturnable<BlockRenderType> cir)
    {
        if (!Config.simplifiedChest)
        {
            cir.setReturnValue(BlockRenderType.INVISIBLE);
        }
    }

    @Inject(method = "getTicker", at = @At("HEAD"), cancellable = true)
    private <T extends BlockEntity> void removeTicker(World world, BlockState state, BlockEntityType<T> type, CallbackInfoReturnable<BlockEntityTicker<T>> cir)
    {
        if (Config.simplifiedChest)
        {
            cir.setReturnValue(null);
        }
    }

    @SuppressWarnings({"DataFlowIssue", "unused"})
    protected ChestBlockMixin(Settings settings, Supplier<BlockEntityType<? extends ChestBlockEntity>> entityTypeRetriever)
    {
        super(null, null);
    }
}
