package org.celestial_artistry.anti_japanese_war;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.celestial_artistry.anti_japanese_war.init.ModCreativeModeTabs;
import org.celestial_artistry.anti_japanese_war.init.ModEntities;
import org.celestial_artistry.anti_japanese_war.init.ModItems;
import org.slf4j.Logger;

@SuppressWarnings("removal")
@Mod(AntiJapaneseWarMod.MOD_ID)
public class AntiJapaneseWarMod {

    public static final String MOD_ID = "anti_japanese_war";
    public static final Logger LOGGER = LogUtils.getLogger();

    public AntiJapaneseWarMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(modEventBus);
        ModEntities.ENTITIES.register(modEventBus);
        ModCreativeModeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
