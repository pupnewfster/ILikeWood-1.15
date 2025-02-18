package yamahari.ilikewood.provider.blockstate;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import yamahari.ilikewood.registry.objecttype.WoodenBlockType;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.Util;

import java.util.stream.IntStream;

public final class ComposterBlockStateProvider extends AbstractBlockStateProvider {
    public ComposterBlockStateProvider(final DataGenerator generator, final ExistingFileHelper helper) {
        super(generator, helper, WoodenBlockType.COMPOSTER);
    }

    @Override
    public void registerStateAndModel(final Block block) {
        final String woodType = ((IWooden) block).getWoodType().getName();
        final String path = Util.toPath(ModelProvider.BLOCK_FOLDER, WoodenBlockType.COMPOSTER.getName());
        final ModelFile template = this
            .models()
            .withExistingParent(Util.toPath(path, woodType), modLoc(Util.toPath(path, "template")))
            .texture("top", Util.toPath(path, "top", woodType))
            .texture("side", Util.toPath(path, "side", woodType))
            .texture("bottom", Util.toPath(path, "bottom", woodType));

        final MultiPartBlockStateBuilder builder =
            this.getMultipartBuilder(block).part().modelFile(template).addModel().end();

        IntStream.range(1, 9).forEach(level -> {
            final ModelFile content = new ModelFile.UncheckedModelFile(mcLoc(Util.toPath(ModelProvider.BLOCK_FOLDER,
                String.format("composter_contents%s", level != 8 ? level : "_ready"))));
            builder.part().modelFile(content).addModel().condition(ComposterBlock.LEVEL, level).end();
        });
    }
}
