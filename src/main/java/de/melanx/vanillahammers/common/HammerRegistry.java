package de.melanx.vanillahammers.common;

import de.melanx.vanillahammers.VanillaHammers;
import de.melanx.vanillahammers.api.HammerItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static de.melanx.morevanillalib.api.BigBreakMaterials.*;

public class HammerRegistry {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, VanillaHammers.MODID);
    public static final String POSTFIX = "_hammer";

    public static final RegistryObject<Item> BONE_HAMMER = ITEMS.register("bone" + POSTFIX, () -> new HammerItem(BONE, BONE.getAttackSpeed()));
    public static final RegistryObject<Item> COAL_HAMMER = ITEMS.register("coal" + POSTFIX, () -> new HammerItem(COAL, COAL.getAttackSpeed()));
    public static final RegistryObject<Item> EMERALD_HAMMER = ITEMS.register("emderald" + POSTFIX, () -> new HammerItem(EMERALD, EMERALD.getAttackSpeed()));
    public static final RegistryObject<Item> ENDER_HAMMER = ITEMS.register("ender" + POSTFIX, () -> new HammerItem(ENDER, ENDER.getAttackSpeed()));
    public static final RegistryObject<Item> FIERY_HAMMER = ITEMS.register("fiery" + POSTFIX, () -> new HammerItem(FIERY, FIERY.getAttackSpeed()));
    public static final RegistryObject<Item> GLOWSTONE_HAMMER = ITEMS.register("glowstone" + POSTFIX, () -> new HammerItem(GLOWSTONE, GLOWSTONE.getAttackSpeed()));
    public static final RegistryObject<Item> LAPIS_HAMMER = ITEMS.register("lapis" + POSTFIX, () -> new HammerItem(LAPIS, LAPIS.getAttackSpeed()));
    public static final RegistryObject<Item> NETHER_HAMMER = ITEMS.register("nether" + POSTFIX, () -> new HammerItem(NETHER, NETHER.getAttackSpeed()));
    public static final RegistryObject<Item> OBSIDIAN_HAMMER = ITEMS.register("obsidian" + POSTFIX, () -> new HammerItem(OBSIDIAN, OBSIDIAN.getAttackSpeed()));
    public static final RegistryObject<Item> PAPER_HAMMER = ITEMS.register("paper" + POSTFIX, () -> new HammerItem(PAPER, PAPER.getAttackSpeed()));
    public static final RegistryObject<Item> PRISMARINE_HAMMER = ITEMS.register("prismarine" + POSTFIX, () -> new HammerItem(PRISMARINE, PRISMARINE.getAttackSpeed()));
    public static final RegistryObject<Item> QUARTZ_HAMMER = ITEMS.register("quartz" + POSTFIX, () -> new HammerItem(QUARTZ, QUARTZ.getAttackSpeed()));
    public static final RegistryObject<Item> REDSTONE_HAMMER = ITEMS.register("redstone" + POSTFIX, () -> new HammerItem(REDSTONE, REDSTONE.getAttackSpeed()));
    public static final RegistryObject<Item> SLIME_HAMMER = ITEMS.register("slime" + POSTFIX, () -> new HammerItem(SLIME, SLIME.getAttackSpeed()));

    public static void registerHammers() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
