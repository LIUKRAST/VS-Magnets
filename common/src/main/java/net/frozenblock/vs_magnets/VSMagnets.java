package net.frozenblock.vs_magnets;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class VSMagnets {
    public static final String MOD_ID = "vs_magnets";

    public static final int MAGNETIC_FORCE_INTENSITY = 100000;

    public static final TagKey<Block> NORTH_POLE_MAGNET = TagKey.create(Registries.BLOCK, id("north_pole_magnet"));
    public static final TagKey<Block> SOUTH_POLE_MAGNET = TagKey.create(Registries.BLOCK, id("south_pole_magnet"));

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
