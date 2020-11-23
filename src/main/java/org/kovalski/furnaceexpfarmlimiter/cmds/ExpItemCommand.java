package org.kovalski.furnaceexpfarmlimiter.cmds;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.CookingRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.kovalski.furnaceexpfarmlimiter.FurnaceExpFarmLimiter;
import org.kovalski.furnaceexpfarmlimiter.config.MessageUtil;

import java.util.Iterator;

public class ExpItemCommand implements CommandExecutor {

    private FurnaceExpFarmLimiter main = FurnaceExpFarmLimiter.getInstance();
    private MessageUtil messageUtil = main.getMessageUtil();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        String message;
        if (!sender.hasPermission("fefl.expitem")) {
            message = messageUtil.getMessage(MessageUtil.Messages.ERROR_NO_PERMISSION);
            if (!message.isEmpty()) sender.sendMessage(message);
            return true;
        }

        ItemStack item = ((Player) sender).getInventory().getItemInMainHand();
        if (item.getType().equals(Material.AIR)){
            message = messageUtil.getMessage(MessageUtil.Messages.ERROR_NO_ITEM);
            if (!message.isEmpty()) sender.sendMessage(message);
            return true;
        }

        Iterator<Recipe> it = Bukkit.getServer().recipeIterator();

        while (it.hasNext()) {
            Recipe recipe = it.next();
            if (recipe instanceof CookingRecipe) {
                if (((CookingRecipe) recipe).getInput().isSimilar(item)) {
                    sender.sendMessage("§b[" + recipe.getClass().getName() + "] " + ((CookingRecipe) recipe).getInput().toString() + "\n§aExperience Value: " + ((CookingRecipe) recipe).getExperience());
                }
            }
        }

        return true;

    }
}
