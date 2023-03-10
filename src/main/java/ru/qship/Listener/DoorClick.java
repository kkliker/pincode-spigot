package ru.qship.Listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Openable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import ru.qship.qSosatChlenOsla;

public class DoorClick implements Listener {

    qSosatChlenOsla ChlenOsla = qSosatChlenOsla.getPlugin(qSosatChlenOsla.class);



    @EventHandler
    public void interactdoor(PlayerInteractEvent e){

        testcommand test = new testcommand();

        if(e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getHand() == EquipmentSlot.HAND){


            Block block = e.getClickedBlock();

            if(block != null){
                if (block.getType() == Material.IRON_DOOR || block.getType() == Material.IRON_TRAPDOOR){


                    if(ChlenOsla.getConfig().contains(block.getLocation().toString())) {


                        BlockState state = e.getClickedBlock().getState();

                        Openable openable = (Openable) state.getBlockData();

                        if(openable.isOpen()) {

                            openable.setOpen(false);
                            state.setBlockData((BlockData) openable);
                            state.update();

                        }
                        else {

                            ChlenOsla.hashMap.put(e.getPlayer(), e.getClickedBlock());


                            test.openInventory(ChatColor.BLACK + "Пин-Код: «____»", e.getPlayer());

                        }

                    }


                }




            }

        }


    }



}
