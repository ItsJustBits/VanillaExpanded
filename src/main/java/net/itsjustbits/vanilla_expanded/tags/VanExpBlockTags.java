package net.itsjustbits.vanilla_expanded.tags;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

import static net.itsjustbits.vanilla_expanded.initializers.VanillaExpMain.newID;

public class VanExpBlockTags {
    public static final Tag<Block> CRIMSON_FOREST_GROUND = registerBlockTag("crimson_forest_ground");
    public static final Tag<Block> WARPED_FOREST_GROUND = registerBlockTag("warped_forest_ground");

    public static final Tag<Block> PICKAXE_NETHERITE_MINEABLE = registerBlockTag("netherite_pickaxe_mineable");
    public static final Tag<Block> PICKAXE_DIAMOND_MINEABLE = registerBlockTag("diamond_pickaxe_mineable");
    public static final Tag<Block> PICKAXE_IRON_MINEABLE = registerBlockTag("iron_pickaxe_mineable");
    public static final Tag<Block> PICKAXE_STONE_MINEABLE = registerBlockTag("stone_pickaxe_mineable");

    public static final Tag<Block> SHOVEL_NETHERITE_MINEABLE = registerBlockTag("netherite_shovel_mineable");
    public static final Tag<Block> SHOVEL_DIAMOND_MINEABLE = registerBlockTag("diamond_shovel_mineable");
    public static final Tag<Block> SHOVEL_IRON_MINEABLE = registerBlockTag("iron_shovel_mineable");
    public static final Tag<Block> SHOVEL_STONE_MINEABLE = registerBlockTag("stone_shovel_mineable");

    private VanExpBlockTags() {
    }

    private static Tag<Block> registerBlockTag(String id) {
        return TagRegistry.block(newID(id));
    }
}
