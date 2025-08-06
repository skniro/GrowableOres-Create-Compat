package com.skniro.growable_ores_create_compat;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(GrowableOresCreateCompat.MODID)
public class GrowableOresCreateCompat {
    public static final String MODID = "growable_ores_create_compat";
    private static final Logger LOGGER = LogUtils.getLogger();


    public GrowableOresCreateCompat() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);
    }
}
