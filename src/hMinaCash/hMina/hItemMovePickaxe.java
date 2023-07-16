package hMinaCash.hMina;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class hItemMovePickaxe implements Listener {

	@EventHandler
	void Listener(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (hMinaDataBase.containsPlayer(p)) {
			e.setCancelled(true);
		}
 	}

}


