package net.itsjustbits.vanilla_expanded.initializers;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.itsjustbits.vanilla_expanded.initializers.blocks.VanExpBlocks;
import net.itsjustbits.vanilla_expanded.world.gen.VanExpOreFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import static net.itsjustbits.vanilla_expanded.initializers.VanillaExpMain.newID;
import static net.minecraft.world.gen.feature.OreFeatureConfig.*;
import static net.minecraft.world.gen.feature.OreFeatureConfig.Target.*;
import static net.itsjustbits.vanilla_expanded.world.gen.VanExpOreFeatureConfig.Target.*;

public class VanExpWorldGen {

    public static Feature<OreFeatureConfig> ORE;

    private static void addOre(Biome biome, Target target, int veinSize, int veinPerChunk, int bottomOffset, int minY, int maxY, BlockState oreBlock) {
        biome.addFeature(
                GenerationStep.Feature.UNDERGROUND_ORES,
                Feature.ORE.configure(
                        new OreFeatureConfig(
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

    private static void addOre(Biome biome, VanExpOreFeatureConfig.Target target, int veinSize, int veinPerChunk, int bottomOffset, int minY, int maxY, BlockState oreBlock) {
        biome.addFeature(
                GenerationStep.Feature.UNDERGROUND_ORES,
                Feature.ORE.configure(
                        new OreFeatureConfig(
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



    private void handleBiome(Biome biome) {
        if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
            addOre(biome, NATURAL_STONE, 5, 1, 0, 0, 25, VanExpBlocks.BASE_METAL_ORES[3].getDefaultState());
            for (int i = 0; i< VanExpBlocks.BASE_METAL_ORES.length - 1; i++)
                if (i !=3)
                    addOre(biome, NATURAL_STONE,8, 3, 0, 0, 54, VanExpBlocks.BASE_METAL_ORES[i].getDefaultState());
            for (int i = 0; i< VanExpBlocks.BASE_GEM_ORES.length - 1; i++)
                addOre(biome, NATURAL_STONE, 7, 1, 0, 0, 25, VanExpBlocks.BASE_GEM_ORES[i].getDefaultState());
        }

        //Nether ores
        int darkIronVeinSize = 8; //0
        int arditeVeinSize = 4; //1
        int cobaltVeinSize = 4; //2

        //Dark Iron
        if (biome.equals(Biomes.WARPED_FOREST) || biome.equals(Biomes.SOUL_SAND_VALLEY)) {
            addOre(biome, BLACKSTONE, darkIronVeinSize, 10, 0, 0, 128, VanExpBlocks.DARK_IRON_ORE.getDefaultState());
        }

        //Ardite
        if (biome.equals(Biomes.WARPED_FOREST) || biome.equals(Biomes.NETHER_WASTES) || biome.equals(Biomes.BASALT_DELTAS)) {
            addOre(biome, NETHER_ORE_REPLACEABLES, arditeVeinSize, 8, 0, 20, 128, VanExpBlocks.ARDITE.getDefaultState());
        }

        //Cobalt
        if (biome.equals(Biomes.CRIMSON_FOREST) || biome.equals(Biomes.NETHER_WASTES)) {
            addOre(biome, NETHERRACK, cobaltVeinSize, 8, 0, 20, 128, VanExpBlocks.COBALT.getDefaultState());
        }
    }

    public void init() {

        Registry.BIOME.forEach(this::handleBiome);
        RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> handleBiome(biome));
    }

}
