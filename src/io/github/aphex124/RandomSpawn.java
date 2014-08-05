package io.github.aphex124;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RandomSpawn implements Listener{
	
	public World world;
	Location sp1 = new Location(world, 0, 125, 0);
	Random random = new Random();
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		e.getPlayer().getWorld();
		e.getPlayer().teleport(sp1);
		
	}	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("basic")) { // If the player typed /basic then do the following...
			Player player = (Player) sender;
			player.getPlayer().teleport(sp1);
			return true;
		}
		return false; 
	}
	
}
