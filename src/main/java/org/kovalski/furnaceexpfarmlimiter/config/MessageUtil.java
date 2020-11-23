package org.kovalski.furnaceexpfarmlimiter.config;

import org.bukkit.configuration.ConfigurationSection;
import org.kovalski.furnaceexpfarmlimiter.FurnaceExpFarmLimiter;

public class MessageUtil {

    private FurnaceExpFarmLimiter main = FurnaceExpFarmLimiter.getInstance();
    private UTFConfig utfconfig = main.getUTFConfig();
    private ConfigurationSection messages = utfconfig.getConfigurationSection("messages");

    public enum Messages{
        CONFIG_VERSION,
        PREFIX,
        MSG_RELOAD,
        ERROR_NO_PERMISSION,
        ERROR_NO_ITEM,
        USAGE_FEFL

    }

    public String getMessage(Messages messageName){

        String message = " ";

        switch (messageName){
            case CONFIG_VERSION:
                message = utfconfig.getString("config-version");
                break;
            case PREFIX:
                message = utfconfig.getString("prefix");
                break;
            case MSG_RELOAD:
                message = messages.getString("msg_reload");
                break;
            case ERROR_NO_PERMISSION:
                message = messages.getString("error_no_permission");
                break;
            case ERROR_NO_ITEM:
                message = messages.getString("error_no_item");
                break;
            case USAGE_FEFL:
                message = messages.getString("usage_fefl");
                break;
        }

        return message.replaceAll("%prefix%", utfconfig.getString("prefix")).replaceAll("&", "§");
    }

    public void reload(){
        utfconfig = main.getUTFConfig();
        messages = utfconfig.getConfigurationSection("messages");
    }

}
