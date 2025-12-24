package org.celestial_artistry.anti_japanese_war.datagen.lang;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.common.data.LanguageProvider;
import org.celestial_artistry.anti_japanese_war.AntiJapaneseWarMod;
import org.celestial_artistry.anti_japanese_war.init.ModEntities;
import org.celestial_artistry.anti_japanese_war.init.ModItems;
import org.celestial_artistry.anti_japanese_war.util.Helpers;

public class ModLanguageProviderEn extends LanguageProvider {

    public ModLanguageProviderEn(PackOutput output) {
        super(output, AntiJapaneseWarMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.antiJapaneseWar", "Anti Japanese War");
        ModItems.ITEMS.getEntries().forEach(item -> {
            if (!(item.get() instanceof BlockItem)) {
                add(item.get(),
                        formatFieldName(Helpers.getItemName(item.get())));
            }
        });
        ModEntities.ENTITIES.getEntries().forEach(entity -> {
            add(entity.get(),
                    formatFieldName(Helpers.getEntityName(entity.get())));
        });
    }

    private static String formatFieldName(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        boolean nextUpper = true;

        for (char c : input.toCharArray()) {
            if (c == '_') {
                result.append(' ');
                nextUpper = true;
            } else {
                if (nextUpper) {
                    result.append(Character.toUpperCase(c));
                    nextUpper = false;
                } else {
                    result.append(Character.toLowerCase(c));
                }
            }
        }

        return result.toString();
    }
}
