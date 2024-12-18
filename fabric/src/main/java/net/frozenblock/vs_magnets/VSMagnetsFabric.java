package net.frozenblock.vs_magnets;

import net.fabricmc.api.ModInitializer;
import net.frozenblock.vs_magnets.registry.RegisterBlocks;
import net.frozenblock.vs_magnets.registry.RegisterCreativeTabs;

public class VSMagnetsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        RegisterBlocks.register();
        RegisterCreativeTabs.register();
    }
}
