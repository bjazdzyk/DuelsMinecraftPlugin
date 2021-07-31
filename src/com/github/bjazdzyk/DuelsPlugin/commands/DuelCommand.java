package com.github.bjazdzyk.DuelsPlugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.github.bjazdzyk.DuelsPlugin.Main;


public class DuelCommand implements CommandExecutor{

	private Plugin plugin = Main.getPlugin(Main.class);
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(cmd.getName().equalsIgnoreCase("duel")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(args.length > 0) {
					player.sendMessage("LUL");
				}else {
					player.sendMessage(plugin.getConfig().getString("messages.IncorrectDuelCommandUsage"));
				}
				
			}
		}
		return false;
	}

}
