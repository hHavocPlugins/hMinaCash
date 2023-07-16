package hMinaCash.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import hMinaCash.Utils.hInventarioAPI;

public class hMinaCashCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("minacash")) {
			
			if (sender instanceof Player) {
				Player p = (Player) sender;
				
				if (args.length == 0) {
					hInventarioAPI.hMinaCashCMD(p);
					return true;
				}
				
			}else {
				Bukkit.getConsoleSender().sendMessage("");
				Bukkit.getConsoleSender().sendMessage("§6[hMinaCash] §eApenas jogadores pode executar esse Comando");
				Bukkit.getConsoleSender().sendMessage("");
			}
		}
		return false;
	}
}