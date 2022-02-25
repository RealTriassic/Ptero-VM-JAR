package com.triassic.pterovm;

import java.io.File;

public class InstallerThread extends Thread {
    public void run() {
        try {

            // Initialize the startCommand string to later modify it in an if-else statement.
            String[] startCommand;

            // Check if custom.sh file exists.
            File customScript = new File("custom.sh");

            if (customScript.exists()) {

                System.out.println("Found custom.sh file, loading from custom.sh...");

                // Send special ANSI codes to center cursor, also known as "clearing console screen".
                System.out.print("\033[H\033[2J");
                System.out.flush();

                // Define the new startCommand for loading custom.sh
                startCommand = new String[] { "bash", "custom.sh" };

            } else {

                System.out.println("No custom.sh file was found, loading from installer.sh...");

                // Send special ANSI codes to center cursor, also known as "clearing console screen".
                System.out.print("\033[H\033[2J");
                System.out.flush();

                // Define the new startCommand for loading installer.sh
                startCommand = new String[] { "bash", "installer.sh" };

            }

            // Create the ProcessBuilder for our script file.
            ProcessBuilder installerProcess = new ProcessBuilder(startCommand);

            // Inherit installerProcess's input and output and block the thread to "wait" for the file to "finish" executing.
            installerProcess.inheritIO();
            installerProcess.start().waitFor();

        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}