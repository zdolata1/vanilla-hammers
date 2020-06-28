package de.melanx.vanillahammers.items;

import de.melanx.morevanillalib.api.BigBreakItem;
import de.melanx.vanillahammers.VanillaHammers;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static de.melanx.morevanillalib.api.BigBreakMaterials.*;

public class HammerRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VanillaHammers.MODID);
    public static final String POSTFIX = "_hammer";

    public static final RegistryObject<Item> WOOD_HAMMER = ITEMS.register("wooden" + POSTFIX, () -> new BigBreakItem(WOOD, WOOD.getAttackSpeed()));
    public static final RegistryObject<Item> STONE_HAMMER = ITEMS.register("stone" + POSTFIX, () -> new BigBreakItem(STONE, STONE.getAttackSpeed()));
    public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register("iron" + POSTFIX, () -> new BigBreakItem(IRON, IRON.getAttackSpeed()));
    public static final RegistryObject<Item> GOLD_HAMMER = ITEMS.register("golden" + POSTFIX, () -> new BigBreakItem(GOLD, GOLD.getAttackSpeed()));
    public static final RegistryObject<Item> DIAMOND_HAMMER = ITEMS.register("diamond" + POSTFIX, () -> new BigBreakItem(DIAMOND, DIAMOND.getAttackSpeed()));
    public static final RegistryObject<Item> NETHERITE_HAMMER = ITEMS.register("netherite"+ POSTFIX, () -> new BigBreakItem(NETHERITE, NETHERITE.getAttackSpeed()));

    public static final RegistryObject<Item> BONE_HAMMER = ITEMS.register("bone" + POSTFIX, () -> new BigBreakItem(BONE, BONE.getAttackSpeed()));
    public static final RegistryObject<Item> COAL_HAMMER = ITEMS.register("coal" + POSTFIX, () -> new BigBreakItem(COAL, COAL.getAttackSpeed()));
    public static final RegistryObject<Item> EMERALD_HAMMER = ITEMS.register("emerald" + POSTFIX, () -> new BigBreakItem(EMERALD, EMERALD.getAttackSpeed()));
    public static final RegistryObject<Item> ENDER_HAMMER = ITEMS.register("ender" + POSTFIX, () -> new BigBreakItem(ENDER, ENDER.getAttackSpeed()));
    public static final RegistryObject<Item> FIERY_HAMMER = ITEMS.register("fiery" + POSTFIX, () -> new BigBreakItem(FIERY, FIERY.getAttackSpeed()));
    public static final RegistryObject<Item> GLOWSTONE_HAMMER = ITEMS.register("glowstone" + POSTFIX, () -> new BigBreakItem(GLOWSTONE, GLOWSTONE.getAttackSpeed()));
    public static final RegistryObject<Item> LAPIS_HAMMER = ITEMS.register("lapis" + POSTFIX, () -> new BigBreakItem(LAPIS, LAPIS.getAttackSpeed()));
    public static final RegistryObject<Item> NETHER_HAMMER = ITEMS.register("nether" + POSTFIX, () -> new BigBreakItem(NETHER, NETHER.getAttackSpeed()));
    public static final RegistryObject<Item> OBSIDIAN_HAMMER = ITEMS.register("obsidian" + POSTFIX, () -> new ObsidianHammer(OBSIDIAN, OBSIDIAN.getAttackSpeed()));
    public static final RegistryObject<Item> PAPER_HAMMER = ITEMS.register("paper" + POSTFIX, () -> new BigBreakItem(PAPER, PAPER.getAttackSpeed()));
    public static final RegistryObject<Item> PRISMARINE_HAMMER = ITEMS.register("prismarine" + POSTFIX, () -> new BigBreakItem(PRISMARINE, PRISMARINE.getAttackSpeed()));
    public static final RegistryObject<Item> QUARTZ_HAMMER = ITEMS.register("quartz" + POSTFIX, () -> new BigBreakItem(QUARTZ, QUARTZ.getAttackSpeed()));
    public static final RegistryObject<Item> REDSTONE_HAMMER = ITEMS.register("redstone" + POSTFIX, () -> new BigBreakItem(REDSTONE, REDSTONE.getAttackSpeed()));
    public static final RegistryObject<Item> SLIME_HAMMER = ITEMS.register("slime" + POSTFIX, () -> new BigBreakItem(SLIME, SLIME.getAttackSpeed()));

    public static void registerHammers() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
