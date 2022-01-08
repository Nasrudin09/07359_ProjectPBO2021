package Model;

import Entity.AdminEntity_07359;
import java.sql.*;
import java.util.ArrayList;

public class AdminModel_07359 extends ModelAbstract_07359{
    private String sql;
    
    public void insertData(AdminEntity_07359 AdminEntity){
        try {
            sql = "INSERT INTO admin_07359 (nama_07359, npm_07359,alamat_07359, password_07359, noTelp_07359,petugasKelas_07359) Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, AdminEntity.getNama_07359());
            stat.setString(2, AdminEntity.getNpm_07359());
            stat.setString(3, AdminEntity.getAlamat_07359());
            stat.setString(4, AdminEntity.getPassword_07359());
            stat.setString(5, AdminEntity.getnoTelp_07359());
            stat.setString(6, AdminEntity.getPetugasKelas_07359());
            stat.executeUpdate();
        } catch(SQLException e) {
            System.out.println("GAGAL INPUT DATA!!!");
            System.out.println(e);
        }
    }
    
    public ArrayList<AdminEntity_07359> getAdmin_07359(){ //getMhs->mengambil dta mhs dri database
        ArrayList<AdminEntity_07359> arraylistAdmin_07359 = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM admin_07359";
            ResultSet rs_07359 = stat.executeQuery(sql);
            while(rs_07359.next()) {
                AdminEntity_07359 adminEntity_07359 = new AdminEntity_07359();
                adminEntity_07359.setId_07359(rs_07359.getInt("id_07359"));
                adminEntity_07359.setNama_07359(rs_07359.getString("nama_07359"));
                adminEntity_07359.setNpm_07359(rs_07359.getString("npm_07359"));
                adminEntity_07359.setAlamat_07359(rs_07359.getString("alamat_07359"));
                adminEntity_07359.setPassword_07359(rs_07359.getString("password_07359"));
                adminEntity_07359.setnoTelp_07359(rs_07359.getString("noTelp_07359"));
                adminEntity_07359.setPetugasKelas_07359(rs_07359.getString("petugasKelas_07359"));
                arraylistAdmin_07359.add(adminEntity_07359);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arraylistAdmin_07359; //mengembalikan kumpulandata yg  didpt kedlm arraylistMhs
    }
    
    public ArrayList<AdminEntity_07359> getAdmin_07359(int id){
        ArrayList<AdminEntity_07359> arrAdmin = new ArrayList<>();
        try {
            sql = "SELECT * FROM admin_07359 where id_07359 =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                AdminEntity_07359 adminEntity = new AdminEntity_07359();
                
                adminEntity.setId_07359(rs.getInt("id_07359"));
                adminEntity.setNama_07359(rs.getString("nama_07359"));
                adminEntity.setNpm_07359(rs.getString("npm_07359"));
                adminEntity.setAlamat_07359(rs.getString("alamat_07359"));
                adminEntity.setPassword_07359(rs.getString("password_07359"));
                adminEntity.setnoTelp_07359(rs.getString("noTelp_07359"));
                adminEntity.setPetugasKelas_07359(rs.getString("petugasKelas_07359"));
                arrAdmin.add(adminEntity);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }return arrAdmin;
    }
    
    @Override
    public void updatePassword(String password, int id){
        try {
            sql = "update admin_07359 SET password_07359 =? WHERE id_07359 =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, password);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch(SQLException e) {
            System.out.println("GAGAL RUBAH PASSWORD!!!");
            System.out.println(e);
        }
    }
    
    @Override
    public int cekLogin(String npm, String password){
        int cek = 0;
        try {
            sql = "SELECT * FROM admin_07359 where npm_07359 = ? and password_07359 = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, npm);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
               cek = rs.getInt("id_07359");
            } else {
                cek = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } return cek;
    }
    
    public void verifSiswa(int id){
        try {
            sql = "update mahasiswa_07359 SET status = 1 WHERE id_07359 =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteData(int id){
        try {
            sql = "DELETE FROM mahasiswa_07359 where id_07359 =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            stat.executeUpdate();
        } catch (SQLException e) {
            System.out.println("GAGAL Hapus DATA!!!");
        }
    }
}