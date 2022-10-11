package com.group5;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SiteuserRepository
{
    @Autowired
    private DataSource dataSource;

    public Siteuser findUser(Integer id)
    {
        Siteuser user = null;

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, username, password FROM siteuser WHERE id = " + id)) {

            if (rs.next()){
                user = (new Siteuser(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
