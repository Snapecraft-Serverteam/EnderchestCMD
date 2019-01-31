package net.snapecraft.EC.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ec_cmd implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            if(args.length == 0) {
                if(sender.hasPermission("ec.self")) {
                    ((Player)sender).openInventory(((Player)sender).getEnderChest());
                    sender.sendMessage("§aDeine Enderchest wurde geöffnet!");
                } else {
                    sender.sendMessage("§cDu hast keine Rechte diesen Befehl auszuführen");
                }
            }
            if(args.length == 1) {
                if(sender.hasPermission("ec.other")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null) {
                        ((Player)sender).openInventory(target.getEnderChest());
                        sender.sendMessage("§aDie Enderchest von §6 " + target.getDisplayName() + " §a wurde geöffnet!");
                    } else {
                        sender.sendMessage("§cSpieler nicht gefunden");
                    }
                }
            }
        } else {
            sender.sendMessage("§cDieser Befehl kann nur von Spielern ausgeführt werden!");
        }
        return true;
    }
}
