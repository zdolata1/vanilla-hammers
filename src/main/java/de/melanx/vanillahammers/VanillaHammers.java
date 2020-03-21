package de.melanx.vanillahammers;

import de.melanx.vanillahammers.common.HammerRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(VanillaHammers.MODID)
public class VanillaHammers {
    public static final String MODID = "vanillahammers";
    public static VanillaHammers instance;

    public VanillaHammers() {
        instance = this;
        HammerRegistry.registerHammers();
        MinecraftForge.EVENT_BUS.register(this);
    }
}