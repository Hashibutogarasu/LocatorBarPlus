package com.karasu256.locatorbarplus.mixin.client;

import net.minecraft.client.gui.hud.bar.ExperienceBar;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ExperienceBar.class)
public interface ExperienceBarAccessor {
    @Accessor("BACKGROUND")
    Identifier getBackground();

    @Accessor("PROGRESS")
    Identifier getProgress();
}
