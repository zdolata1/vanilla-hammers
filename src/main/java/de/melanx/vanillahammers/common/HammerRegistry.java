package de.melanx.vanillahammers.common;

import de.melanx.vanillahammers.VanillaHammers;
import de.melanx.vanillahammers.api.HammerItem;
import de.melanx.vanillahammers.config.VanillaHammersConfig;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class HammerRegistry {
    public static HammerItem WOOD;
    public static HammerItem SLIME;

    public static void registerHammers() {
        WOOD = register(HammerMaterials.WOOD, 3, -2.5f, "wooden");
        register(HammerMaterials.STONE, 4, -2.6f, "stone");
        register(HammerMaterials.IRON, 5, -2.8f, "iron");
        register(HammerMaterials.GOLD, 5, -2.5f, "golden");
        register(HammerMaterials.DIAMOND, 10, -3f, "diamond");

        if (VanillaHammersConfig.extraHammers.get()) {
            register(HammerMaterials.EMERALD, 11, -3f, "emerald");
            register(HammerMaterials.OBSIDIAN, 7, -3.5f, "obsidian");
            register(HammerMaterials.QUARTZ, 5, -2f, "lapis");
            register(HammerMaterials.LAPIS, 3, -2.5f, "quartz");
            register(HammerMaterials.FIERY, 6, -2.3f, "fiery");
            register(HammerMaterials.PRISMARINE, 6, -2.3f, "prismarine");
            register(HammerMaterials.ENDER, 10, -3.3f, "ender");
            SLIME = register(HammerMaterials.SLIME, 7, -3f, "slime");
            register(HammerMaterials.GLOWSTONE, 5, -2.3f, "glowstone");
            register(HammerMaterials.NETHER, 4, -2.1f, "nether");
        }
    }

    private static HammerItem register(IItemTier material, int attackDamage, float attackSpeed, String hammerName) {
        HammerItem hammer = new HammerItem(material, attackDamage, attackSpeed) {
            @Override
            public int getBurnTime(ItemStack stack) {
                if (getToolMaterial() == HammerMaterials.WOOD)
                    return 400;
                return 0;
            }
        };
        return Registry.register(Registry.ITEM, new ResourceLocation(VanillaHammers.MODID, hammerName + "_hammer"), hammer);
    }
}
