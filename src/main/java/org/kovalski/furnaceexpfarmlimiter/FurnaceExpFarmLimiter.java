package org.kovalski.furnaceexpfarmlimiter;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.kovalski.furnaceexpfarmlimiter.cmds.ExpItemCommand;
import org.kovalski.furnaceexpfarmlimiter.cmds.ReloadCommand;
import org.kovalski.furnaceexpfarmlimiter.config.MessageUtil;
import org.kovalski.furnaceexpfarmlimiter.config.UTFConfig;
import org.kovalski.furnaceexpfarmlimiter.recipe.RecipeManager;
import org.kovalski.furnaceexpfarmlimiter.recipe.RecipeReader;

import java.io.File;

public final class FurnaceExpFarmLimiter extends JavaPlugin {

    private static FurnaceExpFarmLimiter instance;
    private MessageUtil messageUtil;
    private RecipeManager recipeManager;
    private RecipeReader recipeReader;
    private UTFConfig UTFConfig;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        recipeManager = new RecipeManager();
        loadConfig();
        messageUtil = new MessageUtil();
        loadCommands();
        recipeReader = new RecipeReader();
        Bukkit.getLogger().info("§b["+this.getName()+"] Plugin loaded successfully!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("§cPlugin Disabled.");
    }

    private void loadConfig(){
        UTFConfig = new UTFConfig(new File(this.getDataFolder(), "config.yml"));
    }

    private void loadCommands(){
        getCommand("ExpItem").setExecutor(new ExpItemCommand());
        getCommand("FurnaceExpFarmLimiter").setExecutor(new ReloadCommand());
    }

    public void reloadConfig(){
        UTFConfig = new UTFConfig(new File(this.getDataFolder(), "config.yml"));
        messageUtil.reload();
        recipeReader.reload();
    }

    public static FurnaceExpFarmLimiter getInstance(){
        return instance;
    }

    public RecipeManager getRecipeManager() {
        return recipeManager;
    }

    public UTFConfig getUTFConfig() {
        return UTFConfig;
    }

    public MessageUtil getMessageUtil() {
        return messageUtil;
    }
}
