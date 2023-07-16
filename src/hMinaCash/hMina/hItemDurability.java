package hMinaCash.hMina;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class hItemDurability  implements Listener {

	
	@EventHandler
	void Listener(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (hMinaDataBase.containsPlayer(p)) {
			if (p.getItemInHand().getType() == null || p.getItemInHand().getType() == Material.AIR) {
				return;
			}
			
			if (p.getItemInHand().getType() == Material.DIAMOND_PICKAXE) {			
				p.getItemInHand().setDurability((short) (p.getItemInHand().getDurability() - 1));
			}
			
		}
	}
}
