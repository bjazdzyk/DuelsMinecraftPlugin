package com.github.bjazdzyk.DuelsPlugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.bjazdzyk.DuelsPlugin.commands.DuelCommand;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin{
	public void onEnable() {
		Bukkit.getLogger().info("Duels Plugin" +  ChatColor.GREEN + " ENABLED");
		
		loadConfig();
		Bukkit.getLogger().info(ChatColor.GREEN + "Config loaded");
		
		this.getCommand("duel").setExecutor(new DuelCommand());
	}
	public void onDisable() {
		Bukkit.getLogger().info("Duels Plugin" +  ChatColor.RED + " DISABLED");
	}
	public void loadConfig() {
		getConfig().addDefault("messages.DuelOfferSent", "Duel offer sent . . .");
		getConfig().addDefault("messages.noArgumentsInDuelsCommand", "INCORRECT usage of command /duel" + "\n" + "Please type /duel <PlayerName> <kit>");
		getConfig().addDefault("messages.DuelOfferRecived", " sent you duel offer");
		getConfig().addDefault("messages.IsOffline", " is offline now");
		getConfig().addDefault("messages.FrstArg_PlayerNickname", "First argument of /duels cannot be your nickname!");
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
}