package Utilities;

import java.sql.*;

public class DBConnection {

    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbUser = "sa", dbPass = "123",
                        dbUrl = "jdbc:sqlserver://localhost:1433;"
                        + "databaseName=QuanLyTapHoa;"
                        + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
                conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                System.out.println("Kết nối thành công");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return conn;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
