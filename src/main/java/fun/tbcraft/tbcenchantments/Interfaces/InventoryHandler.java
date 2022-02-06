package fun.tbcraft.tbcenchantments.Interfaces;

import fun.tbcraft.tbcenchantments.Data.ItemDataType;
import fun.tbcraft.tbcenchantments.Data.ItemType;
import fun.tbcraft.tbcenchantments.Main;
import static org.bukkit.Material.*;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Arrays;

public class InventoryHandler implements Listener {
    private Main plugin;

    Material[] enchantableItems = {NETHERITE_HELMET, NETHERITE_CHESTPLATE, NETHERITE_LEGGINGS, NETHERITE_BOOTS,
    DIAMOND_HELMET, DIAMOND_CHESTPLATE, DIAMOND_LEGGINGS, DIAMOND_BOOTS, IRON_HELMET, IRON_CHESTPLATE, IRON_LEGGINGS,
    IRON_BOOTS, CHAINMAIL_HELMET, CHAINMAIL_CHESTPLATE, CHAINMAIL_LEGGINGS, CHAINMAIL_BOOTS, GOLDEN_HELMET,
    GOLDEN_CHESTPLATE, GOLDEN_LEGGINGS, GOLDEN_BOOTS, LEATHER_HELMET, LEATHER_CHESTPLATE, LEATHER_LEGGINGS,
    LEATHER_BOOTS, TURTLE_HELMET, NETHERITE_SWORD, DIAMOND_SWORD, IRON_SWORD, STONE_SWORD, GOLDEN_SWORD, WOODEN_SWORD,
    NETHERITE_PICKAXE, DIAMOND_PICKAXE, IRON_PICKAXE, STONE_PICKAXE, GOLDEN_PICKAXE, WOODEN_PICKAXE, NETHERITE_AXE,
    DIAMOND_AXE, IRON_AXE, STONE_AXE, GOLDEN_AXE, WOODEN_AXE, NETHERITE_SHOVEL, DIAMOND_SHOVEL, IRON_SHOVEL,
    STONE_SHOVEL, GOLDEN_SHOVEL, WOODEN_SHOVEL, NETHERITE_HOE, DIAMOND_HOE, IRON_HOE, STONE_HOE, GOLDEN_HOE,
    WOODEN_HOE, BOW, CROSSBOW, FISHING_ROD, TRIDENT, SHEARS, SHIELD, ELYTRA, FLINT_AND_STEEL, CARROT_ON_A_STICK,
    WARPED_FUNGUS_ON_A_STICK};

    ArrayList<Material> enchantable = new ArrayList<>();

    public InventoryHandler(Main plugin) {
        this.plugin = plugin;
        enchantable.addAll(Arrays.asList(enchantableItems));
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getCurrentItem() == null || event.getCurrentItem().getItemMeta() == null) return;

        ItemMeta meta = event.getCurrentItem().getItemMeta();
        PersistentDataContainer container = meta.getPersistentDataContainer();
        String tag = container.get(new NamespacedKey(plugin, "tag"), PersistentDataType.STRING);

        // If the item has the tag "immovable" (meaning it is a filler item) simply cancel the event
        if (tag == null) return;
        if (tag.equals("immovable")) {
            event.setCancelled(true);
        }

        if (!event.getView().getTitle().contains("Custom Anvil")) return;

        NamespacedKey itemTypeKey = new NamespacedKey(plugin, "type");
        ItemType itemType = container.get(itemTypeKey, new ItemDataType());


        // Handle the item being shift clicked into our inventory
        if (event.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY) {
            if (event.getClickedInventory().getType() == InventoryType.PLAYER) {
                event.setCancelled(true);
                if (event.getCurrentItem().getType() == Material.LAPIS_LAZULI) {
                    ItemStack item = event.getCurrentItem();
                    item.setAmount(event.getCurrentItem().getAmount());
                    event.setCurrentItem(null);
                    event.getInventory().setItem(21, item);
                }
                if (itemType == ItemType.ENCHANTMENT_SCROLL) {
                    ItemStack item = event.getCurrentItem();
                    item.setAmount(event.getCurrentItem().getAmount());
                    event.setCurrentItem(null);
                    event.getInventory().setItem(20, item);
                }
                if (enchantable.contains(event.getCurrentItem().getType())) {
                    ItemStack item = event.getCurrentItem();
                    item.setAmount(event.getCurrentItem().getAmount());
                    event.setCurrentItem(null);
                    event.getInventory().setItem(19, item);
                }
            }
        }
    }
}
