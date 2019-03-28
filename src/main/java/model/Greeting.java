package model;


import javax.validation.constraints.NotEmpty;

public class Greeting {

    @NotEmpty(message = "Email cannot Be empty")
    private String Email;
    @NotEmpty(message = "Password cannot Be empty")
    private String Password;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}