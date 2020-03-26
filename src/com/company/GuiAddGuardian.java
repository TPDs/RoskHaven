package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GuiAddGuardian extends GuiAddChild {

    static JLabel title;
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
    static JButton next2;
    static JButton add_next;
    static JTextArea addedG;
    static int v_counter;
    static ArrayList<GuiAddGuardian> v_list = new ArrayList<>();


    // String name, String mail, String phoneNumber, String address, String childCPR

    GuiAddGuardian() {
    }

    String name;
    String mail;
    String phoneNumber;
    String adresse;

    public GuiAddGuardian(String name, String mail, String phoneNumber, String location) {
        this.name = name;
        this.mail= mail;
        this.phoneNumber= phoneNumber;
        this.adresse= location;

    }

    public void guiAddGuardian() {
        Gui.frame.setTitle("Roskilde frie børnehave - Tilføj Værge");
        name_box = new JTextField("");
        mail_box = new JTextField("");
        phone_box = new JTextField("");
        address_box = new JTextField("");
        adresse_postnummer_box = new JTextField("");
        v_counter = 0;
        //ArrayList<GuiAddGuardian> v_list = new ArrayList<>();

        GuiAddGuardian ter = new GuiAddGuardian();
        next2 = new JButton("Næste");
        add_next = new JButton("Tilføj Værge");
        Gui.frame.getContentPane().add(next2,BorderLayout.CENTER);
        next2.setBounds(275, 320, 75, 20);
        add_next.setBounds(75, 320, 75, 20);
        next2.addActionListener(ter);
        add_next.addActionListener(ter);

        title = new JLabel("Tilføj Værge til " + barn_navn);
        name_text = new JLabel("Navn:");
        mail_text = new JLabel("Email:");
        phone_text = new JLabel("Tlf nummer:");
        adresse_text = new JLabel("Adresse:");
        adresse_postnummer_text = new JLabel("Postnummer :");
        addedG = new JTextArea("");
        addedG.setLineWrap(true);
        addedG.setBounds(35,245,340,50);
        addedG.setEditable(false);

        int y = 40; //x For text fields
        int yy = 90; // y
        Gui.frame.getContentPane().add(name_text, BorderLayout.CENTER);
        title.setBounds(130, 35, 300, 45);
        name_text.setBounds(y, yy, 100, 20);
        mail_text.setBounds(y, yy += 30, 100, 20);
        phone_text.setBounds(y, yy += 30, 100, 20);
        adresse_text.setBounds(y, yy += 30, 100, 20);
        adresse_postnummer_text.setBounds(y, yy += 30, 100, 25);

        int x = 200; // X for Box
        int xx = 90; // Y for Box
        name_box.setBounds(x, xx, 150, 20);
        mail_box.setBounds(x, xx += 30, 150, 20);
        phone_box.setBounds(x, xx += 30, 150, 20);
        address_box.setBounds(x, xx += 30, 150, 20);
        adresse_postnummer_box.setBounds(x, xx += 30, 150, 20);

        Gui.frame.add(addedG);
        Gui.frame.add(title);
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
        frame.add(next2);
        frame.add(add_next);

        adresse_postnummer_box.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    add_next.doClick();

                }
            }
        });

    }


    @Override
    public String toString() {
        return "\nGuardian\n "  +
                "\nname: " + name  +
                "\nMail: " + mail  +
                "\nPhone: " + phoneNumber  +
                "\nAdresse: " + adresse;
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

        if (s == "Næste") {
            System.out.println("Næste click");
            clean.guiAddChild();
            clean.guiAddGuardian();

            GuiConfirm confirm = new GuiConfirm();
            confirm.guiConfirm();
        } else if (s == "Tilføj Værge") {
            String location = address_box.getText() + "  " + adresse_postnummer_box.getText();
            addedG.setText("Navn: " + name_box.getText()+ "\nKontakt info: " + mail_box.getText()+ ",    " + phone_box.getText() +"\nAdresse: " +location);
            //newg = new Guardian(name_text.getText(),mail_box.getText(),phone_box.getText(),location,barn_cpr);
            String Gname = name_box.getText();
            v_list.add(new GuiAddGuardian(name_box.getText(),mail_box.getText(),phone_box.getText(),location));
            v_counter++;
            name_box.setText(null);
            mail_box.setText(null);
            phone_box.setText(null);
            address_box.setText(null);
            adresse_postnummer_box.setText(null);
            System.out.println(v_list.toString());

        }


    }





}


