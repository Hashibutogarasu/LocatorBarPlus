package com.karasu256.locatorbarplus.mixin.client;

import com.karasu256.locatorbarplus.config.ModConfig;
import com.karasu256.locatorbarplus.impl.IExperienceBar;
import com.karasu256.locatorbarplus.impl.ILocatorBar;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.hud.bar.Bar;
import net.minecraft.client.gui.hud.bar.ExperienceBar;
import net.minecraft.client.gui.hud.bar.LocatorBar;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("DataFlowIssue")
@Mixin(LocatorBar.class)
public abstract class LocatorBarMixin implements ILocatorBar {
    @Shadow
    @Final
    private MinecraftClient client;
    @Unique
    private ModConfig modConfig;

    @Unique
    private InGameHud inGameHud;

    @Unique
    private ExperienceBar experienceBar;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void onConstructed(MinecraftClient client, CallbackInfo ci) {
        this.modConfig = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }

    @Inject(method = "renderAddons", at = @At("HEAD"))
    private void renderAddons(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        if (this.modConfig.general.modEnabled){
            this.renderAddons(context, tickCounter, this.modConfig.locatorBar.experienceBarTransparency);
        }
    }

    @Override
    public void renderAddons(DrawContext context, RenderTickCounter tickCounter, float transparency) {
        ((IExperienceBar)this.experienceBar).renderBar(context, tickCounter, transparency);
        Bar.drawExperienceLevel(context, this.client.textRenderer, this.client.player.experienceLevel);
    }

    @Override
    public void setInGameHud(InGameHud inGameHud) {
        this.inGameHud = inGameHud;
    }

    @Override
    public void setExperienceBar(ExperienceBar experienceBar) {
        this.experienceBar = experienceBar;
    }
}
