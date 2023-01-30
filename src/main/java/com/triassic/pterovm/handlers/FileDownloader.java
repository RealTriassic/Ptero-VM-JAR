package com.triassic.pterovm.handlers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class FileDownloader {
    public static void downloadFile(String fileUrl, String fileName) throws IOException {
        URL fetchFile = new URL(fileUrl);
        ReadableByteChannel readableByteChannel = Channels.newChannel(fetchFile.openStream());

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        } catch (Exception e) {
            Log.severe("Failed to download " + fileName + ".");
        }
    }
}