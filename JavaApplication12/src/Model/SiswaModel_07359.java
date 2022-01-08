package Model;

import Entity.SiswaEntity_07359;
import Entity.KelasEntity_07359;
import java.sql.*;
import java.util.ArrayList;

//manipulasi dta, menangani validas dari control tdk berhubungan dgn view
public class SiswaModel_07359 extends ModelAbstract_07359 {
    private String sql;
    public KelasEntity_07359 kelas= new KelasEntity_07359();
    
    public ArrayList<SiswaEntity_07359> getSiswa_07359(){ //getMhs->mengambil dta mhs dri database
        ArrayList<SiswaEntity_07359> arraylistSiswa_07359 = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM mahasiswa_07359";
            ResultSet rs_07359 = stat.executeQuery(sql);
            while(rs_07359.next()) {
                SiswaEntity_07359 mahasiswaEntity_07359 = new SiswaEntity_07359();
                mahasiswaEntity_07359.setId_07359(rs_07359.getInt("id_07359"));
                mahasiswaEntity_07359.setNama_07359(rs_07359.getString("nama_07359"));
                mahasiswaEntity_07359.setNpm_07359(rs_07359.getString("npm_07359"));
                mahasiswaEntity_07359.setAlamat_07359(rs_07359.getString("alamat_07359"));
                mahasiswaEntity_07359.setPassword_07359(rs_07359.getString("password_07359"));
                mahasiswaEntity_07359.setnoTelp_07359(rs_07359.getString("noTelp_07359"));
                mahasiswaEntity_07359.setJenisKelamin_07359(rs_07359.getString("jenisKelamin_07359"));
                mahasiswaEntity_07359.setKelas_07359(rs_07359.getString("kelas_07359"));
                mahasiswaEntity_07359.setStatus_07359(rs_07359.getInt("status"));
                mahasiswaEntity_07359.setGambar_07359(rs_07359.getString("gambar"));
                arraylistSiswa_07359.add(mahasiswaEntity_07359);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistSiswa_07359; //mengembalikan kumpulandata yg  didpt kedlm arraylistMhs
    }
    
    public ArrayList<SiswaEntity_07359> getSiswa_07359(int id){
        ArrayList<SiswaEntity_07359> arrSiswa = new ArrayList<>();
        try {
            sql = "SELECT * FROM mahasiswa_07359 where id_07359 =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                SiswaEntity_07359 mahasiswaEntity = new SiswaEntity_07359();
                
                mahasiswaEntity.setId_07359(rs.getInt("id_07359"));
                mahasiswaEntity.setNama_07359(rs.getString("nama_07359"));
                mahasiswaEntity.setNpm_07359(rs.getString("npm_07359"));
                mahasiswaEntity.setAlamat_07359(rs.getString("alamat_07359"));
                mahasiswaEntity.setPassword_07359(rs.getString("password_07359"));
                mahasiswaEntity.setnoTelp_07359(rs.getString("noTelp_07359"));
                mahasiswaEntity.setJenisKelamin_07359(rs.getString("jenisKelamin_07359"));
                mahasiswaEntity.setKelas_07359(rs.getString("kelas_07359"));
                mahasiswaEntity.setStatus_07359(rs.getInt("status"));
                mahasiswaEntity.setGambar_07359(rs.getString("gambar"));
                arrSiswa.add(mahasiswaEntity);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }return arrSiswa;
    }
    
    public void insertData(SiswaEntity_07359 SiswaEntity) {
        try {
            sql = "INSERT INTO mahasiswa_07359 (nama_07359, npm_07359,alamat_07359, password_07359, noTelp_07359, jenisKelamin_07359, kelas_07359) Values(?,?,?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, SiswaEntity.getNama_07359());
            stat.setString(2, SiswaEntity.getNpm_07359());
            stat.setString(3, SiswaEntity.getAlamat_07359());
            stat.setString(4, SiswaEntity.getPassword_07359());
            stat.setString(5, SiswaEntity.getnoTelp_07359());
            stat.setString(6, SiswaEntity.getJenisKelamin_07359());
            stat.setString(7, SiswaEntity.getKelas_07359());
            
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("GAGAL INPUT DATA!!!");
            e.printStackTrace();
        }
    }
    
    public void updateNama(String nama, int id){
        try{
            sql = "update mahasiswa_07359 SET nama_07359 =? WHERE id_07359 =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH NAMA!!!");
            e.printStackTrace();
        }
    }
    
    public void updateNpm(String npm, int id){
        try{
            sql = "update mahasiswa_07359 SET npm_07359 =? WHERE id_07359 =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, npm);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH NPM!!!");
            e.printStackTrace();
        }
    }
    
    public void updateAlamat(String alamat, int id){
        try{
            sql = "update mahasiswa_07359 SET alamat_07359 =? WHERE id_07359 =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, alamat);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH ALAMAT!!!");
            e.printStackTrace();
        }
    }
    
    public void updateGambar(String gambar, int id){
        try{
            sql = "update mahasiswa_07359 SET gambar =? WHERE id_07359 =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, gambar);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH GAMBAR!!!");
            e.printStackTrace();
        }
    }
    
    public void updatePassword(String password, int id){
        try{
            sql = "update mahasiswa_07359 SET password_07359 =? WHERE id_07359 =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, password);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH PASSWORD!!!");
            e.printStackTrace();
        }
    }
    
    public void updateNoTelp(String noTelp, int id){
        try{
            sql = "update mahasiswa_07359 SET noTelp_07359 =? WHERE id_07359 =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, noTelp);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH NOMOR!!!");
            e.printStackTrace();
        }
    }
    
    public void updateJenisKelamin(String jenisKelamin, int id){
        try{
            sql = "update mahasiswa_07359 SET jenisKelamin_07359 =? WHERE id_07359 =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, jenisKelamin);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH JENISKELAMIN!!!");
            e.printStackTrace();
        }
    }
    
    public void updateKelas(String kelas, int id){
        try{
            sql = "update mahasiswa_07359 SET kelas_07359 =? WHERE id_07359 =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, kelas);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e){
            System.out.println("GAGAL RUBAH KELAS!!!");
            e.printStackTrace();
        }
    }
    
    public int cekLogin(String npm, String password){
        int cek = 0;
        try{
            sql = "SELECT * FROM mahasiswa_07359 where npm_07359 = ? and password_07359 = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, npm);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                cek = rs.getInt("id_07359");
                String nama = rs.getString("nama_07359");
                System.out.println("Selamat Datang " + nama);
            } else {
                cek = 0;
            }
        } catch (SQLException e){
            e.printStackTrace();
        } return cek;
    }
    
    public int cekVerif(int id){
        int cek = 0;
        try {
            sql = "SELECT * FROM mahasiswa_07359 where id_07359 =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                cek = rs.getInt("status");
            } else {
                cek = 0;
            }
        } catch (Exception e){
            e.printStackTrace();
        } return cek;
    }
}