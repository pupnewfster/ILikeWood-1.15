package yamahari.ilikewood.provider.blockstate;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ScaffoldingBlock;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import yamahari.ilikewood.registry.objecttype.WoodenBlockType;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.Util;

public final class ScaffoldingBlockStateProvider extends AbstractBlockStateProvider {
    public ScaffoldingBlockStateProvider(final DataGenerator generator, final ExistingFileHelper helper) {
        super(generator, helper, WoodenBlockType.SCAFFOLDING);
    }

    @Override
    public void registerStateAndModel(final Block block) {
        final String woodType = ((IWooden) block).getWoodType().getName();
        final String path = Util.toPath(ModelProvider.BLOCK_FOLDER, WoodenBlockType.SCAFFOLDING.getName());
        this.getVariantBuilder(block).forAllStates(blockState -> {
            final String stable = blockState.getValue(ScaffoldingBlock.BOTTOM) ? "unstable" : "stable";
            final ModelFile template = this
                .models()
                .withExistingParent(Util.toPath(path, stable, woodType), modLoc(Util.toPath(path, stable, "template")))
                .texture("top", modLoc(Util.toPath(path, "top", woodType)))
                .texture("side", modLoc(Util.toPath(path, "side", woodType)))
                .texture("bottom", modLoc(Util.toPath(path, "bottom", woodType)));
            return ConfiguredModel.builder().modelFile(template).build();
        });
    }
}
