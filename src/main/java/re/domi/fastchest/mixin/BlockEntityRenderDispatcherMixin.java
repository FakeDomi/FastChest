package re.domi.fastchest.mixin;

import com.google.common.collect.Maps;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(BlockEntityRenderDispatcher.class)
public class BlockEntityRenderDispatcherMixin
{
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Shadow
    private final Map<BlockEntityType<?>, BlockEntityRenderer<?>> renderers = Maps.newHashMap();

    @Inject(method = "<init>()V", at = @At("TAIL"))
    private void constructor(CallbackInfo info)
    {
        this.renderers.remove(BlockEntityType.CHEST);
        this.renderers.remove(BlockEntityType.ENDER_CHEST);
        this.renderers.remove(BlockEntityType.TRAPPED_CHEST);
    }
}
