package net.itsjustbits.vanilla_expanded.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.loot.LootTable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

import static net.itsjustbits.vanilla_expanded.initializers.VanillaExpMain.newID;

public class VanExpOreBlock extends Block {
    private int minExp;
    private int maxExp;
    private final int minExpFinal;
    private final int maxExpFinal;
    private final Tag<Item> matchingTool;
    private final Block effectivityCopy;

    public VanExpOreBlock(int minExp, int maxExp, Tag<Item> matchingTool, Block effectivityCopy, Settings settings) {
        super(settings);
        this.minExpFinal = minExp;
        this.maxExpFinal = maxExp;
        this.matchingTool = matchingTool;
        this.effectivityCopy = effectivityCopy;
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (player.getMainHandStack().getItem().isIn(matchingTool) && player.getMainHandStack().isEffectiveOn(effectivityCopy.getDefaultState())) {
            this.lootTableId = null;
            this.minExp = minExpFinal;
            this.maxExp = maxExpFinal;
            player.getMainHandStack().getMiningSpeedMultiplier(state);
        }
        else {
            this.lootTableId = newID("null_table");
            this.minExp = 0;
            this.maxExp = 0;
        }

        super.onBreak(world, pos, state, player);
    }

    protected int getExperienceWhenMined(Random random) {
        return MathHelper.nextInt(random, minExp, maxExp);
    }

    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
        super.onStacksDropped(state, world, pos, stack);
        if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
            int i = this.getExperienceWhenMined(world.random);
            if (i > 0) {
                this.dropExperience(world, pos, i);
            }
        }
    }
}
