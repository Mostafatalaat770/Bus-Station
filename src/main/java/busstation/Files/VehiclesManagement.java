/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Files;

import busstation.Database.VehiclesDB;
import busstation.Vehicles.Bus;
import busstation.Vehicles.Limousine;
import busstation.Vehicles.MiniBus;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Mostafa Talaat
 */
public class VehiclesManagement {

    private Scanner in;
    private final VehiclesDB vehiclesDB;

    public VehiclesManagement(VehiclesDB vehiclesDB) {
        this.vehiclesDB = vehiclesDB;
    }

    public boolean readBuses() {
        try {
            vehiclesDB.getBuses().clear();
            in = new Scanner(new File("Buses.txt"));
            in.useDelimiter(",|\\n");
            while (in.hasNextLine()) {
                String name = in.next();
                int capacity = in.nextInt();
                boolean specialNeeds = in.nextBoolean();
                boolean AC = in.nextBoolean();
                boolean WIFI = in.nextBoolean();
                vehiclesDB.createBus(name, capacity, specialNeeds, AC, WIFI);

            }
            return true;
        } catch (FileNotFoundException ex) {

            return false;
        }

    }

    public boolean readLimousines() {
        try {
            vehiclesDB.getLimousines().clear();
            in = new Scanner(new File("Limousine.txt"));
            in.useDelimiter(",|\\n");
            while (in.hasNextLine()) {
                String name = in.next();
                int capacity = in.nextInt();
                boolean specialNeeds = in.nextBoolean();
                boolean AC = in.nextBoolean();
                boolean WIFI = in.nextBoolean();
                vehiclesDB.createBus(name, capacity, specialNeeds, AC, WIFI);

            }
            return true;
        } catch (FileNotFoundException ex) {

            return false;
        }

    }

    public boolean readMiniBuses() {
        try {
            vehiclesDB.getMiniBuses().clear();
            in = new Scanner(new File("MiniBuses.txt"));
            in.useDelimiter(",|\\n");
            while (in.hasNextLine()) {
                String name = in.next();
                int capacity = in.nextInt();
                boolean specialNeeds = in.nextBoolean();
                boolean AC = in.nextBoolean();
                boolean WIFI = in.nextBoolean();
                vehiclesDB.createMiniBus(name, capacity, specialNeeds, AC, WIFI);

            }
            return true;
        } catch (FileNotFoundException ex) {

            return false;
        }

    }

    public boolean writeBuses() {
        try {
            Formatter file = new Formatter(new File("Buses.txt"));
            for (int i = 0; i < vehiclesDB.getBuses().size(); i++) {
                Bus tempBus = vehiclesDB.getBuses().get(i);
                String name = tempBus.getName();
                int capacity = tempBus.getCapacity();
                boolean specialNeeds = tempBus.isSpecialNeeds();
                boolean AC = tempBus.isAC();
                boolean WIFI = tempBus.isWIFI();
                if (i + 1 != vehiclesDB.getBuses().size()) {
                    file.format("%s%s%s%s%n", name + ",", capacity + ",", specialNeeds + ",", AC + ",", WIFI);
                } else {
                    file.format("%s%s%s%s", name + ",", capacity + ",", specialNeeds + ",", AC + ",", WIFI);

                }
            }
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }
    }

    public boolean writeLimousines() {
        try {
            Formatter file = new Formatter(new File("Limousines.txt"));
            for (int i = 0; i < vehiclesDB.getLimousines().size(); i++) {
                Limousine tempLimousines = vehiclesDB.getLimousines().get(i);
                String name = tempLimousines.getName();
                int capacity = tempLimousines.getCapacity();
                boolean specialNeeds = tempLimousines.isSpecialNeeds();
                boolean AC = tempLimousines.isAC();
                boolean WIFI = tempLimousines.isWIFI();
                if (i + 1 != vehiclesDB.getLimousines().size()) {
                    file.format("%s%s%s%s%n", name + ",", capacity + ",", specialNeeds + ",", AC + ",", WIFI);
                } else {
                    file.format("%s%s%s%s", name + ",", capacity + ",", specialNeeds + ",", AC + ",", WIFI);

                }
            }
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }
    }

    public boolean writeMiniBuses() {
        try {
            Formatter file = new Formatter(new File("Buses.txt"));
            for (int i = 0; i < vehiclesDB.getMiniBuses().size(); i++) {
                MiniBus tempMiniBus = vehiclesDB.getMiniBuses().get(i);
                String name = tempMiniBus.getName();
                int capacity = tempMiniBus.getCapacity();
                boolean specialNeeds = tempMiniBus.isSpecialNeeds();
                boolean AC = tempMiniBus.isAC();
                boolean WIFI = tempMiniBus.isWIFI();
                if (i + 1 != vehiclesDB.getMiniBuses().size()) {
                    file.format("%s%s%s%s%n", name + ",", capacity + ",", specialNeeds + ",", AC + ",", WIFI);
                } else {
                    file.format("%s%s%s%s", name + ",", capacity + ",", specialNeeds + ",", AC + ",", WIFI);

                }
            }
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }
    }
}
