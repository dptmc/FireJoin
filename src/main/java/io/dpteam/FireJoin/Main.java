package io.dpteam.PluginName;

import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	public static Main instance;
	public config configInstance;

	public Main() {
		super();
	}

	public void onEnable() {
		instance = this;
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		System.out.println("FireJoin Enabled");

		this.configInstance = new config();
		this.configInstance.load();
		System.out.println("Config Power is set to: " + config.configPower);
		System.out.println("Login delay time is set to: " + config.loginDelay);
	}

	@Override
	public void onDisable() {
		System.out.println("FireJoin Disabled");
	}

	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent e) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			public void run() {
				Firework f = (Firework)e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), Firework.class);
				FireworkMeta meta = utils.getRandomFire(f.getFireworkMeta());
				f.setFireworkMeta(meta);
			}
		}, (long)config.loginDelay);
	}

	public static Main getPlugin() {
		return instance;
	}

	public config getConfigInstance() {
		return this.configInstance;
	}
}
