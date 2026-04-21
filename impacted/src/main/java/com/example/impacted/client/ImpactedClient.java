
package com.example.impacted.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;

public class ImpactedClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ImpactEvents.init();

        ClientTickEvents.END_CLIENT_TICK.register(c -> ImpactManager.tick());

        WorldRenderEvents.END.register(ctx -> {
            ImpactRenderer.render(ctx.matrixStack());
        });
    }
}
