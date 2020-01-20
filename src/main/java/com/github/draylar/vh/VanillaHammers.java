package com.github.draylar.vh;

import com.github.draylar.vh.common.HammerRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(VanillaHammers.MODID)
public class VanillaHammers {
    public static VanillaHammers instance;
    public static final String MODID = "vanillahammers";
    public static final int DURABILITY_MODIFIER = 5;
//	public static VanillaHammersConfig CONFIG = AutoConfig.register(VanillaHammersConfig.class, GsonConfigSerializer::new).getConfig();

    public VanillaHammers() {
        instance = this;

        HammerRegistry.registerHammers();
        MinecraftForge.EVENT_BUS.register(this);
    }
//		FurnaceFuelBurnTimeEvent.INSTANCE.add(HammerRegistry.WOOD, 400);
}