package Entity;

public class SiswaEntity_07359 extends UserEntityAbstract_07359 {
    private String jenisKelamin_07359; // sudah ada pada database,shg lgsg panggil gett/sett
    private String kelas_07359;
    private String gambar_07359;
    private int status_07359;
    
    
    //langsung menuju ke userEntity
    public SiswaEntity_07359(){};
    
    //mengisi attr encap
    public String getJenisKelamin_07359(){ return jenisKelamin_07359; }
    public String getKelas_07359(){ return kelas_07359; }
    public int getStatus_07359(){ return status_07359; }
    public String getGambar07359(){ return gambar_07359; }
    
    public void setJenisKelamin_07359(String jenisKelamin_07359) { this.jenisKelamin_07359 = jenisKelamin_07359; }
    public void setKelas_07359(String kelas_07359) { this.kelas_07359 = kelas_07359; }
    public void setStatus_07359(int status_07359) { this.status_07359 = status_07359; }
    public void setGambar_07359(String gambar_07359) { this.gambar_07359 = gambar_07359; }
}