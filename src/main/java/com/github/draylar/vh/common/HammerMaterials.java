package com.github.draylar.vh.common;

import com.github.draylar.vh.VanillaHammers;
import net.minecraft.block.Blocks;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public enum HammerMaterials implements IItemTier {
    WOOD(0, 59 * VanillaHammers.DURABILITY_MODIFIER, 2.0F / 3.5f, 0.0f, 15, () -> {
        return Ingredient.fromTag(ItemTags.PLANKS);
    }),
    STONE(1, 131 * VanillaHammers.DURABILITY_MODIFIER, 4.0F / 3.5f, 0.0f, 5, () -> {
        return Ingredient.fromItems(Blocks.COBBLESTONE);
    }),
    IRON(2, 250 * VanillaHammers.DURABILITY_MODIFIER, 6.0F / 3.5f, 0.0f, 14, () -> {
        return Ingredient.fromItems(Items.IRON_INGOT);
    }),
    DIAMOND(3, 1561 * VanillaHammers.DURABILITY_MODIFIER, 8.0F / 3.5f, 0.0f, 10, () -> {
        return Ingredient.fromItems(Items.DIAMOND);
    }),
    GOLD(0, 32 * VanillaHammers.DURABILITY_MODIFIER, 12.0F / 3.5f, 0.0f, 22, () -> {
        return Ingredient.fromItems(Items.GOLD_INGOT);
    }),
    EMERALD(3, 1028 * VanillaHammers.DURABILITY_MODIFIER, 12.0F / 3.5f, 0.0f, 25, () -> {
        return Ingredient.fromItems(Items.EMERALD);
    }),
    OBSIDIAN(2, 2048 * VanillaHammers.DURABILITY_MODIFIER, 5.0F / 3.5f, 0.0f, 5, () -> {
        return Ingredient.fromItems(Items.OBSIDIAN);
    }),
    LAPIS(1, 220 * VanillaHammers.DURABILITY_MODIFIER, 6.0f / 3.5f, 0.0f, 30, () -> {
        return Ingredient.fromItems(Items.LAPIS_LAZULI);
    }),
    QUARTZ(2, 1028 * VanillaHammers.DURABILITY_MODIFIER, 8.0F / 3.5f, 0.0f, 10, () -> {
        return Ingredient.fromItems(Items.QUARTZ);
    }),
    FIERY(3, 750 * VanillaHammers.DURABILITY_MODIFIER, 7.0F / 3.5f, 0f, 15, () -> {
        return Ingredient.fromItems(Items.MAGMA_BLOCK);
    }),
    PRISMARINE(3, 750 * VanillaHammers.DURABILITY_MODIFIER, 7.0F / 3.5F, 0f, 20, () -> {
        return Ingredient.fromItems(Items.PRISMARINE_SHARD);
    }),
    ENDER(3, 1561 * VanillaHammers.DURABILITY_MODIFIER, 10f / 3.5f, 0, 10, () -> {
        return Ingredient.fromItems(Items.ENDER_PEARL);
    }),
    SLIME(2, 1500 * VanillaHammers.DURABILITY_MODIFIER, 6f / 3.5f, 0, 20, () -> {
        return Ingredient.fromItems(Items.SLIME_BALL);
    }),
    POTATO(1, 500 * VanillaHammers.DURABILITY_MODIFIER, 4.0F / 3.5f, 0.0f, 100, () -> {
        return Ingredient.fromItems(Registry.ITEM.getOrDefault(new ResourceLocation("lil-tater", "lil_tater")));
    }),
    GLOWSTONE(2, 442 * VanillaHammers.DURABILITY_MODIFIER, 5.0F / 3.5f, 0.0f, 15, () -> {
        return Ingredient.fromItems(Registry.ITEM.getOrDefault(new ResourceLocation("netherthings", "glowstone_ingot")));
    }),
    NETHER(1, 280 * VanillaHammers.DURABILITY_MODIFIER, 5.0F / 3.5f, 0.0f, 77, () -> {
        return Ingredient.fromItems(Registry.ITEM.getOrDefault(new ResourceLocation("netherthings", "nether_brick")));
    }),
    VIBRANIUM(3, (int) (21850d * (VanillaHammers.DURABILITY_MODIFIER / 2.5f)), 22f / 3.5f, 0.0f, 7, () -> {
        return Ingredient.fromItems(Registry.ITEM.getOrDefault(new ResourceLocation("netherthings", "vibranium")));
    });

    private final int harvestLevel;
    private final int durability;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyLoadBase<Ingredient> repairMaterial;

    HammerMaterials(int harvestLevel, int durability, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyLoadBase<>(repairMaterial);
    }


    @Override
    public int getMaxUses() {
        return this.durability;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }


}
