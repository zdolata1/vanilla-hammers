package de.melanx.vanillahammers.common;

import de.melanx.vanillahammers.VanillaHammers;
import de.melanx.vanillahammers.data.tags.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.LazyLoadBase;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public enum HammerMaterials implements IItemTier {
    WOOD(0, 59 * VanillaHammers.DURABILITY_MODIFIER, 2.0F / 3.5f, 3, -2.5F, 15, () -> {
        return Ingredient.fromTag(ItemTags.PLANKS);
    }, "wooden", ItemTags.PLANKS, ItemTags.LOGS),
    STONE(1, 131 * VanillaHammers.DURABILITY_MODIFIER, 4.0F / 3.5f, 4, -2.6F, 5, () -> {
        return Ingredient.fromTag(Tags.Items.COBBLESTONE);
    }, "stone", Tags.Items.COBBLESTONE, Tags.Items.STONE),
    IRON(2, 250 * VanillaHammers.DURABILITY_MODIFIER, 6.0F / 3.5f, 5, -2.8F, 14, () -> {
        return Ingredient.fromTag(Tags.Items.INGOTS_IRON);
    }, "iron", Tags.Items.INGOTS_IRON, Tags.Items.STORAGE_BLOCKS_IRON),
    GOLD(0, 32 * VanillaHammers.DURABILITY_MODIFIER, 12.0F / 3.5f, 5, -2.5F, 22, () -> {
        return Ingredient.fromTag(Tags.Items.INGOTS_GOLD);
    }, "golden", Tags.Items.INGOTS_GOLD, Tags.Items.STORAGE_BLOCKS_GOLD),
    DIAMOND(3, 1561 * VanillaHammers.DURABILITY_MODIFIER, 8.0F / 3.5f, 10, -3.0F, 10, () -> {
        return Ingredient.fromTag(Tags.Items.GEMS_DIAMOND);
    }, "diamond", Tags.Items.GEMS_DIAMOND, Tags.Items.STORAGE_BLOCKS_DIAMOND),
    EMERALD(3, 1028 * VanillaHammers.DURABILITY_MODIFIER, 12.0F / 3.5f, 11, -3.0F, 25, () -> {
        return Ingredient.fromTag(Tags.Items.GEMS_EMERALD);
    }, "emerald", Tags.Items.GEMS_EMERALD, Tags.Items.STORAGE_BLOCKS_EMERALD),
    OBSIDIAN(2, 2048 * VanillaHammers.DURABILITY_MODIFIER, 5.0F / 3.5f, 7, -3.5F, 5, () -> {
        return Ingredient.fromTag(Tags.Items.OBSIDIAN);
    }, "obsidian", Tags.Items.OBSIDIAN),
    QUARTZ(2, 1028 * VanillaHammers.DURABILITY_MODIFIER, 8.0F / 3.5f, 5, -2.0F, 10, () -> {
        return Ingredient.fromTag(Tags.Items.GEMS_QUARTZ);
    }, "quartz", Tags.Items.GEMS_QUARTZ, Tags.Items.STORAGE_BLOCKS_QUARTZ),
    LAPIS(1, 220 * VanillaHammers.DURABILITY_MODIFIER, 6.0f / 3.5f, 3, -2.5F, 30, () -> {
        return Ingredient.fromTag(Tags.Items.GEMS_LAPIS);
    }, "lapis", Tags.Items.GEMS_LAPIS, Tags.Items.STORAGE_BLOCKS_LAPIS),
    FIERY(3, 750 * VanillaHammers.DURABILITY_MODIFIER, 7.0F / 3.5f, 6, -2.3F, 15, () -> {
        return Ingredient.fromTag(ModTags.Items.MAGMA_BLOCK);
    }, "fiery", ModTags.Items.MAGMA_CREAM, ModTags.Items.MAGMA_BLOCK),
    PRISMARINE(3, 750 * VanillaHammers.DURABILITY_MODIFIER, 7.0F / 3.5F, 6, -2.3F, 20, () -> {
        return Ingredient.fromTag(Tags.Items.DUSTS_PRISMARINE);
    }, "prismarine", Tags.Items.DUSTS_PRISMARINE, ModTags.Items.PRISMARINE),
    ENDER(3, 1561 * VanillaHammers.DURABILITY_MODIFIER, 10f / 3.5f, 10, -3.3F, 10, () -> {
        return Ingredient.fromTag(Tags.Items.ENDER_PEARLS);
    }, "ender", ModTags.Items.DRAGON_HEAD, Tags.Items.END_STONES),
    SLIME(2, 1500 * VanillaHammers.DURABILITY_MODIFIER, 6f / 3.5f, 7, -3.0F, 20, () -> {
        return Ingredient.fromTag(Tags.Items.SLIMEBALLS);
    }, "slime", Tags.Items.SLIMEBALLS, ModTags.Items.SLIME_BLOCK),
    GLOWSTONE(2, 189 * VanillaHammers.DURABILITY_MODIFIER, 5.0F / 3.5f, 5, -2.3F, 15, () -> {
        return Ingredient.fromTag(ModTags.Items.STORAGE_BLOCKS_GLOWSTONE);
    }, "glowstone", Tags.Items.DUSTS_GLOWSTONE, ModTags.Items.STORAGE_BLOCKS_GLOWSTONE),
    NETHER(1, 280 * VanillaHammers.DURABILITY_MODIFIER, 5.0F / 3.5f, 4, -2.1F, 77, () -> {
        return Ingredient.fromTag(ModTags.Items.NETHER_BRICKS);
    }, "nether", Tags.Items.NETHERRACK, ModTags.Items.NETHER_BRICKS);

    private final int harvestLevel;
    private final int durability;
    private final float efficiency;
    private final float attackDamage;
    private final float attackSpeed;
    private final int enchantability;
    private final LazyLoadBase<Ingredient> repairMaterial;
    private final String prefix;
    private final Tag<Item> tagIngredient1;
    private final Tag<Item> tagIngredient2;

    HammerMaterials(int harvestLevel, int durability, float efficiency, float attackDamage, float attackSpeed, int enchantability, Supplier<Ingredient> repairMaterial, String prefix, Tag<Item> ingredient1, Tag<Item> ingredient2) {
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyLoadBase<>(repairMaterial);
        this.prefix = prefix;
        this.tagIngredient1 = ingredient1;
        this.tagIngredient2 = ingredient2;
    }

    HammerMaterials(int harvestLevel, int durability, float efficiency, float attackDamage, float attackSpeed, int enchantability, Supplier<Ingredient> repairMaterial, String prefix, Tag<Item> ingredient1) {
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyLoadBase<>(repairMaterial);
        this.prefix = prefix;
        this.tagIngredient1 = ingredient1;
        this.tagIngredient2 = null;
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

    public String getPrefix() {
        return this.prefix;
    }

    public Tag<Item> getTagIngredient1() {
        return this.tagIngredient1;
    }

    public Tag<Item> getTagIngredient2() {
        return this.tagIngredient2;
    }

    public float getAttackSpeed() {
        return this.attackSpeed;
    }

}
