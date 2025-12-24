package org.celestial_artistry.anti_japanese_war.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.celestial_artistry.anti_japanese_war.AntiJapaneseWarMod;
import org.celestial_artistry.anti_japanese_war.client.renderer.CpcSoliderRenderer;
import org.celestial_artistry.anti_japanese_war.client.renderer.JapaneseKatanaSoliderRenderer;
import org.celestial_artistry.anti_japanese_war.client.renderer.JapaneseSoliderRenderer;
import org.celestial_artistry.anti_japanese_war.client.renderer.KmtSoliderRenderer;
import org.celestial_artistry.anti_japanese_war.client.renderer.MusketBallRenderer;
import org.celestial_artistry.anti_japanese_war.entity.CpcSolider;
import org.celestial_artistry.anti_japanese_war.entity.JapaneseKatanaSolider;
import org.celestial_artistry.anti_japanese_war.entity.JapaneseSolider;
import org.celestial_artistry.anti_japanese_war.entity.KmtSolider;
import org.celestial_artistry.anti_japanese_war.init.ModEntities;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = AntiJapaneseWarMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AntiJapaneseWarClientMod {

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.JAPANESE_SOLIDER.get(), JapaneseSolider.createAttributes().build());
        event.put(ModEntities.JAPANESE_KATANA_SOLIDER.get(), JapaneseKatanaSolider.createAttributes().build());
        event.put(ModEntities.KMT_SOLIDER.get(), KmtSolider.createAttributes().build());
        event.put(ModEntities.CPC_SOLIDER.get(), CpcSolider.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.MUSKET_BALL.get(),
                MusketBallRenderer::new);
        event.registerEntityRenderer(ModEntities.JAPANESE_SOLIDER.get(),
                JapaneseSoliderRenderer::new);
        event.registerEntityRenderer(ModEntities.JAPANESE_KATANA_SOLIDER.get(),
                JapaneseKatanaSoliderRenderer::new);
        event.registerEntityRenderer(ModEntities.KMT_SOLIDER.get(),
                KmtSoliderRenderer::new);
        event.registerEntityRenderer(ModEntities.CPC_SOLIDER.get(),
                CpcSoliderRenderer::new);
    }
}
