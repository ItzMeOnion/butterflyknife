package dev.chatgpt.balisong;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class BalisongSpinClient implements ClientModInitializer {
    private static KeyBinding toggleSpinKey;
    private static boolean spinning = false;

    @Override
    public void onInitializeClient() {
        toggleSpinKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.balisong_spin.toggle",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                "category.balisong_spin.controls"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggleSpinKey.wasPressed()) spinning = !spinning;
        });
    }

    public static boolean isSpinning() { return spinning; }
}
