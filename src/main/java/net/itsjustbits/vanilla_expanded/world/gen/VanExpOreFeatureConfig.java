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

public class VanExpOreFeatureConfig implements FeatureConfig {
    public static final Codec<VanExpOreFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(VanExpOreFeatureConfig.Target.field_24898.fieldOf("target").forGetter((oreFeatureConfig) -> {
            return oreFeatureConfig.target;
        }), BlockState.CODEC.fieldOf("state").forGetter((oreFeatureConfig) -> {
            return oreFeatureConfig.state;
        }), Codec.INT.fieldOf("size").withDefault(0).forGetter((oreFeatureConfig) -> {
            return oreFeatureConfig.size;
        })).apply(instance, VanExpOreFeatureConfig::new);
    });
    public final VanExpOreFeatureConfig.Target target;
    public final int size;
    public final BlockState state;

    public VanExpOreFeatureConfig(VanExpOreFeatureConfig.Target target, BlockState state, int size) {
        this.size = size;
        this.state = state;
        this.target = target;
    }

    public static enum Target implements StringIdentifiable {
        BLACKSTONE("blackstone", new BlockPredicate(Blocks.BLACKSTONE)),
        SOUL_SOIL("soul_soil", new BlockPredicate(Blocks.SOUL_SOIL));

        public static final Codec<VanExpOreFeatureConfig.Target> field_24898 = StringIdentifiable.method_28140(VanExpOreFeatureConfig.Target::values, VanExpOreFeatureConfig.Target::byName);
        private static final Map<String, VanExpOreFeatureConfig.Target> nameMap = (Map)Arrays.stream(values()).collect(Collectors.toMap(VanExpOreFeatureConfig.Target::getName, (target) -> {
            return target;
        }));
        private final String name;
        private final Predicate<BlockState> predicate;

        private Target(String name, Predicate<BlockState> predicate) {
            this.name = name;
            this.predicate = predicate;
        }

        public String getName() {
            return this.name;
        }

        public static VanExpOreFeatureConfig.Target byName(String name) {
            return (VanExpOreFeatureConfig.Target)nameMap.get(name);
        }

        public Predicate<BlockState> getCondition() {
            return this.predicate;
        }

        public String asString() {
            return this.name;
        }
    }
}
