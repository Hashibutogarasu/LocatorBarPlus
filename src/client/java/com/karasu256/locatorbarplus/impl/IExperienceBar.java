package com.karasu256.locatorbarplus.impl;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;

public interface IExperienceBar {
    void renderBar(DrawContext context, RenderTickCounter tickCounter, float transparency);
}
