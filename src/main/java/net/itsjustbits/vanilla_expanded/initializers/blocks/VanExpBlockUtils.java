package net.itsjustbits.vanilla_expanded.initializers.blocks;

import net.itsjustbits.vanilla_expanded.initializers.VanillaExpMain;
import net.minecraft.block.Block;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.itsjustbits.vanilla_expanded.initializers.VanillaExpMain.*;


public class VanExpBlockUtils {
    public static final ItemGroup blockGroup = VanillaExpMain.VANEXP_BLOCKS;

    public static MaterialColor[] assignColors() {
        MaterialColor[] colors = new MaterialColor[17];
        colors[0] = MaterialColor.COLORS[8];

        for (int i = 0; i <= colors.length - 1; i++) {
            if (i > 0)
                colors[i] = MaterialColor.COLORS[i + 14];
        }
        return colors;
    }

    public static void registerBlock(String name, Block block, boolean inGroup) {
        Registry.register(Registry.BLOCK, new Identifier(nameSpace, name), block);
        Registry.register(Registry.ITEM, new Identifier(nameSpace, name), new BlockItem(block, new Item.Settings().group(inGroup ? blockGroup : null)));
    }

    public static void registerMultiBlock(String name, Block[] block, String[] variantType) {
        for (int i = 0; i <= variantType.length - 1; i++) {
            Registry.register(Registry.BLOCK, new Identifier(nameSpace, variantType[i] + name), block[i]);
            Registry.register(Registry.ITEM, new Identifier(nameSpace, variantType[i] + name), new BlockItem(block[i], new Item.Settings().group(blockGroup)));
        }
    }
}
