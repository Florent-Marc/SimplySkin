package com.SimplySkin.common.network;

import com.SimplySkin.Constant;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class Network {

    public static SimpleNetworkWrapper network;
    static int id = -1;
    public static void init(){
        network = NetworkRegistry.INSTANCE.newSimpleChannel(Constant.MODID);

        //packetFromServer(PacketExample.ServerHandler.class, PacketExample.class);
    }

    public static void packetFromClient(Class handler, Class packet) {
        network.registerMessage(handler, packet, id++, Side.CLIENT);
    }

    public static void packetFromServer(Class handler, Class packet) {
        network.registerMessage(handler, packet, id++, Side.SERVER);
    }
}
