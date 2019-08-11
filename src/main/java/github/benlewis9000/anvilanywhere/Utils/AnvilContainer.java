package github.benlewis9000.anvilanywhere.Utils;

import net.minecraft.server.v1_8_R3.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class AnvilContainer extends ContainerAnvil {

    public AnvilContainer(EntityHuman entity) {
        super(entity.inventory, entity.world, new BlockPosition(0,0,0), entity);
    }

    @Override
    public boolean a(EntityHuman entityhuman) {
        return true;
    }

    public static void openAnvil(Player player) {
        EntityPlayer p = ((CraftPlayer) player).getHandle();
        AnvilContainer container = new AnvilContainer(p);

        int c = p.nextContainerCounter();
        p.playerConnection.sendPacket(new PacketPlayOutOpenWindow(c, "minecraft:anvil", new ChatMessage("Repair & Name", new Object[]{}), 0));
        p.activeContainer = container;
        p.activeContainer.windowId = c;
        p.activeContainer.addSlotListener(p);
    }

}