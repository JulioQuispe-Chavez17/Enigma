package io.vallegrande.pe.services;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.vallegrande.pe.utils.EncryptedVernam;

@Singleton
public class VernamService {

    @Inject
    EncryptedVernam util;

    public String generateKeys(String chain, String keyword) {
        return util.generateKey(chain, keyword);
    }

    public String encrypt(String chain, String key) {
        return util.cipherText(chain, key);
    }

    public String decipher(String chain, String key) {
        return util.originalText(chain, key);
    }
}
