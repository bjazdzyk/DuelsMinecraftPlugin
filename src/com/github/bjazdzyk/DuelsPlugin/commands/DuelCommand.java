package com.github.bjazdzyk.DuelsPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.github.bjazdzyk.DuelsPlugin.Main;

import net.md_5.bungee.api.ChatColor;


public class DuelCommand implements CommandExecutor{

	private Plugin plugin = Main.getPlugin(Main.class);
	private FileConfiguration config = plugin.getConfig();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(cmd.getName().equalsIgnoreCase("duel")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(args.length > 0) {
					if(plugin.getServer().getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))) {
						Player oponent = Bukkit.getPlayer(args[0]);
						if(player.equals(oponent)) {
							player.sendMessage(ChatColor.RED + config.getString("messages.FrstArg_PlayerNickname"));
							return true;
						}
						player.sendMessage(ChatColor.GOLD + config.getString("messages.DuelOfferSent"));
						oponent.sendMessage(ChatColor.BOLD + player.getName() + ChatColor.RESET + ChatColor.GOLD +  config.getString("messages.DuelOfferRecived"));
						return true;
					}else {
						player.sendMessage(ChatColor.GOLD + args[0] + ChatColor.RESET + ChatColor.RED + config.getString("messages.IsOffline"));
						return true;
					}
				}else {
					player.sendMessage(ChatColor.RED + config.getString("messages.noArgumentsInDuelsCommand"));
					return true;
				}
				
			}
		}
		return false;
	}

}