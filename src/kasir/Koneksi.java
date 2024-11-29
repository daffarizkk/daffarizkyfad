package kasir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    // Konstanta untuk konfigurasi database
    private static final String URL = "jdbc:mysql://localhost:3306/barang"; // Nama database diubah menjadi 'barang'
    private static final String USER = "root"; // Ganti sesuai username MySQL Anda
    private static final String PASSWORD = ""; // Ganti sesuai password MySQL Anda

    // Method untuk mendapatkan koneksi
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi ke database berhasil!");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC tidak ditemukan: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Koneksi database gagal: " + e.getMessage());
        }
        return conn;
    }

    // Method untuk menutup koneksi
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Koneksi ditutup!");
            } catch (SQLException e) {
                System.err.println("Gagal menutup koneksi: " + e.getMessage());
            }
        }
    }
}
