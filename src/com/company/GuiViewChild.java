package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiViewChild extends GuiCheckChild implements ActionListener {


    static JLabel topTekst;
    static JButton back;
    static JButton editChild;
    static JButton editGuardian;
    static JButton createGuardian;
    static JButton removeChild;
    static JTextArea child_info;
    static JScrollPane scroll;

    GuiViewChild(){}

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

        //child_info.setBounds(20,50,340,170);

        back.setBounds(40, 320, 100, 20);
        editChild.setBounds(40, 230, 130, 20);
        editGuardian.setBounds(220, 230, 130, 20);
        createGuardian.setBounds(40,270,130,20);
        removeChild.setBounds(220, 270, 130, 20);

        child_info.setLineWrap(true);
        child_info.setEditable(false);
        child_info.setVisible(true);

        scroll = new JScrollPane(child_info);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(20,50,335,170);


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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GuiClear clean = new GuiClear();
        String s = e.getActionCommand();

        if (s == "Tilbage") {
            clean.guiViewChild();
            Gui.logo.setVisible(true);

            GuiBoss boss = new GuiBoss();
            boss.GuiBoss();
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
