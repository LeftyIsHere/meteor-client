/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client/).
 * Copyright (c) 2020 Meteor Development.
 */

package minegame159.meteorclient.modules.misc;

import minegame159.meteorclient.modules.Category;
import minegame159.meteorclient.modules.ToggleModule;

public class UnfocusedCPU extends ToggleModule {
    public UnfocusedCPU() {
        super(Category.Misc, "unfocused-CPU", "Will not render anything when your Minecraft window is not focused.");
    }
}
