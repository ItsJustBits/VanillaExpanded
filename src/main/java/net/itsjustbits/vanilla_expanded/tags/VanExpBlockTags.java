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

    private VanExpBlockTags() {
    }

    private static Tag<Block> registerBlockTag(String id) {
        return TagRegistry.block(newID(id));
    }
}
