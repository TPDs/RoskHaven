package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiViewChild extends GuiCheckChild implements ActionListener {


    static JLabel topTekst;
    static JButton back;
    static JButton editChild;
    static JButton editGuardian;
    static JButton createGuardian;
    static JButton removeChild;
    static JTextArea child_info;
    static JScrollPane scroll;
    static ArrayList<GuiViewChild> G_list = new ArrayList<>();


    GuiViewChild(){}

    String name;
    String mail;
    String phoneNumber;
    String adresse;
    String gID;

    public GuiViewChild(String name, String mail, String phoneNumber, String location,String gID) {
        this.name = name;
        this.mail= mail;
        this.phoneNumber= phoneNumber;
        this.adresse= location;
        this.gID= gID;
    }

    public void guiViewChild() {
        Gui.frame.setTitle("Roskilde frie børnehave - ViewChild");

        GuiViewChild te = new GuiViewChild();

        topTekst = new JLabel("Hvad kunne du tænke dig at gøre?");

        child_info = new JTextArea(10,10);

        back = new JButton("Tilbage");
        editChild = new JButton("Opdater Barn");
        editGuardian = new JButton("Opdater Værge");
        createGuardian = new JButton("Opret Værge");
        removeChild = new JButton("Fjern Barn");

        Gui.frame.getContentPane().add(topTekst, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(back, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(editChild, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(editGuardian, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(createGuardian,BorderLayout.CENTER);
        Gui.frame.getContentPane().add(removeChild, BorderLayout.CENTER);
        Gui.frame.getContentPane().add(child_info, BorderLayout.CENTER);

        topTekst.setBounds(90, 25, 200, 20);

        back.setBounds(35, 320, 100, 20);
        editChild.setBounds(35, 230, 130, 20);
        editGuardian.setBounds(220, 230, 130, 20);
        createGuardian.setBounds(35,270,130,20);
        removeChild.setBounds(220, 270, 130, 20);

        Font  f2  = new Font(Font.DIALOG,  Font.BOLD, 11);
        child_info.setFont(f2);

        child_info.setLineWrap(true);
        child_info.setEditable(false);
        child_info.setVisible(true);

        scroll = new JScrollPane(child_info);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(35,50,315,170);

        barn_navn =Kindergarten.getInstance().searchAndFindChild(barn_cpr).getName() ;
        barn_note =Kindergarten.getInstance().searchAndFindChild(barn_cpr).getNote();
        int barn_age = Kindergarten.getInstance().searchAndFindChild(barn_cpr).calcAge();


        child_info.setText("Navn:   " + barn_navn +"\nCPR:   " + barn_cpr +  "\nAlder:   "+ barn_age +  "\nNoter:    " +barn_note +"\n");
        child_info.append("\nVærger:");
        G_list = new ArrayList<>();
        for (int i =0; i < Kindergarten.getInstance().searchAndFindChild(barn_cpr).getGuardians().size();) {

            String G_name = Kindergarten.getInstance().searchAndFindChild(barn_cpr).getGuardians().get(i).getName();
            String G_mail = Kindergarten.getInstance().searchAndFindChild(barn_cpr).getGuardians().get(i).getMail();
            String G_phone = Kindergarten.getInstance().searchAndFindChild(barn_cpr).getGuardians().get(i).getPhoneNumber();
            String G_adresse = Kindergarten.getInstance().searchAndFindChild(barn_cpr).getGuardians().get(i).getAddress();
            String gID = Kindergarten.getInstance().searchAndFindChild(barn_cpr).getGuardians().get(i).getGuardianID();

            G_list.add(new GuiViewChild(G_name,G_mail,G_phone,G_adresse,gID));
            child_info.append("\n\nNavn:   " + G_name);
            child_info.append("\nMail:   " + G_mail);
            child_info.append("\nTelefon:   " + G_phone);
            child_info.append("\nAdresse:   " + G_adresse);
            i++;
        }

        frame.add(topTekst);

        back.addActionListener(te);
        editChild.addActionListener(te);
        editGuardian.addActionListener(te);
        createGuardian.addActionListener(te);
        removeChild.addActionListener(te);

        frame.getContentPane().add(scroll);
        frame.add(back);
        frame.add(editChild);
        frame.add(editGuardian);
        frame.add(createGuardian);
        frame.add(removeChild);

        if(ansatliste.getSelectedItem() == "Daglig leder"){
            topTekst.setText("Barnets informationer");
            topTekst.setBounds(130,25,200,20);
            editChild.setVisible(false);
            editGuardian.setVisible(false);
            createGuardian.setVisible(false);
            removeChild.setVisible(false);
        }



    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public String getAdresse() {
        return adresse;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

        if (s == "Tilbage") {
            if(ansatliste.getSelectedItem() == "Daglig leder") {
                clean.guiViewChild();
                Gui.logo.setVisible(true);

                GuiDailyManager dailyManager = new GuiDailyManager();
                dailyManager.guiDailyManager();
            } else if(ansatliste.getSelectedItem() == "Boss"){
                clean.guiViewChild();
                Gui.logo.setVisible(true);

                GuiBoss boss = new GuiBoss();
                boss.GuiBoss();
            }
        } else if (s == "Opdater Barn") {

            clean.guiViewChild();

            GuiEditChild editChild = new GuiEditChild();
            editChild.guiEditChild();
        } else if(s == "Opdater Værge"){

            clean.guiViewChild();

            GuiEditGuardian editGuardian = new GuiEditGuardian();
            editGuardian.guiEditGuardian();
        } else if(s == "Opret Værge"){

            clean.guiViewChild();

            GuiAddGuardian addGuardian = new GuiAddGuardian();
            addGuardian.guiAddGuardian();
        } else if(s == "Fjern Barn"){

            clean.guiViewChild();

            GuiRemoveChild removeChild = new GuiRemoveChild();
            removeChild.guiRemoveChild();
        }
    }





}
