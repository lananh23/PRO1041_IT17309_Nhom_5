package Utilities;

import java.sql.*;

public class DBConnection {

    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
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
            }

        }
        return conn;
    }

    public static void main(String[] args) {
        getConnection();
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = getConnection();
        String dbpn = conn.getMetaData().getDatabaseProductName();
        System.out.println(dbpn);

    }

    //hàm thực thi câu lệnh select
    public static ResultSet Getdata(String cauTruyVan) {
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(cauTruyVan);
            //thực thicaau truy vấn select dc truyền vào từ
            //tham số cautruyvan
            //trả về kết quả là ResultSet
            rs = ps.executeQuery();
            return rs;//trả về resultset nếu thành công
        } catch (SQLException ex) {
            System.out.println("Loi thuc thi truy van");
            return null;
        }

    }

    // hàm thực thi 3 câu lệnh insert delete update
    public static int ExecuteTruyVan(String cauTruyVan) {
        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(cauTruyVan);
            return ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Loi thuc thi truy van");
            return -1;
        }
    }

}
