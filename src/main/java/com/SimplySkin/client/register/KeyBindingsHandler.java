package com.SimplySkin.client.register;

import com.SimplySkin.Constant;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class KeyBindingsHandler
{
	private static String category = (Constant.MODNAME);
	public static KeyBinding

	debug = new KeyBinding("Debug", Keyboard.KEY_F7, category);

	private KeyBindingsHandler() {};

	public static void register()
	{
		registerKeys(debug);
	}

	private static void registerKeys(KeyBinding... keys)
	{
		for(KeyBinding key : keys) ClientRegistry.registerKeyBinding(key);
	}

}