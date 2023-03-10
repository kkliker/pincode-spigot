package ru.qship.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.qship.qSosatChlenOsla;

public class AddPassToDoor implements CommandExecutor {


    qSosatChlenOsla ChlenOsla = qSosatChlenOsla.getPlugin(qSosatChlenOsla.class);

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        Player p = (Player) commandSender;

        if (p.isOp()) {

            Block b = p.getTargetBlock(null, 5);

            if ((b.getType() == Material.IRON_DOOR || b.getType() == Material.IRON_TRAPDOOR) && strings.length != 0) {


                ChlenOsla.getConfig().set(b.getLocation().toString(), strings[0]);
                ChlenOsla.saveConfig();

                p.sendMessage("Succesfully add pass to door | " + strings[0]);

            } else {
                p.sendMessage("Error");

            }

        }
            return true;
        }

}
