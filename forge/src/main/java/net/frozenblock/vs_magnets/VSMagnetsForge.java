package net.frozenblock.vs_magnets;

import net.frozenblock.vs_magnets.registry.RegisterBlocks;
import net.frozenblock.vs_magnets.registry.RegisterCreativeTabs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;

@Mod(VSMagnets.MOD_ID)
public class VSMagnetsForge {

    public VSMagnetsForge() {
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
    }

    @SubscribeEvent
    public void registerEvent(RegisterEvent event) {
        event.register(Registries.BLOCK, helper -> RegisterBlocks.register());
        event.register(Registries.CREATIVE_MODE_TAB, helper -> RegisterCreativeTabs.register());
    }

}
