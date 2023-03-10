package ru.qship.Listener;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Objects;
import java.util.UUID;

public class testcommand  implements CommandExecutor {


    public ItemStack accept = getSkull("https://textures.minecraft.net/texture/a79a5c95ee17abfef45c8dc224189964944d560f19a44f19f8a46aef3fee4756");
    public ItemStack decline = getSkull("https://textures.minecraft.net/texture/27548362a24c0fa8453e4d93e68c5969ddbde57bf6666c0319c1ed1e84d89065");

    public ItemStack n0 = getSkull("https://textures.minecraft.net/texture/a3a487b1f81c9ecc6e18857c6566529e7efa23eef59814fe57d64df8e2cf1");

    public ItemStack n1 = getSkull("https://textures.minecraft.net/texture/bf61269735f1e446becff25f9cb3c823679719a15f7f0fbc9a03911a692bdd");

    public ItemStack n2 = getSkull("https://textures.minecraft.net/texture/7d81a32d978f933deb7ea26aa326e4174697595a426eaa9f2ae5f9c2e661290");

    public ItemStack n3 = getSkull("https://textures.minecraft.net/texture/ceadaded81563f1c87769d6c04689dcdb9e8ca01da35281cd8fe251728d2d");

    public ItemStack n4 = getSkull("https://textures.minecraft.net/texture/6c608c2db525d6d77f7de4b961d67e53e9d7bacdaff31d4ca10fbbf92d66");

    public ItemStack n5 = getSkull("https://textures.minecraft.net/texture/1144c5193435199c135bd47d166ef1b4e2d3218383df9d34e3bb20d9f8e593");

    public ItemStack n6 = getSkull("https://textures.minecraft.net/texture/f61f7e38556856eae5566ef1c44a8cc64af8f3a58162b1dd8016a8778c71c");

    public ItemStack n7 = getSkull("https://textures.minecraft.net/texture/6e1cf31c49a24a8f37849fc3c5463ab64cc9bceb6f276a5c44aedd34fdf520");

    public ItemStack n8 = getSkull("https://textures.minecraft.net/texture/61c9c09d52debc465c32542c68be42bda6f6753fe1deba257327ac5a0c3ad");

    public ItemStack n9 = getSkull("https://textures.minecraft.net/texture/2dcf39f4bcd98484b0b479a7992d9270fe3a59b9b1a806d7a64ffb5b551ad");


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        Player player = (Player) commandSender;


        return false;
    }

    public ItemStack getSkull(String url) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
        if (url.isEmpty()) return head;


        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;
        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e1) {
            e1.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }

    public void openInventory(String title, Player player) {

        ItemMeta declinemeta = decline.getItemMeta();
        declinemeta.setDisplayName(ChatColor.RED + "Отклонить");

        ItemMeta acceptmeta = accept.getItemMeta();
        acceptmeta.setDisplayName(ChatColor.GREEN + "Принять");

        ItemMeta n0meta = n0.getItemMeta();
        n0meta.setDisplayName(ChatColor.WHITE + "0");

        ItemMeta n1meta = n1.getItemMeta();
        n1meta.setDisplayName(ChatColor.WHITE + "1");

        ItemMeta n2meta = n2.getItemMeta();
        n2meta.setDisplayName(ChatColor.WHITE + "2");

        ItemMeta n3meta = n3.getItemMeta();
        n3meta.setDisplayName(ChatColor.WHITE + "3");

        ItemMeta n4meta = n4.getItemMeta();
        n4meta.setDisplayName(ChatColor.WHITE + "4");

        ItemMeta n5meta = n5.getItemMeta();
        n5meta.setDisplayName(ChatColor.WHITE + "5");

        ItemMeta n6meta = n6.getItemMeta();
        n6meta.setDisplayName(ChatColor.WHITE + "6");

        ItemMeta n7meta = n7.getItemMeta();
        n7meta.setDisplayName(ChatColor.WHITE + "7");

        ItemMeta n8meta = n8.getItemMeta();
        n8meta.setDisplayName(ChatColor.WHITE + "8");

        ItemMeta n9meta = n9.getItemMeta();
        n9meta.setDisplayName(ChatColor.WHITE + "9");

        n0.setItemMeta(n0meta);
        n1.setItemMeta(n1meta);
        n2.setItemMeta(n2meta);
        n3.setItemMeta(n3meta);
        n4.setItemMeta(n4meta);
        n5.setItemMeta(n5meta);
        n6.setItemMeta(n6meta);
        n7.setItemMeta(n7meta);
        n8.setItemMeta(n8meta);
        n9.setItemMeta(n9meta);

        accept.setItemMeta(acceptmeta);
        decline.setItemMeta(declinemeta);


        Inventory inv = Bukkit.createInventory(player, 54, title);


        for (int i = 0; i < 54; i++) {


            switch (i) {


                case 12:
                    inv.setItem(i, n1);
                    break;

                case 13:
                    inv.setItem(i, n2);
                    break;

                case 14:
                    inv.setItem(i, n3);
                    break;

                case 21:
                    inv.setItem(i, n4);
                    break;
                case 22:
                    inv.setItem(i, n5);
                    break;
                case 23:
                    inv.setItem(i, n6);
                    break;

                case 30:
                    inv.setItem(i, n7);
                    break;
                case 31:
                    inv.setItem(i, n8);
                    break;
                case 32:
                    inv.setItem(i, n9);
                    break;

                case 40:
                    inv.setItem(i, n0);
                    break;

                case 39:
                    inv.setItem(i, accept);
                    break;
                case 41:
                    inv.setItem(i, decline);
                    break;

                default:
                    inv.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
                    break;

            }

        }

        player.openInventory(inv);

    }


    public String hidestring(String string){


        StringBuilder builder = new StringBuilder();

        for(char c : string.toCharArray()){
            builder.append(ChatColor.COLOR_CHAR).append(c);
        }

        return builder.toString();

    }

}
