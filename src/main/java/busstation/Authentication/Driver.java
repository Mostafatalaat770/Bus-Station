/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package busstation.Authentication;

import java.util.HashMap;


public class Driver implements Authentication {

       HashMap <String, String> driverDB = new HashMap<>();

    @Override
    public boolean createAccount(String username, String password) {
        driverDB.put(username, password);
        return true;
    }
    
    
    @Override
    public boolean authenticate(String username, String password) {
        return (driverDB.get(username).equals(password));
    }

    @Override
    public boolean changePassword(String username, String password, String newPassword) {
        driverDB.replace(username, password, newPassword);
        return true;
    }

}
