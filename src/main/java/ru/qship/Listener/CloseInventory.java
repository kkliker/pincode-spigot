package ru.qship.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import ru.qship.qSosatChlenOsla;

public class CloseInventory implements Listener {

    qSosatChlenOsla ChlenOsla = qSosatChlenOsla.getPlugin(qSosatChlenOsla.class);

    @EventHandler
    public void playercloseinvntory(InventoryCloseEvent e){

        Player p = (Player) e.getPlayer();

        new BukkitRunnable() {
            @Override
            public void run() {

        if(!(p.getOpenInventory().getTitle().substring(0,8).equals(ChatColor.BLACK + "Пин-Ко"))){


            ChlenOsla.hashMap.remove(p);

                }

            }
        }.runTaskLater(qSosatChlenOsla.getPlugin(qSosatChlenOsla.class),5L);


    }

    @EventHandler
    public void leaveevent(PlayerQuitEvent e){

        Player p = e.getPlayer();

                ChlenOsla.hashMap.remove(p);


    }

}
