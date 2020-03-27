package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiEditGuardian extends GuiViewChild implements ActionListener {


    static JLabel g_name,g_info;
    static JComboBox guardian_list;
    static JButton edit,exit;
    static JTextField name,mail,adresse,phone;
    GuiEditGuardian() {
    }


    public void guiEditGuardian() {
        Gui.frame.setTitle("Roskilde frie børnehave - EditGuardian");

        GuiEditGuardian te = new GuiEditGuardian();

        String[] guardianArrays = {"Far", "mor", "søs"};

        guardian_list = new JComboBox(guardianArrays);
        guardian_list.setSelectedIndex(2);
        guardian_list.addActionListener(te);
        g_name = new JLabel("Barn_navn fra cpr"); //rettes til barn navn via cpr
        g_info = new JLabel("Info: ");

        name = new JTextField();
        mail = new JTextField();
        adresse = new JTextField();
        phone = new JTextField();

        edit = new JButton("Ret");
        exit = new JButton("Afslut");

        edit.addActionListener(te);
        exit.addActionListener(te);


        guardian_list.setBounds(160, 90, 190, 20);
        g_name.setBounds(140, 40, 200, 20);
        g_info.setBounds(45, 150, 200, 20);
        name.setBounds(45,180,250,20);
        mail.setBounds(45,210,250,20);
        adresse.setBounds(45,240,250,20);
        phone.setBounds(45,270,250,20);

        edit.setBounds(40,320,100,20);
        exit.setBounds(240,320,100,20);

        frame.add(guardian_list);
        frame.add(name);
        frame.add(mail);
        frame.add(adresse);
        frame.add(phone);
        frame.add(g_name);
        frame.add(g_info);
        frame.add(edit);
        frame.add(exit);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (guardian_list.getSelectedItem().equals("mor")){
            name.setText("mor er nice");
            mail.setText("mor love");
            adresse.setText("morvej 12");
            phone.setText("66");


        } else if (guardian_list.getSelectedItem().equals("søs")){
            name.setText("Søs er nice");
            mail.setText("Søs love");
            adresse.setText("søsvej 55");
            phone.setText("88888");

        }
        else if (guardian_list.getSelectedItem().equals("Far")) {
            name.setText("lol tester");
            mail.setText("Jeg ved det jo ikke");
            adresse.setText("Google det da ");
            phone.setText("Bruger ikke phone, men smartphone");


        }
        else if (s=="Afslut") {
            System.out.println("Lukker ned");
        }
    }
}
