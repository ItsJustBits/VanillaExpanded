package net.itsjustbits.vanilla_expanded.initializers;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.itsjustbits.vanilla_expanded.initializers.blocks.VanExpBlocks;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class VanillaExpMain implements ModInitializer {
	public static final String nameSpace = "vanexp";

	public static Identifier newID(String path) {
		return new Identifier(nameSpace, path);
	}

	public static final ItemGroup VANEXP_BLOCKS = FabricItemGroupBuilder.create(newID("blocks"))
			.icon(() -> new ItemStack(VanExpBlocks.BASE_METAL_ORES[0]))
			.build();

	public static final ItemGroup VANEXP_ITEMS = FabricItemGroupBuilder.create(newID("items"))
			.icon(() -> new ItemStack(null))
			.build();

	public static final ItemGroup VANEXP_TOOLS = FabricItemGroupBuilder.create(newID("tools"))
			.icon(() -> new ItemStack(null))
			.build();

	public static final ItemGroup VANEXP_COMBAT = FabricItemGroupBuilder.create(newID("combat"))
			.icon(() -> new ItemStack(null))
			.build();

	@Override
	public void onInitialize() {

		VanExpBlocks.init();
		VanExpItems.init();

		System.out.println("Vanilla Expansion registered !");
	}
}
