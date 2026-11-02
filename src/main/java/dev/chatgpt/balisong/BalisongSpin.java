package dev.chatgpt.balisong;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BalisongSpin implements ModInitializer {
    public static final String MOD_ID = "balisong_spin";
    public static final Item BUTTERFLY_KNIFE = Registry.register(
            Registries.ITEM,
            Identifier.of(MOD_ID, "butterfly_knife"),
            new Item(new Item.Settings().maxCount(1))
    );

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register(entries -> entries.add(BUTTERFLY_KNIFE));
    }
}
