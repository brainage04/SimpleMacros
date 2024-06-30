package com.github.brainage04.simplemacros.command;

import com.github.brainage04.simplemacros.Client;
import com.github.brainage04.simplemacros.config.Config;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;

public class CommandRegistration {
    public static void registerCommands() {
        ClientCommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess) ->
                dispatcher.register(ClientCommandManager.literal(Client.MOD_ID)
                .executes(context -> {
                    MinecraftClient.getInstance().send(() -> context.getSource().getClient().setScreen(
                            Config.createScreen(
                                    context.getSource().getClient().currentScreen
                            )
                    ));
                    return 1;
                })
        )));
    }
}
