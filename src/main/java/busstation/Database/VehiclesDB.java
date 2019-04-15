/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package busstation.Database;

import busstation.Vehicles.Bus;
import busstation.Vehicles.Limousine;
import busstation.Vehicles.MiniBus;
import java.util.ArrayList;

/**
 *
 * @author Mostafa Talaat
 */
public class VehiclesDB {
    private ArrayList<Bus> buses = new ArrayList<>();
    private ArrayList<MiniBus> miniBuses = new ArrayList<>();
    private ArrayList<Limousine> limousines = new ArrayList<>();

    public void createBus(String name,int capacity, boolean hasSepcialNeeds, boolean hasAC, boolean hasWIFI) {
        buses.add(new Bus(name,capacity, hasSepcialNeeds, hasAC, hasWIFI));
    }

    public void createMiniBus(String name,int capacity, boolean hasSepcialNeeds, boolean hasAC, boolean hasWIFI) {
        miniBuses.add(new MiniBus(name,capacity, hasSepcialNeeds, hasAC, hasWIFI));
    }

    public void createLimousine(String name,int capacity, boolean hasSepcialNeeds, boolean hasAC, boolean hasWIFI) {
limousines.add(new Limousine(name,capacity, hasSepcialNeeds, hasAC, hasWIFI));
    }

    public ArrayList<Bus> getBuses() {
        return buses;
    }

    public ArrayList<MiniBus> getMiniBuses() {
        return miniBuses;
    }

    public ArrayList<Limousine> getLimousines() {
        return limousines;
    }
    
    
}
