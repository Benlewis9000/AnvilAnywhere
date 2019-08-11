package github.benlewis9000.anvilanywhere.Commands;


import github.benlewis9000.anvilanywhere.AnvilAnywhere;
import github.benlewis9000.anvilanywhere.Resources.ConfigType;
import github.benlewis9000.anvilanywhere.Utils.AnvilContainer;
import github.benlewis9000.anvilanywhere.Utils.ChatUtils;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AnvilCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {

        if (cmd.getLabel().equalsIgnoreCase("anvil")&& sender instanceof Player){

            Player player = ((Player) sender).getPlayer();

            if (player.hasPermission("anvilanywhere.use") || player.isOp()){

                player.playSound(player.getLocation(), Sound.ANVIL_LAND, 1, 1);
                AnvilContainer.openAnvil(player);

            }
            else {

                String denyMessage = AnvilAnywhere.instance.getConfigManager().getConfig(ConfigType.SETTINGS).getString("deny-message");

                player.sendMessage(ChatUtils.color(denyMessage));
                player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1, 1);

            }

            return true;
        }

        return false;
    }
}
