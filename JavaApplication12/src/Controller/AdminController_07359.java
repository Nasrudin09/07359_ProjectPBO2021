package Controller;

import Entity.AdminEntity_07359;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class AdminController_07359 {
    
//    public void insertData(String nama, String npm, String alamat, String password, String no_telp, String petugasKelas){
//        AllObjectModel_07359.adminModel.insertData(new AdminEntity_07359(nama,npm,alamat,password,no_telp,petugasKelas));
//    }
    public void insertData(String nama, String npm, String alamat, String password, String no_telp, String petugasKelas){
        AdminEntity_07359 mahasiswaEntities = new AdminEntity_07359();
        mahasiswaEntities.setNama_07359(nama);
        mahasiswaEntities.setNpm_07359(npm);
        mahasiswaEntities.setAlamat_07359(alamat);
        mahasiswaEntities.setPassword_07359(password);
        mahasiswaEntities.setnoTelp_07359(no_telp);
        mahasiswaEntities.setPetugasKelas_07359(petugasKelas);
        AllObjectModel_07359.adminModel.insertData(mahasiswaEntities);
    }
    public void deleteData(int id){
        AllObjectModel_07359.adminModel.deleteData(id);
    }
    public void updatePassword(String pass, int id){
            AllObjectModel_07359.adminModel.updatePassword(pass, id);
    }
    public void verifSiswa(int id){
        AllObjectModel_07359.adminModel.verifSiswa(id);
    }

    public int login(String npm, String password){
        int log = AllObjectModel_07359.adminModel.cekLogin(npm, password);
        return log;
    }
    
    public ArrayList<AdminEntity_07359> getById(int ceklogin){
        return AllObjectModel_07359.adminModel.getAdmin_07359(ceklogin);
    }
    
    public ArrayList<AdminEntity_07359> getDataAdmin(){
        return AllObjectModel_07359.adminModel.getAdmin_07359();
    }
    
    public DefaultTableModel daftarAdmin(){
        DefaultTableModel dataDaftarAdmin = new DefaultTableModel();
        Object[] kolom = {"ID", "NPM", "ALAMAT", "NAMA", "NOTELP", "PETUGAS KELAS"};
        dataDaftarAdmin.setColumnIdentifiers(kolom);
        int size = getDataAdmin().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[8];
            data[0] = AllObjectModel_07359.adminModel.getAdmin_07359().get(i).getId_07359();
            data[1] = AllObjectModel_07359.adminModel.getAdmin_07359().get(i).getNpm_07359();
            data[2] = AllObjectModel_07359.adminModel.getAdmin_07359().get(i).getNama_07359();
            data[3] = AllObjectModel_07359.adminModel.getAdmin_07359().get(i).getAlamat_07359();
            data[4] = AllObjectModel_07359.adminModel.getAdmin_07359().get(i).getnoTelp_07359();
            data[5] = AllObjectModel_07359.adminModel.getAdmin_07359().get(i).getPetugasKelas_07359();
            dataDaftarAdmin.addRow(data);
        }
        return dataDaftarAdmin;
    }
}

