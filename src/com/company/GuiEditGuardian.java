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
        guardian_list.addActionListener(te);
        guardian_list.setSelectedIndex(2);

        g_name = new JLabel("Barn_navn fra cpr"); //rettes til barn navn via cpr
        g_info = new JLabel("Info: ");

        name = new JTextField();
        mail = new JTextField();
        adresse = new JTextField();
        phone = new JTextField();

        edit = new JButton("Ret");
        exit = new JButton("Afslut");


        guardian_list.setBounds(200, 90, 150, 20);
        g_name.setBounds(140, 40, 150, 20);
        g_info.setBounds(45, 60, 150, 20);
        name.setBounds(45,90,100,20);
        mail.setBounds(45,120,100,20);
        adresse.setBounds(45,150,100,20);
        phone.setBounds(45,180,100,20);
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
            name.setText("");
            mail.setText("");
            adresse.setText("");
            phone.setText("");


        }

    }
}
