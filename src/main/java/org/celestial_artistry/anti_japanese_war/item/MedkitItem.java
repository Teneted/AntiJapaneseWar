package org.celestial_artistry.anti_japanese_war.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MedkitItem extends Item {

    public MedkitItem() {
        super(new Properties().durability(4));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        boolean flag = player.getAbilities().instabuild;
        if (player.getHealth() < player.getMaxHealth() && !flag) {
            player.setHealth(player.getMaxHealth());
        }else {
            return InteractionResultHolder.fail(player.getItemInHand(hand));
        }
        ItemStack itemstack = player.getItemInHand(hand);
        if (!flag) {
            itemstack.hurtAndBreak(1, player, (p_41300_) -> {
                p_41300_.broadcastBreakEvent(hand);
            });
        }
        return super.use(level, player, hand);
    }
}
