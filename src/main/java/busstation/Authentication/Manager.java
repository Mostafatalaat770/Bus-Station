/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package busstation.Authentication;

import java.util.HashMap;
import java.util.Map;


public class Manager implements Authentication {
    HashMap<String, String> managerDB = new HashMap<>();

    @Override
    public boolean createAccount(String username, String password) {
        managerDB.put(username, password);
        return true;
    }

    @Override
    public boolean authenticate(String username, String password) {
        return (managerDB.get(username).equals(password));
    }

    @Override
    public boolean changePassword(String username, String password, String newPassword) {
        managerDB.replace(username, password, newPassword);
        return true;
    }

}
