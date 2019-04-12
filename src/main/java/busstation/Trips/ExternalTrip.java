/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Trips;

public class ExternalTrip extends Trips {

    public ExternalTrip(String name, String startPos, String endPos, double startTime, double endTime, double price, double discountPrecent, String stopType) {
        super(name, startPos, endPos, startTime, endTime, price, discountPrecent, stopType);
    }

}
