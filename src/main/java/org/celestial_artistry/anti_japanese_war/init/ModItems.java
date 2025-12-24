package org.celestial_artistry.anti_japanese_war.init;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.celestial_artistry.anti_japanese_war.AntiJapaneseWarMod;
import org.celestial_artistry.anti_japanese_war.item.GrenadeItem;
import org.celestial_artistry.anti_japanese_war.item.GunItem;
import org.celestial_artistry.anti_japanese_war.item.HighlandBarleyAlcoholItem;
import org.celestial_artistry.anti_japanese_war.item.KatanaItem;
import org.celestial_artistry.anti_japanese_war.item.MachineGunItem;
import org.celestial_artistry.anti_japanese_war.item.MedkitItem;
import org.celestial_artistry.anti_japanese_war.item.MusketBallItem;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AntiJapaneseWarMod.MOD_ID);

    // Misc
    public static final RegistryObject<Item> ASSEMBLY_ORDER =
            registerItem("assembly_order");
    public static final RegistryObject<Item> FRIDE_HIGHLAND_BARLEY =
            registerItem("fried_hignland_barley");
    public static final RegistryObject<Item> GRASS_ROOTS =
            registerItem("grass_roots");
    public static final RegistryObject<Item> HIGHLAND_BARLEY_STEW =
            registerItem("highland_barley_stew");
    public static final RegistryObject<Item> HIGHLAND_BARLEY =
            registerItem("highland_barley");
    public static final RegistryObject<Item> HIGHLAND_BARLEY_ALCOHOL =
            ITEMS.register("highland_barley_alcohol", HighlandBarleyAlcoholItem::new);
    public static final RegistryObject<Item> HIGHLAND_BARLEY_FLOUR =
            registerItem("highland_barley_flour");
    public static final RegistryObject<Item> HIGHLAND_BARLEY_SEEDS =
            registerItem("highland_barley_seeds");
    public static final RegistryObject<Item> MEDKIT =
            ITEMS.register("medkit", MedkitItem::new);
    public static final RegistryObject<Item> SUCIDIDE_DYNAMITE =
            registerItem("suicide_dynamite");

    // Weapons and Guns, Bullets
    public static final RegistryObject<Item> KATANA =
            ITEMS.register("katana", KatanaItem::new);
    public static final RegistryObject<Item> KMT_RIFLE =
            ITEMS.register("kmt_rifle", GunItem::new);
    public static final RegistryObject<Item> CPC_RIFLE =
            ITEMS.register("cpc_rifle", GunItem::new);
    public static final RegistryObject<Item> MACHINE_GUN =
            ITEMS.register("machine_gun", MachineGunItem::new);
    public static final RegistryObject<Item> MACHINE_GUN_BULLET =
            registerItem("machine_gun_bullet");
    public static final RegistryObject<Item> MUSKET_BALL =
            ITEMS.register("musket_ball", MusketBallItem::new);
    public static final RegistryObject<Item> GRENADE =
            ITEMS.register("grenade", GrenadeItem::new);

    // Helmets
    public static final RegistryObject<Item> JAPANESE_SOLIDER_HELMET =
            registerHelmet( "japanese_solider_helmet", ModArmorMaterials.JAPANESE_HELMET);
    public static final RegistryObject<Item> CPC_SOLIDER_HELMET =
            registerHelmet("cpc_solider_helmet", ModArmorMaterials.CPC_HELMET);
    public static final RegistryObject<Item> KMT_SOLIDER_HELMET =
            registerHelmet("kmt_solider_helmet", ModArmorMaterials.KMT_HELMET);

    // Spawn Eggs
    public static final RegistryObject<Item> JAPANESE_SOLIDER_SPAWN_EGG =
            ITEMS.register("japanese_solider_spawn_egg",
                    () -> new ForgeSpawnEggItem(ModEntities.JAPANESE_SOLIDER,
                    12623485, 15656192, new Item.Properties()));
    public static final RegistryObject<Item> JAPANESE_KATANA_SOLIDER_SPAWN_EGG =
            ITEMS.register("japanese_katana_solider_spawn_egg",
                    () -> new ForgeSpawnEggItem(ModEntities.JAPANESE_KATANA_SOLIDER,
                            12623485, 15656192, new Item.Properties()));
    public static final RegistryObject<Item> KMT_SOLIDER_SPAWN_EGG =
            ITEMS.register("kmt_solider_spawn_egg",
                    () -> new ForgeSpawnEggItem(ModEntities.KMT_SOLIDER,
                            2243405, 7375001, new Item.Properties()));
    public static final RegistryObject<Item> CPC_SOLIDER_SPAWN_EGG =
            ITEMS.register("cpc_solider_spawn_egg",
                    () -> new ForgeSpawnEggItem(ModEntities.CPC_SOLIDER,
                            15198183, 44975, new Item.Properties()));

    private static RegistryObject<Item> registerHelmet(String name, ArmorMaterial material) {
        return ITEMS.register(name, () -> new ArmorItem(material, ArmorItem.Type.HELMET, new Item.Properties()));
    }

    private static RegistryObject<Item> registerItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }
}
