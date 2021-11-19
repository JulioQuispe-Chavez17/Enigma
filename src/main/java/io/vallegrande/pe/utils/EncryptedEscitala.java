package io.vallegrande.pe.utils;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EncryptedEscitala {
    private int row;
    private String messages;

    public String cipher(String message, int columns) {
        message.toUpperCase();
        setRow(calculateRow(columns, message.length()));
        setMessages(message);
        int currentRow = getRow();
        var currentMatrix = matrix(message, getRow(), columns);
        String messageEncrypt = "";
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < currentRow; i++) {
                messageEncrypt += currentMatrix[i][j];
            }
        }
        return messageEncrypt.toString().trim();
    }

    // Not use message
    public String decoded(String message, int columns) {
        int currentRow = getRow();
        var currentMatrix = matrix(getMessages(), currentRow, columns);
        String messageDecoded = "";

        for (int i = 0; i < currentRow; i++) {
            for (int j = 0; j < columns; j++) {
                messageDecoded += currentMatrix[i][j];
            }
        }

        return messageDecoded.trim();

    }

    private char[][] matrix(String chain, int rows, int column) {
        char[][] initMatrix = new char[rows][column];
        int counter = 0;
        char[] text = chain.toCharArray();
        char Null = ' ';
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                initMatrix[i][j] = counter < text.length ? text[counter] : Null;
                counter++;
            }
        }
        return initMatrix;
    }

    public int calculateRow(int columns, int sizeMessage) {
        return sizeMessage % columns == 0 ? sizeMessage / columns : sizeMessage / columns + 1;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

}
