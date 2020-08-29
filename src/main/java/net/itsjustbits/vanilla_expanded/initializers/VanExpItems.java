package net.itsjustbits.vanilla_expanded.initializers;

import net.itsjustbits.vanilla_expanded.armor.VanExpArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;


import static net.itsjustbits.vanilla_expanded.initializers.VanillaExpMain.*;

public class VanExpItems {

    //Items group
    //Ore items
    public static final Item COPPER_INGOT = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item TIN_INGOT = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item BRONZE_INGOT = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item SILVER_INGOT = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item LEAD_INGOT = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item NICKEL_INGOT = new Item(new Item.Settings().group(VANEXP_ITEMS));

    public static final Item RUBY = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item TOPAZ = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item PERIDOT = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item SAPPHIRE = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item AMETHYST = new Item(new Item.Settings().group(VANEXP_ITEMS));

    public static final Item SOUL_IRON_INGOT = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item SOUL_IRON_NUGGET = new Item(new Item.Settings().group(VANEXP_ITEMS));

    public static final Item ARDITE_INGOT = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item ARDITE_CHUNK = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item ARDITE_NUGGET = new Item(new Item.Settings().group(VANEXP_ITEMS));

    public static final Item COBALT_INGOT = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item COBALT_CHUNK = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item COBALT_NUGGET = new Item(new Item.Settings().group(VANEXP_ITEMS));

    public static final Item PLATINUM_INGOT = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item PLATINUM_CHUNK = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item PLATINUM_NUGGET = new Item(new Item.Settings().group(VANEXP_ITEMS));

    public static final Item MALACHITE = new Item(new Item.Settings().group(VANEXP_ITEMS));
    public static final Item SULFUR = new Item(new Item.Settings().group(VANEXP_ITEMS));

    //Combat group
    //Armor
    public static final Item COPPER_HELMET = new ArmorItem(VanExpArmorMaterial.COPPER, EquipmentSlot.HEAD, (new Item.Settings().group(VANEXP_COMBAT)));
    public static final Item COPPER_CHESTPLATE = new ArmorItem(VanExpArmorMaterial.COPPER, EquipmentSlot.CHEST, (new Item.Settings().group(VANEXP_COMBAT)));
    public static final Item COPPER_LEGGINGS = new ArmorItem(VanExpArmorMaterial.COPPER, EquipmentSlot.LEGS, (new Item.Settings().group(VANEXP_COMBAT)));
    public static final Item COPPER_BOOTS = new ArmorItem(VanExpArmorMaterial.COPPER, EquipmentSlot.FEET, (new Item.Settings().group(VANEXP_COMBAT)));

    public static final Item SOUL_IRON_HELMET = new ArmorItem(VanExpArmorMaterial.SOUL_IRON, EquipmentSlot.HEAD, (new Item.Settings().group(VANEXP_COMBAT)));
    public static final Item SOUL_IRON_CHESTPLATE = new ArmorItem(VanExpArmorMaterial.SOUL_IRON, EquipmentSlot.CHEST, (new Item.Settings().group(VANEXP_COMBAT)));
    public static final Item SOUL_IRON_LEGGINGS = new ArmorItem(VanExpArmorMaterial.SOUL_IRON, EquipmentSlot.LEGS, (new Item.Settings().group(VANEXP_COMBAT)));
    public static final Item SOUL_IRON_BOOTS = new ArmorItem(VanExpArmorMaterial.SOUL_IRON, EquipmentSlot.FEET, (new Item.Settings().group(VANEXP_COMBAT)));

    public static final Item ARDITE_HELMET = new ArmorItem(VanExpArmorMaterial.ARDITE, EquipmentSlot.HEAD, (new Item.Settings().group(VANEXP_COMBAT)));
    public static final Item ARDITE_CHESTPLATE = new ArmorItem(VanExpArmorMaterial.ARDITE, EquipmentSlot.CHEST, (new Item.Settings().group(VANEXP_COMBAT)));
    public static final Item ARDITE_LEGGINGS = new ArmorItem(VanExpArmorMaterial.ARDITE, EquipmentSlot.LEGS, (new Item.Settings().group(VANEXP_COMBAT)));
    public static final Item ARDITE_BOOTS = new ArmorItem(VanExpArmorMaterial.ARDITE, EquipmentSlot.FEET, (new Item.Settings().group(VANEXP_COMBAT)));

    public static final Item COBALT_HELMET = new ArmorItem(VanExpArmorMaterial.COBALT, EquipmentSlot.HEAD, (new Item.Settings().group(VANEXP_COMBAT)));
    public static final Item COBALT_CHESTPLATE = new ArmorItem(VanExpArmorMaterial.COBALT, EquipmentSlot.CHEST, (new Item.Settings().group(VANEXP_COMBAT)));
    public static final Item COBALT_LEGGINGS = new ArmorItem(VanExpArmorMaterial.COBALT, EquipmentSlot.LEGS, (new Item.Settings().group(VANEXP_COMBAT)));
    public static final Item COBALT_BOOTS = new ArmorItem(VanExpArmorMaterial.COBALT, EquipmentSlot.FEET, (new Item.Settings().group(VANEXP_COMBAT)));

