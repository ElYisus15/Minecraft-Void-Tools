package com.elyisus14.voidtools;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

import static com.elyisus14.voidtools.ToolTags.INCORRECT_FOR_VOID_TOOL;

public class ToolTiers {
    public static final Tier VOID_TIER = new SimpleTier(
            INCORRECT_FOR_VOID_TOOL,
            9000,
            90f,
            59f,
            20,
            () -> Ingredient.of(VoidTools.VOID_INGOT)
    );
}