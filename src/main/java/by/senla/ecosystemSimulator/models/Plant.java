package by.senla.ecosystemSimulator.models;

public class Plant extends Organism {
    public Plant(String name, boolean isPredator, int requiredWater, int comfortTemperature, int comfortHumidity) {
        super(name, "Plant", isPredator, requiredWater, comfortTemperature, comfortHumidity);
    }
}
