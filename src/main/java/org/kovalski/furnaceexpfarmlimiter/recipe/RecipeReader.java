package org.kovalski.furnaceexpfarmlimiter.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.kovalski.furnaceexpfarmlimiter.FurnaceExpFarmLimiter;
import org.kovalski.furnaceexpfarmlimiter.config.UTFConfig;

public class RecipeReader {

    private static FurnaceExpFarmLimiter instance = FurnaceExpFarmLimiter.getInstance();

    private UTFConfig utfConfig;
    private RecipeManager recipeManager;
    private boolean debug;

    private ConfigurationSection stoneFurnace;
    private ConfigurationSection blastFurnace;
    private ConfigurationSection campFire;
    private ConfigurationSection smokingRecipe;

    public RecipeReader(){

        utfConfig = instance.getUTFConfig();
        recipeManager = instance.getRecipeManager();
        debug = utfConfig.getBoolean("debug");

        blastFurnace = utfConfig.getConfigurationSection("recipes.blast_furnace");
        stoneFurnace = utfConfig.getConfigurationSection("recipes.stone_furnace");
        campFire = utfConfig.getConfigurationSection("recipes.camp_fire");
        smokingRecipe = utfConfig.getConfigurationSection("recipes.smoker");

        run();
    }

    public void reload(){
        utfConfig = instance.getUTFConfig();
        recipeManager = instance.getRecipeManager();
        debug = utfConfig.getBoolean("debug");

        blastFurnace = utfConfig.getConfigurationSection("recipes.blast_furnace");
        stoneFurnace = utfConfig.getConfigurationSection("recipes.stone_furnace");
        campFire = utfConfig.getConfigurationSection("recipes.camp_fire");
        smokingRecipe = utfConfig.getConfigurationSection("recipes.smoker");

        run();
    }

    private void run(){
        if (stoneFurnace != null){
            for (String string : stoneFurnace.getKeys(true)){
                Material material = Material.getMaterial(string);
                if (material == null) continue;
                ItemStack item = new ItemStack(material);
                recipeManager.setExperienceStoneFurnaceRecipe(item, Float.parseFloat(stoneFurnace.getString(string)));
                if (debug) Bukkit.getLogger().info("§b[StoneFurnace] " + string + " " + Float.parseFloat(stoneFurnace.getString(string)));
            }
        }

        if (blastFurnace != null){
            for (String string : blastFurnace.getKeys(true)){
                Material material = Material.getMaterial(string);
                if (material == null) continue;
                ItemStack item = new ItemStack(material);
                recipeManager.setExperienceBlastingRecipe(item, Float.parseFloat(blastFurnace.getString(string)));
                if (debug) Bukkit.getLogger().info("§b[BlastFurnace] " + string + " " + Float.parseFloat(blastFurnace.getString(string)));
            }
        }

        if (campFire != null){
            for (String string : campFire.getKeys(true)){
                Material material = Material.getMaterial(string);
                if (material == null) continue;
                ItemStack item = new ItemStack(material);
                recipeManager.setExperienceCampFireRecipe(item, Float.parseFloat(campFire.getString(string)));
                if (debug) Bukkit.getLogger().info("§b{CampFire] " + string + " " + Float.parseFloat(campFire.getString(string)));
            }
        }

        if (smokingRecipe != null){
            for (String string : smokingRecipe.getKeys(true)){
                Material material = Material.getMaterial(string);
                if (material == null) continue;
                ItemStack item = new ItemStack(material);
                recipeManager.setExperienceSmokingRecipe(item, Float.parseFloat(smokingRecipe.getString(string)));
                if (debug) Bukkit.getLogger().info("§b[Smoker] " + string + " " + Float.parseFloat(smokingRecipe.getString(string)));
            }
        }
    }

}
