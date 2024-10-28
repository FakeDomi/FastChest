package re.domi.fastchest;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class FastChestTags
{
    public static final Identifier IDENTIFIER = Identifier.of("fastchest", "compatible_chests");
    public static final TagKey<BlockEntityType<?>> COMPATIBLE_CHEST_BLOCK_ENTITIES = TagKey.of(RegistryKeys.BLOCK_ENTITY_TYPE, IDENTIFIER);
    public static final TagKey<Block> COMPATIBLE_CHEST_BLOCKS = TagKey.of(RegistryKeys.BLOCK, IDENTIFIER);
}
