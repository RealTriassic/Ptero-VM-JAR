package com.triassic.pterovm;

public class InstallerThread extends Thread {
    public void run() {
        try {

            // This is the command that will be executed on server start-up.
            String[] startCommand = { "bash", "installer.sh" };

            // Create the ProcessBuilder for our installerProcess.
            ProcessBuilder installerProcess = new ProcessBuilder(startCommand);

            // Inherit installerProcess's input and output and block the thread to "wait" for the file to "finish" executing.
            installerProcess.inheritIO();
            installerProcess.start().waitFor();

        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}
