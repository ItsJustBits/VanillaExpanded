package net.itsjustbits.vanilla_expanded.initializers.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.itsjustbits.vanilla_expanded.blocks.VanExpOreBlock;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.Tag;

import static net.itsjustbits.vanilla_expanded.initializers.blocks.VanExpBlockUtils.*;
import static net.itsjustbits.vanilla_expanded.initializers.blocks.VanExpBlockPrefixes.*;

public class VanExpBlocks {

    //Mining Levels :
    //0 = wood & gold
    //1 = stone
    //2 = iron
    //3 = diamond
    //4 = netherite

    private static FabricBlockSettings makeNetherOre(Material material, Tag<Item> tag, int miningLevel, float hardness, float resistance, BlockSoundGroup sound) {
        return FabricBlockSettings.of(material, MaterialColor.NETHER).breakByHand(false).breakByTool(tag, miningLevel).strength(hardness, resistance).sounds(sound);
    }

    private static FabricBlockSettings makeOre(int miningLevel, float hardness, float resistance) {
        return FabricBlockSettings.of(Material.STONE, MaterialColor.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, miningLevel).strength(hardness, resistance).sounds(BlockSoundGroup.STONE);
    }

    public static final Block[] BASE_METAL_ORES = MultiBlockMakers.makeMultiBlock(base_metal_ores.length, makeOre(1, 3.0F, 3.0F));
    public static final Block[] BASE_GEM_ORES = MultiBlockMakers.makeMultiBlock(base_gem_ores.length, makeOre(2, 3.0F, 3.0F));
    public static final Block SOUL_IRON_ORE = new VanExpOreBlock( 3, 7, FabricToolTags.PICKAXES, Blocks.DIAMOND_ORE, makeNetherOre(Material.STONE, FabricToolTags.PICKAXES, 2, 3.0F, 3.0F, BlockSoundGroup.NETHER_GOLD_ORE));
    public static final Block SOUL_SOIL_SOUL_IRON_ORE = new VanExpOreBlock( 3, 7, FabricToolTags.SHOVELS, Blocks.DIAMOND_ORE, makeNetherOre(Material.SOIL, FabricToolTags.SHOVELS, 2, 3.0F, 3.0F, BlockSoundGroup.SOUL_SOIL));
    public static final Block ARDITE = new VanExpOreBlock(4, 9, FabricToolTags.PICKAXES, Blocks.ANCIENT_DEBRIS, makeNetherOre(Material.STONE, FabricToolTags.PICKAXES, 4, 3.0F, 6.0F, BlockSoundGroup.NETHER_GOLD_ORE));
    public static final Block BLACKSTONE_ARDITE = new VanExpOreBlock(4, 9, FabricToolTags.PICKAXES, Blocks.ANCIENT_DEBRIS, makeNetherOre(Material.STONE, FabricToolTags.PICKAXES, 4, 3.0F, 6.0F, BlockSoundGroup.GILDED_BLACKSTONE));
    public static final Block BASALT_ARDITE = new VanExpOreBlock(4, 9, FabricToolTags.PICKAXES, Blocks.ANCIENT_DEBRIS, makeNetherOre(Material.STONE, FabricToolTags.PICKAXES, 4, 3.0F, 6.0F, BlockSoundGroup.BASALT));
    public static final Block COBALT = new VanExpOreBlock(4, 9, FabricToolTags.PICKAXES, Blocks.ANCIENT_DEBRIS, makeNetherOre(Material.STONE, FabricToolTags.PICKAXES, 4, 3.0F, 6.0F, BlockSoundGroup.NETHER_GOLD_ORE));

    public static void init() {
        registerMultiBlock("ore", BASE_METAL_ORES, base_metal_ores);
        registerMultiBlock("ore", BASE_GEM_ORES, base_gem_ores);
        registerBlock("soul_iron_ore", SOUL_IRON_ORE);
        registerBlock("soul_soil_soul_iron_ore", SOUL_SOIL_SOUL_IRON_ORE);
        registerBlock("ardite_ore", ARDITE);
        registerBlock("blackstone_ardite_ore", BLACKSTONE_ARDITE);
        registerBlock("basalt_ardite_ore", BASALT_ARDITE);
        registerBlock("cobalt_ore", COBALT);
    }
}
