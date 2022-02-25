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

        try {

            // Download the latest Installer.sh file off of the source.
            File installerFile = new File("installer.sh");
            URL fetchFile = new URL("https://raw.githubusercontent.com/afnan007a/Ptero-vm/main/installer.sh");

            // Check if the Installer.sh file exists and if it does, skip the download, otherwise, download the file.
            if (!installerFile.exists()) {

                System.out.println("Downloading the Installer.sh file...");
                System.out.flush();

                ReadableByteChannel readableByteChannel = Channels.newChannel(fetchFile.openStream());

                try (FileOutputStream fos = new FileOutputStream(installerFile)) {
                    fos.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
                }

            } else {
                System.out.println("Skipping Installer.sh file download, file exists.");
                System.out.flush();
            }

        } catch (Exception error) {
            System.out.println("An error occurred whilst downloading installer.sh.");
            System.out.flush();

            error.printStackTrace();
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