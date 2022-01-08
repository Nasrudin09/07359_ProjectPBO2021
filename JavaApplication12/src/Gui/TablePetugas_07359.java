package Gui;

import Entity.AdminEntity_07359;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class TablePetugas_07359 extends ComponentGui_07359 {
    JTable tabelpetugasKelas = new JTable();
    JScrollPane sppetugasKelas = new JScrollPane(tabelpetugasKelas);
    JTextField textpilih = new JTextField();
    int kode;
    int id;
    String nama, npm, alamat, password, notelp, petugasKelas;
    
    public TablePetugas_07359(){}
    public TablePetugas_07359 (int cek){
    initComponent(cek);
    }

    void initComponent(final int cek){
        for(AdminEntity_07359 mahasiswaEntities : AllObjectController_07359.admin.getById(cek)) {
            this.id       = mahasiswaEntities.getId_07359();
            this.nama     = mahasiswaEntities.getNama_07359();
            this.npm      = mahasiswaEntities.getNpm_07359();
            this.alamat   = mahasiswaEntities.getAlamat_07359();
            this.password = mahasiswaEntities.getPassword_07359();
            this.notelp   = mahasiswaEntities.getnoTelp_07359();
            this.petugasKelas   = mahasiswaEntities.getPetugasKelas_07359();
        }
        
        setTitle("PROGRAM VERIF MAHASISWA");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        labelnama.setBounds(25, 50, 40, 25);
        add(labelnama);
        fieldnama.setBounds(120, 50, 100, 25);
        fieldnama.setText(nama);
        fieldnama.setEditable(false);
        add(fieldnama);
        
        labelnpm.setBounds(25, 80, 40, 25);
        add(labelnpm);
        fieldnpm.setBounds(120, 80, 100, 25);
        fieldnpm.setText(npm);
        fieldnpm.setEditable(false);
        add(fieldnpm);
        
        labelalamat.setBounds(25, 110, 40, 25);
        add(labelalamat);
        fieldalamat.setBounds(120, 110, 100, 25);
        fieldalamat.setText(alamat);
        fieldalamat.setEditable(false);
        add(fieldalamat);
        
        labelpassword.setBounds(25, 140, 80, 25);
        add(labelpassword);
        fieldpassword.setBounds(120, 140, 100, 25);
        fieldpassword.setText(password);
        fieldpassword.setEditable(false);
        add(fieldpassword);
        
        labelnotelp.setBounds(25, 170, 80, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(120, 170, 100, 25);
        fieldnotelp.setText(notelp);
        fieldnotelp.setEditable(false);
        add(fieldnotelp);
        
        labelpetugasKelas.setBounds(25, 200, 40, 25);
        add(labelpetugasKelas);
        fieldpetugasKelas.setBounds(120, 200, 100, 25);
        fieldpetugasKelas.setText(petugasKelas);
        fieldpetugasKelas.setEditable(false);
        add(fieldpetugasKelas);
        
        setTitle("DAFTAR PETUGAS KELAS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setVisible(true);
        
        sppetugasKelas.setBounds(20, 50, 500, 350);
        tabelpetugasKelas.setModel(AllObjectController_07359.admin.daftarAdmin());
        add(sppetugasKelas);
        
        tabelpetugasKelas.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelpetugasKelas.getSelectedRow();
                textpilih.setText(AllObjectController_07359.admin.daftarAdmin().getValueAt(i, 0).toString());
            }
        });
    }
        
//    public TablePetugas_07359 (int cek){
//    initComponent(cek);
//    }
//    
//    void initComponent(final int cek){
//        for(AdminEntity_07359 mahasiswaEntities : AllObjectController_07359.admin.getById(cek)) {
//            this.id       = mahasiswaEntities.getId_07359();
//            this.nama     = mahasiswaEntities.getNama_07359();
//            this.npm      = mahasiswaEntities.getNpm_07359();
//            this.alamat   = mahasiswaEntities.getAlamat_07359();
//            this.password = mahasiswaEntities.getPassword_07359();
//            this.notelp   = mahasiswaEntities.getnoTelp_07359();
//            this.petugasKelas   = mahasiswaEntities.getPetugasKelas_07359();
//        }
//        
//        setTitle("PROGRAM VERIF MAHASISWA");
//        
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(380,480);
//        setLocationRelativeTo(null);
//        getContentPane().setBackground(Color.white);
//        setLayout(null);
//        setVisible(true);
//        
//        btnback.setBounds(25, 20, 80, 25);
//        btnback.setBackground(Color.white);
//        btnback.setFocusPainted(false);
//        btnback.setBorder(null);
//        add(btnback);
//        
//        labelnama.setBounds(25, 50, 40, 25);
//        add(labelnama);
//        fieldnama.setBounds(120, 50, 100, 25);
//        fieldnama.setText(nama);
//        fieldnama.setEditable(false);
//        add(fieldnama);
//        
//        labelnpm.setBounds(25, 80, 40, 25);
//        add(labelnpm);
//        fieldnpm.setBounds(120, 80, 100, 25);
//        fieldnpm.setText(npm);
//        fieldnpm.setEditable(false);
//        add(fieldnpm);
//        
//        labelalamat.setBounds(25, 110, 40, 25);
//        add(labelalamat);
//        fieldalamat.setBounds(120, 110, 100, 25);
//        fieldalamat.setText(alamat);
//        fieldalamat.setEditable(false);
//        add(fieldalamat);
//        
//        labelpassword.setBounds(25, 140, 80, 25);
//        add(labelpassword);
//        fieldpassword.setBounds(120, 140, 100, 25);
//        fieldpassword.setText(password);
//        fieldpassword.setEditable(false);
//        add(fieldpassword);
//        
//        labelnotelp.setBounds(25, 170, 80, 25);
//        add(labelnotelp);
//        fieldnotelp.setBounds(120, 170, 100, 25);
//        fieldnotelp.setText(notelp);
//        fieldnotelp.setEditable(false);
//        add(fieldnotelp);
//        
//        labelpetugasKelas.setBounds(25, 200, 40, 25);
//        add(labelpetugasKelas);
//        fieldpetugasKelas.setBounds(120, 200, 100, 25);
//        fieldpetugasKelas.setText(petugasKelas);
//        fieldpetugasKelas.setEditable(false);
//        add(fieldpetugasKelas);
//    }
    
}
    