package yamahari.ilikewood.item;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.IItemRenderProperties;
import yamahari.ilikewood.client.renderer.tileentity.WoodenChestItemStackTileEntityRenderer;
import yamahari.ilikewood.registry.objecttype.WoodenBlockType;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public final class WoodenChestBlockItem extends WoodenBlockItem {
    public WoodenChestBlockItem(final Block block) {
        super(WoodenBlockType.CHEST, block, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    }

    @Override
    public void initializeClient(@Nonnull final Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            @Override
            public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
                return new WoodenChestItemStackTileEntityRenderer();
            }
        });
    }
}
