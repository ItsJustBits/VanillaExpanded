package net.itsjustbits.vanilla_expanded.initializers.blocks;

import jdk.internal.jline.internal.Nullable;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.Tag;

import static net.itsjustbits.vanilla_expanded.initializers.blocks.VanExpBlockUtils.*;

public class MultiBlockMakers {

    // Generic
    public static Block[] makeMultiBlock(int numberOfVariants, Material material, @Nullable Tag<Item> toolRequired, @Nullable int toolLevel, boolean handBreakable, float strength, BlockSoundGroup sound) {
        Block[] blocks = new Block[numberOfVariants];

        for (int j = 0; j <= blocks.length - 1; j++) {
            blocks[j] = new Block(FabricBlockSettings.of(material, assignColors()[j]).breakByTool(toolRequired, toolLevel).breakByHand(handBreakable).strength(strength).sounds(sound));
        }
        return blocks;
    }

    public static Block[] makeMultiBlock(int numberOfBlocks, AbstractBlock.Settings settings) {
        Block[] blocks = new Block[numberOfBlocks];

        for (int j = 0; j <= blocks.length - 1; j++) {
            blocks[j] = new Block(settings);
        }
        return blocks;
    }
}
