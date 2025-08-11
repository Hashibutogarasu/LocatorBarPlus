package com.karasu256.locatorbarplus.mixin.client;

import com.karasu256.locatorbarplus.impl.IExperienceBar;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.bar.Bar;
import net.minecraft.client.gui.hud.bar.ExperienceBar;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@SuppressWarnings("DataFlowIssue")
@Mixin(ExperienceBar.class)
public abstract class ExperienceBarMixin implements Bar, IExperienceBar {
    @Shadow
    @Final
    private MinecraftClient client;

    @Override
    public void renderBar(DrawContext context, RenderTickCounter tickCounter, float transparency) {
        ClientPlayerEntity clientPlayerEntity = this.client.player;
        int i = this.getCenterX(this.client.getWindow());
        int j = this.getCenterY(this.client.getWindow());
        int k = clientPlayerEntity.getNextLevelExperience();
        if (k > 0) {
            int l = (int) (clientPlayerEntity.experienceProgress * 183.0F);
            context.drawGuiTexture(RenderPipelines.GUI_TEXTURED, ((ExperienceBarAccessor) this).getBackground(), i, j,
                    182, 5);
            if (l > 0) {
                int alpha = (int) (transparency * 255);
                int color = (alpha << 24) | 0xFFFFFF;
                context.drawGuiTexture(RenderPipelines.GUI_TEXTURED, ((ExperienceBarAccessor) this).getProgress(), 182,
                        5, 0, 0, i, j, l, 5, color);
            }
        }
    }
}
