package de.melanx.vanillahammers;

import de.melanx.vanillahammers.common.HammerRegistry;
import de.melanx.vanillahammers.config.VanillaHammersConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(VanillaHammers.MODID)
public class VanillaHammers {
    public static final String MODID = "vanillahammers";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static VanillaHammers instance;

    public VanillaHammers() {
        instance = this;
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, VanillaHammersConfig.SERVER_CONFIG);
        VanillaHammersConfig.loadConfig(VanillaHammersConfig.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + "-server.toml"));
        HammerRegistry.registerHammers();
        MinecraftForge.EVENT_BUS.register(this);
    }
}