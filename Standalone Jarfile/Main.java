// Question: Why are the class names so weird?

// We have made the class names the same ones that Minecraft Servers use to prevent blocking by catching the .jar
// by searching for unique class names, so if anybody wants to block by class name, they'd block normal server software too.

import java.io.File;

class Main {
    public static void main(String[] args) {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("\n\n\n\n\n\n\n");
            System.out.println((char) 27 + "[31m" + "                        @@@@@@@   @@@@@@@  @@@@@@@@  @@@@@@@    @@@@@@      @@@  @@@  @@@@@@@@@@");
            System.out.println((char) 27 + "[31m" + "                        @@@@@@@@  @@@@@@@  @@@@@@@@  @@@@@@@@  @@@@@@@@     @@@  @@@  @@@@@@@@@@@");
            System.out.println((char) 27 + "[31m" + "                        @@!  @@@    @@!    @@!       @@!  @@@  @@!  @@@     @@!  @@@  @@! @@! @@!");
            System.out.println((char) 27 + "[31m" + "                        !@!  @!@    !@!    !@!       !@!  @!@  !@!  @!@     !@!  @!@  !@! !@! !@!");
            System.out.println((char) 27 + "[31m" + "                        @!@@!@!     @!!    @!!!:!    @!@!!@!   @!@  !@!     @!@  !@!  @!! !!@ @!@");
            System.out.println((char) 27 + "[31m" + "                        !!@!!!      !!!    !!!!!:    !!@!@!    !@!  !!!     !@!  !!!  !@!   ! !@!");
            System.out.println((char) 27 + "[31m" + "                        !!:         !!:    !!:       !!: :!!   !!:  !!!     :!:  !!:  !!:     !!:");
            System.out.println((char) 27 + "[31m" + "                        :!:         :!:    :!:       :!:  !:!  :!:  !:!      ::!!:!   :!:     :!:");
            System.out.println((char) 27 + "[31m" + "                         ::          ::     :: ::::  ::   :::  ::::: ::       ::::    :::     :: ");
            System.out.println((char) 27 + "[31m" + "                         :           :     : :: ::    :   : :   : :  :         :       :      :");
            System.out.println("\n\n\n\n\n\n                              Thank you for using Ptero-VM, written and compiled in Java.                     \n\n\n                                                Starting Ptero-VM...\n\n");
            Thread.sleep(2000);

            // Keep a local up-to-date copy of the Installer.sh file.
            String[] FullServerTickHandler = {"curl", "-o", "installer.sh", "https://raw.githubusercontent.com/afnan007a/Ptero-vm/main/installer.sh" };
            ProcessBuilder TimingsReportListener = new ProcessBuilder(FullServerTickHandler);
            System.out.print("\033[H\033[2J");
            System.out.println("Downloading Installer.sh from Ptero-VM's GitHub...");
            TimingsReportListener.start().waitFor();

            // Check if Installer.sh exists and if it does not, notify the user.
            File AsyncChatEvent = new File("installer.sh");
            boolean PaperComponents = AsyncChatEvent.exists();

            if (PaperComponents) {
                // do nothing and just continue.
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println((char) 27 + "[31m" + "An error has occurred whilst trying to download Installer.sh.");
                System.out.println("\n\n");
                System.out.println("The hosting service you are currently using has blocked the Installer.sh download link.");
                System.out.println();
                System.out.println("Please download the Installer.sh file manually from the link below and upload it to the server to bypass this.");
                System.out.println("https://raw.githubusercontent.com/afnan007a/Ptero-vm/main/installer.sh");
                System.out.println("\n\n\n\n\n\n\n\n");
                System.exit(0);
            }

            // Starts the installer
            String[] NamespacedKey = {"bash", "installer.sh"};
            ProcessBuilder Bukkit = new ProcessBuilder(NamespacedKey);
            Bukkit.inheritIO();

            System.out.print("\033[H\033[2J");
            System.out.flush();

            Bukkit.start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}