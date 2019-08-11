package github.benlewis9000.anvilanywhere.Resources;

import github.benlewis9000.anvilanywhere.AnvilAnywhere;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import javax.security.auth.login.Configuration;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

public class ConfigManager {

    Logger l = AnvilAnywhere.plugin.getLogger();



    /**
     * HashMap to store all of the plugins config files, represented by their enum type
     */
    private HashMap<ConfigType, FileConfiguration> configs = new HashMap<>();

    public ConfigManager(){

        configs.put(ConfigType.SETTINGS, null);
        configs.put(ConfigType.PLAYERDATA, null);

        // Load/setup each config type as needed
        for (ConfigType type : configs.keySet()) {

            configs.put(type, loadConfig(type.getName()));

        }

    }

    /**
     * Fully load or setup a config
     * @param name of file to load
     * @return the loaded YamlConfiguration
     */
    private FileConfiguration loadConfig(String name){

        FileConfiguration config = null;

        // Check for and create plugins data folder
        if (!AnvilAnywhere.plugin.getDataFolder().exists()){

            AnvilAnywhere.plugin.getDataFolder().mkdir();

        }

        // Create memory File for settings.yml
        File file = new File(AnvilAnywhere.plugin.getDataFolder(), name);

        try {

            // Check for physical File
            if (!file.exists()){

                l.info("file \"" + file.getName() + "\" does not exist. Creating...");

                // ..create if not found..
                file.createNewFile();
                // ..and assign defaults..
                saveDefaultData(name);

            }

            // ..and assign as YamlConfig
            config = YamlConfiguration.loadConfiguration(file);

        }
        catch (Exception e){

            // Print error and disable plugin
            e.printStackTrace();
            AnvilAnywhere.plugin.getLogger().severe("Could not load \"" + name + "\"! Disabling...");
            AnvilAnywhere.plugin.getServer().getPluginManager().disablePlugin(AnvilAnywhere.plugin);

        }

        return config;

    }

    /**
     * Get a specific FileConfiguration from the manager
     * @param type of config to get
     * @return the desired config
     */
    public FileConfiguration getConfig(ConfigType type){

        return configs.get(type);

    }

    /**
     * Saves the default data to a file as defined in the .jar
     */
    public void saveDefaultData(String name) {

        // Check resource to load data from exists...
        if (AnvilAnywhere.plugin.getResource(name) == null){

            // Print warning
            AnvilAnywhere.plugin.getLogger().severe("Could not find resource \"" + name + "\"!");

        }

        // Save resource to plugins folder
        AnvilAnywhere.plugin.saveResource(name, true); //todo - works with true, untested with false (should work) - 10/08/10 02:09

    }

}
