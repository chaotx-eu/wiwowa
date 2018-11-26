package eu.zoho.chaotx.app.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import eu.zoho.chaotx.app.App;
import eu.zoho.chaotx.app.data.User;
import eu.zoho.chaotx.crypt.Encryptor;

/**
 * Manager for all users located in the .users
 * file of the APP_DIR. Also offers functionalities
 * to login and register users
 */
public class UserManager implements Serializable {
    private static final long serialVersionUID = 0;

    // Name of the users-File
    public static final String USERS_FILE = ".users";

    // Length used for password tokens
    public static final int TOKEN_LENGTH = 128;

    // Map holding all the users with their name as key
    private Map<String, User> userMap;

    // Encryptor of this manager used for user passwords
    private Encryptor encryptor;

    // Currently logged in user
    private User loggedInUser = null;

    // private ctor so no instance
    // can be created from outside
    private UserManager() {
        super();
        userMap = new HashMap<>();
        encryptor = new Encryptor();
    }

    /**
     * Trys to register a new user and returns wether
     * the operation succeded.
     * 
     * @param name user name
     * @param password user password
     * @return true if user has been registered or false
     *         if a user with the passed user name already
     *         exists in this manager
     */
    public boolean register(String name, String password) {
        if(userMap.containsKey(name)) return false;
        userMap.put(name, new User(name,
            encryptor.createToken(password, TOKEN_LENGTH)));

        return true;
    }

    /**
     * Trys to log the user in and returns wether
     * the operation succeded.
     * 
     * @param name user name
     * @param password user password
     * @return true on success or false if the password was incorrect
     * @throws IllegalArgumentException if user does not exist in this manager
     */
    public boolean login(String name, String password) throws IllegalArgumentException {
        if(!userMap.containsKey(name))
            throw new IllegalArgumentException("User '" + name + "' does not exist");

        if(encryptor
        .createToken(password, TOKEN_LENGTH)
        .equals(userMap.get(name).getToken())) {
            loggedInUser = userMap.get(name);
            return true;
        }

        return false;
    }

    /**
     * Logs out currently logged in user
     * 
     * @return true on success false otherwise
     *         i.e. no user was logged in
     */
    public boolean logout() {
        boolean wasLoggedIn = loggedInUser != null;
        loggedInUser = null;
        return wasLoggedIn;
    }

    /**
     * Returns the currently logged in user
     * 
     * @return logged in user or null if no
     *         user is logged in
     */
    public User getLoggedInUser() {
        return loggedInUser;
    }

    /**
     * Saves this user manager to the
     * file at the passed path
     */
    public void save(String filePath) {
        User backup = loggedInUser;
        loggedInUser = null;
        
        try(ObjectOutputStream oos = new ObjectOutputStream(
        new FileOutputStream(filePath))) {
            oos.writeObject(this);
            loggedInUser = backup;
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            loggedInUser = backup;
        }
    }

    /**
     * Overload for convenience which saves this
     * user manager to the USERS_FILE by default
     */
    public void save() {
        save(App.APP_DIR + File.separator + USERS_FILE);
    }

    /**
     * Loads the user manager from the file at the passed
     * path or creates a new empty project manager if the
     * file does not exist
     * 
     * @return the loaded/created user manager
     *         or null in case an error occured
     *         during load
     */
    public static UserManager load(String filePath) {
        if(!(new File(filePath).isFile()))
            return new UserManager();

        try(ObjectInputStream ois = new ObjectInputStream(
        new FileInputStream(filePath))) {
            return (UserManager)ois.readObject();
        } catch(ClassNotFoundException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Overload for convenience which loads the
     * user manager from the USERS_FILE by default
     * 
     * @return loaded/created user manager
     */
    public static UserManager load() {
        return load(App.APP_DIR + File.separator + USERS_FILE);
    }
}