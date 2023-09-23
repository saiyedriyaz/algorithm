package net.demo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class JDBCDemo {
    public static void main(String[] args) throws SQLException {
        Connection c = null;////get connection

                String qr = "insert into STOCK ( ID, TICKER, LASTPRICE, EXCHANGE ) "+
                "values( ?, ?, ?, ?)";
        PreparedStatement ps = c.prepareStatement(qr);
        ps.setInt(1, 1);
        ps.setString(2, "APPL");
        ps.setNull(3, Types.INTEGER);
        ps.setNull(4, Types.VARCHAR);
        ps.setString(4, null);
    }
}
