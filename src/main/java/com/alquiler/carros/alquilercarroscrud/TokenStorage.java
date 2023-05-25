package com.alquiler.carros.alquilercarroscrud;

import java.security.SecureRandom;

import static org.apache.xalan.xsltc.compiler.Constants.CHARACTERS;


public class TokenStorage {

    public static String TOKEN = "";
    private static final int TOKEN_LENGTH = 60;

    public static void generateToken() {
        StringBuilder token = new StringBuilder();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < TOKEN_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            token.append(randomChar);
        }

        TOKEN = token.toString();
    }

}
