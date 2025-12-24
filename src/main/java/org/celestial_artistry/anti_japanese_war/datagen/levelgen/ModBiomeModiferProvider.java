package org.celestial_artistry.anti_japanese_war.datagen.levelgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import org.celestial_artistry.anti_japanese_war.init.ModEntities;
import org.celestial_artistry.anti_japanese_war.util.Helpers;

import java.util.List;

public class ModBiomeModiferProvider {

    public static final ResourceKey<BiomeModifier> ADD_JAPANESE_SOLIDER = register("add_japanese_solider");
    public static final ResourceKey<BiomeModifier> ADD_JAPANESE_KATANA_SOLIDER = register("add_japanese_katana_solider");
    public static final ResourceKey<BiomeModifier> ADD_KMT_SOLIDER = register("add_kmt_solider");
    public static final ResourceKey<BiomeModifier> ADD_CPC_SOLIDER = register("add_cpc_solider");

    public static void addBiomeModifiers(BootstapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        context.register(ADD_JAPANESE_SOLIDER, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.JAPANESE_SOLIDER.get(), 90, 6, 12))
        ));
        context.register(ADD_JAPANESE_KATANA_SOLIDER, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.JAPANESE_KATANA_SOLIDER.get(), 90, 2, 10))
        ));
        context.register(ADD_KMT_SOLIDER, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.KMT_SOLIDER.get(), 80, 4, 8))
        ));
        context.register(ADD_CPC_SOLIDER, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.CPC_SOLIDER.get(), 80, 5, 10))
        ));
    }

    private static ResourceKey<BiomeModifier> register(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, Helpers.identifier(name));
    }
}
