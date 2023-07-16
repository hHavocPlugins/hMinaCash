package hMinaCash.hMina;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class hPickupandDropListener implements Listener {

	@EventHandler
	void Listener(PlayerPickupItemEvent e) {
		Player p = e.getPlayer();
		if (hMinaDataBase.containsPlayer(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	void Listener(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if (hMinaDataBase.containsPlayer(p)) {
			e.setCancelled(true);
		}
	}
}
