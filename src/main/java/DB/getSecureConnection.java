package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class getSecureConnection {


    private Connection con;

    public getSecureConnection() {
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/bank", "root", "Lola.1.2.3");
        } catch (SQLException ex) {
            Logger.getLogger(getSecureConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection returnConnection() {
        return con;
    }

}
