package net.itsjustbits.vanilla_expanded.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

import static net.itsjustbits.vanilla_expanded.initializers.VanillaExpMain.newID;

public class VanExpBlock extends Block {
    //private final Tag<Item> matchingTool;
    //private final Block effectivityCopy;

    public VanExpBlock(Settings settings) {
        super(settings);
        //this.matchingTool = matchingTool;
        //this.effectivityCopy = effectivityCopy;
    }

    /**
    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (player.getMainHandStack().getItem().isIn(matchingTool) && player.getMainHandStack().isEffectiveOn(effectivityCopy.getDefaultState())) {
            this.lootTableId = null;
        }
        else {
            this.lootTableId = newID("null_table");
        }

        super.onBreak(world, pos, state, player);
    }
    **/
}
