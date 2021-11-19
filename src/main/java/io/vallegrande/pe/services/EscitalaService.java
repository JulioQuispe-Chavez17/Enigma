package io.vallegrande.pe.services;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.vallegrande.pe.utils.EncryptedEscitala;

@Singleton
public class EscitalaService {
    @Inject
    EncryptedEscitala util;

    public String encrypt(String chain, int columns) {
        return util.cipher(chain, columns);
    }

    public String decipher(String chain, int columns) {
        return util.decoded(chain, columns);
    }
}
