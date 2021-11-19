package io.vallegrande.pe.utils;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EncryptedCesar {
  public String rotate(String originalChain, int rotations) {
    originalChain.toUpperCase();
    final int ALPHABET_LENGTH = 26, INIT_MINUSCULES = 97, INIT_CAPITAL = 65;
    String rotatedChain = "";
    for (int x = 0; x < originalChain.length(); x++) {
      char currentCharacter = originalChain.charAt(x);
      if (!Character.isLetter(currentCharacter)) {
        rotatedChain += currentCharacter;
        continue;
      }

      int currentAsciiCode = (int) currentCharacter;
      boolean isCapitalized = Character.isUpperCase(currentCharacter);

      int newAlphabetPosition = ((currentAsciiCode - (isCapitalized ? INIT_CAPITAL : INIT_MINUSCULES)) + rotations)
          % ALPHABET_LENGTH;
      // Arreglar rotaciones negativas
      if (newAlphabetPosition < 0)
        newAlphabetPosition += ALPHABET_LENGTH;
      int newAsciiPosition = (isCapitalized ? INIT_CAPITAL : INIT_MINUSCULES) + newAlphabetPosition;

      rotatedChain += Character.toString((char) newAsciiPosition);
    }
    return rotatedChain.trim();
  }
}
