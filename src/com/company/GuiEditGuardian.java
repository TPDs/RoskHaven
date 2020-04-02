package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiEditGuardian extends GuiViewChild implements ActionListener {


    static JLabel g_name,g_info;
    static JComboBox guardian_list;
    static JButton edit,exit;
    static JTextField name,mail,adresse,phone;
    ArrayList G_list_name = new ArrayList<String>();
    GuiEditGuardian() {
    }


    public void guiEditGuardian() {
        Gui.frame.setTitle("Roskilde frie børnehave - EditGuardian");

        GuiEditGuardian te = new GuiEditGuardian();

        for (int i =0; i < G_list.size();) {
            G_list_name.add(G_list.get(i).name);
            i++;
        }

        //String barn_name =Kindergarten.getInstance().searchAndFindChild(barn_cpr).getName();
        guardian_list = new JComboBox(G_list_name.toArray());
        guardian_list.setSelectedIndex(G_list_name.size()-1);
        guardian_list.addActionListener(te);
        g_name = new JLabel( "Listen over Væger"); //rettes til barn navn via cpr
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
        for (int i=0; i< G_list.size();i++) {
            if (guardian_list.getSelectedItem().equals(G_list.get(i).getName())) {
                name.setText(G_list.get(i).getName());
                mail.setText(G_list.get(i).getMail());
                adresse.setText(G_list.get(i).getAdresse());
                phone.setText(G_list.get(i).getPhoneNumber());
            }

        else if (s=="Afslut") {
                Gui.logo.setVisible(true);

                GuiBoss boss = new GuiBoss();
                boss.GuiBoss();
        }
        else if (s=="Ret") {
            System.out.println("Ret");

            }

        }
    }
}
