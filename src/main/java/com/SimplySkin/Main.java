package com.SimplySkin;

import com.SimplySkin.client.ClientEventHandler;
import com.SimplySkin.client.register.KeyBindingsHandler;
import com.SimplySkin.common.event.SLEventHandler;
import com.SimplySkin.common.event.register.RegisterHandler;
import com.SimplySkin.common.network.Network;
import com.SimplySkin.proxy.CommonProxy;
import com.SimplySkin.server.commands.CommandExample;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(
        modid = Constant.MODID,
        name = Constant.MODNAME,
        version = Constant.VERSION
)
public class Main {

    //==================================================FORGE===========================================================
    @SidedProxy(modId = Constant.MODID, clientSide = "com." + Constant.MODID + ".proxy.ClientProxy", serverSide = "com." + Constant.MODID + ".proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance(Constant.MODID)
    public static Main INSTANCE;


    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        if (event.getSide().isClient()) {
            MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
            KeyBindingsHandler.register();
        }

        MinecraftForge.EVENT_BUS.register(new SLEventHandler());
        MinecraftForge.EVENT_BUS.register(new RegisterHandler());

        proxy.onPreInit(event);

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        Network.init();
        RegisterHandler.initSounds();
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent e) {
        e.registerServerCommand(new CommandExample());
    }
}