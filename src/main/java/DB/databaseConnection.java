package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class databaseConnection {

    private Connection con;
    private String url;
    private String username;
    private String password;


    public databaseConnection() {
        url = "jdbc:derby://localhost:1527/bank";
        username = "root";
        password = "Lola.1.2.3";

    }

    public Connection getConnection() {
        //loading driver
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return con;
    }

    public PreparedStatement prepareStatement(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


