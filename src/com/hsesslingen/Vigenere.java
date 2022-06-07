package com.hsesslingen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

public class Vigenere {


    public static void crypt() throws IOException {
        Path path = Path.of("C:\\Users\\levin\\Desktop\\Lab-Cryptography\\vigenere.txt");
        String rawContent = Files.readString(path);
        String content = rawContent.toUpperCase(Locale.ROOT).replaceAll("[^\\p{L}]", "");
        String encryptedText = "";

        int contentLength = content.length();

        System.out.println(content);
        System.out.println("Enter LEVINKERSCHBERGER as key or some other UPPERCASE letters to encrypt");
        Scanner scanner = new Scanner(System.in);
        String KEY = scanner.nextLine();
        String KEY_MULTIPLE = "";

        for(int i = 0; i < contentLength; i++) {
            KEY_MULTIPLE += KEY.charAt(i % KEY.length());
        }

        for(int i = 0; i < contentLength; i++) {
            // converting in range 0-25
            int x = (content.charAt(i) + KEY_MULTIPLE.charAt(i)) %26;
            // convert into Upper-Letters
            x += 'A';
          encryptedText += (char) x;

       }
        System.out.println(encryptedText);
        TextAnalyse.analyse(encryptedText);
    }


}
