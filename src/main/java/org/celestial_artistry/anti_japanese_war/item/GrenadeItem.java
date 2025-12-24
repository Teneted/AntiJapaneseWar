package org.celestial_artistry.anti_japanese_war.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.item.EggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.celestial_artistry.anti_japanese_war.init.ModEntities;

public class GrenadeItem extends Item {

    public GrenadeItem() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!level.isClientSide) {
            LargeFireball largeFireball = new LargeFireball(EntityType.FIREBALL, level);
            largeFireball.setItem(itemstack);
            largeFireball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(largeFireball);
        }

        if (!player.isCreative()) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.success(itemstack);
    }
}
