package net.itsjustbits.vanilla_expanded.initializers;

import me.shedaniel.cloth.api.dynamic.registry.v1.BiomesRegistry;
import me.shedaniel.cloth.api.dynamic.registry.v1.DynamicRegistryCallback;
import me.shedaniel.cloth.api.dynamic.registry.v1.EarlyInitializer;
import net.itsjustbits.vanilla_expanded.initializers.blocks.VanExpBlocks;
import net.itsjustbits.vanilla_expanded.tags.VanExpBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import static net.minecraft.world.gen.feature.OreFeatureConfig.Rules.*;

public class VanExpEarlyInit implements EarlyInitializer {

    public static final RuleTest BLACKSTONE = new BlockMatchRuleTest(Blocks.BLACKSTONE);
    public static final RuleTest BASALT = new BlockMatchRuleTest(Blocks.BASALT);
    public static final RuleTest SOUL_SOIL = new BlockMatchRuleTest(Blocks.SOUL_SOIL);
    public static final RuleTest CRIMSON_FOREST_REPLACEABLE = new TagMatchRuleTest(VanExpBlockTags.CRIMSON_FOREST_GROUND);
    public static final RuleTest WARPED_FOREST_REPLACEABLE = new TagMatchRuleTest(VanExpBlockTags.WARPED_FOREST_GROUND);

    private static void addOre(DynamicRegistryManager manager, Biome biome, RuleTest groundType, BlockState oreBlock, int veinSize, int bottomOffset, int topOffset, int maxY, int veinPerChunk) {
        BiomesRegistry.registerFeature(manager, biome, GenerationStep.Feature.UNDERGROUND_ORES, () -> Feature.ORE.configure(
                new OreFeatureConfig(groundType, oreBlock, veinSize)).decorate(Decorator.RANGE.configure(
                        new RangeDecoratorConfig(bottomOffset, topOffset, maxY))).spreadHorizontally().repeat(veinPerChunk));
    }

    private void handleBiome(DynamicRegistryManager manager, Biome biome, RegistryKey<Biome> key) {

        if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
            for (int i = 0; i< VanExpBlocks.BASE_METAL_ORES.length - 1; i++)
                addOre(manager, biome, BASE_STONE_OVERWORLD, VanExpBlocks.BASE_METAL_ORES[i].getDefaultState(), 8, 0, 0, 40, 15);
            for (int i = 0; i< VanExpBlocks.BASE_GEM_ORES.length - 1; i++)
                addOre(manager, biome, BASE_STONE_OVERWORLD, VanExpBlocks.BASE_GEM_ORES[i].getDefaultState(), 6, 0, 0, 28, 2);
        }

        //Nether ores
        int darkIronVeinSize = 4;
        int arditeVeinSize = 4;
        int cobaltVeinSize = 4;

        //Nether Wastes
        if (key.equals(BiomeKeys.NETHER_WASTES)) {
            addOre(manager, biome, NETHERRACK, VanExpBlocks.ARDITE.getDefaultState(), arditeVeinSize - 1, 10, 20, 128, 5);
            addOre(manager, biome, NETHERRACK, VanExpBlocks.COBALT.getDefaultState(), cobaltVeinSize - 1, 10, 20, 128, 5);
        }

        //Crimson Forest
        if (key.equals(BiomeKeys.CRIMSON_FOREST)) {
            addOre(manager, biome, CRIMSON_FOREST_REPLACEABLE, VanExpBlocks.COBALT.getDefaultState(), cobaltVeinSize + 2, 10, 20, 128, 20);
        }

        //Warped Forest
        if (key.equals(BiomeKeys.WARPED_FOREST)) {
            addOre(manager, biome, WARPED_FOREST_REPLACEABLE, VanExpBlocks.DARK_IRON_ORE.getDefaultState(), darkIronVeinSize + 2, 10, 20, 128, 15);
            addOre(manager, biome, WARPED_FOREST_REPLACEABLE, VanExpBlocks.ARDITE.getDefaultState(), arditeVeinSize + 2, 10, 20, 128, 20);
        }

        //Soul Sand Valley
        if (key.equals(BiomeKeys.SOUL_SAND_VALLEY)) {
            addOre(manager, biome, SOUL_SOIL, VanExpBlocks.SOUL_SOIL_DARK_IRON_ORE.getDefaultState(), darkIronVeinSize + 4, 10, 20, 128, 20);
        }

        //Basalt Deltas
        if (key.equals(BiomeKeys.BASALT_DELTAS)) {
            addOre(manager, biome, BLACKSTONE, VanExpBlocks.BLACKSTONE_ARDITE.getDefaultState(), arditeVeinSize + 2, 10, 20, 128, 20);
            addOre(manager, biome, BASALT, VanExpBlocks.BASALT_ARDITE.getDefaultState(), arditeVeinSize + 2, 10, 20, 128, 20);
        }
    }

    @Override
    public void onEarlyInitialization() {

        DynamicRegistryCallback.callback(Registry.BIOME_KEY).register((manager, key, biome) -> handleBiome(manager, biome, key));
    }
}
