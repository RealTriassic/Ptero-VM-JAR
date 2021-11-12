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
            String[] curl_cmd = {"curl", "-o", "installer.sh", "https://raw.githubusercontent.com/afnan007a/Ptero-vm/main/installer.sh" };
            ProcessBuilder curl = new ProcessBuilder(curl_cmd);
            System.out.print("\033[H\033[2J");
            System.out.println("Downloading Installer.sh from Ptero-VM's GitHub...");
            curl.start().waitFor();

            // Starts the installer
            String[] installer_cmd = {"bash", "installer.sh"};
            ProcessBuilder installer = new ProcessBuilder(installer_cmd);
            installer.inheritIO();

            System.out.print("\033[H\033[2J");
            System.out.flush();

            installer.start().waitFor();
         } catch (Exception e) {
            e.printStackTrace();
        }
    }
}