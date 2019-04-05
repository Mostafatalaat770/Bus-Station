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
public class Vehicles {
    private final int capacity;
    boolean hasSepcialNeeds;
    boolean hasAC;
    boolean hasWIFI;

    public Vehicles(int capacity, boolean hasSepcialNeeds, boolean hasAC, boolean hasWIFI) {
        this.capacity = capacity;
        this.hasSepcialNeeds = hasSepcialNeeds;
        this.hasAC = hasAC;
        this.hasWIFI = hasWIFI;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isHasSepcialNeeds() {
        return hasSepcialNeeds;
    }

    public boolean isHasAC() {
        return hasAC;
    }

    public boolean isHasWIFI() {
        return hasWIFI;
    }
    
    
}
