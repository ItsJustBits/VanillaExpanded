package net.itsjustbits.vanilla_expanded.world.gen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.predicate.block.BlockPredicate;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//This code was copied from vanilla game and adapted for this mod's purpose, all credit goes to Mojang

public class VanExpOreFeatureConfig implements FeatureConfig {
    public static final Codec<VanExpOreFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(GroundFillerBlock.field_24898.fieldOf("target").forGetter((oreFeatureConfig) -> {
            return oreFeatureConfig.target;
        }), BlockState.CODEC.fieldOf("state").forGetter((oreFeatureConfig) -> {
            return oreFeatureConfig.state;
        }), Codec.INT.fieldOf("size").withDefault(0).forGetter((oreFeatureConfig) -> {
            return oreFeatureConfig.size;
        })).apply(instance, VanExpOreFeatureConfig::new);
    });
    public final GroundFillerBlock target;
    public final int size;
    public final BlockState state;

    public VanExpOreFeatureConfig(GroundFillerBlock target, BlockState state, int size) {
        this.size = size;
        this.state = state;
        this.target = target;
    }

    public static enum GroundFillerBlock implements StringIdentifiable {
        BLACKSTONE("blackstone", new BlockPredicate(Blocks.BLACKSTONE)),
        BASALT("basalt", new BlockPredicate(Blocks.BASALT)),
        SOUL_SOIL("soul_soil", new BlockPredicate(Blocks.SOUL_SOIL)),
        WARPED_FOREST_REPLACEABLE("warped_forest_replaceables", (blockState) -> {
            if (blockState == null) {
                return false;
            } else {
                return blockState.isOf(Blocks.NETHERRACK) || blockState.isOf(Blocks.WARPED_NYLIUM);
            }
        });

        public static final Codec<GroundFillerBlock> field_24898 = StringIdentifiable.method_28140(GroundFillerBlock::values, GroundFillerBlock::byName);
        private static final Map<String, GroundFillerBlock> nameMap = (Map)Arrays.stream(values()).collect(Collectors.toMap(GroundFillerBlock::getName, (target) -> {
            return target;
        }));
        private final String name;
        private final Predicate<BlockState> predicate;

        private GroundFillerBlock(String name, Predicate<BlockState> predicate) {
            this.name = name;
            this.predicate = predicate;
        }

        public String getName() {
            return this.name;
        }

        public static GroundFillerBlock byName(String name) {
            return (GroundFillerBlock)nameMap.get(name);
        }

        public Predicate<BlockState> getCondition() {
            return this.predicate;
        }

        public String asString() {
            return this.name;
        }
    }
}
