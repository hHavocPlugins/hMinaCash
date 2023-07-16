package hMinaCash.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import hMinaCash.Main;
import hMinaCash.Configs.hLocationCFG;
import hMinaCash.Utils.ActionBar;
import hMinaCash.Utils.Item_Plugin;
import hMinaCash.Utils.hPlayerUtilsCFG;
import hMinaCash.hMina.hMinaDataBase;

public class hMinaCashListener implements Listener{

	static int task_x;
	
	@EventHandler
	void Listener(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("§7Mina de Cash")) {
			e.setCancelled(true);
			
			if (e.getCurrentItem().hasItemMeta()) {
				if (e.getCurrentItem().getItemMeta().hasDisplayName()) {
					
					if (e.getCurrentItem().getType() == Material.SPRUCE_DOOR_ITEM) {
						
						if (hLocationCFG.get().get("spawn.setada") == null) {
							p.sendMessage("§6MINA CASH => §aEssa area ainda nao foi setada !");
							p.closeInventory();
							return;
						}else if (hLocationCFG.get().getBoolean("spawn.setada") == true) {
							
							if (hMinaDataBase.containsPlayer(p)) {
								if (hLocationCFG.get().get("saida.setada") == null) {
									p.kickPlayer("§6MINA CASH => §aSeu Saiu da §6MINA CASH");
									p.closeInventory();
									return;
								}else if (hLocationCFG.get().getBoolean("saida.setada") == true) {
									p.sendMessage("§6MINA CASH => §aVoce foi telesportado com sucesso ao spawn !");
					            	p.teleport((Location) hLocationCFG.get().get("saida.loc"));
					            	hMinaDataBase.removePlayer(p);
					            	p.getInventory().setItem(4, null);
								}
								Bukkit.getScheduler().cancelTask(task_x);
							}else {
								
						            boolean isEmpty = true;
						            for (ItemStack item : p.getInventory().getContents()) {
						                if(item != null) {
						                    isEmpty = false;
						                    break;
						                }
						            }
						            if(isEmpty) {
						            	
										if (!(hPlayerUtilsCFG.getTempo(p) > 0)) {
											p.sendMessage("§6MINA CASH => §aVoce nao possui tempo parar minerar na §6MINA CASH");
											p.closeInventory();
											return;
										}else {
											
											task_x = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
												
												@Override
												public void run() {
												
													if (!p.isOnline()) {
														Bukkit.getScheduler().cancelTask(task_x);
													}
													
													if (hPlayerUtilsCFG.getTempo(p) > 0) {
														int tempo_result = hPlayerUtilsCFG.getTempo(p) - 1;
														ActionBar.sendActionText(p, "§6MINA CASH => §fTempo: §6" + hPlayerUtilsCFG.getTempo(p) + " §fsegundos");
														hPlayerUtilsCFG.setTempo(p, tempo_result);
													}else if (hPlayerUtilsCFG.getTempo(p) <= 0) {
														if (hLocationCFG.get().get("saida.setada") == null) {
															p.kickPlayer("§6MINA CASH => §aSeu tempo de minerar acabou !");
															p.closeInventory();
											            	p.getInventory().setItem(4, null);
															return;
														}else if (hLocationCFG.get().getBoolean("saida.setada") == true) {
															p.sendMessage("§6MINA CASH => §aVoce foi telesportado com sucesso ao spawn !");
											            	p.teleport((Location) hLocationCFG.get().get("saida.loc"));
											            	hMinaDataBase.removePlayer(p);
											            	p.getInventory().setItem(4, null);
														}
														Bukkit.getScheduler().cancelTask(task_x);
													}
												}
											}, 0, 20);
											
											p.sendMessage("§6MINA CASH => §aVoce foi telesportado com sucesso a nossa mina !");
							            	p.teleport((Location) hLocationCFG.get().get("spawn.loc"));
							            	Item_Plugin.Picareta(p);
							            	p.closeInventory();
							            	hMinaDataBase.addPlayer(p);
										}
						            	return;
						            }else {
									   p.sendMessage("§6MINA CASH => §aLimpe seu inventario primeiro !!");
							           p.closeInventory();
							           return;
						            }
								}
							}
						}
					
						if (e.getCurrentItem().getType() == Material.SKULL_ITEM)  {
							if (hPlayerUtilsCFG.getDrops(p) <= 0) {
								p.sendMessage("§6MINA CASH => §aVoce nao possui drops minerados !");
								p.closeInventory();
								return;
							}else {
								p.sendMessage("§6MINA CASH => §aVoce recolheu o seus Drops minerados !!");
								Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.getInstance().getConfig().getString("ComandoCash").replace("@player", p.getName()).replace("@quantia", "" + hPlayerUtilsCFG.getDrops(p)));
								hPlayerUtilsCFG.setDrops(p, 0);
								p.closeInventory();
								return;
							}
						}
					
						p.closeInventory();
					}
				}
			}
		}
	}
