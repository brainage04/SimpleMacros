package com.github.brainage04.myfabrictemplate.keybind;

import com.github.brainage04.myfabrictemplate.Client;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeybindRegistration {
    public static KeyBinding exampleKeybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
        String.format("com.github.%s.%s.keybinds.exampleKeybind", Client.MOD_AUTHOR, Client.MOD_ID),
        InputUtil.Type.KEYSYM,
        GLFW.GLFW_KEY_KP_ENTER,
        Client.MOD_NAME
    ));

    public static void registerKeybinds() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (exampleKeybind.wasPressed()) {
                client.player.sendMessage(Text.literal("Key 1 was pressed!"), false);
            }
        });
    }
}
