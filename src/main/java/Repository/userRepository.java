package Repository;

import hash.PasswordEncrypt;
import model.PersonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.stereotype.Service;
import java.sql.*;

@Service
public class userRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean createAccount(PersonForm u) {
        String query = "insert into users(firstname,lastname,Username,email,password,repassword) values(?,?,?,?,?,?)";

        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement)
                    throws SQLException, DataAccessException {

                preparedStatement.setString(1, u.getName());
                preparedStatement.setString(2, u.getLastname());
                preparedStatement.setString(3, u.getUsername());
                preparedStatement.setString(4, u.getEmail());
                preparedStatement.setString(5, PasswordEncrypt.encryptPassword(u.getPassword()));
                preparedStatement.setString(6, PasswordEncrypt.encryptPassword(u.getRepassword()));

                return preparedStatement.execute();

            }
        });
    }


    public boolean checkEmail(PersonForm u) {

        String sql = "SELECT * FROM users WHERE email = ?";
        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setString(1, u.getEmail());
                ResultSet rs;
                rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    return true;
                } else {

                    return false;
                }
            }
        });

    }

    public boolean checkLogin(PersonForm u) {

        String sql = "SELECT * FROM users WHERE email = ? and password = ?";
        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setString(1, u.getEmail());
                preparedStatement.setString(2, PasswordEncrypt.encryptPassword(u.getPassword()));
                ResultSet rs;
                rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }
            }
        });

    }
}


