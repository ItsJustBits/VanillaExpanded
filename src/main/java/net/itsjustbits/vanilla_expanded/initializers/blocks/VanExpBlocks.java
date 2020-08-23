package net.itsjustbits.vanilla_expanded.initializers.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

import static net.itsjustbits.vanilla_expanded.initializers.blocks.VanExpBlockUtils.*;

public class VanExpBlocks {

    private static AbstractBlock.Settings makeOre(int miningLevel, float hardness, float resistance) {
        return FabricBlockSettings.of(Material.STONE, MaterialColor.STONE).breakByTool(FabricToolTags.PICKAXES, miningLevel).strength(hardness, resistance).sounds(BlockSoundGroup.STONE);
    }

    public static final Block[] BASE_METAL_ORES = MultiBlockMakers.makeMultiBlock(4, makeOre(1, 3.0F, 3.0F));
    public static final Block[] BASE_GEM_ORES = MultiBlockMakers.makeMultiBlock(5, makeOre(2, 3.0F, 3.0F));

    public static void init() {
        registerMultiBlock("ore", BASE_METAL_ORES, BlockPrefixes.base_metal_ores);
        registerMultiBlock("ore", BASE_GEM_ORES, BlockPrefixes.base_gem_ores);
    }
}
