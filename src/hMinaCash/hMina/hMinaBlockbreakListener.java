package hMinaCash.hMina;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import hMinaCash.Main;
import hMinaCash.Utils.ActionBar;
import hMinaCash.Utils.hPlayerUtilsCFG;

public class hMinaBlockbreakListener implements Listener {

	int blockBreak;
	
	@EventHandler
	void Listener(BlockBreakEvent e)  {
		Player p = e.getPlayer();
		if (hMinaDataBase.containsPlayer(p)) {
			if (e.getBlock().getType() == Material.GOLD_BLOCK || e.getBlock().getType() == Material.GOLD_ORE) {
				Material block = e.getBlock().getType();
				
				e.setCancelled(true);
				e.getBlock().setType(Material.AIR);
				blockBreak = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
					
					@Override
					public void run() {
						e.getBlock().setType(block);
					}
				}, 60*20);
				
				hPlayerUtilsCFG.setBlocos(p, hPlayerUtilsCFG.getBlocos(p) + 1);
				double calc = 0;
				if (hPlayerUtilsCFG.getFortuna(p) > 0) {
					calc = Main.getInstance().getConfig().getInt("Picareta.CashQuedaAoMinerar") * hPlayerUtilsCFG.getFortuna(p);
				}else {
					calc = Main.getInstance().getConfig().getInt("Picareta.CashQuedaAoMinerar");
				}
				
				if (calc < 1000) {
					ActionBar.sendActionText(p, "§6MINA CASH => §aAdicionado: §6"+ calc +  " §aDrops");
				}else if (calc >= 1000 && calc <= 1000000) {
					int result = (int) (calc / 1000);
					ActionBar.sendActionText(p, "§6MINA CASH => §aAdicionado: §6"+ result +  "k §aDrops");
				}else if (calc >= 1000000 && calc <= 1000000000) {
					int result = (int) (calc / 1000000);
					ActionBar.sendActionText(p, "§6MINA CASH => §aAdicionado: §6"+ result +  "M §aDrops");
				}else if (calc >= 1000000000 && calc <= 1000000000000.0) {
					int result = (int) (calc / 1000000000);
					ActionBar.sendActionText(p, "§6MINA CASH => §aAdicionado: §6"+ result +  "B §aDrops");
				}else if (calc >= 1000000000000.0 && calc <= 100000000000000.0) {
					int result = (int) (calc / 1000000000000.0);
					ActionBar.sendActionText(p, "§6MINA CASH => §aAdicionado: §6"+ result +  "T §aDrops");
				}
				
				hPlayerUtilsCFG.setDrops(p, hPlayerUtilsCFG.getDrops(p) + calc);
			}else {
				e.setCancelled(true);
			}
		}
	}
	
}
