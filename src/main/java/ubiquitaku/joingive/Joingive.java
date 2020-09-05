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
        b.addPage("(旧)オーコの十戒\n" +
                "1.おこが唯一の神であること\n" +
                "2.偶像を作ってはならない\n" +
                "3.おこの名をみだりに唱えてはならない\n" +
                "4.安息日を取らない\n" +
                "5.おこを敬うこと\n" +
                "6.汝、殺すことなかれ\n" +
                "7.かすれていて読めない…\n" +
                "8.汝、盗むことなかれ\n" +
                "9.おこについて偽証してはいけない\n" +
                "10.おこの財産をむさぼってはならない\n");
        b.addPage("崇めよ称えよ敬え崇拝せよ\n" +
                "おこは絶対無二の唯一神な\n" +
                "り。\n" +
                "常にあなたを見ています。\n" +
                "あなたの隣人としてそこに\n" +
                "居ます。愛しなさい。");
        b.addPage("(新)オーコの十戒\n" +
                "1.私のほかに神があってはならない。(takaronix以外の神の禁止)\n" +
                "2.あなたの神、主の名をみだりに唱えてはならない。(メンションの禁止)\n" +
                "3.主の日を心にとどめ、これを聖とせよ。(適切な休憩)\n" +
                "4.あなたの父兄を敬え。(親と仲良く)\n");
        b.addPage("5.殺してはならない。(PKの禁止)\n" +
                "6.彼女を作ってはならない、。(不純異性交遊の禁止)\n" +
                "7.盗んではならない。(窃盗行為の禁止)\n" +
                "8.隣人に関して偽証してはならない。(荒らしの禁止)\n");
        b.addPage("全てを守れぬものは、神の怒りがその身に落ちるであろう。\n" +
                "神はあなたと共にいつもそこにあります。\n" +
                "信じなさい、崇めなさい。\n" +
                "称えなさい、愛しなさい。");
        b.setTitle("§c§kaaa§r§c§lおーこの十戒§r§c§kaaa§r");
        b.setAuthor(e.getPlayer().getName());
        book.setItemMeta(b);
        e.getPlayer().getInventory().addItem(book);
        config.set(e.getPlayer().getName(),"にゃあ");
        saveConfig();
        System.out.println("うんこ");
        e.getPlayer().sendMessage("うんこ");
    }
}
