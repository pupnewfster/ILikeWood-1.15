package yamahari.ilikewood.client.renderer.tileentity;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.ChestType;
import yamahari.ilikewood.block.WoodenChestBlock;
import yamahari.ilikewood.client.Atlases;
import yamahari.ilikewood.client.tileentity.WoodenChestTileEntity;
import yamahari.ilikewood.plugin.vanilla.VanillaWoodTypes;
import yamahari.ilikewood.registry.woodtype.IWoodType;
import yamahari.ilikewood.util.Util;

import javax.annotation.Nonnull;

public final class WoodenChestTileEntityRenderer extends ChestRenderer<WoodenChestTileEntity> {
    public WoodenChestTileEntityRenderer(final BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Nonnull
    @Override
    protected Material getMaterial(final WoodenChestTileEntity woodenChestTileEntity,
                                   @Nonnull final ChestType chestType) {
        final IWoodType woodType;
        if (woodenChestTileEntity.hasLevel()) {
            final Block block = woodenChestTileEntity.getBlockState().getBlock();
            woodType =
                block instanceof WoodenChestBlock ? ((WoodenChestBlock) block).getWoodType() : Util.DUMMY_WOOD_TYPE;
        } else {
            woodType = woodenChestTileEntity.getWoodType();
        }
        return Atlases
            .getChestMaterials(!woodType.equals(Util.DUMMY_WOOD_TYPE) ? woodType : VanillaWoodTypes.OAK)
            .get(chestType);
    }
}
