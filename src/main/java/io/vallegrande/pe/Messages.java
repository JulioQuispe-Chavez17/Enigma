package io.vallegrande.pe;

import java.io.Serializable;

public class Messages implements Serializable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
     
}
