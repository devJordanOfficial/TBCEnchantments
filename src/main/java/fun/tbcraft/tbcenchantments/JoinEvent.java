package fun.tbcraft.tbcenchantments;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().setResourcePack("https://www.dropbox.com/sh/t3tche1su4r2ldk/AACwL0G9hKPeyL3mz4YOiiTPa?dl=1");
    }

}
