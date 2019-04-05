/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.Authentication;

/**
 *
 * @author Mostafa Talaat
 */
public interface Authentication {

    public boolean authenticate(String username, String password);

    public boolean createAccount(String username, String password);

    public boolean changePassword(String username, String password,
            String newPassword);

}
