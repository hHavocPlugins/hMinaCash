package hMinaCash.Eventos;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import hMinaCash.Utils.hPlayerUtilsCFG;

public class hTempoInteractListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	void Listener(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if (p.getItemInHand().hasItemMeta()) {
			if (p.getItemInHand().getItemMeta().hasDisplayName()) {
				if (p.getItemInHand().getType() == Material.getMaterial(347)) {
					if (p.getItemInHand().getItemMeta().getDisplayName().equals("§7Tempo de §6MINA CASH")) {
						if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
							
							hPlayerUtilsCFG.setTempo(p, hPlayerUtilsCFG.getTempo(p) + 30);
							
							if (p.getItemInHand().getAmount() > 1) {
								p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
							}else {
								p.setItemInHand(null);
							}
							
							p.sendMessage("§6MINA CASH => §aAtivou 30 segundos de tempo na §6MINA CASH");
							e.setCancelled(true);		
							}
						}
					}
				}
			}
	}
}
