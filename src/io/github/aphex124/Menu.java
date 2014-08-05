package io.github.aphex124;

import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;
import org.bukkit.plugin.Plugin;

public class Menu implements Listener{
			
	private Inventory inv;
	private ItemStack Fighter, Archer, Brawler;
	
	public Menu(Plugin p) {
		inv = Bukkit.getServer().createInventory(null, 9, ChatColor.AQUA + "Kit Selection");
		
		Fighter = createItem(DyeColor.LIME, ChatColor.GREEN + "Fighter");
		Archer = createItem(DyeColor.RED, ChatColor.RED + "Archer");
		Brawler = createItem(DyeColor.LIGHT_BLUE, ChatColor.BLUE + "(Coming Soon)");
		
		inv.setItem(3, Fighter);
		inv.setItem(5, Archer);
//		inv.setItem(8, Brawler);
		
		Bukkit.getServer().getPluginManager().registerEvents(this, p);
	}
		
	
	private ItemStack createItem(DyeColor dc, String name) {
		ItemStack i = new Wool(dc).toItemStack(1);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(name);
		im.setLore(Arrays.asList("Set your kit to the " + name.toUpperCase() + " Kit!"));
		i.setItemMeta(im);
		return i;
	}
	
	
	public void show(Player p) {
		p.openInventory(inv);
	}
	
	ItemStack IronHelmet = new ItemStack(Material.IRON_HELMET);
	ItemStack IronChestplate = new ItemStack(Material.IRON_CHESTPLATE);
	ItemStack IronLeggings = new ItemStack(Material.IRON_LEGGINGS);
	ItemStack IronBoots = new ItemStack(Material.IRON_BOOTS);
	
	ItemStack DiamondSword = new ItemStack(Material.DIAMOND_SWORD);
	ItemStack IronSword = new ItemStack(Material.IRON_SWORD);
	ItemStack DiamondAxe = new ItemStack(Material.DIAMOND_AXE);
	
	ItemStack FiveCrapples = new ItemStack(Material.GOLDEN_APPLE, 5);
	ItemStack SevenCrapples = new ItemStack(Material.GOLDEN_APPLE, 7);
	
	ItemStack Bow = new ItemStack(Material.BOW);
	ItemStack SixteenArrows = new ItemStack(Material.ARROW, 16);
	ItemStack TwoStacksofArrows = new ItemStack(Material.ARROW, 128);
	
	ItemStack XPBottle = new ItemStack(Material.EXP_BOTTLE, 12);
	
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (!e.getInventory().getName().equalsIgnoreCase(inv.getName())) return;
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Fighter")) {
			e.setCancelled(true);
			e.getWhoClicked().getInventory().setHelmet(IronHelmet);
			e.getWhoClicked().getInventory().setChestplate(IronChestplate);
			e.getWhoClicked().getInventory().setLeggings(IronLeggings);
			e.getWhoClicked().getInventory().setBoots(IronBoots);
			e.getWhoClicked().getInventory().addItem(DiamondSword);
			e.getWhoClicked().getInventory().addItem(FiveCrapples);
			e.getWhoClicked().getInventory().addItem(Bow);
			e.getWhoClicked().getInventory().addItem(SixteenArrows);
			e.getWhoClicked().getInventory().addItem(XPBottle);
			e.getWhoClicked().closeInventory();
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Archer")) {
			e.setCancelled(true);
			e.getWhoClicked().getInventory().setHelmet(IronHelmet);
			e.getWhoClicked().getInventory().setChestplate(IronChestplate);
			e.getWhoClicked().getInventory().setLeggings(IronLeggings);
			e.getWhoClicked().getInventory().setBoots(IronBoots);
			e.getWhoClicked().getInventory().addItem(IronSword);
			e.getWhoClicked().getInventory().addItem(SevenCrapples);
			e.getWhoClicked().getInventory().addItem(Bow);
			e.getWhoClicked().getInventory().addItem(TwoStacksofArrows);
			e.getWhoClicked().getInventory().addItem(XPBottle);
			e.getWhoClicked().closeInventory();
		}		
	}	
}