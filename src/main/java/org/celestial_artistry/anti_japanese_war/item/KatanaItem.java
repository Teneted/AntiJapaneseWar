package org.celestial_artistry.anti_japanese_war.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class KatanaItem extends SwordItem {

    public KatanaItem() {
        super(Tiers.IRON, 3, -2.4F, new Item.Properties().stacksTo(1));
    }
}
