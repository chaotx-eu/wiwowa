package eu.zoho.chaotx.app.logic;

import eu.zoho.chaotx.crypt.Encryptor;

/**
 * Manages the state of projects which are dedicated
 * to users and therefore password protected. There
 * may only be one instance of this class (Singleton)
 * which is either the default ProjectManager without
 * any Projects or a ProjectManager which is loaded
 * from the .projects-File
 */
public class ProjectManager {
    // private ctor so no instance
    // can be created from outside
    private ProjectManager() {super();}

    /**
     * Loads the project manager from the .projects-File
     * or creates a new empty project manager if the file
     * does not exist
     * 
     * @return the loaded/created project manager
     */
    public static ProjectManager getInstance() {
        Encryptor e = new Encryptor();
        return new ProjectManager();
    }
}