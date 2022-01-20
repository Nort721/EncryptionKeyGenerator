package com.nort721.gen;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

public class EncryptionKeyGenerator extends JFrame {

    private SecureRandom rnd;
    private JTextField textField;

    public void start() {
        rnd = new SecureRandom();
        buildGUI();
        setVisible(true);

        // generate a 128 key on launch
        generateKey(128);
    }

    private void buildGUI() {

        setResizable(false);
        setTitle("EncryptionKeyGenerator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jPanel = new JPanel();
        jPanel.removeAll();
        setBounds(150, 150, 385, 130);
        jPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(jPanel);
        jPanel.setLayout(null);

        int buttonsHeight = 55;

        textField = new JTextField();
        textField.setBounds(75, 20, 250, 20);
        jPanel.add(textField);
        //textField.setEditable(false);
        textField.setColumns(10);

        JButton gen64Btn = new JButton("64-Bit");
        gen64Btn.setBounds(10, buttonsHeight, 80, 28);
        jPanel.add(gen64Btn);
        gen64Btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                generateKey(64);
            }
        });

        JButton gen128Btn = new JButton("128-Bit");
        gen128Btn.setBounds(100, buttonsHeight, 80, 28);
        jPanel.add(gen128Btn);
        gen128Btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                generateKey(128);
            }
        });

        JButton gen256Btn = new JButton("256-Bit");
        gen256Btn.setBounds(190, buttonsHeight, 80, 28);
        jPanel.add(gen256Btn);
        gen256Btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                generateKey(256);
            }
        });

        JButton gen512Btn = new JButton("512-Bit");
        gen512Btn.setBounds(280, buttonsHeight, 80, 28);
        jPanel.add(gen512Btn);
        gen512Btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                generateKey(512);
            }
        });
    }

    private void generateKey(int size) {
        String key = generateKeyString(size);
        textField.setText(key);
        copyToClipboard(key);
    }

    private String generateKeyString(int size) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (size / 8); i++) {
            char let = alphabet[rnd.nextInt(alphabet.length)];
            sb.append(rnd.nextInt() % 2 == 0 ? Character.toUpperCase(let) : let);
        }
        return sb.toString();
    }

    private void copyToClipboard(String str) {
        StringSelection stringSelection = new StringSelection(str);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
