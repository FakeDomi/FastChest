package re.domi.fastchest.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EnderChestBlockEntity.class)
public abstract class EnderChestBlockEntityMixin
{
    /**
     * @author Fury_Phoenix
     * @reason No-op animation, also stops EBE animations
     **/
    @Overwrite
    public static void clientTick(World w, BlockPos p, BlockState s, EnderChestBlockEntity c){}
}
