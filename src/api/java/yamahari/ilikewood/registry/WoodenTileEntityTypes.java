package yamahari.ilikewood.registry;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;

// TODO same refactor as for other registries
public final class WoodenTileEntityTypes {
    public static RegistryObject<BlockEntityType<?>> WOODEN_BARREL;
    public static RegistryObject<BlockEntityType<?>> WOODEN_CHEST;
    public static RegistryObject<BlockEntityType<?>> WOODEN_LECTERN;

    private WoodenTileEntityTypes() {
    }
}
