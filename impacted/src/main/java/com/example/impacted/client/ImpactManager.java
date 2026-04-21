
package com.example.impacted.client;

import java.util.*;
import net.minecraft.util.math.Vec3d;

public class ImpactManager {

    private static final List<ImpactInstance> list = new ArrayList<>();

    public static void spawn(Vec3d pos) {
        list.add(new ImpactInstance(pos));
    }

    public static void tick() {
        list.removeIf(i -> !i.update());
    }

    public static List<ImpactInstance> all() {
        return list;
    }
}
