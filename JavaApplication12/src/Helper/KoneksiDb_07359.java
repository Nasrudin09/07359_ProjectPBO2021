package Helper;
import java.sql.Connection;
import java.sql.DriverManager;

// mengoneksi bahasa java dengan database(MySQL)
public class KoneksiDb_07359 {
    public static Connection getconnection(){
        Connection conn = null;
        String driver = "com.mysql.cj.jdbc.Driver"; //memanggil driver
        String url = "jdbc:mysql://localhost:3306/khursus_english"; //database
        String user = "root"; //xampp
        String pass = "";
        //blok
        try {
            Class.forName(driver); // memanggail driver
            conn = DriverManager.getConnection(url, user, pass); //mengconect
            System.out.println("Berhasil Koneksi Database");
        } catch (Exception e) {
            System.out.println("Gagal Koneksi Database");
            e.printStackTrace();
        }
        return conn;
    }
}