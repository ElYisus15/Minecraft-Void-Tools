package com.elyisus14.voidtools;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static net.neoforged.neoforge.internal.versions.neoforge.NeoForgeVersion.MOD_ID;

public class ToolTags {
    public static final TagKey<Block> INCORRECT_FOR_VOID_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(MOD_ID, "incorrect_for_void_tool"));
}