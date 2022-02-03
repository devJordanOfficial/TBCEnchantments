package fun.tbcraft.tbcenchantments;

import fun.tbcraft.tbcenchantments.Interfaces.CustomAnvil;
import fun.tbcraft.tbcenchantments.Interfaces.InventoryHandler;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Main extends JavaPlugin {

    Scrolls scrolls;

    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new JoinEvent(), this);
        pm.registerEvents(new InventoryHandler(this), this);

        CustomEnchantment.register();
        scrolls = new Scrolls(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (label.equalsIgnoreCase("test")) {
            Player player = (Player) sender;
            Inventory inv = player.getInventory();
            inv.addItem(scrolls.getCommonScroll());
            inv.addItem(scrolls.getUncommonScroll());
            inv.addItem(scrolls.getRareScroll());
            inv.addItem(scrolls.getEpicScroll());
            inv.addItem(scrolls.getMythicalScroll());
            inv.addItem(scrolls.getLegendaryScroll());
            return true;
        }

        if (label.equalsIgnoreCase("anvil")) {
            CustomAnvil anvil = new CustomAnvil(this);
            anvil.open((Player) sender);
        }

        return false;
    }

    public String format(String message) {
        final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

        Matcher matcher = pattern.matcher(message);
        while (matcher.find()) {
            String color = message.substring(matcher.start(), matcher.end());
            message = message.replace(color, ChatColor.of(color) + "");
            CharSequence input;
            matcher = pattern.matcher(message);
        }

        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
