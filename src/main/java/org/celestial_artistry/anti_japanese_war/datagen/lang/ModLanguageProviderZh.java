package org.celestial_artistry.anti_japanese_war.datagen.lang;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import org.celestial_artistry.anti_japanese_war.AntiJapaneseWarMod;
import org.celestial_artistry.anti_japanese_war.init.ModEntities;
import org.celestial_artistry.anti_japanese_war.init.ModItems;

public class ModLanguageProviderZh extends LanguageProvider {

    public ModLanguageProviderZh(PackOutput output) {
        super(output, AntiJapaneseWarMod.MOD_ID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.antiJapaneseWar", "抗日战争");
        add(ModItems.KMT_RIFLE.get(), "中正式步枪");
        add(ModItems.CPC_RIFLE.get(), "三八式步枪");
        add(ModItems.ASSEMBLY_ORDER.get(), "军事集结令");
        add(ModItems.FRIDE_HIGHLAND_BARLEY.get(), "炒青稞");
        add(ModItems.GRASS_ROOTS.get(), "草根");
        add(ModItems.HIGHLAND_BARLEY_STEW.get(), "青稞煲");
        add(ModItems.HIGHLAND_BARLEY.get(), "青稞");
        add(ModItems.HIGHLAND_BARLEY_ALCOHOL.get(), "青稞酒");
        add(ModItems.HIGHLAND_BARLEY_FLOUR.get(), "青稞面");
        add(ModItems.HIGHLAND_BARLEY_SEEDS.get(), "青稞种子");
        add(ModItems.KATANA.get(), "太刀");
        add(ModItems.GRENADE.get(), "手榴弹");
        add(ModItems.MACHINE_GUN.get(), "机关枪");
        add(ModItems.MACHINE_GUN_BULLET.get(), "机关枪子弹");
        add(ModItems.MEDKIT.get(), "医疗包");
        add(ModItems.MUSKET_BALL.get(), "火药弹");
        add(ModItems.SUCIDIDE_DYNAMITE.get(), "自杀式炸弹");
        add(ModItems.JAPANESE_SOLIDER_HELMET.get(), "日本士兵头盔");
        add(ModItems.CPC_SOLIDER_HELMET.get(), "共军士兵头盔");
        add(ModItems.KMT_SOLIDER_HELMET.get(), "国军士兵头盔");
        add(ModEntities.MUSKET_BALL.get(), "火药弹");
        add(ModEntities.JAPANESE_SOLIDER.get(), "日军士兵");
        add(ModEntities.JAPANESE_KATANA_SOLIDER.get(), "日军太刀武士");
        add(ModEntities.KMT_SOLIDER.get(), "国军士兵");
        add(ModEntities.CPC_SOLIDER.get(), "共军士兵");
        add(ModItems.JAPANESE_SOLIDER_SPAWN_EGG.get(), "日军士兵生成蛋");
        add(ModItems.JAPANESE_KATANA_SOLIDER_SPAWN_EGG.get(), "日军太刀武士生成蛋");
        add(ModItems.KMT_SOLIDER_SPAWN_EGG.get(), "国军士兵生成蛋");
        add(ModItems.CPC_SOLIDER_SPAWN_EGG.get(), "共军士兵生成蛋");
    }
}
