package eu.zoho.chaotx.app.data;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 0;

    private String name;
    private String token;

    public User(String name, String token) {
        this.name = name;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }
}