package fun.tbcraft.tbcenchantments;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Scrolls {

    private Main plugin;
    public Scrolls(Main plugin) {
        this.plugin = plugin;
    }

    public ItemStack getCommonScroll() {
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(plugin.format("&fEnchantment Scroll"));
        meta.setCustomModelData(1000000);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getUncommonScroll() {
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(plugin.format("&fEnchantment Scroll"));
        meta.setCustomModelData(1100000);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getRareScroll() {
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(plugin.format("&fEnchantment Scroll"));
        meta.setCustomModelData(1200000);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getEpicScroll() {
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(plugin.format("&fEnchantment Scroll"));
        meta.setCustomModelData(1300000);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getMythicalScroll() {
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(plugin.format("&fEnchantment Scroll"));
        meta.setCustomModelData(1400000);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getLegendaryScroll() {
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(plugin.format("&fEnchantment Scroll"));
        meta.setCustomModelData(1500000);
        meta.addEnchant(CustomEnchantment.TELEPATHY, 1, true);
        item.setItemMeta(meta);

        return item;
    }

}
