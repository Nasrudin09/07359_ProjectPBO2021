package Entity;

//class yg belum jelas implement
public abstract class UserEntityAbstract_07359 {
    //dapatdipanggil oleh class yg sama dan anak kelas yg  mewarisinya
    protected int id_07359;
    protected String nama_07359,npm_07359,alamat_07359, password_07359, noTelp_07359;
    
    public UserEntityAbstract_07359(){
    }
    
    public UserEntityAbstract_07359(String nama_07359,String npm_07359, String alamat_07359, String password_07359, String noTelp_07359){
        this.nama_07359 = nama_07359;
        this.npm_07359 = npm_07359;
        this.alamat_07359  = alamat_07359;
        this.password_07359 = password_07359;
        this.noTelp_07359 = noTelp_07359;
    }
    
    //attribut encapsulation
    public int getId_07359(){ return id_07359; }
    public String getNama_07359(){ return nama_07359; }
    public String getNpm_07359(){ return npm_07359; }
    public String getAlamat_07359(){ return alamat_07359; }
    public String getPassword_07359(){ return password_07359; }
    public String getnoTelp_07359(){ return noTelp_07359;}
    
    public void setId_07359(int id_07359){ this.id_07359 = id_07359; }
    public void setNama_07359(String nama_07359){ this.nama_07359 = nama_07359; }
    public void setNpm_07359(String npm_07359){ this.npm_07359 = npm_07359; }
    public void setAlamat_07359(String alamat_07359){ this.alamat_07359 = alamat_07359; }
    public void setPassword_07359(String password_07359){ this.password_07359 = password_07359; }
    public void setnoTelp_07359(String noTelp_07359){ this.noTelp_07359 = noTelp_07359; }
}
