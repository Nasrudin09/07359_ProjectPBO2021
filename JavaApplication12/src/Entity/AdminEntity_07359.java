package Entity;

public class AdminEntity_07359 extends UserEntityAbstract_07359 {
    private String petugasKelas_07359;
    public AdminEntity_07359(){};
    public AdminEntity_07359(String nama_07359, String npm_07359,String alamat_07359, String password_07359, String noTelp_07359, String petugasKelas_07359){
        super(nama_07359,npm_07359,alamat_07359,password_07359,noTelp_07359);
        this.petugasKelas_07359 = petugasKelas_07359;
    }
    
    public String getPetugasKelas_07359(){ return petugasKelas_07359; }
    public void setPetugasKelas_07359(String petugasKelas_07359){ this.petugasKelas_07359 = petugasKelas_07359; }
}
