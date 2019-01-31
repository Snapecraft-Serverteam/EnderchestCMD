package net.snapecraft.EC;

import net.snapecraft.EC.command.ec_cmd;
import net.snapecraft.EC.command.inv_cmd;
import net.snapecraft.EC.command.troll.cmd_troll_openinv;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin implements Listener {

    public static List<Player> troll;

    @Override
    public void onEnable() {
        troll = new ArrayList<Player>();
        getServer().getPluginCommand("ec").setExecutor(new ec_cmd());
        getServer().getPluginCommand("invsee").setExecutor(new inv_cmd());
        //getServer().getPluginCommand("openinv").setExecutor(new cmd_troll_openinv());
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onInv(InventoryInteractEvent e) {
        for (Player l : troll) {
            if(l.getName() == e.getWhoClicked().getName()) {
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        if(troll.contains(e.getPlayer())) {
            troll.remove(e.getPlayer());
        }
    }

}
