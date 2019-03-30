package model;

import validators.FieldMatch;

import javax.validation.constraints.*;


//
//@FieldMatch.List({
// ,
//        @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
//})
@FieldMatch(first = "repassword", second = "password", message = "The password fields must match")
public class PersonForm {

    private int id;
    @NotEmpty(message = "Name cannot Be empty")
    @Size(min = 3, max = 15, message = "Name must be between 3 and 15 characters")
    private String name;
    @NotEmpty(message = "Last Name cannot Be empty")
    @Size(min = 3, max = 20, message = "Last Name must be between 3 and 20 characters")
    private String lastname;
    @Pattern(regexp = "(.*[a-z].*)", message = "Username must contain at Least 1 lowercase Letter")
    @Pattern(regexp = "(.*[0-9].*)", message = "Username must contain at Least 1 number")
    @Pattern(regexp = "(.*[A-Z].*)", message = " Username must contain at Least 1 uppercase Letter")
    @NotEmpty(message = "Last Name cannot Be empty")
    @Size(min = 5, max = 15, message = "Username must be between 5 and 15 characters")
    private String Username;
    @NotEmpty(message = "Email cannot Be empty")
    private String email;
    @NotEmpty(message = "Password cannot Be empty")
    @Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters")
    @Pattern(regexp = "(.*[A-Z].*)", message = "Password must contain at Least 1 uppercase Letter")
    @Pattern(regexp = "(.*[a-z].*)", message = "Password must contain at Least 1 lowercase Letter")
    @Pattern(regexp = "(.*[0-9].*)", message = "Password must contain at Least 1 number")
    private String password;
    @NotEmpty
    private String repassword;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getRepassword() {
        return repassword;
    }
}