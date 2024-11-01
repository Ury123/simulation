package by.senla.ecosystemSimulator.io;

import by.senla.ecosystemSimulator.models.Animal;
import by.senla.ecosystemSimulator.models.Ecosystem;
import by.senla.ecosystemSimulator.models.Organism;
import by.senla.ecosystemSimulator.models.Plant;

import java.io.*;

public class FileManager {
    private static final String FOLDER = "ecosystems/";

    public static void saveEcosystem(Ecosystem ecosystem) throws IOException {
        File folder = new File(FOLDER);
        if (!folder.exists()) {
            folder.mkdir();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FOLDER + ecosystem.getName() + ".txt"))) {
            writer.write("Name:" + ecosystem.getName() + "\n");
            writer.write("Temperature:" + ecosystem.getTemperature() + "\n");
            writer.write("Humidity:" + ecosystem.getHumidity() + "\n");
            writer.write("AmountOfWater:" + ecosystem.getAmountOfWater() + "\n");

            for (Organism organism : ecosystem.getOrganisms()) {
                writer.write(organism.getType() + "," + organism.getName() + "," + organism.getPredator() + "," + organism.getRequiredWater() + "," + organism.getComfortTemperature() +"," + organism.getComfortHumidity() + "\n");
            }
        }
    }

    public static Ecosystem loadEcosystem(String ecosystemName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FOLDER + ecosystemName + ".txt"))) {
            String name = reader.readLine().split(":")[1];
            int temperature = Integer.parseInt(reader.readLine().split(":")[1]);
            int humidity = Integer.parseInt(reader.readLine().split(":")[1]);
            int amountOfWater = Integer.parseInt(reader.readLine().split(":")[1]);

            Ecosystem ecosystem = new Ecosystem(name, temperature, humidity, amountOfWater);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String type = data[0];
                String organismName = data[1];
                boolean isPredator = Boolean.parseBoolean(data[2]);
                int requiredWater = Integer.parseInt(data[3]);
                int comfortTemperature = Integer.parseInt(data[4]);
                int comfortHumidity = Integer.parseInt(data[5]);

                if (type.equalsIgnoreCase("plant")) {
                    ecosystem.addOrganism(new Plant(organismName, isPredator, requiredWater, comfortTemperature, comfortHumidity));
                } else if (type.equalsIgnoreCase("animal")) {
                    ecosystem.addOrganism(new Animal(organismName, isPredator, requiredWater, comfortTemperature, comfortHumidity));
                }
            }
            return ecosystem;
        }
    }
}