    public static final Item PLATINUM_HELMET = new ArmorItem(VanExpArmorMaterial.COBALT, EquipmentSlot.HEAD, (new Item.Settings().group(VANEXP_COMBAT)));
    public static final Item PLATINUM_CHESTPLATE = new ArmorItem(VanExpArmorMaterial.COBALT, EquipmentSlot.CHEST, (new Item.Settings().group(VANEXP_COMBAT)));
    public static final Item PLATINUM_LEGGINGS = new ArmorItem(VanExpArmorMaterial.COBALT, EquipmentSlot.LEGS, (new Item.Settings().group(VANEXP_COMBAT)));
    public static final Item PLATINUM_BOOTS = new ArmorItem(VanExpArmorMaterial.COBALT, EquipmentSlot.FEET, (new Item.Settings().group(VANEXP_COMBAT)));


    public static final Item[] COPPER_ARMOR = {
            COPPER_HELMET,
            COPPER_CHESTPLATE,
            COPPER_LEGGINGS,
            COPPER_BOOTS
    };
    public static final Item[] SOUL_IRON_ARMOR = {
            SOUL_IRON_HELMET,
            SOUL_IRON_CHESTPLATE,
            SOUL_IRON_LEGGINGS,
            SOUL_IRON_BOOTS
    };
    public static final Item[] ARDITE_ARMOR = {
            ARDITE_HELMET,
            ARDITE_CHESTPLATE,
            ARDITE_LEGGINGS,
            ARDITE_BOOTS
    };
    public static final Item[] COBALT_ARMOR = {
            COBALT_HELMET,
            COBALT_CHESTPLATE,
            COBALT_LEGGINGS,
            COBALT_BOOTS
    };
    public static final Item[] PLATINUM_ARMOR = {
            PLATINUM_HELMET,
            PLATINUM_CHESTPLATE,
            PLATINUM_LEGGINGS,
            PLATINUM_BOOTS
    };

    //Utils
    private static class ItemUtils {
        private static void registerOreItem(int type, String path, Item item) {
            if (type == 1) //Ingot
                Registry.register(Registry.ITEM, newID(path + "_ingot"), item);
            if (type == 2) //Nugget
                Registry.register(Registry.ITEM, newID(path + "_nugget"), item);
            if (type == 3) //Chunk
                Registry.register(Registry.ITEM, newID(path + "_chunk"), item);
        }

        private static void registerArmor(String path, Item[] item) {
            Registry.register(Registry.ITEM, newID(path + "_helmet"), item[0]);
            Registry.register(Registry.ITEM, newID(path + "_chestplate"), item[1]);
            Registry.register(Registry.ITEM, newID(path + "_leggings"), item[2]);
            Registry.register(Registry.ITEM, newID(path + "_boots"), item[3]);
        }
    }

    public static void init() {

        //Items group
        //Ingots
        ItemUtils.registerOreItem(1, "copper", COPPER_INGOT);
        ItemUtils.registerOreItem(1, "tin", TIN_INGOT);
        ItemUtils.registerOreItem(1, "silver", SILVER_INGOT);
        ItemUtils.registerOreItem(1, "bronze", BRONZE_INGOT);
        ItemUtils.registerOreItem(1, "nickel", NICKEL_INGOT);
        ItemUtils.registerOreItem(1, "lead", LEAD_INGOT);

        ItemUtils.registerOreItem(1, "soul_iron", SOUL_IRON_INGOT);
        ItemUtils.registerOreItem(1, "ardite", ARDITE_INGOT);
        ItemUtils.registerOreItem(1, "cobalt", COBALT_INGOT);
        ItemUtils.registerOreItem(1, "platinum", PLATINUM_INGOT);

        ItemUtils.registerOreItem(3, "ardite", ARDITE_CHUNK);
        ItemUtils.registerOreItem(3, "cobalt", COBALT_CHUNK);
        ItemUtils.registerOreItem(3, "platinum", PLATINUM_CHUNK);

        ItemUtils.registerOreItem(2, "soul_iron", SOUL_IRON_NUGGET);
        ItemUtils.registerOreItem(2, "ardite", ARDITE_NUGGET);
        ItemUtils.registerOreItem(2, "cobalt", COBALT_NUGGET);
        ItemUtils.registerOreItem(2, "platinum", PLATINUM_NUGGET);

        //Gems
        Registry.register(Registry.ITEM, newID("ruby"), RUBY);
        Registry.register(Registry.ITEM, newID("topaz"), TOPAZ);
        Registry.register(Registry.ITEM, newID("peridot"), PERIDOT);
        Registry.register(Registry.ITEM, newID("sapphire"), SAPPHIRE);
        Registry.register(Registry.ITEM, newID("amethyst"), AMETHYST);
        Registry.register(Registry.ITEM, newID("malachite"), MALACHITE);

        //Other ore items
        Registry.register(Registry.ITEM, newID("sulfur"), SULFUR);

        //Combat group
        //Armor
        ItemUtils.registerArmor("copper", COPPER_ARMOR);
        ItemUtils.registerArmor("soul_iron", SOUL_IRON_ARMOR);
        ItemUtils.registerArmor("ardite", ARDITE_ARMOR);
        ItemUtils.registerArmor("cobalt", COBALT_ARMOR);
        ItemUtils.registerArmor("platinum", PLATINUM_ARMOR);
    }
}
