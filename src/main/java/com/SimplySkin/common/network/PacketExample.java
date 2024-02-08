package com.SimplySkin.common.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketExample implements IMessage {

    private long pos;
    private String name;
    private String desc;
    private String reward;
    private long time;
    private boolean isAdmin;

    public PacketExample() {
    }

    public PacketExample(BlockPos pos, String name, String desc, String reward, long time, boolean isAdmin) {
        this.pos = pos.toLong();
        this.name = name;
        this.desc = desc;
        this.reward = reward;
        this.time = time;
        this.isAdmin = isAdmin;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.pos = buf.readLong();
        this.name = ByteBufUtils.readUTF8String(buf);
        this.desc = ByteBufUtils.readUTF8String(buf);
        this.reward = ByteBufUtils.readUTF8String(buf);
        this.time = buf.readLong();
        this.isAdmin = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(this.pos);
        ByteBufUtils.writeUTF8String(buf, this.name);
        ByteBufUtils.writeUTF8String(buf, this.desc);
        ByteBufUtils.writeUTF8String(buf, this.reward);
        buf.writeLong(this.time);
        buf.writeBoolean(this.isAdmin);
    }

    public static class ServerHandler implements IMessageHandler<PacketExample, IMessage> {

        @Override
        public IMessage onMessage(PacketExample message, MessageContext ctx) {
            //code
            return null;
        }
    }

}