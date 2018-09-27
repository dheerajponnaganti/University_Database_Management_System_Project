package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection
{
private static final String CON = "jdbc:oracle:thin:cseb14_15/kavyasai123@192.168.23.144:1521:orcl";

public static Connection getconnection() throws SQLException
{
    try
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(CON);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return null;
}
}
