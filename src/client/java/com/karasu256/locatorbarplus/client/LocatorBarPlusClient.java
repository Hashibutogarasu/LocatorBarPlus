package com.karasu256.locatorbarplus.client;

import com.karasu256.locatorbarplus.config.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;

public class LocatorBarPlusClient implements ClientModInitializer {
    public static final String MOD_ID = "locatorbarplus";

    @Override
    public void onInitializeClient() {
        AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
    }
}
