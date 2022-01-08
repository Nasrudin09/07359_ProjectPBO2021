package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AdminGui_07359 extends ComponentGui_07359 {
    JTable tabelmahasiswa = new JTable();
    JScrollPane spmahasiswa = new JScrollPane(tabelmahasiswa);
    JTextField textpilih = new JTextField();
    int kode;
    
    public AdminGui_07359(int cek){
        initComponent(cek);
    }
    
    void initComponent(final int cek){
        setTitle("PROGRAM VERIF MAHASISWA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,650);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.gray);
        
        setLayout(null);
        setVisible(true);
        
        spmahasiswa.setBounds(20, 50, 800, 500);
        tabelmahasiswa.setModel(AllObjectController_07359.mahasiswa.daftarSiswa());
        add(spmahasiswa);
        
        btnverif.setBounds(840, 50, 110, 25);
        btnverif.setFocusPainted(false);
        btnverif.setBorder(null);
        btnverif.setBackground(Color.black);
        btnverif.setForeground(Color.white);
        add(btnverif);
        
        btndelete.setBounds(840, 95, 110, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
        btnubahpassword.setText("UBAH PASSWORD");
        btnubahpassword.setBounds(840, 140, 110, 25);
        btnubahpassword.setFocusPainted(false);
        btnubahpassword.setBorder(null);
        btnubahpassword.setBackground(Color.black);
        btnubahpassword.setForeground(Color.white);
        add(btnubahpassword);
        
        btnback.setBounds(840, 275, 110, 25);
        btnback.setBackground(Color.gray);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        btnregister.setText("REGIST ADMIN");
        btnregister.setBounds(840, 185, 110, 25);
        btnregister.setFocusPainted(false);
        btnregister.setBorder(null);
        btnregister.setBackground(Color.black);
        btnregister.setForeground(Color.white);
        add(btnregister);
        
        btnpetugasKelas.setText("DAFTAR ADMIN");
        btnpetugasKelas.setBounds(840, 230, 110, 25);
        btnpetugasKelas.setFocusPainted(false);
        btnpetugasKelas.setBorder(null);
        btnpetugasKelas.setBackground(Color.black);
        btnpetugasKelas.setForeground(Color.white);
        add(btnpetugasKelas);
        
        tabelmahasiswa.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelmahasiswa.getSelectedRow();
                textpilih.setText(AllObjectController_07359.mahasiswa.daftarSiswa().getValueAt(i, 0).toString());
            }
        });
        
        btnverif.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController_07359.admin.verifSiswa(kode);
                JOptionPane.showMessageDialog(null, "Berhasil Verifikasi");
                tabelmahasiswa.setModel(AllObjectController_07359.mahasiswa.daftarSiswa());
            }
        });
        
        btndelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController_07359.admin.deleteData(kode);
                tabelmahasiswa.setModel(AllObjectController_07359.mahasiswa.daftarSiswa());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA");
            }
        });
        
        btnback.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnback.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnback.setForeground(Color.black);
            }
        });
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                LoginAdminGui_07359 loginAdminGui = new LoginAdminGui_07359();
                loginAdminGui.setVisible(true);
                dispose();
            }
        });
        
        btnubahpassword.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputpass = JOptionPane.showInputDialog("Masukkan Password Baru");
                    if(inputpass.length() > 0){
                        AllObjectController_07359.admin.updatePassword(inputpass, cek);
                        JOptionPane.showMessageDialog(null, "Berhasil Ubah Password");
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnregister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                RegisterAdminGui_07359 registerAdminGui = new RegisterAdminGui_07359();
                registerAdminGui.setVisible(true);
                dispose();
            }
        });
        
        btnpetugasKelas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                TablePetugas_07359 tablePetugas = new TablePetugas_07359();
                tablePetugas.setVisible(true);
                dispose();
            }
        });
    } 
}
