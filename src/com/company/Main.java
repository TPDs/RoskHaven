package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InitiateArray ia = new InitiateArray();
        LogIn login = new LogIn(ia);

        Gui gui = new Gui();
        gui.gui();
    }
}
