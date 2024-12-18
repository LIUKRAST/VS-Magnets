package net.frozenblock.vs_magnets;

import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector3i;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.ShipForcesInducer;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class MagneticField implements ShipForcesInducer {
    private static final List<MagneticField> FIELDS = new ArrayList<>();
    private final ArrayList<Magnet> magnetPoles = new ArrayList<>();

    public static MagneticField getOrCreate(ServerShip ship) {
        MagneticField magneticField = ship.getAttachment(MagneticField.class);
        if(magneticField == null) {
            magneticField = new MagneticField();
            ship.saveAttachment(MagneticField.class, magneticField);
        }
        return magneticField;
    }

    public void addMagnetPole(BlockPos pos, boolean north) {
        magnetPoles.add(new Magnet(VectorConversionsMCKt.toJOML(pos), north));
        if(!FIELDS.contains(this))
            FIELDS.add(this);
    }

    public void removeMagnetPole(BlockPos pos) {
        Vector3i vec = VectorConversionsMCKt.toJOML(pos);
        magnetPoles.removeIf(m -> m.pos().equals(vec));
        if(magnetPoles.isEmpty())
            FIELDS.remove(this);
    }

    @Override
    public void applyForces(@NotNull PhysShip physShip) {
        for(Magnet magnet : magnetPoles) {
            for(MagneticField other : FIELDS) {
                if(other == this) continue;

                physShip.applyInvariantForceToPos(new Vector3d(0, 1, 0), new Vector3d(magnet.pos()).add(0.5, 0.5, 0.5));
            }
        }
    }

}
