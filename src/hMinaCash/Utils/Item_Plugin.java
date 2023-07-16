package hMinaCash.Utils;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Item_Plugin {

	public static void add_Item_Tempo(Player p, int quantia) {
		@SuppressWarnings("deprecation")
		ItemStack item = new ItemStack(Material.getMaterial(347), quantia);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName("§7Tempo de §6MINA CASH");
		ArrayList<String> item_lore = new ArrayList<>();
		item_lore.add("");
		item_lore.add("§7Utilize esse item para adquir tempo na §6MINA CASH");
		item_lore.add("§7Tempo: 30 Segundos");
		item_lore.add("");
		itemm.setLore(item_lore);
		item.setItemMeta(itemm);
		p.getInventory().addItem(item);
	}
	
	public static void Picareta(Player p) {
		ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName("§6Picareta");
		ArrayList<String> item_lore = new ArrayList<>();
		item_lore.add("");
		item_lore.add("§7Minere com a sua picareta para receber drops");
		item_lore.add("");
		itemm.setLore(item_lore);
		if (hPlayerUtilsCFG.getEffiencia(p) > 0) {
			itemm.addEnchant(Enchantment.DIG_SPEED, hPlayerUtilsCFG.getEffiencia(p), true);
		}
		
		if (hPlayerUtilsCFG.getFortuna(p) > 0) {
			itemm.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, hPlayerUtilsCFG.getFortuna(p), true);
		}
		
		item.setItemMeta(itemm);
		p.getInventory().setItem(4, item);
	}
	
}
