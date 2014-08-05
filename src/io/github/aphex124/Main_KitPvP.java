package io.github.aphex124;
 
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;
 
public class Main_KitPvP extends JavaPlugin implements Listener {
 
        private Menu menu;
        private RandomSpawn rnds;
       
        public void onEnable() {
                menu = new Menu(this);
                Bukkit.getServer().getPluginManager().registerEvents(this, this);
        }

        
        @EventHandler
        public void onPlayerRespawn(PlayerRespawnEvent e) {
        	e.getPlayer();
                menu.show(e.getPlayer()); 
        }
        
        
        @EventHandler
        public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        PlayerInventory inventory = player.getInventory();
        ItemStack itemstack = new ItemStack(Material.ANVIL);
        menu.show(event.getPlayer()); 
        inventory.addItem(itemstack);
        
}        
}

