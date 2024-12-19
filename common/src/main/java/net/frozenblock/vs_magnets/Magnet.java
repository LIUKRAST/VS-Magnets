package net.frozenblock.vs_magnets;

import org.joml.Vector3d;
import org.joml.Vector3i;
import org.valkyrienskies.core.api.ships.Ship;

public class Magnet {
    private final Vector3i pos;
    private final boolean north;

    public Magnet(Vector3i pos, boolean north) {
        this.pos = pos;
        this.north = north;
    }

    public Vector3d getPos(Ship ship) {
        return ship.getTransform().getShipToWorld().transformPosition(new Vector3d(pos));
    }

    public boolean isNorthPole() {
        return this.north;
    }

    public Vector3i getRawPos() {
        return pos;
    }
}
