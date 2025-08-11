package com.karasu256.locatorbarplus.impl;

import net.minecraft.client.gui.hud.bar.ExperienceBar;
import net.minecraft.client.gui.hud.bar.LocatorBar;

public interface IInGameHud {
    LocatorBar getLocatorBar();
    ExperienceBar getExperienceBar();
}
