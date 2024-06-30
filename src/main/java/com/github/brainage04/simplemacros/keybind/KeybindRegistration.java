package com.github.brainage04.simplemacros.keybind;

import com.github.brainage04.simplemacros.Client;
import com.github.brainage04.simplemacros.config.Config;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeybindRegistration {
    public static KeyBinding configKeybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            String.format("com.github.%s.%s.keybinds.configKeybind", Client.MOD_AUTHOR, Client.MOD_ID),
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_KP_ENTER,
            Client.MOD_NAME
    ));

    public static void registerKeybinds() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (configKeybind.isPressed()) {
                MinecraftClient.getInstance().setScreen(Config.createScreen(MinecraftClient.getInstance().currentScreen));
            }
        });
    }
}
