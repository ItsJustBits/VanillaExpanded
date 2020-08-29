package net.itsjustbits.vanilla_expanded.armor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.itsjustbits.vanilla_expanded.initializers.VanExpItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum  VanExpArmorMaterial implements ArmorMaterial {
    COPPER("copper", 10, new int[]{2, 5, 6, 2}, 22, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(VanExpItems.ARDITE_INGOT);
    }),
    SOUL_IRON("soul_iron", 20, new int[]{3, 6, 8, 3}, 18, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.5F, 0.0F, () -> {
        return Ingredient.ofItems(VanExpItems.ARDITE_INGOT);
    }),
    ARDITE("ardite", 42, new int[]{4, 7, 9, 4}, 18, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.1F, () -> {
        return Ingredient.ofItems(VanExpItems.ARDITE_INGOT);
    }),
    COBALT("cobalt", 42, new int[]{4, 7, 9, 4}, 18, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.1F, () -> {
        return Ingredient.ofItems(VanExpItems.COBALT_INGOT);
    });

    private static final int[] baseDurability = {13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] armorValues;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredient;

    VanExpArmorMaterial(String name, int durabilityMultiplier, int[] armorValueArr, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.armorValues = armorValueArr;
        this.enchantability = enchantability;
        this.equipSound = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = new Lazy(repairIngredient);
    }


    public int getDurability(EquipmentSlot equipmentSlot_1) {
        return baseDurability[equipmentSlot_1.getEntitySlotId()] * this.durabilityMultiplier;
    }

    public int getProtectionAmount(EquipmentSlot equipmentSlot_1) {
        return this.armorValues[equipmentSlot_1.getEntitySlotId()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Environment(EnvType.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
