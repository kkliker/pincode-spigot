package ru.qship;

import org.bukkit.block.Block;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import ru.qship.Listener.*;

import java.util.HashMap;

public class qSosatChlenOsla extends JavaPlugin {

  public  HashMap<Player, Block> hashMap = new HashMap<>();

    public  HashMap<Player, ItemFrame> hashMapmap = new HashMap<>();

    @Override
    public void onEnable() {

        getCommand("AddPassToDoor").setExecutor(new AddPassToDoor());

        getServer().getPluginManager().registerEvents(new InventoryMaster(),this);
        getServer().getPluginManager().registerEvents(new DoorClick(),this);
        getServer().getPluginManager().registerEvents(new CloseInventory(),this);

    }
}
