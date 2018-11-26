package eu.zoho.chaotx.app.data;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The user class offers persons the ability to register
 * themselfs within this app by genertaing a unique
 * user object dependent of a personal password
 */
public class User implements Serializable {
    private static final long serialVersionUID = 0;

    private String name;
    private String token;
    private Project activeProject;
    private Map<String, Project> projectMap;

    /**
     * Creates a new user with the passed name and
     * its (preferably) uniquely generated token
     * 
     * @param name user name
     * @param token generated token
     */
    public User(String name, String token) {
        this.name = name;
        this.token = token;
        projectMap = new HashMap<>();
    }

    /**
     * Returns the name of the user
     * 
     * @return user name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the token of the user
     * 
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * Returns the currently active project of this user
     * 
     * @return active project or null if no project is active
     */
    public Project getActiveProject() {
        return activeProject;
    }
    
    /**
     * Marks a project from this users project map as active project
     * 
     * @param title title of the project 
     * @throws IllegalArgumentException if a project with that
     *                                  title does not exist
     */
    public void setActiveProject(String title) throws IllegalArgumentException {
        if(projectMap.containsKey(title))
            throw new IllegalArgumentException("A project with the title '"
                + title + "' does not exist");
                
        activeProject = projectMap.get(title);
    }

    /**
     * Adds a new project to this users project map
     * 
     * @param title title of the project
     * @throws IllegalArgumentException if a project with that
     *                                  title already exists
     */
    public void addProject(String title) throws IllegalArgumentException {
        if(projectMap.containsKey(title))
            throw new IllegalArgumentException("A project with the title '"
                + title + "' already exists");

        projectMap.put(title, new Project());
    }

    /**
     * Removes a project from this users project map
     * 
     * @param title title of the project
     * @return the removed project or null if no project
     *         with the passed title was present
     */
    public Project removeProject(String title) {
        return projectMap.remove(title);
    }

    /**
     * Returns the whole project map without write access
     * 
     * @return readonly project map
     */
    public Map<String, Project> getProjectMap() {
        return Collections.unmodifiableMap(projectMap);
    }
}