package model;

import javax.validation.constraints.NotEmpty;

public class LoginForm {

    @NotEmpty(message = "Email cannot Be Username")
    private String Username;
    @NotEmpty(message = "Password cannot Be empty")
    private String Password;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
