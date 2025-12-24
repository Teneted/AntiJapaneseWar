package org.celestial_artistry.anti_japanese_war.client.renderer;

import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.ArrowLayer;
import net.minecraft.client.renderer.entity.layers.BeeStingerLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.layers.SpinAttackEffectLayer;
import net.minecraft.resources.ResourceLocation;
import org.celestial_artistry.anti_japanese_war.AntiJapaneseWarMod;
import org.celestial_artistry.anti_japanese_war.entity.KmtSolider;

public class KmtSoliderRenderer extends LivingEntityRenderer<KmtSolider, PlayerModel<KmtSolider>> {

    private static final ResourceLocation TEXTURE_LOCATION =
            ResourceLocation.fromNamespaceAndPath(AntiJapaneseWarMod.MOD_ID,
                    "textures/entity/kmt_solider.png");

    public KmtSoliderRenderer(EntityRendererProvider.Context p_174557_) {
        super(p_174557_, new PlayerModel<>(p_174557_.bakeLayer(ModelLayers.PLAYER), true), 0.5F);
        this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidArmorModel(p_174557_.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidArmorModel(p_174557_.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), p_174557_.getModelManager()));
        this.addLayer(new ArrowLayer<>(p_174557_, this));
        this.addLayer(new ElytraLayer<>(this, p_174557_.getModelSet()));
        this.addLayer(new SpinAttackEffectLayer<>(this, p_174557_.getModelSet()));
        this.addLayer(new BeeStingerLayer<>(this));
        this.addLayer(new ItemInHandLayer<>(this, p_174557_.getItemInHandRenderer()));
    }

    @Override
    public ResourceLocation getTextureLocation(KmtSolider p_114482_) {
        return TEXTURE_LOCATION;
    }
}
