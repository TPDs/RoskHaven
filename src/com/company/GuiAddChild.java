package com.company;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GuiAddChild extends GuiBoss implements ActionListener {

    static JLabel child_name;
    static JTextField c_name;
    static JLabel child_birth;
    static JTextField c_birth;
    static JLabel child_cpr;
    static JTextField c_cpr;
    static JLabel child_address;
    static JTextField c_address;
    static JLabel child_note;
    static JTextField c_note;
    static JButton next;
    //static String user;
    //static String password;

    GuiAddChild(){}

    public void guiAddChild(){
        Gui.frame.setTitle("Roskilde frie børnehave - AddChild menu");






    }
}
