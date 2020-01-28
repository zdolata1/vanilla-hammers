package de.melanx.vanillahammers.common;

import de.melanx.vanillahammers.VanillaHammers;
import de.melanx.vanillahammers.api.HammerItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class HammerRegistry {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, VanillaHammers.MODID);

    public static void registerHammers() {
        for (HammerMaterials type : HammerMaterials.values()) {
            String name = type.getPrefix();
            float attackSpeed = type.getAttackSpeed();
            ITEMS.register(name + "_hammer", () -> new HammerItem(type, 0, attackSpeed));
        }
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
