package github.benlewis9000.anvilanywhere.Commands;


import github.benlewis9000.anvilanywhere.AnvilAnywhere;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AnvilCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {

        if (cmd.getLabel().equalsIgnoreCase("anvil")&& sender instanceof Player){

            Player player = (Player) ((Player) sender).getPlayer();

            if (player.hasPermission("anvilanywhere.use") || player.isOp()){

                new AnvilGUI.Builder().plugin(AnvilAnywhere.plugin).open(player);

            }
            else player.sendMessage("§d6» §cYou must be rank §8]§cImmortal§8]§c or higher to use this! Support the server by purchasing ranks at §bshop.incidia.net§c!");

            return true;
        }

        return false;
    }
}
