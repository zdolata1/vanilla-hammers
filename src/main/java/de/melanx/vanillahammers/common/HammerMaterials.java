package de.melanx.vanillahammers.common;

import de.melanx.vanillahammers.VanillaHammers;
import net.minecraft.block.Blocks;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.LazyLoadBase;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public enum HammerMaterials implements IItemTier {
    WOOD(0, 59 * VanillaHammers.DURABILITY_MODIFIER, 2.0F / 3.5f, 3, -2.5F, 15, () -> {
        return Ingredient.fromTag(ItemTags.PLANKS);
    }, "wooden", BlockTags.PLANKS, BlockTags.LOGS),
    STONE(1, 131 * VanillaHammers.DURABILITY_MODIFIER, 4.0F / 3.5f, 4, -2.6F, 5, () -> {
        return Ingredient.fromItems(Blocks.COBBLESTONE);
    }, "stone", Tags.Blocks.COBBLESTONE, Tags.Blocks.STONE),
    IRON(2, 250 * VanillaHammers.DURABILITY_MODIFIER, 6.0F / 3.5f, 5, -2.8F, 14, () -> {
        return Ingredient.fromItems(Items.IRON_INGOT);
    }, "iron", Tags.Items.INGOTS_IRON, Tags.Blocks.STORAGE_BLOCKS_IRON),
    GOLD(0, 32 * VanillaHammers.DURABILITY_MODIFIER, 12.0F / 3.5f, 5, -2.5F, 22, () -> {
        return Ingredient.fromItems(Items.GOLD_INGOT);
    }, "golden", Tags.Items.INGOTS_GOLD, Tags.Blocks.STORAGE_BLOCKS_GOLD),
    DIAMOND(3, 1561 * VanillaHammers.DURABILITY_MODIFIER, 8.0F / 3.5f, 10, -3.0F, 10, () -> {
        return Ingredient.fromItems(Items.DIAMOND);
    }, "diamond", Tags.Items.GEMS_DIAMOND, Tags.Blocks.STORAGE_BLOCKS_DIAMOND),
    EMERALD(3, 1028 * VanillaHammers.DURABILITY_MODIFIER, 12.0F / 3.5f, 11, -3.0F, 25, () -> {
        return Ingredient.fromItems(Items.EMERALD);
    }, "emerald", Tags.Items.GEMS_EMERALD, Tags.Blocks.STORAGE_BLOCKS_EMERALD),
    OBSIDIAN(2, 2048 * VanillaHammers.DURABILITY_MODIFIER, 5.0F / 3.5f, 7, -3.5F, 5, () -> {
        return Ingredient.fromItems(Items.OBSIDIAN);
    }, "obsidian", Tags.Blocks.OBSIDIAN),
    QUARTZ(2, 1028 * VanillaHammers.DURABILITY_MODIFIER, 8.0F / 3.5f, 5, -2.0F, 10, () -> {
        return Ingredient.fromItems(Items.QUARTZ);
    }, "quartz", Tags.Items.GEMS_QUARTZ, Tags.Blocks.STORAGE_BLOCKS_QUARTZ),
    LAPIS(1, 220 * VanillaHammers.DURABILITY_MODIFIER, 6.0f / 3.5f, 3, -2.5F, 30, () -> {
        return Ingredient.fromItems(Items.LAPIS_LAZULI);
    }, "lapis", Tags.Items.GEMS_LAPIS, Tags.Blocks.STORAGE_BLOCKS_LAPIS),
    FIERY(3, 750 * VanillaHammers.DURABILITY_MODIFIER, 7.0F / 3.5f, 6, -2.3F, 15, () -> {
        return Ingredient.fromItems(Items.MAGMA_BLOCK);
    }, "fiery", Items.MAGMA_CREAM, Blocks.MAGMA_BLOCK),
    PRISMARINE(3, 750 * VanillaHammers.DURABILITY_MODIFIER, 7.0F / 3.5F, 6, -2.3F, 20, () -> {
        return Ingredient.fromItems(Items.PRISMARINE_SHARD);
    }, "prismarine", Tags.Items.DUSTS_PRISMARINE, Blocks.PRISMARINE),
    ENDER(3, 1561 * VanillaHammers.DURABILITY_MODIFIER, 10f / 3.5f, 10, -3.3F, 10, () -> {
        return Ingredient.fromItems(Items.ENDER_PEARL);
    }, "ender", Items.DRAGON_HEAD, Tags.Blocks.END_STONES),
    SLIME(2, 1500 * VanillaHammers.DURABILITY_MODIFIER, 6f / 3.5f, 7, -3.0F, 20, () -> {
        return Ingredient.fromItems(Items.SLIME_BALL);
    }, "slime", Tags.Items.SLIMEBALLS, Blocks.SLIME_BLOCK),
    GLOWSTONE(2, 189 * VanillaHammers.DURABILITY_MODIFIER, 5.0F / 3.5f, 5, -2.3F, 15, () -> {
        return Ingredient.fromItems(Items.GLOWSTONE);
    }, "glowstone", Tags.Items.DUSTS_GLOWSTONE, Blocks.GLOWSTONE),
    NETHER(1, 280 * VanillaHammers.DURABILITY_MODIFIER, 5.0F / 3.5f, 4, -2.1F, 77, () -> {
        return Ingredient.fromItems(Items.NETHER_BRICKS);
    }, "nether", Tags.Blocks.NETHERRACK, Blocks.NETHER_BRICKS);

    private final int harvestLevel;
    private final int durability;
    private final float efficiency;
    private final float attackDamage;
    private final float attackSpeed;
    private final int enchantability;
    private final LazyLoadBase<Ingredient> repairMaterial;
    private final String prefix;
    private final Tag<?> tagIngredient1;
    private final Tag<?> tagIngredient2;
    private final IItemProvider itemIngredient1;
    private final IItemProvider itemIngredient2;

    HammerMaterials(int harvestLevel, int durability, float efficiency, float attackDamage, float attackSpeed, int enchantability, Supplier<Ingredient> repairMaterial, String prefix, Tag<?> ingredient1, Tag<?> ingredient2) {
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyLoadBase<>(repairMaterial);
        this.prefix = prefix;
        this.itemIngredient1 = null;
        this.itemIngredient2 = null;
        this.tagIngredient1 = ingredient1;
        this.tagIngredient2 = ingredient2;
    }

    HammerMaterials(int harvestLevel, int durability, float efficiency, float attackDamage, float attackSpeed, int enchantability, Supplier<Ingredient> repairMaterial, String prefix, IItemProvider ingredient1, Tag<?> ingredient2) {
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyLoadBase<>(repairMaterial);
        this.prefix = prefix;
        this.itemIngredient1 = ingredient1;
        this.itemIngredient2 = null;
        this.tagIngredient1 = null;
        this.tagIngredient2 = ingredient2;
    }

    HammerMaterials(int harvestLevel, int durability, float efficiency, float attackDamage, float attackSpeed, int enchantability, Supplier<Ingredient> repairMaterial, String prefix, Tag<?> ingredient1, IItemProvider ingredient2) {
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyLoadBase<>(repairMaterial);
        this.prefix = prefix;
        this.itemIngredient1 = null;
        this.itemIngredient2 = ingredient2;
        this.tagIngredient1 = ingredient1;
        this.tagIngredient2 = null;
    }

    HammerMaterials(int harvestLevel, int durability, float efficiency, float attackDamage, float attackSpeed, int enchantability, Supplier<Ingredient> repairMaterial, String prefix, IItemProvider ingredient1, IItemProvider ingredient2) {
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyLoadBase<>(repairMaterial);
        this.prefix = prefix;
        this.itemIngredient1 = ingredient1;
        this.itemIngredient2 = ingredient2;
        this.tagIngredient1 = null;
        this.tagIngredient2 = null;
    }

    HammerMaterials(int harvestLevel, int durability, float efficiency, float attackDamage, float attackSpeed, int enchantability, Supplier<Ingredient> repairMaterial, String prefix, IItemProvider ingredient1) {
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyLoadBase<>(repairMaterial);
        this.prefix = prefix;
        this.itemIngredient1 = ingredient1;
        this.itemIngredient2 = null;
        this.tagIngredient1 = null;
        this.tagIngredient2 = null;
    }

    HammerMaterials(int harvestLevel, int durability, float efficiency, float attackDamage, float attackSpeed, int enchantability, Supplier<Ingredient> repairMaterial, String prefix, Tag<?> ingredient1) {
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyLoadBase<>(repairMaterial);
        this.prefix = prefix;
        this.itemIngredient1 = null;
        this.itemIngredient2 = null;
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

    public IItemProvider getItemIngredient1() {
        return this.itemIngredient1;
    }

    public IItemProvider getItemIngredient2() {
        return this.itemIngredient2;
    }

    public Tag<?> getTagIngredient1() {
        return this.tagIngredient1;
    }

    public Tag<?> getTagIngredient2() {
        return this.tagIngredient2;
    }

    public float getAttackSpeed() {
        return this.attackSpeed;
    }

}
