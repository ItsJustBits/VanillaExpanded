package net.itsjustbits.vanilla_expanded.initializers;

import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.itsjustbits.vanilla_expanded.initializers.blocks.VanExpBlocks;
import net.itsjustbits.vanilla_expanded.world.gen.VanExpOreFeature;
import net.itsjustbits.vanilla_expanded.world.gen.VanExpOreFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.function.Predicate;

import static net.itsjustbits.vanilla_expanded.initializers.VanillaExpMain.*;
import static net.minecraft.world.gen.feature.OreFeatureConfig.Rules.*;

public class VanExpWorldGen {

    public static final RuleTest BASALT = new BlockMatchRuleTest(Blocks.NETHERRACK || Blocks.CRIMSON_NYLIUM);
    public static final RuleTest TEST = new Predicate<BlockState> -> {
        if (blockState == null) {
            return false;
        } else {
            return blockState.isOf(Blocks.NETHERRACK) || blockState.isOf(Blocks.CRIMSON_NYLIUM);
        }
    };

    public static Feature<VanExpOreFeatureConfig> ORE;

    private static void addOre(DynamicRegistryManager manager, RuleTest target, int veinSize, int veinPerChunk, int bottomOffset, int minY, int maxY, BlockState oreBlock) {
        GenerationSettings.Builder.feature(
                GenerationStep.Feature.UNDERGROUND_ORES,
                Feature.ORE.configure(
                        new OreFeatureConfig(
                                target, oreBlock,
                                veinSize //Ore vein size
                        )).createDecoratedFeature(
                        Decorator.RANGE.configure(new RangeDecoratorConfig(
                                minY, //Min y level
                                maxY, //Max y level
                                veinPerChunk //Number of veins per chunk
                        ))));
    }

    private static void addOre(Biome biome, VanExpOreFeatureConfig.GroundFillerBlock target, int veinSize, int veinPerChunk, int bottomOffset, int minY, int maxY, BlockState oreBlock) {
        biome.addFeature(
                GenerationStep.Feature.UNDERGROUND_ORES,
                ORE.configure(
                        new VanExpOreFeatureConfig(
                                target, oreBlock,
                                veinSize //Ore vein size
                        )).createDecoratedFeature(
                        Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
                                veinPerChunk, //Number of veins per chunk
                                bottomOffset, //Bottom Offset
                                minY, //Min y level
                                maxY //Max y level
                        ))));
    }



    private void handleBiome(RegistryKey<Biome> biome) {
        if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
            addOre(biome, BASE_STONE_OVERWORLD, 5, 1, 0, 0, 25, VanExpBlocks.BASE_METAL_ORES[3].getDefaultState());
            for (int i = 0; i< VanExpBlocks.BASE_METAL_ORES.length - 1; i++)
                if (i !=3)
                    addOre(biome, BASE_STONE_OVERWORLD,8, 3, 0, 0, 54, VanExpBlocks.BASE_METAL_ORES[i].getDefaultState());
            for (int i = 0; i< VanExpBlocks.BASE_GEM_ORES.length - 1; i++)
                addOre(biome, BASE_STONE_OVERWORLD, 7, 1, 0, 0, 25, VanExpBlocks.BASE_GEM_ORES[i].getDefaultState());
        }

        //Nether ores
        int darkIronVeinSize = 8; //0
        int arditeVeinSize = 4; //1
        int cobaltVeinSize = 4; //2

        //Nether wastes
        if (biome.equals(BiomeKeys.NETHER_WASTES)) {
            addOre(biome, NETHERRACK, arditeVeinSize, 4, 0, 20, 128, VanExpBlocks.ARDITE.getDefaultState());
            addOre(biome, NETHERRACK, cobaltVeinSize, 4, 0, 20, 128, VanExpBlocks.COBALT.getDefaultState());
        }

        //Crimson Forest
        if (biome.equals(BiomeKeys.CRIMSON_FOREST)) {
            addOre(biome, CRIMSON_FOREST_REPLACEABLE, cobaltVeinSize, 8, 0, 20, 128, VanExpBlocks.COBALT.getDefaultState());
        }

        //Warped Forest
        if (biome.equals(BiomeKeys.WARPED_FOREST)) {
            addOre(biome, WARPED_FOREST_REPLACEABLE, darkIronVeinSize, 10, 0, 0, 128, VanExpBlocks.SOUL_IRON_ORE.getDefaultState());
            addOre(biome, WARPED_FOREST_REPLACEABLE, arditeVeinSize, 6, 0, 20, 128, VanExpBlocks.ARDITE.getDefaultState());
        }

        //Soul Sand Valley
        if (biome.equals(BiomeKeys.SOUL_SAND_VALLEY)) {
            addOre(biome, SOUL_SOIL, darkIronVeinSize + 4, 30, 0, 0, 128, VanExpBlocks.SOUL_SOIL_SOUL_IRON_ORE.getDefaultState());
        }

        //Basalt Deltas
        if (biome.equals(BiomeKeys.BASALT_DELTAS)) {
            addOre(biome, BLACKSTONE, arditeVeinSize * 4, 20, 0, 20, 128, VanExpBlocks.BLACKSTONE_ARDITE.getDefaultState());
            addOre(biome, BASALT, arditeVeinSize * 4, 20, 0, 20, 128, VanExpBlocks.BASALT_ARDITE.getDefaultState());
        }
    }

    public void init() {

        ORE = Registry.register(Registry.FEATURE, newID("ore"), new VanExpOreFeature(VanExpOreFeatureConfig.CODEC));

        Registry.BIOME.forEach(this::handleBiome);
        RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> handleBiome(biome));
    }

}
