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
    private String name;
    private int capacity;
    private boolean specialNeeds;
    private boolean AC;
    private boolean WIFI;
    
    public void bookSeat(){
        capacity--;
    }
    public Vehicles(String name,int capacity, boolean specialNeeds, boolean AC, boolean WIFI) {
        this.name = name;
        this.capacity = capacity;
        this.specialNeeds = specialNeeds;
        this.AC = AC;
        this.WIFI = WIFI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(boolean specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public boolean isAC() {
        return AC;
    }

    public void setAC(boolean AC) {
        this.AC = AC;
    }

    public boolean isWIFI() {
        return WIFI;
    }

    public void setWIFI(boolean WIFI) {
        this.WIFI = WIFI;
    }

}
