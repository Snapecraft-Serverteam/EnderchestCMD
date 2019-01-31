package net.snapecraft.EC.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class inv_cmd implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            if(args.length == 1) {
                if(sender.hasPermission("inv.other")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null) {
                        if(target.getName() == sender.getName()) {
                            sender.sendMessage("§cDu kannst dein eigenes Inventar nicht öffnen!");
                        } else {
                            ((Player)sender).openInventory(target.getInventory());
                            sender.sendMessage("§aDas Inventar von §6 " + target.getDisplayName() + " §a wurde geöffnet!");
                        }


                    } else {
                        sender.sendMessage("§cSpieler nicht gefunden");
                    }
                }
            } else {
                sender.sendMessage("§cWrong Usage!");
            }
        } else {
            sender.sendMessage("§cDieser Befehl kann nur von Spielern ausgeführt werden!");
        }
        return true;
    }
}
