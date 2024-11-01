package by.senla.ecosystemSimulator.models;

public class Animal extends Organism {
    public Animal(String name, boolean isPredator, int requiredWater, int comfortTemperature, int comfortHumidity) {
        super(name, "Animal", isPredator, requiredWater, comfortTemperature, comfortHumidity);
    }
}
