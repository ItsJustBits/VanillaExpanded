package net.itsjustbits.vanilla_expanded;

import net.minecraft.block.Block;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class VanillaExpMain implements ModInitializer {
	public final String nameSpace = "vanilla_exp";

	public static final Block COPPER_ORE = new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.STONE).breakByTool(FabricToolTags.PICKAXES).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE));
	public static final Block TIN_ORE = new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.STONE).breakByTool(FabricToolTags.PICKAXES).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE));
	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier(nameSpace, "copper_ore"), COPPER_ORE);
		Registry.register(Registry.BLOCK, new Identifier(nameSpace, "tin_ore"), TIN_ORE);

		Registry.register(Registry.ITEM, new Identifier(nameSpace, "copper_ore"), new BlockItem(COPPER_ORE, new Item.Settings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier(nameSpace, "tin_ore"), new BlockItem(TIN_ORE, new Item.Settings().group(ItemGroup.MISC)));


		System.out.println("Hello Fabric world!");
	}
}
