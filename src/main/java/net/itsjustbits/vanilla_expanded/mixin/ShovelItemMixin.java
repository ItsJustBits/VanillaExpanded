package net.itsjustbits.vanilla_expanded.mixin;

import net.itsjustbits.vanilla_expanded.tags.VanExpBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;

@Mixin(ShovelItem.class)
public class ShovelItemMixin extends MiningToolItem {
    @Shadow private static Set<Block> EFFECTIVE_BLOCKS;

    protected ShovelItemMixin(float attackDamage, float attackSpeed, ToolMaterial material, Settings settings) {
        super(attackDamage, attackSpeed, material, EFFECTIVE_BLOCKS, settings);
    }

    @Inject(at = @At("HEAD"), method = "isEffectiveOn", cancellable = true)
    public boolean isEffectiveOn(BlockState state, CallbackInfoReturnable infoReturnable) {
        int i = this.getMaterial().getMiningLevel();
        if (state.isIn(VanExpBlockTags.SHOVEL_NETHERITE_MINEABLE)) {
            infoReturnable.setReturnValue(i >= 4);
            return i >= 4;
        }
        else if (state.isIn(VanExpBlockTags.SHOVEL_DIAMOND_MINEABLE)) {
            infoReturnable.setReturnValue(i >= 3);
            return i >= 3;
        }
        else if (state.isIn(VanExpBlockTags.SHOVEL_IRON_MINEABLE)) {
            infoReturnable.setReturnValue(i >= 2);
            return i >= 2;
        }
        else if (state.isIn(VanExpBlockTags.SHOVEL_STONE_MINEABLE)) {
            infoReturnable.setReturnValue(i >= 1);
            return i >= 1;
        }
        else {
            infoReturnable.setReturnValue(state.isOf(Blocks.SNOW) || state.isOf(Blocks.SNOW_BLOCK));
            return state.isOf(Blocks.SNOW) || state.isOf(Blocks.SNOW_BLOCK);
        }
    }
}

