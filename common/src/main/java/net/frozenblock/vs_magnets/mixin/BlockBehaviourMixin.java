package net.frozenblock.vs_magnets.mixin;

import net.frozenblock.vs_magnets.MagneticField;
import net.frozenblock.vs_magnets.VSMagnets;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(BlockBehaviour.class)
public class BlockBehaviourMixin {
    @Inject(method = "onPlace", at = @At("TAIL"))
    private void vs_magnets$onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving, CallbackInfo ci) {
        boolean north = state.is(VSMagnets.NORTH_POLE_MAGNET);
        boolean south = state.is(VSMagnets.SOUTH_POLE_MAGNET);
        if(!(north || south)) return;
        if(level.isClientSide) return;
        Ship ship = VSGameUtilsKt.getShipObjectManagingPos(level, pos);
        if(ship == null) {
            ship = VSGameUtilsKt.getShipManagingPos(level, pos);
            if(ship == null) return;
        }
        MagneticField.getOrCreate((ServerShip) ship).addMagnetPole(pos, north);
    }

    @Inject(method = "onRemove", at = @At("TAIL"))
    private void vs_magnets$onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving, CallbackInfo ci) {
        boolean north = state.is(VSMagnets.NORTH_POLE_MAGNET);
        boolean south = state.is(VSMagnets.SOUTH_POLE_MAGNET);
        if(!(north || south)) return;
        if(level.isClientSide) return;
        Ship ship = VSGameUtilsKt.getShipObjectManagingPos(level, pos);
        if(ship == null) {
            ship = VSGameUtilsKt.getShipManagingPos(level, pos);
            if(ship == null) return;
        }
        MagneticField.getOrCreate((ServerShip) ship).removeMagnetPole(pos);
    }
}
