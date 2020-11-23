package org.kovalski.furnaceexpfarmlimiter.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.kovalski.furnaceexpfarmlimiter.FurnaceExpFarmLimiter;
import org.kovalski.furnaceexpfarmlimiter.config.MessageUtil;

public class ReloadCommand implements CommandExecutor {

    private FurnaceExpFarmLimiter main = FurnaceExpFarmLimiter.getInstance();
    private MessageUtil messageUtil = main.getMessageUtil();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String message;
        if (!sender.hasPermission("fefl.reload")){
            message = messageUtil.getMessage(MessageUtil.Messages.ERROR_NO_PERMISSION);
            if (!message.isEmpty()) sender.sendMessage(message);
            return true;
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("reload")){
            main.reloadConfig();
            message = messageUtil.getMessage(MessageUtil.Messages.MSG_RELOAD);
            if (!message.isEmpty()) sender.sendMessage(message);
        }else{
            message = messageUtil.getMessage(MessageUtil.Messages.USAGE_FEFL);
            if (!message.isEmpty()) sender.sendMessage(message);
        }

        return true;
    }
}
