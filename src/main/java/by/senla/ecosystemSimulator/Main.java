package by.senla.ecosystemSimulator;

import by.senla.ecosystemSimulator.menu.StartMenu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        StartMenu startMenu = new StartMenu();
        startMenu.start();

    }
}