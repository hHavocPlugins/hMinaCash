package hMinaCash.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import hMinaCash.Main;
import hMinaCash.Configs.hLocationCFG;
import hMinaCash.Utils.Item_Plugin;

public class hMinaCashAdminCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (cmd.getName().equalsIgnoreCase("minacashadmin")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				
				if (!p.hasPermission("hminacash.admin")) {
					p.sendMessage("§6MINA CASH => §aVoce nao tem permissao para executar esse comando !");
					return true;
				}
				
				if (args.length == 0) {
					p.sendMessage("   §eLista de §6Comandos");
					p.sendMessage("");
					p.sendMessage("§e/minacashadmin setar <spawn/saida>");
					p.sendMessage("§e/minacashadmin give <jogador> <quantia>");
					p.sendMessage("§e/minacashadmin reload");
					p.sendMessage("");
					return true;
				}
				
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("setar")) {
						p.sendMessage("§6MINA CASH => §aUse /minacashadmin setar <spawn/saida>");
						return true;
					}else if (args[0].equalsIgnoreCase("reload")) {
						p.sendMessage("§6MINA CASH => §aPlugin foi recarregado com sucesso !");
						Main.getInstance().reloadConfig();
						return true;
					}else {
						p.sendMessage("§6MINA CASH => §aComando Invalido");
						return true;
					}
				}
				
				if (args.length == 2) {
					if (args[0].equalsIgnoreCase("setar")) {
						if (args[1].equalsIgnoreCase("spawn")) {
							hLocationCFG.get().set("spawn.setada", true);
							hLocationCFG.get().set("spawn.loc", p.getLocation());
							hLocationCFG.save();
							p.sendMessage("§6MINA CASH => §aLocal 'spawn' setado com sucesso");
							return true;
						}else if (args[1].equalsIgnoreCase("saida")) {
							hLocationCFG.get().set("saida.setada", true);
							hLocationCFG.get().set("saida.loc", p.getLocation());
							hLocationCFG.save();
							p.sendMessage("§6MINA CASH => §aLocal 'saida' setado com sucesso");
							return true;
						}else {
							p.sendMessage("§6MINA CASH => §aComando Invalido");
							return true;
						}
					}else {
						p.sendMessage("§6MINA CASH => §aComando Invalido");
						return true;
					}
				}
				
				if (args.length == 3) {
					if (args[0].equalsIgnoreCase("give")) {
						Player target = Bukkit.getPlayerExact(args[1]);
						
						if (target == null) {
							p.sendMessage("§6MINA CASH => §aJogador invalido !");
							return true;
						}else {
							
							try {
								int quantia = Integer.valueOf(args[2]);
								
								p.sendMessage("§6MINA CASH => §aVoce givou o §7Tempo de §6MINA CASH§fx" + quantia  + " §apara o jogador §f" + target.getName());
								Item_Plugin.add_Item_Tempo(target, quantia);
								
							}catch (NumberFormatException e) {
								p.sendMessage("§6MINA CASH => §aO Agurmento esta invalido !");
								return true;
							}
						}
					}
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
