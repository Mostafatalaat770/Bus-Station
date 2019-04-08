/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Trips;

/**
 *
 * @author Mostafa Talaat
 */
public abstract class Trips {

    private String name;
    private String startPos;
    private String endPos;
    private String distance;
    private double duration;
    private int stopType; // 1 : Non-Stop, 2 : One-Stop, 3 : Many-Stops.

    public Trips(String name, String startPos, String endPos, String distance, double duration, int stopType) {
        this.name = name;
        this.startPos = startPos;
        this.endPos = endPos;
        this.distance = distance;
        this.duration = duration;
        this.stopType = stopType;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartPos() {
        return startPos;
    }

    public void setStartPos(String startPos) {
        this.startPos = startPos;
    }

    public String getEndPos() {
        return endPos;
    }

    public void setEndPos(String endPos) {
        this.endPos = endPos;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getStopType() {
        return stopType;
    }

    public void setStopType(int stopType) {
        this.stopType = stopType;
    }


}
