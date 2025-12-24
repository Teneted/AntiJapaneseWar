package org.celestial_artistry.anti_japanese_war.util;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import org.celestial_artistry.anti_japanese_war.AntiJapaneseWarMod;

public class Helpers {

    public static ResourceLocation identifier(String name) {
        return ResourceLocation.fromNamespaceAndPath(AntiJapaneseWarMod.MOD_ID, name);
    }

    public static String getEntityName(EntityType<?> entity) {
        return ForgeRegistries.ENTITY_TYPES.getKey(entity).getPath();
    }

    public static String getItemName(ItemLike itemLike) {
        return ForgeRegistries.ITEMS.getKey(itemLike.asItem()).getPath();
    }

    public static boolean checkSpawnRules(EntityType<?> p_218105_, LevelAccessor p_218106_, MobSpawnType p_218107_, BlockPos p_218108_, RandomSource p_218109_) {
        return p_218106_.getBlockState(p_218108_.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && isBrightEnoughToSpawn(p_218106_, p_218108_);
    }

    protected static boolean isBrightEnoughToSpawn(BlockAndTintGetter p_186210_, BlockPos p_186211_) {
        return p_186210_.getRawBrightness(p_186211_, 0) > 8;
    }
}
