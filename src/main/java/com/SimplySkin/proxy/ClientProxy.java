package com.SimplySkin.proxy;

import com.SimplySkin.common.blocks.BlocksRegister;
import com.SimplySkin.common.items.ItemsRegister;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
public class ClientProxy extends CommonProxy {

    @Override
    public void onPreInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(BlocksRegister.INSTANCE);
        MinecraftForge.EVENT_BUS.register(ItemsRegister.INSTANCE);
    }

}