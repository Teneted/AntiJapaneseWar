package org.celestial_artistry.anti_japanese_war.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.UseAnim;

public class HighlandBarleyAlcoholItem extends PotionItem {

    public HighlandBarleyAlcoholItem() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.DRINK;
    }

    @Override
    public String getDescriptionId(ItemStack p_43003_) {
        return this.getOrCreateDescriptionId();
    }
}
