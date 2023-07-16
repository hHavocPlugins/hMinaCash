package hMinaCash;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import hMinaCash.Comandos.hMinaCashAdminCMD;
import hMinaCash.Comandos.hMinaCashCMD;
import hMinaCash.Configs.hLocationCFG;
import hMinaCash.Configs.hPlayerCFG;
import hMinaCash.Eventos.RegisterListener;
import hMinaCash.Eventos.hMinaCashListener;
import hMinaCash.Eventos.hTempoInteractListener;
import hMinaCash.hMina.PicaretaInvListener;
import hMinaCash.hMina.PicaretaUpgradeClickEventListener;
import hMinaCash.hMina.hBlockCommands;
import hMinaCash.hMina.hItemDurability;
import hMinaCash.hMina.hItemMovePickaxe;
import hMinaCash.hMina.hMinaBlockbreakListener;
import hMinaCash.hMina.hPlayerQuitListener;

public class Main  extends JavaPlugin {

	public static PluginManager pm = Bukkit.getPluginManager();
	private static Main main;
	public static Main getInstance() {
		return main;
	}
	
	@Override
	public void onEnable() {
		main = this;
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§6[hMinaCash] §ePlugin esta sendo iniciado");
		Bukkit.getConsoleSender().sendMessage("");
		
		Eventos();
		Comandos(); 
		saveDefaultConfig();
		hLocationCFG.setup();
		hPlayerCFG.setup();
		
	}
	
	void Comandos() {
		getCommand("minacash").setExecutor(new hMinaCashCMD());
		getCommand("minacashadmin").setExecutor(new hMinaCashAdminCMD());
	}
	
	void Eventos() {
		pm.registerEvents(new hMinaCashListener(), this);
		pm.registerEvents(new RegisterListener(), this);
		pm.registerEvents(new hItemMovePickaxe(), this);
		pm.registerEvents(new hMinaBlockbreakListener(), this);
		pm.registerEvents(new hItemDurability(), this);
		pm.registerEvents(new hTempoInteractListener(), this);
		pm.registerEvents(new PicaretaInvListener(), this);
		pm.registerEvents(new PicaretaUpgradeClickEventListener(), this);
		pm.registerEvents(new hPlayerQuitListener(), this);
		pm.registerEvents(new hBlockCommands(), this);
	}
	
	@Override
	public void onDisable() {
		main = null;
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§6[hMinaCash] §ePlugin esta sendo desligado");
		Bukkit.getConsoleSender().sendMessage("");
	}
	
}
