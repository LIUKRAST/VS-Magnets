package net.frozenblock.vs_magnets.registry;

import net.frozenblock.vs_magnets.VSMagnets;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

public class RegisterCreativeTabs {

    public static final CreativeModeTab TAB = CreativeModeTab
            .builder(CreativeModeTab.Row.TOP, 0)
            .icon(() -> RegisterBlocks.NORTH_POLE_MAGNET.asItem().getDefaultInstance())
            .displayItems((p, outputs) -> {
                outputs.accept(RegisterBlocks.NORTH_POLE_MAGNET);
                outputs.accept(RegisterBlocks.SOUTh_POLE_MAGNET);
            })
            .title(Component.translatable("itemGroup.vs_magnets"))
            .build();

    public static void register() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, VSMagnets.id("main_tab"), TAB);
    }
}
