import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Registro extends JFrame implements ActionListener{
    
    private JLabel lbportada, lbdatos, lbusuario, lbnombre, lbapellido, lbtelefono, lbcorreo, lbcontra, lbconfirmar;
    private JTextField txtusuario, txtnombre, txtapellido, txttelefono, txtcorreo;
    private JPasswordField txtcontra, txtconfirmar;
    private JButton btregistrar, btatras;

    public String nombre, apellido, telefono, usuario, correo, contra, confirmar;

    int opc = 1;
    
    public Registro(){

        setLayout(null);
        setTitle("Programa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(27,20,20));
        setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());

        lbportada = new JLabel("Registro", SwingConstants.CENTER);
        lbportada.setBounds(240,10,120,23);
        lbportada.setFont(new Font("Andale Mono", 1, 18));
        lbportada.setForeground(new Color(255,255,255));
        lbportada.setOpaque(false);
        add(lbportada);

        lbdatos = new JLabel("Ingresa tus datos:");
        lbdatos.setBounds(40,80,180,23);
        lbdatos.setFont(new Font("Andale Mono", 1, 14));
        lbdatos.setForeground(new Color(255,255,255));
        lbdatos.setOpaque(false);
        add(lbdatos);

        lbnombre = new JLabel("Nombre:");
        lbnombre.setBounds(40,140,70,23);
        lbnombre.setFont(new Font("Andale Mono", 1, 14));
        lbnombre.setForeground(new Color(255,255,255));
        lbnombre.setOpaque(false);
        add(lbnombre);

        txtnombre = new JTextField();
        txtnombre.setBounds(40,175,130,23); 
        txtnombre.setFont(new Font("Andale Mono", 1, 14));
        txtnombre.setForeground(new Color(0,0,0));
        add(txtnombre);

        lbapellido = new JLabel("Apellido:");
        lbapellido.setBounds(40,235,80,23);
        lbapellido.setFont(new Font("Andale Mono", 1, 14));
        lbapellido.setForeground(new Color(255,255,255));
        lbapellido.setOpaque(false);
        add(lbapellido);

        txtapellido = new JTextField();
        txtapellido.setBounds(40,270,180,23); 
        txtapellido.setFont(new Font("Andale Mono", 1, 14));
        txtapellido.setForeground(new Color(0,0,0));
        add(txtapellido);

        lbtelefono = new JLabel("Telefono:");
        lbtelefono.setBounds(40,325,80,23);
        lbtelefono.setFont(new Font("Andale Mono", 1, 14));
        lbtelefono.setForeground(new Color(255,255,255));
        lbtelefono.setOpaque(false);
        add(lbtelefono);

        txttelefono = new JTextField();
        txttelefono.setBounds(40,360,130,23); 
        txttelefono.setFont(new Font("Andale Mono", 1, 14));
        txttelefono.setForeground(new Color(0,0,0));
        add(txttelefono);

        lbcorreo = new JLabel("Correo:");
        lbcorreo.setBounds(300,140,70,23);
        lbcorreo.setFont(new Font("Andale Mono", 1, 14));
        lbcorreo.setForeground(new Color(255,255,255));
        lbcorreo.setOpaque(false);
        add(lbcorreo);

        txtcorreo = new JTextField();
        txtcorreo.setBounds(300,175,280,23); 
        txtcorreo.setFont(new Font("Andale Mono", 1, 14));
        txtcorreo.setForeground(new Color(0,0,0));
        add(txtcorreo);

        lbcontra = new JLabel("Contraseña:");
        lbcontra.setBounds(300,235,90,23);
        lbcontra.setFont(new Font("Andale Mono", 1, 14));
        lbcontra.setForeground(new Color(255,255,255));
        lbcontra.setOpaque(false);
        add(lbcontra);

        txtcontra = new JPasswordField();
        txtcontra.setEchoChar('*');
        txtcontra.setBounds(300,270,180,23); 
        txtcontra.setFont(new Font("Andale Mono", 1, 14));
        txtcontra.setForeground(new Color(0,0,0));
        add(txtcontra);

        lbconfirmar = new JLabel("Confirmar:");
        lbconfirmar.setBounds(300,325,90,23);
        lbconfirmar.setFont(new Font("Andale Mono", 1, 14));
        lbconfirmar.setForeground(new Color(255,255,255));
        lbconfirmar.setOpaque(false);
        add(lbconfirmar);

        txtconfirmar = new JPasswordField();
        txtconfirmar.setEchoChar('*');
        txtconfirmar.setBounds(300,360,180,23); 
        txtconfirmar.setFont(new Font("Andale Mono", 1, 14));
        txtconfirmar.setForeground(new Color(0,0,0));
        add(txtconfirmar);

        lbusuario = new JLabel("Usuario:");
        lbusuario.setBounds(40,420,80,23);
        lbusuario.setFont(new Font("Andale Mono", 1, 14));
        lbusuario.setForeground(new Color(255,255,255));
        lbusuario.setOpaque(false);
        add(lbusuario);

        txtusuario = new JTextField();
        txtusuario.setBounds(40,460,130,23); 
        txtusuario.setFont(new Font("Andale Mono", 1, 14));
        txtusuario.setForeground(new Color(0,0,0));
        add(txtusuario);

        btregistrar = new JButton("Registrar");
        btregistrar.setBounds(360,460,100,30);
        btregistrar.setBackground(new Color(255,255,255));
        btregistrar.setFont(new Font("Andale Mono", 1, 14));
        btregistrar.setForeground(Color.black);
        btregistrar.addActionListener(this);
        add(btregistrar);

        btatras = new JButton("Atras");
        btatras.setBounds(480,460,100,30);
        btatras.setBackground(new Color(255,255,255));
        btatras.setFont(new Font("Andale Mono", 1, 14));
        btatras.setForeground(Color.black);
        btatras.addActionListener(this);
        add(btatras);
        
    }

    public void actionPerformed(ActionEvent e){
     
        if(e.getSource() == btregistrar){
    
            nombre = txtnombre.getText().trim();
            apellido = txtapellido.getText();
            telefono = txttelefono.getText();
            correo = txtcorreo.getText();
            contra = new String(txtcontra.getPassword());
            confirmar = new String(txtconfirmar.getPassword());
            usuario = txtusuario.getText();  

                if(opc == 1){
                    if(nombre.equals("") && apellido.equals("") && telefono.equals("") && correo.equals("") && contra.equals("") && confirmar.equals("") && usuario.equals("")){
                        JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
                            opc = 1;
                        }
                        else{
                            opc = 2;
                        }
                }
                
                if(opc == 2){
                        if(nombre.equals("")){
                            JOptionPane.showMessageDialog(null, "Campo (Nombre) en blanco");
                        }
                        if(apellido.equals("")){
                            JOptionPane.showMessageDialog(null, "Campo (Apellido) en blanco");
                        }
                        if(telefono.equals("")){
                            JOptionPane.showMessageDialog(null, "Campo (Telefono) en blanco");
                        }
                        if(correo.equals("")){
                            JOptionPane.showMessageDialog(null, "Campo (Correo) en blanco");
                        }
                        if(contra.equals("")){
                            JOptionPane.showMessageDialog(null, "Campo (Contraseña) en blanco");
                        }
                        if(confirmar.equals("")){
                            JOptionPane.showMessageDialog(null, "Campo (Confirmar) en blanco");
                        }
                        if(usuario.equals("")){
                            JOptionPane.showMessageDialog(null, "Campo (Usuario) en blanco");
                        }
                        else{
                            opc = 3;
                        }
                        }
                        

                if(opc == 3){
                        if(contra.equals(confirmar)){
                            if(contra.equals("") && confirmar.equals("")){
                                opc = 3;
                            }else{
                                opc = 4;
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Campo (Contraseña) y el campo (Confirmar) deben coincidir");
                        }
                        }

                if(opc == 4){
                    if(nombre.equals("") || apellido.equals("") || telefono.equals("") || correo.equals("") || contra.equals("") || confirmar.equals("") || usuario.equals("")){
                        
                    }else{
                        opc = 5;
                    }

                }
                        
                if(opc == 5){ 
                    try{
                        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_programa", "root", "");
                        PreparedStatement pst = cn.prepareStatement("insert into usuarios values(?,?,?,?,?,?,?)");
                        pst.setString(1, "0");
                        pst.setString(2, usuario);
                        pst.setString(3, nombre);
                        pst.setString(4, apellido);
                        pst.setString(5, telefono);
                        pst.setString(6, correo);
                        pst.setString(7, contra);
                        pst.executeUpdate();

                        txtnombre.setText("");
                        txtapellido.setText("");
                        txttelefono.setText("");
                        txtcorreo.setText("");
                        txtcontra.setText("");
                        txtconfirmar.setText("");
                        txtusuario.setText("");

                        JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");

                        Login ventanalogin = new Login();
                        ventanalogin.setBounds(0,0,300,350);
                        ventanalogin.setVisible(true);
                        ventanalogin.setResizable(false);
                        ventanalogin.setLocationRelativeTo(null);
                        this.setVisible(false);
                    }catch(Exception evt){

                    }         
                }  
        }

        if(e.getSource() == btatras){
            Login ventanalogin = new Login();
            ventanalogin.setBounds(0,0,300,350);
            ventanalogin.setVisible(true);
            ventanalogin.setResizable(false);
            ventanalogin.setLocationRelativeTo(null);
            this.setVisible(false);
        }
    }                       
            

        
    public static void main(String args[]){
        Registro ventanaregistro = new Registro();
        ventanaregistro.setBounds(0,0,640,600);
        ventanaregistro.setVisible(true);
        ventanaregistro.setResizable(false);
        ventanaregistro.setLocationRelativeTo(null);
    }

}