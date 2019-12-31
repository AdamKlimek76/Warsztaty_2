package pl.coderslab.model;

import org.mindrot.jbcrypt.BCrypt;

public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private int userGroupId;

    public User() {
        this.id = 0;
        this.name = null;
        this.email = null;
        this.password = null;
        this.userGroupId = 0;
    }


    public User(int id, String name, String email, String password, int userGroupId) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.hashPassword(password);
        this.userGroupId = userGroupId;
    }

    public void hashPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserGroupId(int userGroupId) {
        this.userGroupId = userGroupId;
    }

    public int getUserGroupId() {
        return userGroupId;
    }

    public String toString() {
        return this.id + " " + this.name + " " + this.email + " " + this.password + " " + this.userGroupId;
    }
}
