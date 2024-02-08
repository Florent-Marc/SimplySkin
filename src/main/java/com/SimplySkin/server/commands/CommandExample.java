package com.SimplySkin.server.commands;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class CommandExample extends net.minecraft.command.CommandBase {

    public String getName() {
        return "example";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/example <arg>";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 4;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        sender.sendMessage(new TextComponentString(TextFormatting.GREEN + "You have executed the command!"));

    }

}