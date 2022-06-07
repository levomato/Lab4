package com.hsesslingen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class TextAnalyse {
    public static void analyse() throws IOException {
        Path path = Path.of("C:\\Users\\levin\\Desktop\\Lab-Cryptography\\vigenere.txt");
        String rawContent = Files.readString(path);
        String content = rawContent.toLowerCase(Locale.ROOT).replaceAll("[^\\p{L}]", "");
        int length = content.length();

        int[] freq = new int[content.length()];
        System.out.println("The entered string is "+content);
        //Convert the given string into character array
        char charContent[] = content.toCharArray();
        for(int i = 0; i <content.length(); i++)
        {
            freq[i] = 1;
            for(int j = i+1; j <content.length(); j++)
            {
                if(charContent[i] == charContent[j])
                {
                    freq[i]++;
                    // jeder Buchstabe ist nachdem beide for-loops durchgelaufen sind nur noch einmal im String
                    charContent[j] = '0';
                }
            }
        }

        for(int i = 0; i <freq.length; i++)
        {
            if(charContent[i] != ' ' && charContent[i] != '0')
                System.out.format("Der Buchstabe %s kommt mit der Häufigkeit %f%% %d mal vor \n",charContent[i], ((float)freq[i] / (float)length * 100),freq[i]);
        }
    }

    public static void analyse(String encryptedText) throws IOException {

        String rawContent = encryptedText;
        String content = rawContent.toLowerCase(Locale.ROOT).replaceAll("[^\\p{L}]", "");
        int length = content.length();

        int[] freq = new int[content.length()];
        System.out.println("The entered string is "+content);
        //Convert the given string into character array
        char charContent[] = content.toCharArray();
        for(int i = 0; i <content.length(); i++)
        {
            freq[i] = 1;
            for(int j = i+1; j <content.length(); j++)
            {
                if(charContent[i] == charContent[j])
                {
                    freq[i]++;

                    // jeder Buchstabe ist nachdem beide for-loops durchgelaufen sind nur noch einmal im String
                    charContent[j] = '0';
                }
            }
        }

        for(int i = 0; i <freq.length; i++)
        {
            if(charContent[i] != ' ' && charContent[i] != '0')
                System.out.format("Der Buchstabe %s kommt mit der Häufigkeit %f%% %d mal vor \n",charContent[i], ((float)freq[i] / (float)length * 100),freq[i]);
        }
    }
}
