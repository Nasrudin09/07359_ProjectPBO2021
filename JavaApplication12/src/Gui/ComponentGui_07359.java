package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class ComponentGui_07359 extends JFrame {
    protected JButton btnregister = new JButton("REGISTRASI ?");
    protected JButton btnnotreg = new JButton("REGISTRASI KURSUS");
    protected JButton btnlogin = new JButton("LOG IN");
    protected JButton btnback = new JButton("<< LOG OUT");
    protected JButton btndelete = new JButton("DELETE");
    protected JButton btnverif = new JButton("VERIF");
    protected JButton btnpetugasKelas = new JButton("DAFTAR ADMIN");
    
    protected JLabel labelregister = new JLabel("REGISTER");
    protected JLabel labellogin = new JLabel("LOGIN");
    protected JLabel labelid = new JLabel("ID");
    protected JLabel labelnama = new JLabel("NAMA");
    protected JLabel labelnpm = new JLabel("NPM");
    protected JLabel labelalamat = new JLabel("ALAMAT");
    protected JLabel labelpassword = new JLabel("PASSWORD");
    protected JLabel labelnotelp = new JLabel("NO TELP");
    protected JLabel labeljenisK = new JLabel("JENIS KELAMIN");
    protected JLabel labelkelas = new JLabel("KELAS");
    protected JLabel labelpetugasKelas = new JLabel("PETUGAS KELAS");
    protected JLabel bingkaigambar = new JLabel();
    
    protected JTextField fieldnama = new JTextField();
    protected JTextField fieldnpm = new JTextField();
    protected JTextField fieldalamat = new JTextField();
    protected JPasswordField fieldpassword = new JPasswordField();
    protected JTextField fieldnotelp = new JTextField();
    protected JTextField fieldjenisK = new JTextField();
    protected JTextField fieldkelas = new JTextField();
    protected JTextField fieldpetugasKelas = new JTextField();
    
    protected JButton btnubahnama = new JButton("Ubah");
    protected JButton btnubahnpm = new JButton("Ubah");
    protected JButton btnubahalamat = new JButton("Ubah");
    protected JButton btnubahpassword = new JButton("Ubah");
    protected JButton btnubahnotelp = new JButton("Ubah");
    protected JButton btnubahjenisK = new JButton("Ubah");
    protected JButton btnubahkelas = new JButton("Ubah");
    protected JButton btnubahpetugasKelas = new JButton("Ubah");
    protected JButton btnubahgambar = new JButton("Upload");
    
    BufferedImage bufferedImage = null;
    Image gambarresize;
    
    void kosong(){
        fieldnama.setText(null);
        fieldnpm.setText(null);
        fieldalamat.setText(null);
        fieldpassword.setText(null);
        fieldnotelp.setText(null);
        fieldjenisK.setText(null);
        fieldkelas.setText(null);
        fieldpetugasKelas.setText(null);
    }
}