package de.melanx.vanillahammers.common;

import de.melanx.vanillahammers.VanillaHammers;
import de.melanx.vanillahammers.api.HammerItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static de.melanx.vanillahammers.common.HammerMaterials.*;

public class HammerRegistry {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, VanillaHammers.MODID);

    public static final RegistryObject<Item> WOODEN_HAMMER = register(WOOD);
    public static final RegistryObject<Item> STONE_HAMMER = register(STONE);
    public static final RegistryObject<Item> IRON_HAMMER = register(IRON);
    public static final RegistryObject<Item> GOLD_HAMMER = register(GOLD);
    public static final RegistryObject<Item> DIAMOND_HAMMER = register(DIAMOND);
    public static final RegistryObject<Item> EMERALD_HAMMER = register(EMERALD);
    public static final RegistryObject<Item> OBSIDIAN_HAMMER = register(OBSIDIAN);
    public static final RegistryObject<Item> QUARTZ_HAMMER = register(QUARTZ);
    public static final RegistryObject<Item> LAPIS_HAMMER = register(LAPIS);
    public static final RegistryObject<Item> FIERY_HAMMER = register(FIERY);
    public static final RegistryObject<Item> PRISMARINE_HAMMER = register(PRISMARINE);
    public static final RegistryObject<Item> ENDER_HAMMER = register(ENDER);
    public static final RegistryObject<Item> SLIME_HAMMER = register(SLIME);
    public static final RegistryObject<Item> GLOWSTONE_HAMMER = register(GLOWSTONE);
    public static final RegistryObject<Item> NETHER_HAMMER = register(NETHER);

    public static void registerHammers() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private static RegistryObject<Item> register(HammerMaterials type) {
        String name = type.getPrefix();
        int attackDamage = (int) type.getAttackDamage();
        float attackSpeed = type.getAttackSpeed();
        return ITEMS.register(name + "_hammer", () -> new HammerItem(type, attackDamage, attackSpeed));
    }
}
