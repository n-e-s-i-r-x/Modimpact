
package com.example.impacted.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;

public class ImpactRenderer {

    public static void render(MatrixStack ms) {

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableDepthTest();

        Tessellator t = Tessellator.getInstance();
        BufferBuilder b = t.getBuffer();
        Matrix4f m = ms.peek().getPositionMatrix();

        for (ImpactInstance i : ImpactManager.all()) {

            float p = i.p();
            float r = p * 160f;

            b.begin(VertexFormat.DrawMode.LINES, VertexFormats.POSITION_COLOR);

            int lines = 24;

            for (int k = 0; k < lines; k++) {

                double a = Math.PI * 2 * k / lines;

                float x1 = (float)i.x;
                float y1 = (float)i.y;

                float x2 = (float)(i.x + Math.cos(a) * r);
                float y2 = (float)(i.y + Math.sin(a) * r);

                b.vertex(m, x1, y1, 0).color(1,1,1,1 - p).next();
                b.vertex(m, x2, y2, 0).color(1,1,1,0).next();
            }

            t.draw();
        }

        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
    }
}
