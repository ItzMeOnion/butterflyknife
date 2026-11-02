
package dev.chatgpt.balisong.mixin;

import dev.chatgpt.balisong.BalisongSpin;
import dev.chatgpt.balisong.BalisongSpinClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Util;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

    @Inject(
        method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemDisplayContext;IILnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/world/World;I)V",
        at = @At("HEAD")
    )
    private void balisongSpin$rotateHeldKnife(
        ItemStack stack,
        ItemDisplayContext context,
        int light,
        int overlay,
        MatrixStack matrices,
        VertexConsumerProvider vertexConsumers,
        World world,
        int seed,
        CallbackInfo ci
    ) {
        if (!stack.isOf(BalisongSpin.BUTTERFLY_KNIFE)) return;
        if (!BalisongSpinClient.isSpinning()) return;

        if (context != ItemDisplayContext.FIRST_PERSON_RIGHT_HAND
            && context != ItemDisplayContext.FIRST_PERSON_LEFT_HAND
            && context != ItemDisplayContext.THIRD_PERSON_RIGHT_HAND
            && context != ItemDisplayContext.THIRD_PERSON_LEFT_HAND) {
            return;
        }

        float phase = (Util.getMeasuringTimeMs() % 900L) / 900.0f;
        float angle = phase * 360.0f;

        matrices.translate(0.5, 0.5, 0.0);
        matrices.multiply(
            RotationAxis.POSITIVE_Z.rotationDegrees(angle)
        );
        matrices.translate(-0.5, -0.5, 0.0);
    }
}
