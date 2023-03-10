package ru.qship.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import ru.qship.qSosatChlenOsla;

public class InteractEntity implements Listener {

    testcommand test = new testcommand();
    qSosatChlenOsla ChlenOsla = qSosatChlenOsla.getPlugin(qSosatChlenOsla.class);

    @EventHandler
    public void h(PlayerInteractEntityEvent e){

        if(e.getRightClicked() instanceof ItemFrame){

            ItemFrame frame = (ItemFrame) e.getRightClicked();


            ItemStack stack = frame.getItem();



            MapMeta meta = (MapMeta) stack.getItemMeta();

            if(meta != null) {

                if (meta.getMapId() == 6666) {

                    test.openInventory(ChatColor.BLACK + "Пин-Код: «____»", e.getPlayer());


                }

            }

        }


    }

}
