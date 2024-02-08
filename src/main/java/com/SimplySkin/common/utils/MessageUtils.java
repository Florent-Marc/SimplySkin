package com.SimplySkin.common.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class MessageUtils {

    public static void sendActionChat(EntityPlayer player, String msg, Boolean actionbar) {
        if(!player.world.isRemote) {
            player.sendStatusMessage(new TextComponentString(TextFormatting.GREEN + msg), actionbar);
        }
    }

    public static void sendErrorChat(EntityPlayer player, String msg, Boolean actionbar) {
        if(!player.world.isRemote) {
            player.sendStatusMessage(new TextComponentString(TextFormatting.RED + "✗ " + msg + " ✗"), actionbar);
        }
    }
}
