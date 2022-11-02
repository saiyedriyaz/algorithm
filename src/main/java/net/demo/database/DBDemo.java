package net.demo.database;

import java.sql.DriverManager;

public class DBDemo {
    public static void main(String[] args) throws java.sql.SQLException {
        var sql = "select * from system";
        var con = DriverManager.getConnection("jdbc:derby:zoo");
        try (var ps = con.prepareStatement(sql)) {
            var rs = ps.executeQuery();
            while(rs.next()) {
                System.out.println("hellow world..");
            }
        }
    }
}
