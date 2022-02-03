package fun.tbcraft.tbcenchantments.Interfaces;

import fun.tbcraft.tbcenchantments.Main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class InventoryHandler implements Listener {
    private Main plugin;
    public InventoryHandler(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;

        ItemMeta meta = event.getCurrentItem().getItemMeta();
        PersistentDataContainer container = meta.getPersistentDataContainer();
        String tag = container.get(new NamespacedKey(plugin, "tag"), PersistentDataType.STRING);

        if (tag == null) return;

        if (tag.equals("immovable")) {
            event.setCancelled(true);
        }

        if (meta.getDisplayName().contains("Start")) {
            event.getWhoClicked().sendMessage("Starting item");
        }
    }

    @EventHandler
    public void onMoveItem(InventoryClickEvent event) {
        if (!event.getView().getTitle().contains("Custom Anvil")) return;

        if (event.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY) {
            if (event.getCurrentItem().getType() == Material.LAPIS_LAZULI) {
                if (event.getClickedInventory().getType() == InventoryType.PLAYER) {
                    event.setCancelled(true);
                    ItemStack item = event.getCurrentItem();
                    item.setAmount(event.getCurrentItem().getAmount());
                    event.setCurrentItem(null);
                    event.getInventory().setItem(21, item);
                }
            }
        }
    }

}
