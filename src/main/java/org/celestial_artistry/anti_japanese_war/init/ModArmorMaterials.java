package org.celestial_artistry.anti_japanese_war.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import org.celestial_artistry.anti_japanese_war.AntiJapaneseWarMod;

public class ModArmorMaterials {

    public static final ArmorMaterial KMT_HELMET = new ArmorMaterial() {
        @Override
        public int getDurabilityForType(ArmorItem.Type p_266807_) {
            return 3;
        }

        @Override
        public int getDefenseForType(ArmorItem.Type p_267168_) {
            return 3;
        }

        @Override
        public int getEnchantmentValue() {
            return 15;
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ARMOR_EQUIP_LEATHER;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Tags.Items.LEATHER);
        }

        @Override
        public String getName() {
            return AntiJapaneseWarMod.MOD_ID + ":kmt_helmet";
        }

        @Override
        public float getToughness() {
            return 3;
        }

        @Override
        public float getKnockbackResistance() {
            return 3;
        }
    };

    public static final ArmorMaterial CPC_HELMET = new ArmorMaterial() {
        @Override
        public int getDurabilityForType(ArmorItem.Type p_266807_) {
            return 2;
        }

        @Override
        public int getDefenseForType(ArmorItem.Type p_267168_) {
            return 2;
        }

        @Override
        public int getEnchantmentValue() {
            return 12;
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ARMOR_EQUIP_LEATHER;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Tags.Items.LEATHER);
        }

        @Override
        public String getName() {
            return AntiJapaneseWarMod.MOD_ID + ":cpc_helmet";
        }

        @Override
        public float getToughness() {
            return 2;
        }

        @Override
        public float getKnockbackResistance() {
            return 2;
        }
    };
    public static final ArmorMaterial JAPANESE_HELMET = new ArmorMaterial() {
        @Override
        public int getDurabilityForType(ArmorItem.Type p_266807_) {
            return 4;
        }

        @Override
        public int getDefenseForType(ArmorItem.Type p_267168_) {
            return 4;
        }

        @Override
        public int getEnchantmentValue() {
            return 20;
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ARMOR_EQUIP_LEATHER;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Tags.Items.LEATHER);
        }

        @Override
        public String getName() {
            return AntiJapaneseWarMod.MOD_ID + ":japanese_helmet";
        }

        @Override
        public float getToughness() {
            return 4;
        }

        @Override
        public float getKnockbackResistance() {
            return 4;
        }
    };
}
