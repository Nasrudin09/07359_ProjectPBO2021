package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterAdminGui_07359 extends ComponentGui_07359 {
    public RegisterAdminGui_07359(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("Register Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelregister.setText("REGISTER ADMIN");
        labelregister.setBounds(100, 30, 110, 25);
        add(labelregister);
        labelnama.setBounds(35, 80, 40, 25);
        add(labelnama);
        fieldnama.setBounds(130, 80, 130, 25);
        add(fieldnama);
        
        labelnpm.setBounds(35, 110, 80, 25);
        add(labelnpm);
        fieldnpm.setBounds(130, 110, 130, 25);
        add(fieldnpm);
        
        labelalamat.setBounds(35, 140, 80, 25);
        add(labelalamat);
        fieldalamat.setBounds(130, 140, 130, 25);
        add(fieldalamat);
        
        labelpassword.setBounds(35, 170, 80, 25);
        add(labelpassword);
        fieldpassword.setBounds(130, 170, 130, 25);
        add(fieldpassword);
        
        labelnotelp.setBounds(35, 210, 80, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(130, 210, 130, 25);
        add(fieldnotelp);
        
        labelpetugasKelas.setBounds(35, 240, 80, 25);
        add(labelpetugasKelas);
        fieldpetugasKelas.setBounds(130, 240, 130, 25);
        add(fieldpetugasKelas);
        
        btnregister.setBounds(80, 350, 140, 25);
        btnregister.setBorder(null);
        btnregister.setBackground(Color.black);
        btnregister.setForeground(Color.white);
        btnregister.setFocusPainted(false);
        add(btnregister);
        
        btnregister.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnregister.setForeground(Color.black);
                btnregister.setBackground(Color.green);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnregister.setForeground(Color.white);
                btnregister.setBackground(Color.black);
            }
        });
        
        btnregister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String nama = fieldnama.getText();
                String npm = fieldnpm.getText();
                String alamat = fieldalamat.getText();
                String password = fieldpassword.getText();
                String notelp = fieldnotelp.getText();
                String petugasKelas = fieldpetugasKelas.getText();
                if(nama.length() != 0 && npm.length() != 0 && alamat.length() != 0 && password.length() != 0 && notelp.length() != 0 && petugasKelas.length() != 0){
                    AllObjectController_07359.admin.insertData(nama, npm, alamat, password, notelp, petugasKelas);
                    JOptionPane.showMessageDialog(null, nama + "Adalah Admin");
                    dispose();
                    new LoginAdminGui_07359().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
    }
}
