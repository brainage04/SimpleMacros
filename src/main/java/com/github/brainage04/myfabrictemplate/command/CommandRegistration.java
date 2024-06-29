package com.github.brainage04.myfabrictemplate.command;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.text.Text;

public class CommandRegistration {
    public static void registerCommands() {
        ClientCommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess) ->
                dispatcher.register(ClientCommandManager.literal("foo_client")
                .executes(context -> {
                    context.getSource().sendFeedback(Text.literal("The command is executed in the client!"));
                    return 1;
                })
        )));
    }
}
