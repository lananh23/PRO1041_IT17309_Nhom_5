package Utilities;

import java.sql.*;

public class DBConnection {
<<<<<<< Updated upstream
    private static Connection conn;
    public static Connection getConnection(){
        if(conn == null){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbUser = "sa", dbPass = "caohieu",
                        dbUrl = "jdbc:sqlserver://localhost:1433;"
                            +"databaseName=QuanLyCuaHangTapHoa;"
                            +"encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
                conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                System.out.println("Kết nối thành công");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
=======

    private static final String USERNAME = "sa";
    private static final String PASSWORD = "caohieu";
    private static final String SERVER_NAME = "DESKTOP-6V5UK4J\\SQLEXPRESS";
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
>>>>>>> Stashed changes
            }
            
        }
        return conn;
    }
    public static void main(String[] args) {
        getConnection();
    }
}
