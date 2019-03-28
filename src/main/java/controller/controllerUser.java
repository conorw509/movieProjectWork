package controller;

import org.springframework.jdbc.core.JdbcTemplate;


public class controllerUser {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }





//    public boolean checkLogin(User u) {
//
//        String sql = "";
//        ResultSet rs = null;
//
//        try {
//            sql = "SELECT * FROM users WHERE email = ? and password = ?";
//            pst = con.prepareStatement(sql);
//
//            pst.setString(1, u.getEmail());
//            pst.setString(2, PasswordEncrypt.encryptPassword(u.getPassword()));
//
//            rs = pst.executeQuery();
//
//            if (rs.next()) {
//                return true;
//            } else {
//                return false;
//            }
//
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//
//        return false;
//    }
//
//
//    public boolean checkEmail(User u) {
//
//        String sql = "";
//        ResultSet rs = null;
//
//        try {
//            sql = "SELECT * FROM users WHERE email = ?";
//            pst = con.prepareStatement(sql);
//
//            pst.setString(1, u.getEmail());
//
//            rs = pst.executeQuery();
//
//            if (rs.next()) {
//                return true;
//            } else {
//
//                return false;
//            }
//
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//
//        return false;
//    }


}
