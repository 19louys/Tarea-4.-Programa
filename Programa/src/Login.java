import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{

    private JLabel lbportada, lbusuario, lbcontra;
    private JTextField txtusuario;
    private JButton btingresar, btregistrar;
    private JPasswordField txtcontra;

    String usuario = "";
    String contra = "";
   
    
    public Login(){

        setLayout(null);
        setTitle("Programa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(27,20,20));
        setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());

        lbportada = new JLabel("Login", SwingConstants.CENTER);
        lbportada.setBounds(100,10,70,23);
        lbportada.setFont(new Font("Andale Mono", 1, 18));
        lbportada.setForeground(new Color(255,255,255));
        lbportada.setBackground(Color.white);
        lbportada.setOpaque(false);
        add(lbportada);

        lbusuario = new JLabel("Usuario:");
        lbusuario.setBounds(10,80,70,23);
        lbusuario.setFont(new Font("Andale Mono", 1, 14));
        lbusuario.setForeground(new Color(255,255,255));
        lbusuario.setBackground(Color.white);
        lbusuario.setOpaque(false);
        add(lbusuario);

        lbcontra= new JLabel("Contraseña:");
        lbcontra.setBounds(10,160,100,23);
        lbcontra.setFont(new Font("Andale Mono", 1, 14));
        lbcontra.setForeground(new Color(255,255,255));
        lbcontra.setBackground(Color.white);
        lbcontra.setOpaque(false);
        add(lbcontra);

        txtusuario = new JTextField();
        txtusuario.setBounds(10,110,120,23); 
        txtusuario.setFont(new Font("Andale Mono", 1, 14));
        txtusuario.setForeground(new Color(0,0,0));
        add(txtusuario);

        txtcontra = new JPasswordField();
        txtcontra.setEchoChar('*');
        txtcontra.setBounds(10,190,140,23); 
        txtcontra.setFont(new Font("Andale Mono", 1, 14));
        txtcontra.setForeground(new Color(0,0,0));
        add(txtcontra);

        btingresar = new JButton("Ingresar");
        btingresar.setBounds(10,270,100,30);
        btingresar.setBackground(new Color(255,255,255));
        btingresar.setFont(new Font("Andale Mono", 1, 14));
        btingresar.setForeground(Color.black);
        btingresar.addActionListener(this);
        add(btingresar);

        btregistrar = new JButton("Registrar");
        btregistrar.setBounds(175,270,100,30);
        btregistrar.setBackground(new Color(255,255,255));
        btregistrar.setFont(new Font("Andale Mono", 1, 14));
        btregistrar.setForeground(Color.black);
        btregistrar.addActionListener(this);
        add(btregistrar);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btingresar){

            usuario = txtusuario.getText();
            contra = new String(txtcontra.getPassword());

            if(usuario.equals("") || contra.equals("")){
                JOptionPane.showMessageDialog(null, "Debes ingresar su usuario y contraseña. "+ "\n"+"Si no está registrado debe registrarse.");
            }else{
                try{
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_programa", "root", "");
                    PreparedStatement pst = cn.prepareStatement("select NombreUsuario, Contraseña from usuarios where NombreUsuario = '" + usuario + "' and Contraseña = '" + contra + "'");

                    ResultSet rs = pst.executeQuery();
                    if(rs.next()){
                        Tabla ventanatabla = new Tabla();
                        ventanatabla.setBounds(0,0,700,400);
                        ventanatabla.setVisible(true);
                        ventanatabla.setResizable(false);
                        ventanatabla.setLocationRelativeTo(null);
                        this.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos");
                        txtusuario.setText("");
                        txtcontra.setText("");
                    }
                }catch(Exception evt){

                }
            }
        }

        if(e.getSource() == btregistrar){
            Registro ventanaregistro = new Registro();
            ventanaregistro.setBounds(0,0,640,600);
            ventanaregistro.setVisible(true);
            ventanaregistro.setResizable(false);
            ventanaregistro.setLocationRelativeTo(null);
            this.setVisible(false);
        }
    }

    public static void main(String args[]){
        Login ventanalogin = new Login();
        ventanalogin.setBounds(0,0,300,350);
        ventanalogin.setVisible(true);
        ventanalogin.setResizable(false);
        ventanalogin.setLocationRelativeTo(null);
    }

}