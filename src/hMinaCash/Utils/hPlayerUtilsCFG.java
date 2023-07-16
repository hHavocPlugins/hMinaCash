package hMinaCash.Utils;

import org.bukkit.entity.Player;

import hMinaCash.Configs.hPlayerCFG;

public class hPlayerUtilsCFG {

	public static int getTempo(Player p) {
		return hPlayerCFG.get().getInt(p.getName() + ".tempo");
	}
	
	public static void setTempo(Player p, int quantidade) {
		 hPlayerCFG.get().set(p.getName() + ".tempo", quantidade);
		 hPlayerCFG.save();
	}
	
	public static double getDrops(Player p) {
		return hPlayerCFG.get().getDouble(p.getName() + ".Drops");
	}

	public static void setDrops(Player p, double d) {
		 hPlayerCFG.get().set(p.getName() + ".Drops", d);
		 hPlayerCFG.save();
	}
	
	public static int getEffiencia(Player p) {
		return hPlayerCFG.get().getInt(p.getName() + ".effiencia");
	}
	
	public static void setEffiencia(Player p, int quantidade) {
		 hPlayerCFG.get().set(p.getName() + ".effiencia", quantidade);
		 hPlayerCFG.save();
	}
	
	public static int getFortuna(Player p) {
		return hPlayerCFG.get().getInt(p.getName() + ".fortuna");
	}
	
	public static void setFortuna(Player p, int quantidade) {
		 hPlayerCFG.get().set(p.getName() + ".fortuna", quantidade);
		 hPlayerCFG.save();
	}
	
	public static int getBlocos(Player p) {
		return hPlayerCFG.get().getInt(p.getName() + ".blocos");
	}
	
	public static void setBlocos(Player p, int quantidade) {
		 hPlayerCFG.get().set(p.getName() + ".blocos", quantidade);
		 hPlayerCFG.save();
	}
	
}
