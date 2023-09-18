package de.eltigere.extraordinaryblocks.blockentities.renderers;

import com.mojang.blaze3d.vertex.*;
import de.eltigere.extraordinaryblocks.blockentities.FogBlockBE;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import org.joml.Matrix4f;

import javax.annotation.ParametersAreNonnullByDefault;

public class FogBlockBER implements BlockEntityRenderer<FogBlockBE>{
    private final BlockEntityRendererProvider.Context context;

    private static final ResourceLocation STONE = new ResourceLocation("minecraft", "block/stone");

    public FogBlockBER(BlockEntityRendererProvider.Context context) {
        this.context = context;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(FogBlockBE blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int combinedLight, int combinedOverlay) {
        // render stone texture for testing
        BlockRenderDispatcher dispatcher = context.getBlockRenderDispatcher();
        VertexConsumer builder = multiBufferSource.getBuffer(RenderType.solid());
        TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(STONE);

        poseStack.pushPose();
        Matrix4f matrix = poseStack.last().pose();
        builder.vertex(matrix, 0f, 0f, 0f).color(255, 0, 255, 255).uv(sprite.getU0(), sprite.getV0()).uv2(9999).normal(0f, 0f, 1f).endVertex();
        builder.vertex(matrix, 1f, 0f, 0f).color(255, 0, 255, 255).uv(sprite.getU1(), sprite.getV0()).uv2(9999).normal(0f, 0f, 1f).endVertex();
        builder.vertex(matrix, 1f, 1f, 0f).color(255, 0, 255, 255).uv(sprite.getU1(), sprite.getV1()).uv2(9999).normal(0f, 0f, 1f).endVertex();
        builder.vertex(matrix, 0f, 1f, 0f).color(255, 0, 255, 255).uv(sprite.getU0(), sprite.getV1()).uv2(9999).normal(0f, 0f, 1f).endVertex();
        poseStack.popPose();
    }
}
