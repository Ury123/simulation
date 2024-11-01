package by.senla.ecosystemSimulator.models;

public abstract class Organism {
    private String name;
    private String type;
    private boolean isPredator;
    private int requiredWater;
    private int comfortTemperature;
    private int comfortHumidity;

    //id     ?
    //кол-во особей

    public Organism(String name, String type, boolean isPredator, int requiredWater, int comfortTemperature, int comfortHumidity) {
        this.name = name;
        this.type = type;
        this.isPredator = isPredator;
        this.requiredWater = requiredWater;
        this.comfortTemperature = comfortTemperature;
        this.comfortHumidity = comfortHumidity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean getPredator() {
        return isPredator;
    }

    public void setPredator(boolean isPredator) {
        this.isPredator = isPredator;
    }

    public int getRequiredWater() {
        return requiredWater;
    }

    public void setRequiredWater(int requiredWater) {
        this.requiredWater = requiredWater;
    }

    public int getComfortTemperature() {
        return comfortTemperature;
    }

    public void setComfortTemperature(int comfortTemperature) {
        this.comfortTemperature = comfortTemperature;
    }

    public int getComfortHumidity() {
        return comfortHumidity;
    }

    public void setComfortHumidity(int comfortHumidity) {
        this.comfortHumidity = comfortHumidity;
    }
}
