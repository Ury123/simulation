package by.senla.ecosystemSimulator.menu;

import by.senla.ecosystemSimulator.io.FileManager;
import by.senla.ecosystemSimulator.models.Animal;
import by.senla.ecosystemSimulator.models.Ecosystem;
import by.senla.ecosystemSimulator.models.Organism;
import by.senla.ecosystemSimulator.models.Plant;

import java.util.Scanner;

public class MainMenu {

    private Scanner sc;

    public MainMenu() {
        sc = new Scanner(System.in);
    }

    public void start(Ecosystem ecosystem) {
        while (true) {

            System.out.println("1. view information about ecosystem");
            System.out.println("2. add organism");
            System.out.println("3. delete organism");
            System.out.println("4. change temperature of ecosystem");
            System.out.println("5. change humidity of ecosystem");
            System.out.println("6. change amountOfWater of ecosystem");
            System.out.println("7. save and exit");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    ecosystem.printInfo();
                    break;
                case 2:
                    addNewOrganism(ecosystem);
                    break;
                case 3:
                    deleteOrganism(ecosystem);
                    break;
                case 4:
                    changeTemperature(ecosystem);
                    break;
                case 5:
                    changeHumidity(ecosystem);
                    break;
                case 6:
                    changeAmountOfWater(ecosystem);
                    break;
                case 7:
                    saveAndExit(ecosystem);
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private void addNewOrganism(Ecosystem ecosystem) {
        System.out.println("Enter type (plant/animal):");
        String type = sc.nextLine();

        System.out.println("Enter name:");
        String name = sc.nextLine();

        System.out.println("Is the organism a predator? (yes/no): ");
        boolean isPredator = sc.nextLine().equalsIgnoreCase("yes");

        System.out.println("Enter the required amount of water: ");
        int requiredWater = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the comfortable temperature (in °C): ");
        int comfortTemperature = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the comfortable humidity (in %): ");
        int comfortHumidity = Integer.parseInt(sc.nextLine());

        Organism organism;
        if (type.equalsIgnoreCase("plant")) {
            organism = new Plant(name, isPredator, requiredWater, comfortTemperature, comfortHumidity);
        } else if (type.equalsIgnoreCase("animal")) {
            organism = new Animal(name, isPredator, requiredWater, comfortTemperature, comfortHumidity);
        } else {
            System.out.println("Invalid type.");
            return;
        }
        ecosystem.addOrganism(organism);
    }

    private void deleteOrganism(Ecosystem ecosystem) {
        System.out.println("Enter the name of the organism to remove:");
        String name = sc.nextLine();
        ecosystem.getOrganisms().removeIf(organism -> organism.getName().equals(name));
        System.out.println("Organism removed.");
    }

    private void changeTemperature(Ecosystem ecosystem) {
        System.out.println("Enter new temperature:");
        int temperature = Integer.parseInt(sc.nextLine());
        ecosystem.setTemperature(temperature);
        System.out.println("Temperature changed.");
    }

    private void changeHumidity(Ecosystem ecosystem) {
        System.out.println("Enter new humidity:");
        int humidity = Integer.parseInt(sc.nextLine());
        ecosystem.setHumidity(humidity);
        System.out.println("Humidity changed.");
    }

    private void changeAmountOfWater(Ecosystem ecosystem) {
        System.out.println("Enter amount of water:");
        int amount = Integer.parseInt(sc.nextLine());
        ecosystem.setAmountOfWater(amount);
        System.out.println("Amount of water changed.");
    }

    private void saveAndExit(Ecosystem ecosystem) {
        try {
            FileManager.saveEcosystem(ecosystem);
            System.out.println("Ecosystem saved!");
        } catch (Exception e) {
            System.out.println("Error saving ecosystem.");
        }
    }
}
