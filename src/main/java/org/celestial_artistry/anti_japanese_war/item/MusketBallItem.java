package org.celestial_artistry.anti_japanese_war.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.celestial_artistry.anti_japanese_war.entity.MusketBall;

public class MusketBallItem extends Item {

    public MusketBallItem() {
        super(new Properties());
    }

    public MusketBall createMusketBall(Level p_40513_, ItemStack p_40514_, LivingEntity p_40515_) {
        MusketBall musketBall = new MusketBall(p_40513_, p_40515_, 2);
        return musketBall;
    }

    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == MusketBallItem.class;
    }
}
