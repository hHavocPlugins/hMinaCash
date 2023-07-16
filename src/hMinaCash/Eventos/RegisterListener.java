package hMinaCash.Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import hMinaCash.Configs.hPlayerCFG;

public class RegisterListener implements Listener {

	@EventHandler
	void Listener(PlayerJoinEvent e) {
		Player p = e.getPlayer();
	
		if (hPlayerCFG.get().get(p.getName() + ".Drops") == null) {
			hPlayerCFG.get().set(p.getName() + ".Drops", Float.valueOf(0));
			hPlayerCFG.save();
		}
	
		if (hPlayerCFG.get().get(p.getName() + ".effiencia") == null) {
			hPlayerCFG.get().set(p.getName() + ".effiencia", Float.valueOf(0));
			hPlayerCFG.save();
		}
		
		if (hPlayerCFG.get().get(p.getName() + ".fortuna") == null) {
			hPlayerCFG.get().set(p.getName() + ".fortuna", Float.valueOf(0));
			hPlayerCFG.save();
		}
	
		if (hPlayerCFG.get().get(p.getName() + ".tempo") == null) {
			hPlayerCFG.get().set(p.getName() + ".tempo", Float.valueOf(0));
			hPlayerCFG.save();
		}
		
		if (hPlayerCFG.get().get(p.getName() + ".blocos") == null) {
			hPlayerCFG.get().set(p.getName() + ".blocos", Float.valueOf(0));
			hPlayerCFG.save();
		}
		
	}
	
}
