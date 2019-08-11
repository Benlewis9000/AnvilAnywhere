package github.benlewis9000.anvilanywhere;

import github.benlewis9000.anvilanywhere.Commands.AnvilCommand;
import github.benlewis9000.anvilanywhere.Resources.ConfigManager;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class AnvilAnywhere extends JavaPlugin {

    public static Plugin plugin;
    public static AnvilAnywhere instance;

    private ConfigManager configManager;

    /**
     * Get access to the FileManager singleton
     * @return the plugins FileManager
     */
    public ConfigManager getFileManager() {
        return configManager;
    }

    /**
     * Accessor for ConfigManager
     * @return the plugins ConfigManager
     */
    public ConfigManager getConfigManager() {
        return configManager;
    }

    @Override
    public void onEnable(){

        plugin = this;
        instance = this;

        configManager = new ConfigManager();

        this.getCommand("anvil").setExecutor(new AnvilCommand());

    }

    @Override
    public void onDisable(){


    }

}
