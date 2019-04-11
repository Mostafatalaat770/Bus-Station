/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Files;

import busstation.Database.TripsDB;
import busstation.Trips.ExternalTrip;
import busstation.Trips.InternalTrip;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Mostafa Talaat
 */
public class TripsManagement {

    private Scanner in;
    private final TripsDB tripsDB;

    /**
     * Takes the object of the database of customers so we can do operations on
     * it.
     *
     * @param tripsDB
     */
    public TripsManagement(TripsDB tripsDB) {
        this.tripsDB = tripsDB;
    }

    /**
     * Read method which reads a predefined file and splits it in-order to get
     * our parameters from it. The parameters are comma separated.
     *
     * @return Boolean
     */
    public boolean readInternalFile() {
        try {
            in = new Scanner(new File("InternalTrips.txt"));
            in.useDelimiter(",|\\n");
            while (in.hasNextLine()) {
                String name = in.next();
                String startPos = in.next();
                String endPos = in.next();
                double starTime = in.nextDouble();
                double endTime = in.nextDouble();
                double price = in.nextDouble();
                double discountPrecent = in.nextDouble();
                String stopType = in.next();

                tripsDB.createInternalTrip(name, startPos, endPos, starTime, endTime, price, discountPrecent, stopType);
            }
            in.close();
            System.out.println("read file.\n");
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Can't read file.\n");
            return false;
        }

    }

    public boolean readExternalFile() {
        try {
            in = new Scanner(new File("ExternalTrips.txt"));
            in.useDelimiter(",|\\n");
            while (in.hasNextLine()) {
                String name = in.next();
                String startPos = in.next();
                String endPos = in.next();
                double starTime = in.nextDouble();
                double endTime = in.nextDouble();
                double price = in.nextDouble();
                double discountPrecent = in.nextDouble();
                String stopType = in.next();
                tripsDB.createExternalTrip(name, startPos, endPos, starTime, endTime, price, discountPrecent, stopType);
            }
            in.close();
            System.out.println("read file.\n");
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Can't read file.\n");
            return false;
        }

    }

    /**
     * Write method which saves the database of customers in a predefined file
     * or creates one if it isn't created. It saves the attributes of the class
     * comma separated.
     *
     * @return Boolean
     */
    public boolean writeInternalFile() {
        try {
            Formatter file = new Formatter("InternalTrips.txt");
            for (int i = 0; i < tripsDB.getInternalTrips().size(); i++) {
                InternalTrip tempInternalTrip = tripsDB.getInternalTrips().get(i);
                String name = tempInternalTrip.getName();
                String startPos = tempInternalTrip.getStartPos();
                String endPos = tempInternalTrip.getEndPos();
                double startTime = tempInternalTrip.getStartTime();
                double endTime = tempInternalTrip.getEndTime();
                double price = tempInternalTrip.getPrice();
                double discountPrecent = tempInternalTrip.getDiscountPrecent();
                String stopType = tempInternalTrip.getStopType();
                if (i + 1 != tripsDB.getInternalTrips().size()) {
                    file.format("%s%s%s%s%s%s%s%s%n", name + (","), startPos + (","), endPos + (","), startTime + (","), endTime + (","), price + (","), discountPrecent + (","), stopType);
                } else {
                    file.format("%s%s%s%s%s%s%s%s", name + (","), startPos + (","), endPos + (","), startTime + (","), endTime + (","), price + (","), discountPrecent + (","), stopType);

                }

            }
            file.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }

    }

    public boolean writeExternalFile() {
        try {
            Formatter file = new Formatter("ExternalTrips.txt");
            for (int i = 0; i < tripsDB.getExternalTrips().size(); i++) {
                ExternalTrip tempExternalTrip = tripsDB.getExternalTrips().get(i);
                String name = tempExternalTrip.getName();
                String startPos = tempExternalTrip.getStartPos();
                String endPos = tempExternalTrip.getEndPos();
                double startTime = tempExternalTrip.getStartTime();
                double endTime = tempExternalTrip.getEndTime();
                double price = tempExternalTrip.getPrice();
                double discountPrecent = tempExternalTrip.getDiscountPrecent();
                String stopType = tempExternalTrip.getStopType();
                if (i + 1 != tripsDB.getExternalTrips().size()) {
                    file.format("%s%s%s%s%s%s%s%s%n", name + (","), startPos + (","), endPos + (","), startTime + (","), endTime + (","), price + (","), discountPrecent + (","), stopType);
                } else {
                    file.format("%s%s%s%s%s%s%s%s", name + (","), startPos + (","), endPos + (","), startTime + (","), endTime + (","), price + (","), discountPrecent + (","), stopType);

                }

            }
            file.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }

    }
}
