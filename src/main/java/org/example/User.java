package org.example;

import java.util.Objects;

public abstract class User {
    String username;
    String email;

    public User() {
        this.username = "";
        this.email = "";
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(email, user.email);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    /**
     * displays the users information
     */
    public void displayProfile() {
        System.out.println("Username: " + username + "\nEmail: " + email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
