package com.mistphizzle.noloot;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoLoot extends JavaPlugin implements Listener {
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	public void onDisable() {}
	@EventHandler
	public void onPlayerDeathEvent(PlayerDeathEvent e) {
		Player player = e.getEntity();
		if (!player.hasPermission("noloot.override")) {
			e.getDrops().clear();
			e.setDroppedExp(0);
		}
	}
}