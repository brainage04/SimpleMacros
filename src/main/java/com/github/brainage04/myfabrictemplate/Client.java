package com.github.brainage04.myfabrictemplate;

import com.github.brainage04.myfabrictemplate.command.CommandRegistration;
import com.github.brainage04.myfabrictemplate.keybind.KeybindRegistration;
import net.fabricmc.api.ClientModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client implements ClientModInitializer {
	public static final String MOD_ID = "myfabrictemplate";
	public static final String MOD_NAME = "MyFabricTemplate";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final String MOD_AUTHOR = "brainage04";

	@Override
	public void onInitializeClient() {
		LOGGER.info(MOD_NAME + " initializing...");

		KeybindRegistration.registerKeybinds();
		CommandRegistration.registerCommands();

		LOGGER.info(MOD_NAME + " initialized.");
	}
}