package org.celestial_artistry.anti_japanese_war.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.celestial_artistry.anti_japanese_war.AntiJapaneseWarMod;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AntiJapaneseWarMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ANTI_JAPANESE_WAR_TAB =
            CREATIVE_MODE_TABS.register("anti_japanese_war_tab", () -> CreativeModeTab.builder().withTabsBefore(CreativeModeTabs.COMBAT)
                    .title(Component.translatable("itemGroup.antiJapaneseWar"))
            .icon(() -> ModItems.KMT_RIFLE.get()
                    .getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        ModItems.ITEMS.getEntries().forEach(item ->
                                output.accept(item.get()));
                    }).build());
}
