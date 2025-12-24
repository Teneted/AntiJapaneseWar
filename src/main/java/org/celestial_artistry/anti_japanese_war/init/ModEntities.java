package org.celestial_artistry.anti_japanese_war.init;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.celestial_artistry.anti_japanese_war.AntiJapaneseWarMod;
import org.celestial_artistry.anti_japanese_war.entity.CpcSolider;
import org.celestial_artistry.anti_japanese_war.entity.JapaneseKatanaSolider;
import org.celestial_artistry.anti_japanese_war.entity.JapaneseSolider;
import org.celestial_artistry.anti_japanese_war.entity.KmtSolider;
import org.celestial_artistry.anti_japanese_war.entity.MusketBall;

import java.util.Locale;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AntiJapaneseWarMod.MOD_ID);

    public static final RegistryObject<EntityType<MusketBall>> MUSKET_BALL =
            register("musket_ball",
                    EntityType.Builder.<MusketBall>of(MusketBall::new, MobCategory.MISC)
                            .sized(0.5F, 0.5F)
                            .clientTrackingRange(4)
                            .updateInterval(20));
    public static final RegistryObject<EntityType<JapaneseSolider>> JAPANESE_SOLIDER =
            register("japanese_solider",
                    EntityType.Builder.<JapaneseSolider>of(JapaneseSolider::new, MobCategory.CREATURE)
                            .sized(0.6F, 1.8F)
                            .clientTrackingRange(32)
                            .updateInterval(2));
    public static final RegistryObject<EntityType<JapaneseKatanaSolider>> JAPANESE_KATANA_SOLIDER =
            register("japanese_katana_solider",
                    EntityType.Builder.<JapaneseKatanaSolider>of(JapaneseKatanaSolider::new, MobCategory.CREATURE)
                            .sized(0.6F, 1.8F)
                            .clientTrackingRange(32)
                            .updateInterval(2));
    public static final RegistryObject<EntityType<KmtSolider>> KMT_SOLIDER =
            register("kmt_solider",
                    EntityType.Builder.<KmtSolider>of(KmtSolider::new, MobCategory.CREATURE)
                            .sized(0.6F, 1.8F)
                            .clientTrackingRange(32)
                            .updateInterval(2));
    public static final RegistryObject<EntityType<CpcSolider>> CPC_SOLIDER =
            register("cpc_solider",
                    EntityType.Builder.<CpcSolider>of(CpcSolider::new, MobCategory.CREATURE)
                            .sized(0.6F, 1.8F)
                            .clientTrackingRange(32)
                            .updateInterval(2));

    public static <E extends Entity> RegistryObject<EntityType<E>> register(String name, EntityType.Builder<E> builder) {
        return register(name, builder, true);
    }

    public static <E extends Entity> RegistryObject<EntityType<E>> register(String name, EntityType.Builder<E> builder, boolean serialize) {
        final String id = name.toLowerCase(Locale.ROOT);
        return ENTITIES.register(id, () -> {
            if (!serialize) builder.noSave();
            return builder.build(AntiJapaneseWarMod.MOD_ID + ":" + id);
        });
    }
}
