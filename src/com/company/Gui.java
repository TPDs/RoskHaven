package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Gui implements ActionListener {

    static JFrame frame;
    static JButton button;
    static JTextField t_name;
    static JTextField t_password;
    static JLabel l_name;
    static JLabel l_password;
    static JComboBox ansatliste;
    static JLabel logo;
    static String user;
    static String password;

    Gui() {
    }

    public void gui() {
        frame = new JFrame("Roskilde frie børnehave");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(400, 400);
        frame.setResizable(false);


        Image window_icon = Toolkit.getDefaultToolkit().getImage("src/resourser/window_icon.png");
        frame.setIconImage(window_icon);
        frame.setLocationRelativeTo(null);
        Gui te = new Gui();
        button = new JButton("Login");
        button.setBounds(230, 256, 90, 25);
        button.addActionListener(te);
        String[] ansat = {"Boss", "Daglig leder", "pædagog"};

        ansatliste = new JComboBox(ansat);
        ansatliste.setSelectedIndex(2);

        l_name = new JLabel("Navn:");
        l_password = new JLabel("Password:");
        t_name = new JTextField("");
        t_password = new JTextField("");

        t_name.setBounds(190, 180, 130, 20);
        t_password.setBounds(190, 220, 130, 20);
        ansatliste.setBounds(105, 256, 100, 25);
        l_name.setBounds(105, 180, 150, 20);
        l_password.setBounds(105, 220, 150, 20);



        int x = 95;
        int y = 95;
        Image logo2;
        logo2 = new ImageIcon("src/resourser/kinder.png").getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);

        logo = new JLabel();
        logo.setIcon(new ImageIcon(logo2));
        logo.setBounds(150, 50, x, y);

        frame.add(logo);
        frame.add(ansatliste);

        frame.add(button);
        frame.add(t_name);
        frame.add(t_password);
        frame.add(l_name);
        frame.add(l_password);

        // til at loade et billed og rescale det
        ImageIcon icon = new ImageIcon("src/resourser/doll.jpg");
        Image icon2 = icon.getImage();
        Image scaleicon2 = icon2.getScaledInstance(90, 50, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaleicon2);
        frame.getContentPane().add(button);
        frame.setVisible(true);
        JOptionPane.showMessageDialog(button, "Goddag", "hej", JOptionPane.INFORMATION_MESSAGE, icon);

        t_password.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    button.doClick();

                }
            }
        });

        t_name.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    button.doClick();

                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        /*if (s.equals("Login")) {

            System.out.println("Test: " + t_password.getText() + " " + t_name.getText()); //ændres til login();
            user = t_name.getText();
            password = t_password.getText();
            t_name.setText("");
            t_password.setText("");
            System.out.println(ansatliste.getSelectedItem().toString());
            GuiClear clean = new GuiClear();
            clean.guiClear();

            GuiBoss boss = new GuiBoss(); // ændres til en switch case der gør at vi kan vælge hvem der logger ind via login();
            boss.GuiBoss();


        }*/

        if (s.equals("Login") && ansatliste.getSelectedItem() == "Boss") {

            System.out.println("Test: " + t_password.getText() + " " + t_name.getText()); //ændres til login();
            user = t_name.getText();
            password = t_password.getText();
            t_name.setText("");
            t_password.setText("");
            System.out.println(ansatliste.getSelectedItem().toString());
            GuiClear clean = new GuiClear();
            clean.guiClear();

            GuiBoss boss = new GuiBoss(); // ændres til en switch case der gør at vi kan vælge hvem der logger ind via login();
            boss.GuiBoss();


        } else if (s.equals("Login") && ansatliste.getSelectedItem() == "pædagog") {

            System.out.println("Test: " + t_password.getText() + " " + t_name.getText()); //ændres til login();
            user = t_name.getText();
            password = t_password.getText();
            t_name.setText("");
            t_password.setText("");
            System.out.println(ansatliste.getSelectedItem().toString());
            GuiClear clean = new GuiClear();
            clean.guiClear();

            GuiEmployee employee = new GuiEmployee(); // ændres til en switch case der gør at vi kan vælge hvem der logger ind via login();
            employee.guiEmployee();


        }else if (s.equals("Login") && ansatliste.getSelectedItem() == "Daglig leder") {

            System.out.println("Test: " + t_password.getText() + " " + t_name.getText()); //ændres til login();
            user = t_name.getText();
            password = t_password.getText();
            t_name.setText("");
            t_password.setText("");
            System.out.println(ansatliste.getSelectedItem().toString());
            GuiClear clean = new GuiClear();
            clean.guiClear();

            GuiDailyManager dailyManager = new GuiDailyManager(); // ændres til en switch case der gør at vi kan vælge hvem der logger ind via login();
            dailyManager.guiDailyManager();


        }

    }

}