package com.SimplySkin.client;

import com.SimplySkin.Constant;
import com.SimplySkin.client.register.KeyBindingsHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = Constant.MODID, value = Side.CLIENT)
public class ClientEventHandler {

    public final static Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent e) {
        if (KeyBindingsHandler.debug.isKeyDown()) {
            if (mc.player.canUseCommand(4, "")) {
                mc.player.sendChatMessage("test");
                //mc.displayGuiScreen(new CSSMenuStaff().getGuiScreen());
            }
        }
    }

    //on gui open
    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent e) {
        if (e.getGui() != null) {
            if (e.getGui() instanceof GuiMainMenu) {
                //thread
                BrowserScreen browserScreen = new BrowserScreen("https://www.google.com");
                e.setGui(browserScreen);
            }
        }
    }

}