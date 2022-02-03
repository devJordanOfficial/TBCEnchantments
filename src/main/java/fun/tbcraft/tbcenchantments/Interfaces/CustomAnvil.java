package fun.tbcraft.tbcenchantments.Interfaces;

import fun.tbcraft.tbcenchantments.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class CustomAnvil {
    private Main plugin;
    public CustomAnvil(Main plugin) {
        this.plugin = plugin;
    }

    Inventory inv;

    private void createInv() {
        inv = Bukkit.createInventory(null, 45, "Custom Anvil");
        initializeItems();
    }

    private void initializeItems() {
        ItemStack item = new ItemStack(Material.MAGENTA_STAINED_GLASS_PANE);
        ItemMeta meta = item.getItemMeta();

        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(new NamespacedKey(plugin, "tag"), PersistentDataType.STRING, "immovable");

        meta.setDisplayName(plugin.format("&7↓ Item ↓"));
        item.setItemMeta(meta);
        inv.setItem(10, item);
        meta.setDisplayName(plugin.format("&7↑ Item ↑"));
        item.setItemMeta(meta);
        inv.setItem(28, item);

        item.setType(Material.PURPLE_STAINED_GLASS_PANE);
        meta.setDisplayName(plugin.format("&7↓ Scroll ↓"));
        item.setItemMeta(meta);
        inv.setItem(11, item);
        meta.setDisplayName(plugin.format("&7↑ Scroll ↑"));
        item.setItemMeta(meta);
        inv.setItem(29, item);

        item.setType(Material.BLUE_STAINED_GLASS_PANE);
        meta.setDisplayName(plugin.format("&7↓ Lapis ↓"));
        item.setItemMeta(meta);
        inv.setItem(12, item);
        meta.setDisplayName(plugin.format("&7↑ Lapis ↑"));
        item.setItemMeta(meta);
        inv.setItem(30, item);

        item.setType(Material.YELLOW_STAINED_GLASS_PANE);
        meta.setDisplayName(plugin.format("&7↓ Output ↓"));
        item.setItemMeta(meta);
        inv.setItem(16, item);
        meta.setDisplayName(plugin.format("&7↑ Output ↑"));
        item.setItemMeta(meta);
        inv.setItem(34, item);

        item.setType(Material.RED_STAINED_GLASS_PANE);
        meta.setDisplayName(plugin.format("&r"));
        item.setItemMeta(meta);
        inv.setItem(23, item);

        item.setType(Material.BLACK_STAINED_GLASS_PANE);
        item.setItemMeta(meta);

        for (int i = 0; i < inv.getSize(); i++) {
            ItemStack slot = inv.getItem(i);

            if (i == 19 || i == 20 || i == 21 || i == 25) continue;

            if (slot == null)
                inv.setItem(i, item);
        }
    }

    public void open(Player player) {
        createInv();
        player.openInventory(inv);
    }

}
