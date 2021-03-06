package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiConfirm extends GuiAddGuardian implements ActionListener {
    static JTextArea box_info;
    static JLabel confirm_lable;
    static JButton confirm_button;
    static JButton quit_button;
    static JScrollPane scroll2;

    GuiConfirm() {

    }

    public void guiConfirm() {
        Gui.frame.setTitle("Roskilde frie børnehave - Godkend");

        GuiConfirm te = new GuiConfirm();

        quit_button = new JButton("Afbryd");
        box_info = new JTextArea(10,10);
        confirm_lable = new JLabel("Godkend information");
        confirm_button = new JButton("Godkend");


        confirm_button.setBackground(new Color(62, 249, 106));
        confirm_button.setForeground(Color.BLACK);
        confirm_button.setFocusPainted(false);

        quit_button.setBackground(new Color(239, 33, 44));
        quit_button.setForeground(Color.WHITE);
        quit_button.setFocusPainted(false);


        Gui.frame.getContentPane().add(box_info, BorderLayout.CENTER);

        scroll2 = new JScrollPane(box_info);
        scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        box_info.setLineWrap(true);
        box_info.setEditable(false);
        box_info.setVisible(true);

        Font  f3  = new Font(Font.DIALOG,  Font.BOLD, 12);
        box_info.setFont(f3);

        Gui.frame.getContentPane().add(confirm_lable, BorderLayout.NORTH);
        Gui.frame.getContentPane().add(confirm_button, BorderLayout.CENTER);

        confirm_lable.setBounds(130, 20, 150, 20);
        scroll2.setBounds(50, 45, 280, 240);
        confirm_button.setBounds(265, 320, 95, 20);
        quit_button.setBounds(35,320,100,20);

        frame.getContentPane().add(scroll2);
        Gui.frame.add(quit_button);
        Gui.frame.add(confirm_lable);
        Gui.frame.add(confirm_button);

        quit_button.addActionListener(te);
        confirm_button.addActionListener(te);

        box_info.setText("Barn: " + barn_navn + "\nCPR: " + barn_cpr + "\nNoter: " + barn_note);


        for (int i=0; i < v_list.size();i++) {
            box_info.append("\n\nNavn:         " + v_list.get(i).name);
            box_info.append("\nMail:           "+ v_list.get(i).mail);
            box_info.append("\nTelefon:     "+v_list.get(i).phoneNumber);
            box_info.append("\nAdresse:   "+v_list.get(i).adresse);

        }

    }



    public void confirmList() {

         Child testkid =  Kindergarten.getInstance().addChildToQueue(barn_navn,barn_cpr,barn_note);

        for (int i = 0; i< v_list.size();) {
            testkid.addGuardian(v_list.get(i).name,v_list.get(i).mail,v_list.get(i).phoneNumber,v_list.get(i).adresse);
              i++;
        }
        barn_cpr=null;
        barn_navn=null;
        barn_note=null;
        v_list.clear();


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        GuiBoss bigboss = new GuiBoss();
        String s = e.getActionCommand();

        if (s =="Godkend") {
            confirmList();
            clean.guiConfirm();
            bigboss.GuiBoss();
            logo.setVisible(true);

        }
        else if (s=="Afbryd") {
            clean.guiConfirm();
            bigboss.GuiBoss();
            logo.setVisible(true);
            v_list.clear();

        }

    }

}
