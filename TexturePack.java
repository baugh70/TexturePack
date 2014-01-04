package us.legioncraft.texturepack;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TexturePack extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable(){
		System.out.println("Enabling TexturePack!");
		System.out.println("Loading configuartion!");
		loadConfiguration();
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		System.out.println("Loaded config!");
		System.out.println("TexturePack has been enabled!");
	}
	
	@Override
	public void onDisable(){
		System.out.println("TeturePack has been disabled!");
	}
	
	public void loadConfiguration(){
		getConfig().options().header("TexturePack configuration");
		getConfig().addDefault("Texture Pack", "http://nickeliten.se/ozo/OzoCraft-1.7g.zip");
		getConfig().options().copyDefaults(true);
		getConfig().options().copyHeader(true);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		
		player.setTexturePack(getConfig().getString("Texture Pack"));
	}
	
}
