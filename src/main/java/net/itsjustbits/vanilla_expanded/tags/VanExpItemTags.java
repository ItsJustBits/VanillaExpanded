package net.itsjustbits.vanilla_expanded.tags;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class VanExpItemTags {

    private VanExpItemTags() {
    }

    private static Tag<Item> register(String id) {
        return TagRegistry.item(new Identifier("vom", id));
    }
}
