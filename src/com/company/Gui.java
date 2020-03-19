package com.company;

import javax.swing.*;

public class Gui {

        public void gui(){
            JFrame frame = new JFrame("My First GUI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300,300);
            JButton button = new JButton("Press");
            frame.getContentPane().add(button);
            frame.setVisible(true);
        }
    }


