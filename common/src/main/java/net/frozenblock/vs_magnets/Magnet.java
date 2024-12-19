package net.frozenblock.vs_magnets;

import org.joml.Vector3d;
import org.joml.Vector3i;

public record Magnet(Vector3i pos, boolean north) {

    public Vector3d doublePos() {
        return new Vector3d(pos).add(0.5, 0.5, 0.5);
    }
}
