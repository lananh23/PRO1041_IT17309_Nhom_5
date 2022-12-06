package Utilities;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.*;

public class DBConnection {

    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";
    private static final String SERVER_NAME = "DESKTOP-CSTQHQ6\\SQLEXPRESS";
    private static final String PORT = "1433";
    private static final String DATABASE_NAME = "QuanLyCuaHangTapHoa";
    private static final boolean USING_SSL = true;
    //public static Connection conn = null;
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;

    private static String CONNECT_STRING;
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbUser = "sa", dbPass = "123",
                        dbUrl = "jdbc:sqlserver://localhost:1433;"
                        + "databaseName=QuanLyCuaHangTapHoa;"
                        + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
                conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                System.out.println("Ket noi thanh cong");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = getConnection();
        String dbpn = conn.getMetaData().getDatabaseProductName();
        System.out.println(dbpn);

    }

}
