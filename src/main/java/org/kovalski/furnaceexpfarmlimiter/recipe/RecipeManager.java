package org.kovalski.furnaceexpfarmlimiter.recipe;

import org.bukkit.Bukkit;
import org.bukkit.inventory.*;

import java.util.Iterator;

public class RecipeManager {

    public void setExperienceBlastingRecipe(ItemStack item, float exp){
        Iterator<Recipe> it = Bukkit.getServer().recipeIterator();

        while(it.hasNext()){
            Recipe recipe = it.next();
            if (recipe instanceof BlastingRecipe){
                if (((BlastingRecipe) recipe).getInput().isSimilar(item)){
                    it.remove();
                    BlastingRecipe blastingRecipe = new BlastingRecipe(
                            ((BlastingRecipe) recipe).getKey()
                            ,recipe.getResult()
                            ,((BlastingRecipe) recipe).getInput().getType()
                            ,exp
                            ,((BlastingRecipe) recipe).getCookingTime());
                    Bukkit.addRecipe(blastingRecipe);
                }
            }
        }
    }

    public void setExperienceStoneFurnaceRecipe(ItemStack item, float exp){
        Iterator<Recipe> it = Bukkit.getServer().recipeIterator();

        while(it.hasNext()){
            Recipe recipe = it.next();
            if (recipe instanceof FurnaceRecipe){
                if (((FurnaceRecipe) recipe).getInput().isSimilar(item)){
                    it.remove();
                    FurnaceRecipe furnaceRecipe = new FurnaceRecipe(
                            ((FurnaceRecipe) recipe).getKey()
                            ,recipe.getResult()
                            ,((FurnaceRecipe) recipe).getInput().getType()
                            ,exp
                            ,((FurnaceRecipe) recipe).getCookingTime());
                    Bukkit.addRecipe(furnaceRecipe);
                }
            }
        }
    }

    public void setExperienceSmokingRecipe(ItemStack item, float exp){
        Iterator<Recipe> it = Bukkit.getServer().recipeIterator();

        while(it.hasNext()){
            Recipe recipe = it.next();
            if (recipe instanceof SmokingRecipe){
                if (((SmokingRecipe) recipe).getInput().isSimilar(item)){
                    it.remove();
                    SmokingRecipe smokingRecipe = new SmokingRecipe(
                            ((SmokingRecipe) recipe).getKey()
                            ,recipe.getResult()
                            ,((SmokingRecipe) recipe).getInput().getType()
                            ,exp
                            ,((SmokingRecipe) recipe).getCookingTime());
                    Bukkit.addRecipe(smokingRecipe);
                }
            }
        }
    }

    public void setExperienceCampFireRecipe(ItemStack item, float exp){
        Iterator<Recipe> it = Bukkit.getServer().recipeIterator();

        while(it.hasNext()){
            Recipe recipe = it.next();
            if (recipe instanceof CampfireRecipe){
                if (((CampfireRecipe) recipe).getInput().isSimilar(item)){
                    it.remove();
                    CampfireRecipe campfireRecipe = new CampfireRecipe(
                            ((CampfireRecipe) recipe).getKey()
                            ,recipe.getResult()
                            ,((CampfireRecipe) recipe).getInput().getType()
                            ,exp
                            ,((CampfireRecipe) recipe).getCookingTime());
                    Bukkit.addRecipe(campfireRecipe);
                }
            }
        }
    }


}
