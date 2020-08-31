package ubiquitaku.joingive;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class Joingive extends JavaPlugin implements Listener {
    FileConfiguration config;


    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        config = getConfig();
        getServer().getPluginManager().registerEvents(this,this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void join(PlayerJoinEvent e) {
        if (config.contains(e.getPlayer().getName())) {
            return;
        }
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta b = (BookMeta) book.getItemMeta();
        b.addPage("§a§lうんこ\nにゃあ\nヽ(ﾟ∀｡)ﾉｳｪ");
        b.addPage("((┗(┏ヽ ՞ةڼ◔`┛)┓))ア゛ア゛ア゛ア゛ア゛ア゛ア");
        b.setTitle("読んでね(⋈◍＞◡＜◍)。✧♡");
        b.setAuthor(e.getPlayer().getName());
        book.setItemMeta(b);
        e.getPlayer().getInventory().addItem(book);
        config.set(e.getPlayer().getName(),"にゃあ");
        System.out.println("うんこ");
        e.getPlayer().sendMessage("うんこ");
    }
}
