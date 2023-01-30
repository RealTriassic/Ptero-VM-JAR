package com.triassic.pterovm.handlers;

import java.util.Random;

public class RandomNameGen {
    private static final int NAME_LENGTH = 32;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String generate() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NAME_LENGTH; i++) {
            sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }
}