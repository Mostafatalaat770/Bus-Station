/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Vehicles;

/**
 *
 * @author Mostafa Talaat
 */
public abstract class Vehicles {
    private final int capacity;
    private final boolean specialNeeds;
    private final boolean AC;
    private final boolean WIFI;

    public Vehicles(int capacity, boolean specialNeeds, boolean AC, boolean WIFI) {
        this.capacity = capacity;
        this.specialNeeds = specialNeeds;
        this.AC = AC;
        this.WIFI = WIFI;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isSepcialNeeds() {
        return specialNeeds;
    }

    public boolean isAC() {
        return AC;
    }

    public boolean isWIFI() {
        return WIFI;
    }
    
    
    }
