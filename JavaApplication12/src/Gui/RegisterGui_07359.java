package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterGui_07359 extends ComponentGui_07359 implements ItemListener {
    public Choice pilKelas = new Choice();
    String kelas;
    public RegisterGui_07359(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("Register Akun");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelregister.setBounds(120, 30, 70, 25);
        add(labelregister);
        
        labelnama.setBounds(20, 80, 100, 25);
        add(labelnama);
        fieldnama.setBounds(130, 80, 130, 25);
        add(fieldnama);
        
        labelnpm.setBounds(20, 110, 100, 25);
        add(labelnpm);
        fieldnpm.setBounds(130, 110, 130, 25);
        add(fieldnpm);
        
        labelalamat.setBounds(20, 140, 100, 25);
        add(labelalamat);
        fieldalamat.setBounds(130, 140, 130, 25);
        add(fieldalamat);
        
        labelpassword.setBounds(20, 170, 100, 25);
        add(labelpassword);
        fieldpassword.setBounds(130, 170, 130, 25);
        add(fieldpassword);
        
        labelnotelp.setBounds(20, 200, 100, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(130, 200, 130, 25);
        add(fieldnotelp);
        
        labeljenisK.setBounds(20, 230, 100, 25);
        add(labeljenisK);
        fieldjenisK.setBounds(130, 230, 130, 25);
        add(fieldjenisK);
        
//        labelkelas.setBounds(20, 260, 80, 25);
//        add(labelkelas);
//        fieldkelas.setBounds(130, 260, 130, 25);
//        add(fieldkelas);
        
//        JLabel lblKelas = new JLabel("Kelas");
//        lblKelas.setFont(new Font("Times New Roman", Font.BOLD, 19));
//        lblKelas.setBounds(20, 260, 80, 25);
//        add(lblKelas);
        labelkelas.setBounds(20, 260, 80, 25);
        add(labelkelas);
        pilKelas.setBounds(130, 260, 130, 25);
        pilKelas.add("---List Kelas---");
        pilKelas.add("Basic English");
        pilKelas.add("Pro English");
        pilKelas.add("Intermediate English");
        pilKelas.addItemListener((ItemListener) this);
        add(pilKelas);

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
                btnregister.setBackground(Color.blue);
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
                String jenisK = fieldjenisK.getText();
//                String kelas = fieldkelas.getText();
                if(nama.length() != 0 && npm.length() != 0 && alamat.length() != 0 && password.length() != 0 && notelp.length() != 0 && jenisK.length() != 0 && kelas.length() != 0){
                    AllObjectController_07359.mahasiswa.insertData(nama, npm, alamat, password, notelp, jenisK, kelas);
                    JOptionPane.showMessageDialog(null, "Silahkan Login Kembali");
                    dispose();
                    new LoginGui_07359().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        kelas = pilKelas.getSelectedItem();
    }
}
