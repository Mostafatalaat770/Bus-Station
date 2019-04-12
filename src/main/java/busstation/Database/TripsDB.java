/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Database;

import busstation.Trips.ExternalTrip;
import busstation.Trips.InternalTrip;
import java.util.ArrayList;

/**
 *
 * @author Mostafa Talaat
 */
public class TripsDB {

    ArrayList<InternalTrip> internalTripsDB = new ArrayList<>();
    ArrayList<ExternalTrip> externalTripsDB = new ArrayList<>();
    ArrayList<String> internalTripsName=new ArrayList<>();
    ArrayList<String> externalTripsName=new ArrayList<>();

    public boolean createInternalTrip(String name, String startPos, String endPos, String starTime, String endTime, String price, String discountPrecent, String stopType) {
        internalTripsName.add(name);
        internalTripsDB.add(new InternalTrip(name, startPos, endPos, starTime, endTime, price, discountPrecent, stopType));
        return true;
    }

    public boolean createExternalTrip(String name, String startPos, String endPos, String starTime, String endTime, String price, String discountPrecent, String stopType) {
        externalTripsName.add(name);
        externalTripsDB.add(new ExternalTrip(name, startPos, endPos, starTime, endTime, price, discountPrecent, stopType));
        return true;
    }

    public ArrayList<InternalTrip> getInternalTrips() {
        return internalTripsDB;
    }

    public ArrayList<ExternalTrip> getExternalTrips() {
        return externalTripsDB;
    }

    public ArrayList<String> getInternalTripsName() {
        return internalTripsName;
    }

    public ArrayList<String> getExternalTripsName() {
        return externalTripsName;
    }
}
