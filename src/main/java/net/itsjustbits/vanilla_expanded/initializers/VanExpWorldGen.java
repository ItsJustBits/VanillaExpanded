package net.itsjustbits.vanilla_expanded.initializers;

import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.itsjustbits.vanilla_expanded.initializers.blocks.VanExpBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class VanExpWorldGen {

    private static void addOre(Biome biome, int veinSize, int veinPerChunk, int bottomOffset, int minY, int maxY, BlockState oreBlock) {
        biome.addFeature(
                GenerationStep.Feature.UNDERGROUND_ORES,
                Feature.ORE.configure(
                        new OreFeatureConfig(
                                OreFeatureConfig.Target.NATURAL_STONE, oreBlock,
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
            for (int i = 0; i< VanExpBlocks.BASE_METAL_ORES.length - 1; i++)
                addOre(biome, 8, 5, 0, 0, 54, VanExpBlocks.BASE_METAL_ORES[i].getDefaultState());
            for (int i = 0; i< VanExpBlocks.BASE_GEM_ORES.length - 1; i++) {
                addOre(biome, 8, 3, 0, 0, 25, VanExpBlocks.BASE_GEM_ORES[i].getDefaultState());
            }
        }
    }

    public void init() {

        Registry.BIOME.forEach(this::handleBiome);
        RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> handleBiome(biome));
    }

}
