package org.celestial_artistry.anti_japanese_war.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.celestial_artistry.anti_japanese_war.AntiJapaneseWarMod;
import org.celestial_artistry.anti_japanese_war.entity.MusketBall;

@OnlyIn(Dist.CLIENT)
public class MusketBallRenderer extends EntityRenderer<MusketBall> {
    private static final ResourceLocation TEXTURE_LOCATION = ResourceLocation.fromNamespaceAndPath(AntiJapaneseWarMod.MOD_ID, "textures/entity/musket_ball.png");

    public MusketBallRenderer(EntityRendererProvider.Context p_174008_) {
        super(p_174008_);
    }

    @Override
    public void render(MusketBall bullet, float yaw, float dt, PoseStack poseStack, MultiBufferSource bufferSource, int light) {
        poseStack.pushPose();

        poseStack.scale(bullet.isOnFire() ? 0.075f : 0.05f, 0.05f, 0.05f);

        poseStack.mulPose(entityRenderDispatcher.cameraOrientation());
        poseStack.mulPose(Axis.YP.rotationDegrees(180));

        PoseStack.Pose pose = poseStack.last();
        RenderType renderType = RenderType.entityCutoutNoCull(
                TEXTURE_LOCATION);
        VertexConsumer builder = bufferSource.getBuffer(renderType);

        addVertex(builder, pose, -1, -1, 0, 0, 1, 0, 0, 1, light);
        addVertex(builder, pose,  1, -1, 0, 1, 1, 0, 0, 1, light);
        addVertex(builder, pose,  1,  1, 0, 1, 0, 0, 0, 1, light);
        addVertex(builder, pose, -1,  1, 0, 0, 0, 0, 0, 1, light);

        poseStack.popPose();

        super.render(bullet, yaw, dt, poseStack, bufferSource, light);
    }

    void addVertex(VertexConsumer builder, PoseStack.Pose pose, float x, float y, float z, float u, float v, float nx, float ny, float nz, int light) {
        builder.vertex(pose.pose(), x, y, z)
                .color(255, 255, 255, 255)
                .uv(u, v)
                .overlayCoords(OverlayTexture.NO_OVERLAY)
                .uv2(light)
                .normal(pose.normal(), nx, ny, nz)
                .endVertex();
    }

    @Override
    public ResourceLocation getTextureLocation(MusketBall entity) {
        return TEXTURE_LOCATION;
    }
}
