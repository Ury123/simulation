package by.senla.ecosystemSimulator.menu;

import by.senla.ecosystemSimulator.io.FileManager;
import by.senla.ecosystemSimulator.models.Ecosystem;

import java.util.Scanner;

public class StartMenu {

    private Scanner sc;
    private MainMenu mainMenu;
    private Ecosystem ecosystem;

    public StartMenu() {
        this.sc = new Scanner(System.in);
        this.mainMenu = new MainMenu();
    }

    public void start() {
        while (true) {
            System.out.println("1. Load ecosystem");
            System.out.println("2. Create new ecosystem");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    loadExistingEcosystem();
                    break;
                case 2:
                    createNewEcosystem();
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    start();
                    break;
            }
        }

    }

    private void createNewEcosystem() {
        System.out.println("Enter the name of the ecosystem: ");
        String name = sc.nextLine();

        System.out.println("Enter the temperature of the ecosystem: ");
        int temperature = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the humidity of the ecosystem: ");
        int humidity = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the amount of available water: ");
        int amountOfWater = Integer.parseInt(sc.nextLine());

        Ecosystem ecosystem = new Ecosystem(name, temperature, humidity, amountOfWater);

        mainMenu.start(ecosystem);
    }

    private void loadExistingEcosystem() {
        System.out.println("Enter the name of the ecosystem: ");
        String name = sc.nextLine();

        try {
            this.ecosystem = FileManager.loadEcosystem(name);
            System.out.println("Ecosystem loaded successfully.");
            mainMenu.start(ecosystem);
        } catch (Exception e) {
            System.out.println("Error loading ecosystem. Please try again.");
            start();
        }
    }
}
