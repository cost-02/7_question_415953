package com.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hash {
    public static String generateMD5(String input) {
        try {
            // Crea l'istanza MessageDigest per MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            // Aggiorna il digest usando l'array di byte della stringa
            md.update(input.getBytes());
            
            // Completa il calcolo del hash e ritorna l'array di byte
            byte[] digest = md.digest();
            
            // Converti l'array di byte in una stringa esadecimale
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String text = "Esempio di stringa";
        String md5Hash = generateMD5(text);
        System.out.println("L'hash MD5 della stringa è: " + md5Hash);
    }
}
