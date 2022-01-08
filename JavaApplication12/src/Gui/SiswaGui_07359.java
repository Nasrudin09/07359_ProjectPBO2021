package Gui;

import Entity.SiswaEntity_07359;
import Gui.AllObjectController_07359;
import Gui.LoginGui_07359;
import Gui.AllObjectController_07359;
import Gui.LoginGui_07359;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SiswaGui_07359 extends ComponentGui_07359 {
    int id;
    int status;
    String nama, npm, alamat, password, notelp, jenisK, kelas, gambar, namagambar, path;
    String filemove = "./src/Images/";
    
    File file;
    public SiswaGui_07359(int cek){
        initComponent(cek);
    }
    public Choice pilKelas = new Choice();
    
    void initComponent(final int cek){
        for(SiswaEntity_07359 mahasiswaEntities : AllObjectController_07359.mahasiswa.getById(cek)) {
            this.id       = mahasiswaEntities.getId_07359();
            this.nama     = mahasiswaEntities.getNama_07359();
            this.npm      = mahasiswaEntities.getNpm_07359();
            this.alamat   = mahasiswaEntities.getAlamat_07359();
            this.password = mahasiswaEntities.getPassword_07359();
            this.notelp   = mahasiswaEntities.getnoTelp_07359();
            this.jenisK   = mahasiswaEntities.getJenisKelamin_07359();
            this.kelas    = mahasiswaEntities.getKelas_07359();
            this.status   = mahasiswaEntities.getStatus_07359();
            this.gambar   = mahasiswaEntities.getGambar07359();
        }
        
        setTitle("PROGRAM VERIF MAHASISWA");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.gray);
        setLayout(null);
        setVisible(true);
        
        btnback.setBounds(15, 20, 100, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        labelnama.setBounds(15, 50, 100, 25);
        add(labelnama);
        fieldnama.setBounds(120, 50, 100, 25);
        fieldnama.setText(nama);
        fieldnama.setEditable(false);
        add(fieldnama);
        
        labelnpm.setBounds(15, 80, 100, 25);
        add(labelnpm);
        fieldnpm.setBounds(120, 80, 100, 25);
        fieldnpm.setText(npm);
        fieldnpm.setEditable(false);
        add(fieldnpm);
        
        labelalamat.setBounds(15, 110, 100, 25);
        add(labelalamat);
        fieldalamat.setBounds(120, 110, 100, 25);
        fieldalamat.setText(alamat);
        fieldalamat.setEditable(false);
        add(fieldalamat);
        
        labelpassword.setBounds(15, 140, 100, 25);
        add(labelpassword);
        fieldpassword.setBounds(120, 140, 100, 25);
        fieldpassword.setText(password);
        fieldpassword.setEditable(false);
        add(fieldpassword);
        
        labelnotelp.setBounds(15, 170, 100, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(120, 170, 100, 25);
        fieldnotelp.setText(notelp);
        fieldnotelp.setEditable(false);
        add(fieldnotelp);
        
        labeljenisK.setBounds(15, 200, 100, 25);
        add(labeljenisK);
        fieldjenisK.setBounds(120, 200, 100, 25);
        fieldjenisK.setText(jenisK);
        fieldjenisK.setEditable(false);
        add(fieldjenisK);
        
        labelkelas.setBounds(15, 230, 100, 25);
        add(labelkelas);
        fieldkelas.setBounds(120, 230, 100, 25);
        fieldkelas.setText(kelas);
        fieldkelas.setEditable(false);
        add(fieldkelas);
        
        bingkaigambar.setBounds(50, 260, 150, 200);
        add(bingkaigambar);
        
        btnubahnama.setBounds(245, 50, 80, 25);
        btnubahalamat.setBounds(245, 80, 80, 25);
        btnubahnpm.setBounds(245, 110, 80, 25);
        btnubahpassword.setBounds(245, 140, 80, 25);
        btnubahnotelp.setBounds(245, 170, 80, 25);
        btnubahjenisK.setBounds(245, 200, 80, 25);
        btnubahkelas.setBounds(245, 230, 80, 25);
        btnubahgambar.setBounds(245, 260, 80, 25);
        
        add(btnubahnama);
        add(btnubahnpm);
        add(btnubahalamat);
        add(btnubahpassword);
        add(btnubahnotelp);
        add(btnubahjenisK);
        add(btnubahkelas);
        add(btnubahgambar);
        
        String pict = filemove+gambar;
        System.out.println("pict");
        if(this.gambar != null){
            try{
                bufferedImage = ImageIO.read(new File(pict));
            } catch (IOException ex){
                Logger.getLogger(SiswaGui_07359.class.getName()).log(Level.SEVERE, null,ex);
            }
            
            gambarresize = bufferedImage.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
            bingkaigambar.setIcon(new  ImageIcon(gambarresize));
        }
        
        btnback.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnback.setForeground(Color.yellow);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnback.setForeground(Color.black);
            }
        });
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                LoginGui_07359 loginGui = new LoginGui_07359();
                loginGui.setVisible(true);
                dispose();
            }
        });
        
        btnubahnama.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputnama = JOptionPane.showInputDialog("Massukkan Nama Baru");
                    if(inputnama.length() > 0){
                        AllObjectController_07359.mahasiswa.updateData(1, inputnama, cek);
                        fieldnama.setText(inputnama);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahnpm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputnpm = JOptionPane.showInputDialog("Masukan NPM Baru");
                    if(inputnpm.length() > 0){
                        AllObjectController_07359.mahasiswa.updateData(2, inputnpm, cek);
                        fieldnpm.setText(inputnpm);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahalamat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputalamat = JOptionPane.showInputDialog("Masukan ALAMAT Baru");
                    if(inputalamat.length() > 0){
                        AllObjectController_07359.mahasiswa.updateData(3, inputalamat, cek);
                        fieldalamat.setText(inputalamat);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahpassword.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputpass = JOptionPane.showInputDialog("Masukan Password Baru");
                    if(inputpass.length() > 0){
                        AllObjectController_07359.mahasiswa.updateData(4, inputpass, cek);
                        fieldpassword.setText(inputpass);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahnotelp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputNoTelp = JOptionPane.showInputDialog("Masukan Nomor Telepon Baru");
                    if(inputNoTelp.length() > 0){
                        AllObjectController_07359.mahasiswa.updateData(6, inputNoTelp, cek);
                        fieldnotelp.setText(inputNoTelp);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahjenisK.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputjenisK = JOptionPane.showInputDialog("Masukan JENISKELAMIN Baru");
                    if(inputjenisK.length() > 0){
                        AllObjectController_07359.mahasiswa.updateData(7, inputjenisK, cek);
                        fieldjenisK.setText(inputjenisK);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahkelas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputkelas = JOptionPane.showInputDialog("Masukan KELAS Baru");
                    if(inputkelas.length() > 0){
                        AllObjectController_07359.mahasiswa.updateData(8, inputkelas, cek);
                        fieldkelas.setText(inputkelas);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahgambar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            FileNameExtensionFilter filterekstensi = new FileNameExtensionFilter("Gambar","jpg","png","gif");
            chooser.addChoosableFileFilter(filterekstensi);
            int status = chooser.showOpenDialog(null);
            if(status == JFileChooser.APPROVE_OPTION){
                file = chooser.getSelectedFile();
                File destinasi = new File(filemove.concat(npm + ".jpg"));
                try{
                    Files.move(file.toPath(), destinasi.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    namagambar = destinasi.getName();
                    path = destinasi.getAbsolutePath();
                    try{
                        bufferedImage = ImageIO.read(new File(path));
                    } catch(IOException ex) {
                        Logger.getLogger(SiswaGui_07359.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                gambarresize = bufferedImage.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
                bingkaigambar.setIcon(new ImageIcon(gambarresize));
                AllObjectController_07359.mahasiswa.updateData(9, namagambar, cek);
            } else if (status == JFileChooser.CANCEL_OPTION){
                JOptionPane.showMessageDialog(null, "Tidak Memilih Gambar");
            }
            }
        });
    }
}
