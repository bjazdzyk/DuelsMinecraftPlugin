package com.github.bjazdzyk.DuelsPlugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin{
	public void onEnable() {
		Bukkit.getLogger().info("Duels Plugin" +  ChatColor.GREEN + " ENABLED");
		loadConfig();
		Bukkit.getLogger().info(ChatColor.GREEN + "Config loaded");
	}
	public void onDisable() {
		Bukkit.getLogger().info("Duels Plugin" +  ChatColor.RED + " DISABLED");
	}
	public void loadConfig() {
		getConfig().addDefault("messages.IncorrectDuelCommandUsage", ChatColor.RED + "INCORRECT usage of command /duel" + "\n" + ChatColor.RESET + "Please type" + ChatColor.BOLD + "/duel <PlayerName>");
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
}
