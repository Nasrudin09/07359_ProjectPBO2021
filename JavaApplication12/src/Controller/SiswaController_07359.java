package Controller;

import Entity.SiswaEntity_07359;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class SiswaController_07359 {
    public void insertData(String nama, String npm, String alamat, String password, String no_telp, String jenisKelamin, String kelas){
        SiswaEntity_07359 mahasiswaEntities = new SiswaEntity_07359();
        mahasiswaEntities.setNama_07359(nama);
        mahasiswaEntities.setNpm_07359(npm);
        mahasiswaEntities.setAlamat_07359(alamat);
        mahasiswaEntities.setPassword_07359(password);
        mahasiswaEntities.setnoTelp_07359(no_telp);
        mahasiswaEntities.setJenisKelamin_07359(jenisKelamin);
        mahasiswaEntities.setKelas_07359(kelas);
        AllObjectModel_07359.mahasiswaModel.insertData(mahasiswaEntities);
    }
    
    public void updateData(int urut, String data, int id){
        switch(urut){
            case 1:
                AllObjectModel_07359.mahasiswaModel.updateNama(data, id);
                break;
            case 2:
                AllObjectModel_07359.mahasiswaModel.updateNpm(data, id);
                break;
            case 3:
                AllObjectModel_07359.mahasiswaModel.updateAlamat(data, id);
                break;
            case 4:
                AllObjectModel_07359.mahasiswaModel.updatePassword(data, id);
                break;
            case 5:
                AllObjectModel_07359.mahasiswaModel.updateGambar(data, id);
                break;
            case 6:
                AllObjectModel_07359.mahasiswaModel.updateNoTelp(data, id);
                break;
            case 7:
                AllObjectModel_07359.mahasiswaModel.updateJenisKelamin(data, id);
                break;
            case 8:
                AllObjectModel_07359.mahasiswaModel.updateKelas(data, id);
                break;
        }
    }
    
    public ArrayList<SiswaEntity_07359> getDataSiswa(){
        return AllObjectModel_07359.mahasiswaModel.getSiswa_07359();
    }
    
    public int login(String npm, String password){
        int cek = AllObjectModel_07359.mahasiswaModel.cekLogin(npm, password);
        return cek;
    }
    
    public ArrayList<SiswaEntity_07359> getById(int ceklogin){
        return AllObjectModel_07359.mahasiswaModel.getSiswa_07359(ceklogin);
    }
    
    public int verif(int id){
        int cek = AllObjectModel_07359.mahasiswaModel.cekVerif(id);
        return cek;
    }
    
    public DefaultTableModel daftarSiswa(){
        DefaultTableModel dataDaftarSiswa = new DefaultTableModel();
        Object[] kolom = {"ID", "NAMA", "NPM", "ALAMAT", "NO TELP", "STATUS", "JENIS KELAMIN", "KELAS"};
        dataDaftarSiswa.setColumnIdentifiers(kolom);
        int size = getDataSiswa().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[8];
            data[0] = AllObjectModel_07359.mahasiswaModel.getSiswa_07359().get(i).getId_07359();
            data[1] = AllObjectModel_07359.mahasiswaModel.getSiswa_07359().get(i).getNama_07359();
            data[2] = AllObjectModel_07359.mahasiswaModel.getSiswa_07359().get(i).getNpm_07359();
            data[3] = AllObjectModel_07359.mahasiswaModel.getSiswa_07359().get(i).getAlamat_07359();
            data[4] = AllObjectModel_07359.mahasiswaModel.getSiswa_07359().get(i).getnoTelp_07359();
            data[5] = AllObjectModel_07359.mahasiswaModel.getSiswa_07359().get(i).getJenisKelamin_07359();
            data[6] = AllObjectModel_07359.mahasiswaModel.getSiswa_07359().get(i).getKelas_07359();
            data[7] = AllObjectModel_07359.mahasiswaModel.getSiswa_07359().get(i).getStatus_07359();
            dataDaftarSiswa.addRow(data);
        }
        return dataDaftarSiswa;
    }
}
