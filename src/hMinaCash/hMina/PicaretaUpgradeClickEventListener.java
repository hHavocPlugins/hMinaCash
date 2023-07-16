package hMinaCash.hMina;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import hMinaCash.Main;
import hMinaCash.Utils.Item_Plugin;
import hMinaCash.Utils.hPlayerUtilsCFG;

public class PicaretaUpgradeClickEventListener implements Listener {

	@EventHandler
	void Listener(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("§6PICARETA")) {
			e.setCancelled(true);
			int efficiencia_preço = 0;
			if (!(hPlayerUtilsCFG.getEffiencia(p) > 0)) {
				efficiencia_preço = Main.getInstance().getConfig().getInt("Picareta.PrecoInicialEfficiencia");
			}else {
				efficiencia_preço = Main.getInstance().getConfig().getInt("Picareta.PrecoInicialEfficiencia") * hPlayerUtilsCFG.getEffiencia(p);
			}
			
			int fortuna_preço = 0;
			if (!(hPlayerUtilsCFG.getFortuna(p) > 0)) {
				fortuna_preço = Main.getInstance().getConfig().getInt("Picareta.PrecoInicialFortuna");
			}else {
				fortuna_preço = Main.getInstance().getConfig().getInt("Picareta.PrecoInicialFortuna") * hPlayerUtilsCFG.getFortuna(p);
			}
			
			if (e.getCurrentItem().getType() == Material.BOOK) {
				
				if (e.getSlot() == 12) {
					
					if (!(hPlayerUtilsCFG.getEffiencia(p) >= Main.getInstance().getConfig().getInt("Picareta.MaximoEficiencia"))) {
						if (hPlayerUtilsCFG.getBlocos(p) < efficiencia_preço) {
							p.sendMessage("§6MINA CASH => §aVoce nao tem blocos suficientes");
							return;
						}
						
						if (hPlayerUtilsCFG.getBlocos(p) >= efficiencia_preço) {
							p.sendMessage("§6MINA CASH => §aVoce melhorou um nivel de efficiencia");
							int result = (int) (hPlayerUtilsCFG.getDrops(p) - efficiencia_preço);
							int result_2 = hPlayerUtilsCFG.getEffiencia(p) + 1;
							hPlayerUtilsCFG.setBlocos(p, result);
							hPlayerUtilsCFG.setEffiencia(p, result_2);
							Item_Plugin.Picareta(p);
							p.closeInventory();
							return;
						}
					}else {
						p.sendMessage("§6MINA CASH => §aVoce ja esta no level maximo de efficiencia");
						return;
					}
					
					
				}
				
				if (e.getSlot() == 14) {
					if (!(hPlayerUtilsCFG.getEffiencia(p) >= Main.getInstance().getConfig().getInt("Picareta.MaximoFortuna"))) {
						if (hPlayerUtilsCFG.getBlocos(p) < fortuna_preço) {
							p.sendMessage("§6MINA CASH => §aVoce nao tem blocos suficientes");
							return;
						}
						
						if (hPlayerUtilsCFG.getBlocos(p) >= fortuna_preço) {
							p.sendMessage("§6MINA CASH => §aVoce melhorou um nivel de fortuna");
							int result = (int) (hPlayerUtilsCFG.getDrops(p) - fortuna_preço);
							int result_2 = hPlayerUtilsCFG.getFortuna(p) + 1;
							hPlayerUtilsCFG.setBlocos(p, result);
							hPlayerUtilsCFG.setFortuna(p, result_2);
							Item_Plugin.Picareta(p);
							p.closeInventory();
							return;
						}
					}else {
						p.sendMessage("§6MINA CASH => §aVoce ja esta no level maximo de fortuna");
						return;
					}
				}
				
			}
			
		}
	}
	
}
