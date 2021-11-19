package io.vallegrande.pe.services;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.vallegrande.pe.utils.EncryptedCesar;

@Singleton
public class CesarService {

  @Inject
  EncryptedCesar util;

  public String encrypt(String message) {
    return util.rotate(message, 3);
  }

  public String decipher(String message) {
    return util.rotate(message, -3);
  }

}
