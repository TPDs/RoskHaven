package com.company;

import javax.swing.*;
import java.awt.*;

public class GuiClear {

    public void guiClear() {

        Gui.ansatliste.setBounds(10,10,10,10); //dropDown menu der laver en glitch med andre boxe
        Gui.ansatliste.setVisible(false);
        Gui.frame.remove(Gui.ansatliste);
        Gui.l_name.setVisible(false);
        Gui.l_password.setVisible(false);
        Gui.button.setVisible(false);
        Gui.frame.remove(Gui.button);
        Gui.t_name.setVisible(false);
        Gui.t_password.setVisible(false);
        Gui.l_name.setVisible(false);
        // Gui.logo.setVisible(false);
        //Gui.l_test.setVisible(false);
        //Gui.frame.remove(Gui.l_test);


    }

    public void guiBossClear() {
        GuiBoss.create_kid.setVisible(false);
        GuiBoss.check_kid.setVisible(false);
        GuiBoss.workSheet.setVisible(false);
        GuiBoss.salary.setVisible(false);
        GuiBoss.logout.setVisible(false);



    }


}
