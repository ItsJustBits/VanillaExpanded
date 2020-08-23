package net.itsjustbits.vanilla_expanded.initializers.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

import static net.itsjustbits.vanilla_expanded.initializers.blocks.VanExpBlockUtils.*;
import static net.itsjustbits.vanilla_expanded.initializers.blocks.VanExpBlockPrefixes.*;

public class VanExpBlocks {

    //Mining Levels :
    //0 = wood & gold
    //1 = stone
    //2 = iron
    //3 = diamond
    //4 = netherite

    private static AbstractBlock.Settings makeNetherOre(int miningLevel, float hardness, float resistance) {
        return FabricBlockSettings.of(Material.STONE, MaterialColor.NETHER).breakByTool(FabricToolTags.PICKAXES, miningLevel).strength(hardness, resistance).sounds(BlockSoundGroup.NETHER_GOLD_ORE);
    }

    private static AbstractBlock.Settings makeOre(int miningLevel, float hardness, float resistance) {
        return FabricBlockSettings.of(Material.STONE, MaterialColor.STONE).breakByTool(FabricToolTags.PICKAXES, miningLevel).strength(hardness, resistance).sounds(BlockSoundGroup.STONE);
    }

    public static final Block[] BASE_METAL_ORES = MultiBlockMakers.makeMultiBlock(base_metal_ores.length, makeOre(1, 3.0F, 3.0F));
    public static final Block[] BASE_GEM_ORES = MultiBlockMakers.makeMultiBlock(base_gem_ores.length, makeOre(2, 3.0F, 3.0F));
    public static final Block[] NETHER_METAL_ORES = MultiBlockMakers.makeMultiBlock(nether_metal_ores.length, makeOre(2, 3.0F, 3.0F));

    public static void init() {
        registerMultiBlock("ore", BASE_METAL_ORES, base_metal_ores);
        registerMultiBlock("ore", BASE_GEM_ORES, base_gem_ores);
        registerMultiBlock("ore", NETHER_METAL_ORES, nether_metal_ores);
    }
}
