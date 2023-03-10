package ru.qship.Listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Openable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import ru.qship.qSosatChlenOsla;

import java.util.Set;

public class InventoryMaster implements Listener {

    qSosatChlenOsla ChlenOsla = qSosatChlenOsla.getPlugin(qSosatChlenOsla.class);
    DoorClick doorClick = new DoorClick();

    @EventHandler
    public void inventoryclick(InventoryClickEvent e) {



        testcommand items = new testcommand();


        StringBuilder pincodename = new StringBuilder(e.getView().getTitle());

        Player p = (Player) e.getWhoClicked();


        if (pincodename.toString().length() == 17) {
            e.setCancelled(true);

            if (e.getCurrentItem() != null) {
                if (e.getCurrentItem().getType() != Material.BLACK_STAINED_GLASS_PANE) {


                    ItemStack clicked = e.getCurrentItem();

                    Set<Material> NullSet = null;

                    Block block = p.getTargetBlock(NullSet, 5);
                    String code = ChlenOsla.getConfig().getString(block.getLocation().toString());

                    if (!(clicked.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Принять")) && !(clicked.getItemMeta().getDisplayName().equals(ChatColor.RED + "Отклонить"))) {

                        String clickedname = clicked.getItemMeta().getDisplayName();

                        for (int i = 0; i < pincodename.length(); i++) {

                            if (pincodename.charAt(i) == '_') {


                                pincodename.setCharAt(i, clickedname.charAt(2));
                                items.openInventory(pincodename.toString(), p);
                                break;

                            }

                        }

                    } else if (clicked.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Принять")) {


                        String num1 = String.valueOf(pincodename.charAt(12));
                        String num2 = String.valueOf(pincodename.charAt(13));
                        String num3 = String.valueOf(pincodename.charAt(14));
                        String num4 = String.valueOf(pincodename.charAt(15));


                        String pass = num1 + num2 + num3 + num4;

                        p.closeInventory();


                        if (pass.equals(code)) {

                            

                            BlockState state = ChlenOsla.hashMap.get(p).getState();
                            Openable openable = (Openable) state.getBlockData();

                            openable.setOpen(!openable.isOpen());

                            state.setBlockData((BlockData) openable);
                            state.update();

                            new BukkitRunnable() {
                                @Override
                                public void run() {

                                    Openable openable = (Openable) state.getBlockData();

                                    if (openable.isOpen()) {
                                        openable.setOpen(!openable.isOpen());

                                        state.setBlockData((BlockData) openable);
                                        state.update();
                                    }

                                }
                            }.runTaskLater(qSosatChlenOsla.getPlugin(qSosatChlenOsla.class), 300L);


                        }

                    } else {

                        p.closeInventory();

                    }


                }
            }
        }
    }





}







