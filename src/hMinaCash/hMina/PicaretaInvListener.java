package hMinaCash.hMina;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import hMinaCash.Utils.hInventarioAPI;


public class PicaretaInvListener implements Listener {

	@EventHandler
	void Listener(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if (p.getItemInHand().hasItemMeta()) {
			if (p.getItemInHand().getItemMeta().hasDisplayName()) {
				if (p.getItemInHand().getType() == Material.DIAMOND_PICKAXE) {
					if (p.getItemInHand().getItemMeta().getDisplayName().equals("§6Picareta")) {
						if (hMinaDataBase.containsPlayer(p)) {
							if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
								hInventarioAPI.hPicaretaInv(p);
							}
						}
					}
				}
			}
		}
	}
}
					
