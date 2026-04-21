
package com.example.impacted.client;

import net.minecraft.util.math.Vec3d;
import net.minecraft.client.MinecraftClient;

public class ImpactInstance {

    public double x, y;
    public int tick = 0;
    public int max = 12;

    public ImpactInstance(Vec3d world) {

        MinecraftClient c = MinecraftClient.getInstance();
        var cam = c.gameRenderer.getCamera();
        Vec3d rel = world.subtract(cam.getPos());

        this.x = rel.x * 50 + c.getWindow().getScaledWidth() / 2.0;
        this.y = -rel.y * 50 + c.getWindow().getScaledHeight() / 2.0;
    }

    public boolean update() {
        return ++tick < max;
    }

    public float p() {
        return (float) tick / max;
    }
}
