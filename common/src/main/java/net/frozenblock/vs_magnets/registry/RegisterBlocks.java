package net.frozenblock.vs_magnets.registry;

import net.frozenblock.vs_magnets.VSMagnets;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class RegisterBlocks {

    public static final Block NORTH_POLE_MAGNET = new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK));
    public static final Block SOUTh_POLE_MAGNET = new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK));

    public static void register() {
        simpleBlockItem(VSMagnets.id("north_pole_magnet"), NORTH_POLE_MAGNET);
        simpleBlockItem(VSMagnets.id("south_pole_magnet"), SOUTh_POLE_MAGNET);
    }

    private static void simpleBlockItem(ResourceLocation id, Block block) {
        Registry.register(BuiltInRegistries.BLOCK, id, block);
        Registry.register(BuiltInRegistries.ITEM, id, new BlockItem(block, new Item.Properties()));
    }
}
