package com.nort721.gen;

import javax.swing.*;

public final class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        EncryptionKeyGenerator encryptionKeyGenerator = new EncryptionKeyGenerator();
        encryptionKeyGenerator.start();
    }


}
