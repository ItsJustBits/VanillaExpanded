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

    private static FabricBlockSettings makeNetherOre(Material material, float hardness, float resistance, Tag<Item> tool, int miningLevel, BlockSoundGroup sound) {
        return FabricBlockSettings.of(material, MaterialColor.NETHER).requiresTool().requiresTool().breakByTool(tool, miningLevel).strength(hardness, resistance).sounds(sound);
    }

    private static FabricBlockSettings makeNetherOre(Material material, float hardness, Tag<Item> tool, int miningLevel, BlockSoundGroup sound) {
        return FabricBlockSettings.of(material, MaterialColor.NETHER).requiresTool().requiresTool().breakByTool(tool, miningLevel).strength(hardness).sounds(sound);
    }

    private static FabricBlockSettings makeOre(float hardness, float resistance, Tag<Item> tool, int miningLevel) {
        return FabricBlockSettings.of(Material.STONE, MaterialColor.STONE).requiresTool().breakByTool(tool, miningLevel).strength(hardness, resistance).sounds(BlockSoundGroup.STONE);
    }

    public static final Block[] BASE_METAL_ORES = new Block[base_metal_ores.length];
    public static final Block[] BASE_GEM_ORES = new Block[base_gem_ores.length];

    //Base Metals
    public static final Block COPPER_ORE = new Block(makeOre(3.0F, 3.0F, FabricToolTags.PICKAXES, 1));
    public static final Block TIN_ORE = new Block(makeOre( 3.0F, 3.0F, FabricToolTags.PICKAXES, 1));
    public static final Block SILVER_ORE = new Block(makeOre( 3.0F, 3.0F, FabricToolTags.PICKAXES, 1));
    public static final Block BRONZE_ORE = new Block(makeOre( 3.0F, 3.0F, FabricToolTags.PICKAXES, 2));
    public static final Block LEAD_ORE = new Block(makeOre( 3.0F, 3.0F, FabricToolTags.PICKAXES, 2));
    public static final Block NICKEL_ORE = new Block(makeOre( 3.0F, 3.0F, FabricToolTags.PICKAXES, 2));

    //Base Gems
    public static final Block TOPAZ_ORE = new VanExpOreBlock( 3, 7, makeOre(3.0F, 3.0F, FabricToolTags.PICKAXES, 2));
    public static final Block RUBY_ORE = new VanExpOreBlock( 3, 7, makeOre(3.0F, 3.0F, FabricToolTags.PICKAXES, 2));
    public static final Block AMETHYST_ORE = new VanExpOreBlock( 3, 7, makeOre(3.0F, 3.0F, FabricToolTags.PICKAXES, 2));
    public static final Block PERIDOT_ORE = new VanExpOreBlock( 3, 7, makeOre(3.0F, 3.0F, FabricToolTags.PICKAXES, 2));
    public static final Block SAPPHIRE_ORE = new VanExpOreBlock( 3, 7, makeOre(3.0F, 3.0F, FabricToolTags.PICKAXES, 2));

    //Nether ores
    public static final Block COBALT_ORE = new VanExpOreBlock(4, 9, makeNetherOre(Material.STONE, 3.0F, 6.0F, FabricToolTags.PICKAXES, 4, BlockSoundGroup.NETHER_GOLD_ORE));
    public static final Block MALACHITE_ORE = new VanExpOreBlock(3, 7, makeNetherOre(Material.STONE, 3.0F, 6.0F, FabricToolTags.PICKAXES, 2, BlockSoundGroup.NETHER_GOLD_ORE));

    //Multi Variant Ores
    public static final Block BLACKSTONE_ARDITE_ORE = new VanExpOreBlock(4, 9, makeNetherOre(Material.STONE, 3.0F, 6.0F, FabricToolTags.PICKAXES, 4, BlockSoundGroup.GILDED_BLACKSTONE));

    public static final Block SOIL_SULFUR_ORE = new VanExpOreBlock(2, 6, makeNetherOre(Material.SOIL, 0.5F, FabricToolTags.SHOVELS, 2, BlockSoundGroup.SOUL_SOIL));
    public static final Block SOIL_SOUL_IRON_ORE = new VanExpOreBlock( 3, 7, makeNetherOre(Material.SOIL, 1.0F, FabricToolTags.SHOVELS, 3, BlockSoundGroup.SOUL_SOIL));
    public static final Block SOIL_PLATINUM_ORE = new VanExpOreBlock(4, 9, makeNetherOre(Material.SOIL, 1.5F, FabricToolTags.SHOVELS, 4, BlockSoundGroup.SOUL_SOIL));

    public static final Block SULFUR_ORE = new VanExpOreBlock(2, 6, makeNetherOre(Material.STONE, 3.0F, 3.0F, FabricToolTags.PICKAXES, 2, BlockSoundGroup.NETHER_GOLD_ORE));
    public static final Block SOUL_IRON_ORE = new VanExpOreBlock( 3, 7, makeNetherOre(Material.STONE, 3.0F, 3.0F, FabricToolTags.PICKAXES, 3, BlockSoundGroup.NETHER_GOLD_ORE));
    public static final Block ARDITE_ORE = new VanExpOreBlock(4, 9, makeNetherOre(Material.STONE, 3.0F, 6.0F, FabricToolTags.PICKAXES, 4, BlockSoundGroup.NETHER_GOLD_ORE));
    public static final Block PLATINUM_ORE = new VanExpOreBlock(4, 9, makeNetherOre(Material.STONE, 3.0F, 3.0F, FabricToolTags.PICKAXES, 4, BlockSoundGroup.NETHER_GOLD_ORE));

    public static final Block[] SULFUR_ORES = {
            SOIL_SULFUR_ORE,
            SULFUR_ORE
    };
    public static final Block[] SOUL_IRON_ORES = {
            SOIL_SOUL_IRON_ORE,
            SOUL_IRON_ORE
    };
    public static final Block[] ARDITE_ORES = {
            BLACKSTONE_ARDITE_ORE,
            ARDITE_ORE
    };
    public static final Block[] PLATINUM_ORES = {
            SOIL_PLATINUM_ORE,
            PLATINUM_ORE
    };

    //Ore Blocks
    public static final Block SOUL_IRON_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MaterialColor.BROWN).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).strength(25.0F, 600.0F).sounds(BlockSoundGroup.NETHERITE));
    public static final Block ARDITE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MaterialColor.ORANGE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 4).strength(50.0F, 1200.0F).sounds(BlockSoundGroup.NETHERITE));
    public static final Block COBALT_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MaterialColor.BLUE_TERRACOTTA).requiresTool().breakByTool(FabricToolTags.PICKAXES, 4).strength(50.0F, 1200.0F).sounds(BlockSoundGroup.NETHERITE));
    public static final Block PLATINUM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MaterialColor.LIGHT_BLUE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 4).strength(50.0F, 1200.0F).sounds(BlockSoundGroup.NETHERITE));

    public static void init() {
        BASE_METAL_ORES[0] = COPPER_ORE;
        BASE_METAL_ORES[1] = TIN_ORE;
        BASE_METAL_ORES[2] = SILVER_ORE;
        BASE_METAL_ORES[3] = BRONZE_ORE;
        BASE_METAL_ORES[4] = NICKEL_ORE;
        BASE_METAL_ORES[5] = LEAD_ORE;

        BASE_GEM_ORES[0] = RUBY_ORE;
        BASE_GEM_ORES[1] = TOPAZ_ORE;
        BASE_GEM_ORES[2] = PERIDOT_ORE;
        BASE_GEM_ORES[3] = SAPPHIRE_ORE;
        BASE_GEM_ORES[4] = AMETHYST_ORE;

        registerBlock("copper_ore", COPPER_ORE, true);
        registerBlock("tin_ore", TIN_ORE, true);
        registerBlock("silver_ore", SILVER_ORE, true);
        registerBlock("bronze_ore", BRONZE_ORE, true);
        registerBlock("nickel_ore", NICKEL_ORE, true);
        registerBlock("lead_ore", LEAD_ORE, true);

        registerBlock("ruby_ore", RUBY_ORE,true);
        registerBlock("topaz_ore", TOPAZ_ORE,true);
        registerBlock("peridot_ore", PERIDOT_ORE,true);
        registerBlock("sapphire_ore", SAPPHIRE_ORE,true);
        registerBlock("amethyst_ore", AMETHYST_ORE,true);

        registerBlock("malachite_ore", MALACHITE_ORE,true);
        registerBlock("sulfur_ore", SULFUR_ORES[1],true);
        registerBlock("soul_iron_ore", SOUL_IRON_ORES[1],true);
        registerBlock("ardite_ore", ARDITE_ORES[1],true);
        registerBlock("cobalt_ore", COBALT_ORE,true);
        registerBlock("platinum_ore", PLATINUM_ORES[1],true);
        registerBlock("soul_soil_sulfur_ore", SULFUR_ORES[0],true);
        registerBlock("soul_soil_soul_iron_ore", SOUL_IRON_ORES[0],true);
        registerBlock("soul_soil_platinum_ore", PLATINUM_ORES[0],true);
        registerBlock("blackstone_ardite_ore", ARDITE_ORES[0],true);

        registerBlock("soul_iron_block", SOUL_IRON_BLOCK,true);
        registerBlock("ardite_block", ARDITE_BLOCK,true);
        registerBlock("cobalt_block", COBALT_BLOCK,true);
        registerBlock("platinum_block", PLATINUM_BLOCK,true);
    }
}
