package com.karasu256.locatorbarplus.impl;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.hud.bar.ExperienceBar;
import net.minecraft.client.render.RenderTickCounter;

public interface ILocatorBar {
    void setInGameHud(InGameHud inGameHud);
    void setExperienceBar(ExperienceBar experienceBar);

    void renderAddons(DrawContext context, RenderTickCounter tickCounter, float transparency);
}
