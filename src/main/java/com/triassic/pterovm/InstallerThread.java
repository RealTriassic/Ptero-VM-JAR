package com.triassic.pterovm;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;

public class InstallerThread extends Thread {
    public void run() {
        Yaml yaml = new Yaml();
        InputStream localFile;

        try {
            localFile = Files.newInputStream(new File("config.yml").toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HashMap<String, Object> localData = yaml.load(localFile);

        try {
            String[] startCommand;
            File customScript = new File((String) localData.get("filename"));

            if (customScript.exists()) {
                System.out.println("Found custom script file, loading from " + customScript + "...");
                startCommand = new String[] { "bash", String.valueOf(customScript)};
            } else {
                System.out.println("No custom script file was found, loading from local file...");
                startCommand = new String[] { "bash", Main.randomName() };
            }

            ProcessBuilder installerProcess = new ProcessBuilder(startCommand);
            installerProcess.inheritIO();
            installerProcess.start().waitFor();
        } catch (Exception error) {
            System.out.println("An error occurred in the InstallerThread thread.");
            error.printStackTrace();
        }
    }
}