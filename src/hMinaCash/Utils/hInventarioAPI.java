package hMinaCash.Utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import hMinaCash.Main;

public class hInventarioAPI {

	static String Cash_skull_item = "http://textures.minecraft.net/texture/cb067ae612d5256a24ccfc74c11814f01962b4d81817a618134b45f36fe6fcb3";
	
	public static void hPicaretaInv(Player p) {
		Inventory inv = Bukkit.createInventory(p, 4*9, "§6PICARETA");
		
		int efficiencia_preço = 0;
		
		ItemStack picareta = new ItemStack(Material.BOOK);
		ItemMeta picaretam = picareta.getItemMeta();
		ArrayList<String> picareta_lore = new ArrayList<>();
		picareta_lore.add("");
		picareta_lore.add("§7Melhore esse encatamento");
		picareta_lore.add("§7para quebrar mais rapido !");
		if (!(hPlayerUtilsCFG.getEffiencia(p) > 0)) {
			efficiencia_preço = Main.getInstance().getConfig().getInt("Picareta.PrecoInicialEfficiencia");
		}else {
			efficiencia_preço = Main.getInstance().getConfig().getInt("Picareta.PrecoInicialEfficiencia") * hPlayerUtilsCFG.getEffiencia(p);
		}
		picareta_lore.add("§7Blocos necessarios: " + efficiencia_preço);
		picareta_lore.add("");
		picaretam.setDisplayName("§eEffiencia");
		picaretam.setLore(picareta_lore);
		picareta.setItemMeta(picaretam);
		
		inv.setItem(12, picareta);
		
		int fortuna_preço = 0;
		
		ItemStack fortuna = new ItemStack(Material.BOOK);
		ItemMeta fortunam = fortuna.getItemMeta();
		ArrayList<String> fortuna_lore = new ArrayList<>();
		fortuna_lore.add("");
		fortuna_lore.add("§7Melhore esse encatamento");
		fortuna_lore.add("§7para ganhar mais Drops");
		if (!(hPlayerUtilsCFG.getFortuna(p) > 0)) {
			fortuna_preço = Main.getInstance().getConfig().getInt("Picareta.PrecoInicialFortuna");
		}else {
			fortuna_preço = Main.getInstance().getConfig().getInt("Picareta.PrecoInicialFortuna") * hPlayerUtilsCFG.getFortuna(p);
		}
		fortuna_lore.add("§7Blocos necessarios: " + fortuna_preço);
		fortuna_lore.add("");
		fortunam.setDisplayName("§eFortuna");
		fortunam.setLore(fortuna_lore);
		fortuna.setItemMeta(fortunam);
		
		inv.setItem(14, fortuna);
		
		p.openInventory(inv);
	}
	
	@SuppressWarnings("deprecation")
	public static void hMinaCashCMD(Player p) {
		ActionBar.sendActionText(p, "§aVoce abriu o menu de §6§lMINA CASH §acom sucesso");
		Inventory inv = Bukkit.createInventory(p, 4*9, "§7Mina de Cash");
		
		ItemStack join = new ItemStack(Material.SPRUCE_DOOR_ITEM);
		ItemMeta joinm = join.getItemMeta();
		ArrayList<String> join_lore = new ArrayList<>();
		join_lore.add("");
		join_lore.add("§7Entre e minere §6cash §7em nossa Mina !");
		join_lore.add("");
		join_lore.add("§7Clique §aaqui §7para entrar");
		joinm.setDisplayName("§7Entrar");
		joinm.setLore(join_lore);
		join.setItemMeta(joinm);
		
		ItemStack tempo = new ItemStack(Material.getMaterial(347));
		ItemMeta tempom = tempo.getItemMeta();
		ArrayList<String> tempo_lore = new ArrayList<>();
		tempo_lore.add("");
		tempo_lore.add("§7Olhe o tempo que voce possui para minerar");
		tempo_lore.add("§7Tempo: §f" + hPlayerUtilsCFG.getTempo(p)  + " §7segundos");
		tempo_lore.add("");
		tempom.setDisplayName("§eTempo Disponivel:");
		tempom.setLore(tempo_lore);
		tempo.setItemMeta(tempom);
		
		ItemStack picareta = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta picaretam = picareta.getItemMeta();
		ArrayList<String> picareta_lore = new ArrayList<>();
		picareta_lore.add("");
		picareta_lore.add("  §7Effiencia: " + hPlayerUtilsCFG.getEffiencia(p));
		picareta_lore.add("  §7Fortuna: " + hPlayerUtilsCFG.getFortuna(p));
		picareta_lore.add("");
		picaretam.setDisplayName("§6PICARETA");
		picaretam.setLore(picareta_lore);
		picareta.setItemMeta(picaretam);
		
		
		inv.setItem(11, tempo);
		ArrayList<String> cash_skull_lore = new ArrayList<>();
		cash_skull_lore.add("");
		double drops = Double.valueOf(hPlayerUtilsCFG.getDrops(p));
		if (drops < 1000) {
			cash_skull_lore.add("§a| §fDrops: §6" + drops);
		}else if (drops >= 1000 && drops <= 1000000) {
			int result = (int) (drops / 1000);
			cash_skull_lore.add("§a| §fDrops: §6" + result + "k");
		}else if (drops >= 1000000 && drops <= 1000000000) {
			int result = (int) (drops / 1000000);
			cash_skull_lore.add("§a| §fDrops: §6" + result + "M");
		}else if (drops >= 1000000000 && drops <= 1000000000000.0) {
			int result = (int) (drops / 1000000000);
			cash_skull_lore.add("§a| §fDrops: §6" + result + "B");
		}else if (drops >= 1000000000000.0 && drops <= 100000000000000.0) {
			int result = (int) (drops / 1000000000000.0);
			cash_skull_lore.add("§a| §fDrops: §6" + result + "T");
		}
		cash_skull_lore.add("");
		inv.setItem(13, picareta);
		createSkull(p, inv, 15, Cash_skull_item, "§7Drops minerados", cash_skull_lore);
		inv.setItem(31, join);
		
		p.openInventory(inv);
	}
	
	@SuppressWarnings("unchecked")
	public static void createSkull(Player p,Inventory inv, int Slot, String url, String displayname,@SuppressWarnings("rawtypes") ArrayList lore) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setDisplayName(displayname);
        GameProfile profile = new GameProfile(UUID.randomUUID(), (String) null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));

        try {
            Field profileField = skullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(skullMeta, profile);
        } catch (Throwable var6) {
            var6.printStackTrace();
        }
        skullMeta.setLore(lore);
        skull.setItemMeta(skullMeta);
        inv.setItem(Slot, skull);
	}
	
}
