
package com.example.impacted.client;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.util.ActionResult;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;

public class ImpactEvents {

    public static void init() {

        AttackEntityCallback.EVENT.register((player, world, hand, entity, hit) -> {

            if(world.isClient()) return ActionResult.PASS;

            if(player.getStackInHand(hand).getItem() == Items.MACE) {

                if(entity instanceof PlayerEntity target) {

                    if(!target.isOnGround()) {
                        ImpactManager.spawn(entity.getPos());
                    }
                }
            }

            return ActionResult.PASS;
        });
    }
}
