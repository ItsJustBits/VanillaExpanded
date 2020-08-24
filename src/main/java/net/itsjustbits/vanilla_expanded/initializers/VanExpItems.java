package net.itsjustbits.vanilla_expanded.initializers;

import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;


import static net.itsjustbits.vanilla_expanded.initializers.VanillaExpMain.*;

public class VanExpItems {

    public static final Item COPPER_INGOT = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item TIN_INGOT = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item BRONZE_INGOT = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item SILVER_INGOT = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item LEAD_INGOT = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item NICKEL_INGOT = new Item(new Item.Settings().group(VANEXP_ITEMS));

    public static final Item COPPER_NUGGET = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item TIN_NUGGET = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item BRONZE_NUGGET = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item SILVER_NUGGET = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item LEAD_NUGGET = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item NICKEL_NUGGET = new Item(new Item.Settings().group(VANEXP_ITEMS));

    public static void init() {

        Registry.register(Registry.ITEM, newID("copper_ingot"), COPPER_INGOT);
        Registry.register(Registry.ITEM, newID("tin_ingot"), TIN_INGOT);
        Registry.register(Registry.ITEM, newID("bronze_ingot"), BRONZE_INGOT);
        Registry.register(Registry.ITEM, newID("silver_ingot"), SILVER_INGOT);
        Registry.register(Registry.ITEM, newID("lead_ingot"), LEAD_INGOT);
        Registry.register(Registry.ITEM, newID("nickel_ingot"), NICKEL_INGOT);

        Registry.register(Registry.ITEM, newID("copper_nugget"), COPPER_NUGGET);
        Registry.register(Registry.ITEM, newID("tin_nugget"), TIN_NUGGET);
        Registry.register(Registry.ITEM, newID("bronze_nugget"), BRONZE_NUGGET);
        Registry.register(Registry.ITEM, newID("silver_nugget"), SILVER_NUGGET);
        Registry.register(Registry.ITEM, newID("lead_nugget"), LEAD_NUGGET);
        Registry.register(Registry.ITEM, newID("nickel_nugget"), NICKEL_NUGGET);

    }
}
