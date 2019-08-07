package github.benlewis9000.anvilanywhere;

import github.benlewis9000.anvilanywhere.Commands.AnvilCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class AnvilAnywhere extends JavaPlugin {


    public static Plugin plugin;

    @Override
    public void onEnable(){

        plugin = this;

        this.getCommand("anvil").setExecutor(new AnvilCommand());

    }

    @Override
    public void onDisable(){


    }

}
