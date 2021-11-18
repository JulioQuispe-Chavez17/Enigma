package io.vallegrande.pe;



public class Utilities {
    public String rotate(String originalChain, int rotations) {
        // En ASCII, la a es 97, b 98, A 65, B 66, etcétera
        final int ALPHABET_LENGTH = 26, INIT_MINUSCULES = 97, INIT_CAPITAL = 65;
        String rotatedChain = ""; // La cadena nueva, la que estará rotada
        for (int x = 0; x < originalChain.length(); x++) {
          char currentCharacter = originalChain.charAt(x);
          // Si no es una letra del alfabeto entonces ponemos el char tal y como está
          // y pasamos a la siguiente iteración
          if (!Character.isLetter(currentCharacter)) {
            rotatedChain += currentCharacter;
            continue;
          }
      
          int currentAsciiCode = (int) currentCharacter;
          boolean isCapitalized = Character.isUpperCase(currentCharacter);
      
          // La posición (1 a 26) que ocupará la letra después de ser rotada
          // El % LONGITUD_ALFABETO se utiliza por si se pasa de 26. Por ejemplo,
          // la "z", al ser rotada una vez da el valor de 27, pero en realidad debería
          // regresar a la letra "a", y con mod hacemos eso ya que 27 % 26 == 1,
          // 28 % 26 == 2, etcétera ;)
          int newAlphabetPosition = ((currentAsciiCode
              - (isCapitalized ? INIT_CAPITAL : INIT_MINUSCULES)) + rotations) % ALPHABET_LENGTH;
          // Arreglar rotaciones negativas
          if (newAlphabetPosition < 0)
          newAlphabetPosition += ALPHABET_LENGTH;
          int newAsciiPosition = (isCapitalized ? INIT_CAPITAL : INIT_MINUSCULES) + newAlphabetPosition;
          // Convertir el código ASCII numérico a su representación como símbolo o letra y
          // concatenar
          rotatedChain += Character.toString((char) newAsciiPosition);
        }
        return rotatedChain;
      }
}
