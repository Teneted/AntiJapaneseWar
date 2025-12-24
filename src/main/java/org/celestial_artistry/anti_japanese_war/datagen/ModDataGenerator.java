package org.celestial_artistry.anti_japanese_war.datagen;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.celestial_artistry.anti_japanese_war.AntiJapaneseWarMod;
import org.celestial_artistry.anti_japanese_war.datagen.lang.ModLanguageProviderEn;
import org.celestial_artistry.anti_japanese_war.datagen.lang.ModLanguageProviderZh;
import org.celestial_artistry.anti_japanese_war.datagen.levelgen.ModBiomeModiferProvider;

import java.util.Set;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = AntiJapaneseWarMod.MOD_ID)
public class ModDataGenerator {


    public static RegistrySetBuilder BUILDER =
            new RegistrySetBuilder()
                    .add(ForgeRegistries.Keys.BIOME_MODIFIERS,
                            ModBiomeModiferProvider::addBiomeModifiers);

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        var gen = event.getGenerator();
        var helper = event.getExistingFileHelper();
        var pack = gen.getPackOutput();
        var lookup = event.getLookupProvider();
        gen.addProvider(event.includeClient(), new ModItemModelProvider(pack, helper));
        gen.addProvider(event.includeClient(), new ModLanguageProviderEn(pack));
        gen.addProvider(event.includeClient(), new ModLanguageProviderZh(pack));
        gen.addProvider(event.includeClient(), new DatapackBuiltinEntriesProvider(pack,
                lookup, BUILDER,
                Set.of(AntiJapaneseWarMod.MOD_ID)));
    }
}
