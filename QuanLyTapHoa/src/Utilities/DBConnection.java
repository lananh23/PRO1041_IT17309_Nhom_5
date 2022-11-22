package Utilities;

import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;

public class DBConnection {
<<<<<<< HEAD

    
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";
    private static final String SERVER_NAME = "DESKTOP-CSTQHQ6\\SQLEXPRESS";
    private static final String PORT = "1433";
    private static final String DATABASE_NAME = "QuanLyCuaHangTapHoa";
    private static final boolean USING_SSL = true;
    public static Connection conn = null;

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
=======
    private static Connection conn;
    public static Connection getConnection(){
        if(conn == null){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbUser = "sa", dbPass = "Aa@123456",
                        dbUrl = "jdbc:sqlserver://localhost:1433;"
                            +"databaseName=QuanLyCuaHangTapHoa;"
                            +"encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
                conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                System.out.println("Kết nối thành công");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
>>>>>>> parent of c026d28 (Commit_5_thanhhieu_Login)
            }
            
        }
        return conn;
    }
    public static void main(String[] args) {
        getConnection();
    }
<<<<<<< HEAD

    public static void main(String[] args) throws SQLException {
        Connection conn = getConnection();
        String dbpn = conn.getMetaData().getDatabaseProductName();
        System.out.println(dbpn);

    }

    //hàm thực thi câu lệnh select
    public static ResultSet Getdata(String cauTruyVan) {
        try {
            Statement stm = conn.createStatement();
            //thực thicaau truy vấn select dc truyền vào từ
            //tham số cautruyvan
            //trả về kết quả là ResultSet
            ResultSet rs = stm.executeQuery(cauTruyVan);
            return rs;//trả về resultset nếu thành công
        } catch (SQLException ex) {
            System.out.println("lỗi truy vấn");
            return null;
        }

    }

    // hàm thực thi 3 câu lệnh insert delete update
    public static int ExecuteTruyVan(String cauTruyVan) {
        try {

            Statement stm = conn.createStatement();
            return stm.executeUpdate(cauTruyVan);

        } catch (SQLException ex) {
            System.out.println("lỗi thực thi truy vấn");
            return -1;
        }
    }

=======
>>>>>>> parent of c026d28 (Commit_5_thanhhieu_Login)
}
