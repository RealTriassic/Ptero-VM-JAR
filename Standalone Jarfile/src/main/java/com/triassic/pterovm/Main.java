package com.triassic.pterovm;

import java.io.FileOutputStream;
import java.net.URL;
import java.io.File;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Main {
    public static void main(String[] args) {

        // Send special ANSI codes to center cursor, also known as "clearing console screen".
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Define the name for any custom scripts that can run instead of the normal installer.sh.
        File customScript = new File("custom.sh");

        // Download installer.sh if custom.sh does not exist.
        if (!customScript.exists()) {
            try {

                // Download the latest Installer.sh file off of the source.
                URL fetchFile = new URL("https://raw.githubusercontent.com/afnan007a/Ptero-vm/main/installer.sh");

                System.out.println("Downloading the Installer.sh file...");
                System.out.flush();

                ReadableByteChannel readableByteChannel = Channels.newChannel(fetchFile.openStream());

                try (FileOutputStream fos = new FileOutputStream("installer.sh")) {
                    fos.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
                }

            } catch (Exception error) {
                System.out.println("An error occurred whilst downloading installer.sh.");
                System.out.flush();

                error.printStackTrace();
            }
        }

        try {

            // Start our Installer thread off the main java thread.
            InstallerThread installProcess = new InstallerThread();
            installProcess.start();

        } catch (Exception error) {
            System.out.println("An error occurred whilst trying to start the Installer thread.");
            System.out.flush();

            error.printStackTrace();
        }
    }
}