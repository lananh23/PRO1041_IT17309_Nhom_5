package Utilities;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.*;

public class DBConnection {

    private static final String USERNAME = "sa";
    private static final String PASSWORD = "caohieu";
    private static final String SERVER_NAME = "DESKTOP-6V5UK4J\\\\SQLEXPRESS";
    private static final String PORT = "1433";
    private static final String DATABASE_NAME = "QuanLyCuaHangTapHoa";
    private static final boolean USING_SSL = true;
    public static Connection conn = null;
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;

    private static String CONNECT_STRING;

    static {
        try {
            DriverManager.registerDriver(new SQLServerDriver());
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            StringBuilder connectStringBuilder = new StringBuilder();
            connectStringBuilder.append("jdbc:sqlserver://")
                    .append(SERVER_NAME).append(":").append(PORT).append(";")
                    .append("databaseName=").append(DATABASE_NAME).append(";")
                    .append("user=").append(USERNAME).append(";")
                    .append("password=").append(PASSWORD).append(";");
            if (USING_SSL) {
                connectStringBuilder.append("encrypt=true;trustServerCertificate=true;");
            }
            CONNECT_STRING = connectStringBuilder.toString();
            System.out.println("Connect String co dang: " + CONNECT_STRING);
            System.out.println("Ket noi thanh cong");
        } catch (Exception ex) {
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECT_STRING);
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = getConnection();
        String dbpn = conn.getMetaData().getDatabaseProductName();
        System.out.println(dbpn);

    }
    }