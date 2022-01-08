package Entity;

import java.util.ArrayList;

public class KelasEntity_07359 {
    public KelasEntity_07359(){}
    public ArrayList<String> daftarKelas(){
        ArrayList<String> kelas = new ArrayList<String>();
        kelas.add("Basic English");
        kelas.add("Pro English");
        kelas.add("Intermetidate English");
        return kelas;
    }

    public void lihatKelas(){
        int i = 0;
        for(String Kelas : daftarKelas()){
            System.out.println((i)+". "+Kelas);
            i++;
        }
    }

}
