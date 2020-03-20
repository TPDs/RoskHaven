package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InitiateArray ia = new InitiateArray();
        LogIn login = new LogIn(ia);
        KindergartenOverview ko = new KindergartenOverview(ia);

        Gui gui = new Gui();
        gui.gui();
    }
}
