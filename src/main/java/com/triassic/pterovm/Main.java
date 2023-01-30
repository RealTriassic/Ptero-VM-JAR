package com.triassic.pterovm;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

import com.triassic.pterovm.handlers.FileDownloader;
import com.triassic.pterovm.handlers.Log;
import com.triassic.pterovm.handlers.RandomNameGen;
import org.yaml.snakeyaml.Yaml;

public class Main {
    private static final Yaml yaml = new Yaml();
    private static final String randomName = RandomNameGen.generate() + ".sh";

    public static void main(String[] args) throws IOException {
        Config.createConfig();
        Config.loadConfig();

        InputStream localFile = Files.newInputStream(new File("config.yml").toPath());
        HashMap<String, Object> localData = yaml.load(localFile);

        File customScript = new File((String) localData.get("filename"));
        final String fileUrl = (String) localData.get("url");

        if (!customScript.exists()) {
            FileDownloader.downloadFile(fileUrl, randomName);
        }

        LinkedHashMap <String, Object> startupMessages = (LinkedHashMap <String, Object>) localData.get("startup_messages");

        List<String> text = (List <String>) startupMessages.get("text");
        Boolean toggle = (Boolean) startupMessages.get("enabled");

        if (toggle.equals(true)) {
            for (String msg : text) {
                Log.info(msg);
            }
        }

        try {
            InstallerThread installProcess = new InstallerThread();
            installProcess.start();
        } catch (Exception error) {
            Log.severe("Failed to start installer thread.");
            error.printStackTrace();
        }
    }

    public static String randomName() {
        return randomName;
    }

    public static class Config {
        public static void createConfig() {
            File configFile = new File("config.yml");
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("config.yml");

            if (!configFile.exists()) {
                try {
                    Files.copy(Objects.requireNonNull(inputStream), configFile.toPath());
                } catch (IOException error) {
                    System.out.println("Failed to create configuration file.");
                    error.printStackTrace();

                    System.exit(0);
                }
            }
        }

        public static void loadConfig() throws IOException {
            Yaml yaml = new Yaml();
            InputStream jarFile = Main.class.getClassLoader().getResourceAsStream("config.yml");
            InputStream localFile = Files.newInputStream(new File("config.yml").toPath());

            HashMap<String, Object> jarData = yaml.load(jarFile);
            HashMap<String, Object> localData = yaml.load(localFile);

            if(!Objects.equals(localData.get("config_version").toString(), jarData.get("config_version").toString())) {
                System.out.println("Your config.yml is outdated, delete it and start the server.");
                System.out.println("Your configuration is made for version " + localData.get("config_version") + ". Latest config version is " + jarData.get("config_version") + ".");
                System.exit(0);
            }
        }
    }
}