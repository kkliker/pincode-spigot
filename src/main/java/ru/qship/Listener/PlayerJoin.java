package ru.qship.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.qship.qSosatChlenOsla;

import java.io.IOException;

public class PlayerJoin implements Listener {


    qSosatChlenOsla qsosat = qSosatChlenOsla.getPlugin(qSosatChlenOsla.class);

    @EventHandler
    public void playereblan(PlayerJoinEvent e) throws IOException {


        Player p = e.getPlayer();


        /*File f =new File("/home/container/plugins/OpenRP/descriptions/userdata.yml");
        FileConfiguration fg = new YamlConfiguration();


        fg.load(f);

        Player player = e.getPlayer();

        String name = fg.getString(player.getUniqueId().toString() + ".Имя");
        String suname = fg.getString(player.getUniqueId().toString() + ".Фамилия");
*/





            for(int i = 0;; i++) {


                Object num = qsosat.getConfig().get(String.valueOf(i));

                if (num == null){

                    qsosat.getConfig().set(String.valueOf(i) + ".name", p.getName());
                    qsosat.saveConfig();
                    break;

                }
            }







    }

}
