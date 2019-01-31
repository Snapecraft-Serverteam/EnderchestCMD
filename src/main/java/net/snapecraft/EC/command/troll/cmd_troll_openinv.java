package net.snapecraft.EC.command.troll;

import net.snapecraft.EC.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmd_troll_openinv implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(args.length == 1) {
            if(sender.hasPermission("troll.openPlayerInv")) {
                Player p = Bukkit.getPlayer(args[0]);
                if(p != null) {
                    Main.troll.add(p);
                    p.openInventory(p.getInventory());
                } else {
                    sender.sendMessage("§cSpieler nicht gefunden");
                }
            } else {
                sender.sendMessage("§cDu hast keine Rechte diesen Befehl auszuführen");
            }
        } else {
            sender.sendMessage("§cWrong Usage!");
        }


        return true;
    }
}
