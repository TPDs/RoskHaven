package com.company;


import javax.swing.*;
import java.awt.*;

public class GuiAddGuardian {


    static JTextField name_box;
    static JTextField mail_box;
    static JTextField phone_box;
    static JTextField address_box;
    static JTextField adresse_postnummer_box;
    static JLabel name_text;
    static JLabel mail_text;
    static JLabel phone_text;
    static JLabel adresse_text;
    static JLabel adresse_postnummer_text;


    // String name, String mail, String phoneNumber, String address, String childCPR
    GuiAddGuardian() {
    }

    public void guiAddGuardian() {
        Gui.frame.setTitle("Roskilde frie børnehave - Tilføj Værge");

        name_box = new JTextField("");
        mail_box = new JTextField("");
        phone_box = new JTextField("");
        address_box = new JTextField("");
        adresse_postnummer_box = new JTextField("");

        name_text = new JLabel("Navn:");
        mail_text = new JLabel("Email:");
        phone_text = new JLabel("Tlf nummer:");
        adresse_text = new JLabel("Adresse:");
        adresse_postnummer_text = new JLabel("Postnummer :");
        int y = 20;
        int yy = 85;
        Gui.frame.getContentPane().add(name_text,BorderLayout.CENTER);
        name_text.setBounds(y, yy, 100, 20);
        mail_text.setBounds(y, yy+=30, 100, 20);
        phone_text.setBounds(y, yy+=30, 100, 20);
        adresse_text.setBounds(y, yy+=30, 100, 20);
        adresse_postnummer_text.setBounds(y, yy+=30, 100, 25);
        int x = 180;
        int xx = 85;
        name_box.setBounds(x, xx, 150, 20);
        mail_box.setBounds(x, xx+=30, 150, 20);
        phone_box.setBounds(x, xx+=30, 150, 20);
        address_box.setBounds(x, xx+=30, 150, 20);
        adresse_postnummer_box.setBounds(x, xx+=30, 150, 20);



        Gui.frame.add(name_text);
        Gui.frame.add(mail_text);
        Gui.frame.add(phone_text);
        Gui.frame.add(adresse_text);
        Gui.frame.add(adresse_postnummer_text);

        Gui.frame.add(name_box);
        Gui.frame.add(mail_box);
        Gui.frame.add(phone_box);
        Gui.frame.add(address_box);
        Gui.frame.add(adresse_postnummer_box);

    }
}
