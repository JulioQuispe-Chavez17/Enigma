package io.vallegrande.pe.services;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.vallegrande.pe.utils.EncryptedCesar;
import io.vallegrande.pe.utils.EncryptedEscitala;
import io.vallegrande.pe.utils.EncryptedVernam;

@Singleton
public class ProductSystemService {

    @Inject
    EncryptedCesar cesar;

    @Inject
    EncryptedVernam vernam;

    @Inject
    EncryptedEscitala escitala;

    public String encrypt(String chain, String key, int columns, int rotations) {
        String encryptCesar = cesar.rotate(chain, rotations);
        String encryptVernam = vernam.cipherText(encryptCesar, key);
        String encryptEscitala = escitala.cipher(encryptVernam, columns);
        return encryptEscitala;
    }

    public String decoder(String chain, String key, int columns, int rotations) {
        String decoderEscitala = escitala.decoded(chain, columns);
        String decoderVernam = vernam.originalText(decoderEscitala, key);
        String decoderCesar = cesar.rotate(decoderVernam, -rotations);
        return decoderCesar;
    }

    public String generatedKey(String chain, String keyword) {
        return vernam.generateKey(chain, keyword);
    }
}
