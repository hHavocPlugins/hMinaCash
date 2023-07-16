package hMinaCash.hMina;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class hPlayerQuitListener implements Listener{

	@EventHandler
	void Listener(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		if (hMinaDataBase.containsPlayer(p)) {
			hMinaDataBase.removePlayer(p);
			p.getInventory().setItem(4, null);
		}
		
	}
	
}
