package Gui;

import Gui.AdminGui_07359;
import Gui.LoginGui_07359;
import Gui.AdminGui_07359;
import Gui.LoginGui_07359;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginAdminGui_07359 extends ComponentGui_07359 {
    JButton btnloginmahasiswa = new JButton("LOGIN AS MAHASISWA ?");
    String pathicon;
    public LoginAdminGui_07359(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("Login Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelnpm.setBounds(35, 250, 40, 25);
        add(labelnpm);
        fieldnpm.setBounds(130, 250, 130, 25);
        add(fieldnpm);
        
        labelpassword.setBounds(35, 290, 80, 25);
        add(labelpassword);
        fieldpassword.setBounds(130, 290, 130, 25);
        add(fieldpassword);
        
        btnlogin.setBounds(110, 350, 100, 25);
        btnlogin.setBackground(Color.black);
        btnlogin.setForeground(Color.white);
        btnlogin.setBorder(null);
        add(btnlogin);
        
        btnloginmahasiswa.setBounds(70, 400, 180, 25);
        btnloginmahasiswa.setBorder(null);
        btnloginmahasiswa.setBackground(Color.white);
        add(btnloginmahasiswa);
        
        bingkaigambar.setBounds(80, 50, 150, 150);
        add(bingkaigambar);
        
        pathicon = "C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\JavaApplication12\\src\\Images\\wel.jpg";
        
        try{
            bufferedImage = ImageIO.read(new File(pathicon));
        } catch (IOException ex) {
            Logger.getLogger(LoginGui_07359.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        gambarresize = bufferedImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        bingkaigambar.setIcon(new ImageIcon(gambarresize));
        
        btnloginmahasiswa.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnloginmahasiswa.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnloginmahasiswa.setForeground(Color.black);
            }
        });
        
        btnloginmahasiswa.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               dispose();
               new LoginGui_07359().setVisible(true);
           }
        });
        
        btnlogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnlogin.setForeground(Color.black);
                btnlogin.setBackground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnlogin.setForeground(Color.white);
                btnlogin.setBackground(Color.black);
            }
        });
        
        btnlogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String npm = fieldnpm.getText();
                String password = fieldpassword.getText();
                int cek = AllObjectController_07359.admin.login(npm, password);
                if(cek > 0){
                    dispose();
                    AdminGui_07359 adminGui = new AdminGui_07359(cek);
                    adminGui.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                    kosong();
                }
            }
        });
    }
}