package io.vallegrande.pe.utils;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EncryptedVernam {
    public String generateKey(String str, String key) {
        int x = str.length();
        String generatedKey = "";
        int count = 0;
        int idxKey = 0;
        while (count < x) {
            if (key.length() == idxKey) {
                idxKey = 0;
            }

            if (str.charAt(count) == ' ') {
                generatedKey += " ";
            } else {
                generatedKey += (key.charAt(idxKey));
                idxKey++;
            }

            count++;
        }
        return generatedKey.toUpperCase();
    }

    public String cipherText(String text, String key) {
        text.toUpperCase();
        // initializing cipherText
        String cipherText = "";

        int cipher[] = new int[key.length()];

        for (int i = 0; i < key.length(); i++) {
            cipher[i] = text.charAt(i) - 'A' + key.charAt(i) - 'A';
        }

        for (int i = 0; i < key.length(); i++) {
            if (cipher[i] > 25) {
                cipher[i] = cipher[i] - 26;
            }
        }

        for (int i = 0; i < key.length(); i++) {
            int x = cipher[i] + 'A';
            cipherText += (char) x;
        }

        return cipherText.trim();
    }

    public String originalText(String str, String key) {
        String plainText = "";
        str.toUpperCase();
        int plain[] = new int[key.length()];

        for (int i = 0; i < key.length(); i++) {
            plain[i] = str.charAt(i) - 'A' - (key.charAt(i) - 'A');
        }

        for (int i = 0; i < key.length(); i++) {
            if (plain[i] < 0) {
                plain[i] = plain[i] + 26;
            }
        }

        for (int i = 0; i < key.length(); i++) {
            int x = plain[i] + 'A';
            plainText += (char) x;
        }

        return plainText.trim();
    }

}
