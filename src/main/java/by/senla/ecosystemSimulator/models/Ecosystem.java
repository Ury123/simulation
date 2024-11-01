package by.senla.ecosystemSimulator.models;

import java.util.ArrayList;
import java.util.List;

public class Ecosystem {
    private String name;
    private int temperature;
    private int humidity;
    private int amountOfWater;
    private List<Organism> organisms;

    public Ecosystem(String name, int temperature, int humidity, int amountOfWater) {
        this.name = name;
        this.temperature = temperature;
        this.humidity = humidity;
        this.amountOfWater = amountOfWater;
        this.organisms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getAmountOfWater() {
        return amountOfWater;
    }

    public void setAmountOfWater(int amountOfWater) {
        this.amountOfWater = amountOfWater;
    }

    public List<Organism> getOrganisms() {
        return organisms;
    }

    public void addOrganism(Organism organism) {
        organisms.add(organism);
    }

    public void removeOrganism(Organism organism) {
        organisms.remove(organism);
    }

    public void printInfo() {
        System.out.println("=== Ecosystem Information ===");
        System.out.println("Name: " + name);
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Water Supply: " + amountOfWater + " liters");

        System.out.println("Organisms:");
        if (organisms.isEmpty()) {
            System.out.println("No organisms in this ecosystem.");
        } else {
            for (Organism organism : organisms) {
                System.out.println("- " + organism.getType() + ": " + organism.getName() + "," + organism.getPredator() + "," + organism.getRequiredWater() + "," + organism.getComfortTemperature() + "," + organism.getComfortHumidity());
            }
        }
    }
}
