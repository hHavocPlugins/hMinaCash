package hMinaCash.hMina;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import hMinaCash.Main;

public class hBlockCommands implements Listener {

	@EventHandler
	void Listener(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		
		ArrayList<String> list = new ArrayList<>(Main.getInstance().getConfig().getStringList("ComandosPermitidos"));
		if (hMinaDataBase.containsPlayer(p)) {
			for (String cmd : list) {
				if (e.getMessage().contains(cmd)) {
					e.setCancelled(false);
					return;
				}else {
					e.setCancelled(true);
					p.sendMessage("§cVoce nao pode executar ese comando aqui !");
					return;
				}
			}
		}
	}
}
