import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Actualizar extends JFrame implements ActionListener{
    
    private JLabel lbportada, lbdatos, lbusuario, lbnombre, lbapellido, lbtelefono, lbcorreo, lbcontra, lbconfirmar, lbbuscar;
    private JTextField txtusuario, txtnombre, txtapellido, txttelefono, txtcorreo, txtbuscar;
    private JPasswordField txtcontra, txtconfirmar;
    private JButton btactualizar, btatras, btbuscar;

    public String nombre, apellido, telefono, usuario, correo, contra, confirmar;

    String buscar = "";
    boolean numero;
    int id;

    int opc = 1;
    
    public Actualizar(){

        setLayout(null);
        setTitle("Programa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(27,20,20));
        setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());

        lbportada = new JLabel("Actualizar", SwingConstants.CENTER);
        lbportada.setBounds(240,10,120,23);
        lbportada.setFont(new Font("Andale Mono", 1, 18));
        lbportada.setForeground(new Color(255,255,255));
        lbportada.setOpaque(false);
        add(lbportada);

        lbdatos = new JLabel("Cambia los datos:");
        lbdatos.setBounds(40,80,180,23);
        lbdatos.setFont(new Font("Andale Mono", 1, 14));
        lbdatos.setForeground(new Color(255,255,255));
        lbdatos.setOpaque(false);
        add(lbdatos);

        lbbuscar = new JLabel("Ingrese ID:");
        lbbuscar.setBounds(280,80,80,23);
        lbbuscar.setFont(new Font("Andale Mono", 1, 14));
        lbbuscar.setForeground(new Color(255,255,255));
        lbbuscar.setOpaque(false);
        add(lbbuscar);

        txtbuscar = new JTextField();
        txtbuscar.setBounds(380,80,80,23); 
        txtbuscar.setFont(new Font("Andale Mono", 1, 14));
        txtbuscar.setForeground(new Color(0,0,0));
        add(txtbuscar);

        btbuscar = new JButton("Buscar");
        btbuscar.setBounds(480,80,100,23);
        btbuscar.setBackground(new Color(255,255,255));
        btbuscar.setFont(new Font("Andale Mono", 1, 14));
        btbuscar.addActionListener(this);
        add(btbuscar);
        

        lbnombre = new JLabel("Nombre:");
        lbnombre.setBounds(40,140,70,23);
        lbnombre.setFont(new Font("Andale Mono", 1, 14));
        lbnombre.setForeground(new Color(255,255,255));
        lbnombre.setOpaque(false);
        lbnombre.setVisible(false);
        add(lbnombre);

        txtnombre = new JTextField();
        txtnombre.setBounds(40,175,130,23); 
        txtnombre.setFont(new Font("Andale Mono", 1, 14));
        txtnombre.setForeground(new Color(0,0,0));
        txtnombre.setVisible(false);
        add(txtnombre);

        lbapellido = new JLabel("Apellido:");
        lbapellido.setBounds(40,235,80,23);
        lbapellido.setFont(new Font("Andale Mono", 1, 14));
        lbapellido.setForeground(new Color(255,255,255));
        lbapellido.setBackground(Color.white);
        lbapellido.setOpaque(false);
        lbapellido.setVisible(false);
        add(lbapellido);

        txtapellido = new JTextField();
        txtapellido.setBounds(40,270,180,23); 
        txtapellido.setFont(new Font("Andale Mono", 1, 14));
        txtapellido.setForeground(new Color(0,0,0));
        txtapellido.setVisible(false);
        add(txtapellido);

        lbtelefono = new JLabel("Telefono:");
        lbtelefono.setBounds(40,325,80,23);
        lbtelefono.setFont(new Font("Andale Mono", 1, 14));
        lbtelefono.setForeground(new Color(255,255,255));
        lbtelefono.setOpaque(false);
        lbtelefono.setVisible(false);
        add(lbtelefono);

        txttelefono = new JTextField();
        txttelefono.setBounds(40,360,130,23); 
        txttelefono.setFont(new Font("Andale Mono", 1, 14));
        txttelefono.setForeground(new Color(0,0,0));
        txttelefono.setVisible(false);
        add(txttelefono);

        lbcorreo = new JLabel("Correo:");
        lbcorreo.setBounds(300,140,70,23);
        lbcorreo.setFont(new Font("Andale Mono", 1, 14));
        lbcorreo.setForeground(new Color(255,255,255));
        lbcorreo.setOpaque(false);
        lbcorreo.setVisible(false);
        add(lbcorreo);

        txtcorreo = new JTextField();
        txtcorreo.setBounds(300,175,280,23); 
        txtcorreo.setFont(new Font("Andale Mono", 1, 14));
        txtcorreo.setForeground(new Color(0,0,0));
        txtcorreo.setVisible(false);
        add(txtcorreo);

        lbcontra = new JLabel("Contraseña:");
        lbcontra.setBounds(300,235,90,23);
        lbcontra.setFont(new Font("Andale Mono", 1, 14));
        lbcontra.setForeground(new Color(255,255,255));
        lbcontra.setOpaque(false);
        lbcontra.setVisible(false);
        add(lbcontra);

        txtcontra = new JPasswordField();
        txtcontra.setEchoChar('*');
        txtcontra.setBounds(300,270,180,23); 
        txtcontra.setFont(new Font("Andale Mono", 1, 14));
        txtcontra.setForeground(new Color(0,0,0));
        txtcontra.setVisible(false);
        add(txtcontra);

        lbconfirmar = new JLabel("Confirmar:");
        lbconfirmar.setBounds(300,325,90,23);
        lbconfirmar.setFont(new Font("Andale Mono", 1, 14));
        lbconfirmar.setForeground(new Color(255,255,255));
        lbconfirmar.setOpaque(false);
        lbconfirmar.setVisible(false);
        add(lbconfirmar);

        txtconfirmar = new JPasswordField();
        txtconfirmar.setEchoChar('*');
        txtconfirmar.setBounds(300,360,180,23); 
        txtconfirmar.setFont(new Font("Andale Mono", 1, 14));
        txtconfirmar.setForeground(new Color(0,0,0));
        txtconfirmar.setVisible(false);
        add(txtconfirmar);

        lbusuario = new JLabel("Usuario:");
        lbusuario.setBounds(40,420,80,23);
        lbusuario.setFont(new Font("Andale Mono", 1, 14));
        lbusuario.setForeground(new Color(255,255,255));
        lbusuario.setOpaque(false);
        lbusuario.setVisible(false);
        add(lbusuario);

        txtusuario = new JTextField();
        txtusuario.setBounds(40,460,130,23); 
        txtusuario.setFont(new Font("Andale Mono", 1, 14));
        txtusuario.setForeground(new Color(0,0,0));
        txtusuario.setVisible(false);
        add(txtusuario);

        btactualizar = new JButton("Actualizar");
        btactualizar.setBounds(350,460,110,30);
        btactualizar.setBackground(new Color(255,255,255));
        btactualizar.setFont(new Font("Andale Mono", 1, 14));
        btactualizar.addActionListener(this);
        btactualizar.setVisible(false);
        add(btactualizar);

        btatras = new JButton("Atras");
        btatras.setBounds(480,460,100,30);
        btatras.setBackground(new Color(255,255,255));
        btatras.setFont(new Font("Andale Mono", 1, 14));
        btatras.addActionListener(this);
        add(btatras);
        
    }

    public void actionPerformed(ActionEvent e){
     
        if(e.getSource() == btactualizar){
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
                        PreparedStatement pst = cn.prepareStatement("update usuarios set NombreUsuario = ?, Nombre = ?, Apellido = ?, Teléfono = ?, Correo = ?, Contraseña = ? where ID = '" + id + "' ");
                        pst.setString(1, usuario);
                        pst.setString(2, nombre);
                        pst.setString(3, apellido);
                        pst.setString(4, telefono);
                        pst.setString(5, correo);
                        pst.setString(6, contra);
                        pst.executeUpdate();

                        txtnombre.setText("");
                        txtapellido.setText("");
                        txttelefono.setText("");
                        txtcorreo.setText("");
                        txtcontra.setText("");
                        txtconfirmar.setText("");
                        txtusuario.setText("");

                        JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");

                        Tabla ventanatabla = new Tabla();
                        ventanatabla.setBounds(0,0,700,400);
                        ventanatabla.setVisible(true);
                        ventanatabla.setResizable(false);
                        ventanatabla.setLocationRelativeTo(null);
                        this.setVisible(false);
                    }catch(Exception evt){

                    }         
                }  
        }

        if(e.getSource() == btatras){
            Tabla ventanatabla = new Tabla();
            ventanatabla.setBounds(0,0,700,400);
            ventanatabla.setVisible(true);
            ventanatabla.setResizable(false);
            ventanatabla.setLocationRelativeTo(null);
            this.setVisible(false);
        }

        if(e.getSource() == btbuscar){

            lbnombre.setVisible(false);
            txtnombre.setVisible(false);
            lbapellido.setVisible(false);
            txtapellido.setVisible(false);
            lbtelefono.setVisible(false);
            txttelefono.setVisible(false);
            lbcorreo.setVisible(false);
            txtcorreo.setVisible(false);
            lbcontra.setVisible(false);
            txtcontra.setVisible(false);
            lbconfirmar.setVisible(false);
            txtconfirmar.setVisible(false);
            lbusuario.setVisible(false);
            txtusuario.setVisible(false);
            btactualizar.setVisible(false);

            buscar = txtbuscar.getText().trim();
            numero = buscar.matches("[+-]?\\d*(\\.\\d+)?");
            if(numero == true){
                try{
                    
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_programa", "root", "");
                    PreparedStatement pst = cn.prepareStatement("select * from usuarios where ID = ?");
                    pst.setString(1, buscar);

                    ResultSet rs = pst.executeQuery();

                    if(rs.next()){
                        lbnombre.setVisible(true);
                        txtnombre.setVisible(true);
                        lbapellido.setVisible(true);
                        txtapellido.setVisible(true);
                        lbtelefono.setVisible(true);
                        txttelefono.setVisible(true);
                        lbcorreo.setVisible(true);
                        txtcorreo.setVisible(true);
                        lbcontra.setVisible(true);
                        txtcontra.setVisible(true);
                        lbconfirmar.setVisible(true);
                        txtconfirmar.setVisible(true);
                        lbusuario.setVisible(true);
                        txtusuario.setVisible(true);
                        btactualizar.setVisible(true);
                        
                        txtnombre.setText(rs.getString("Nombre"));
                        txtapellido.setText(rs.getString("Apellido"));
                        txttelefono.setText(rs.getString("Teléfono"));
                        txtcorreo.setText(rs.getString("Correo"));
                        txtcontra.setText(rs.getString("Contraseña"));
                        txtconfirmar.setText(rs.getString("Contraseña"));
                        txtusuario.setText(rs.getString("NombreUsuario"));

                        id = Integer.parseInt(buscar);

                    }else{
                        if(txtbuscar.getText().length()==0){
                            JOptionPane.showMessageDialog(null, "Debe ingresar el ID");
                        }else{
                            JOptionPane.showMessageDialog(null, "Error, verfique lo ingresado anteriormente");
                        }
                        
                    }

                }catch(Exception evt){
                    JOptionPane.showMessageDialog(null, "Error.");
                }

            }else if(numero == false || txtbuscar.getText().length()==0){
                JOptionPane.showMessageDialog(null, "Error al introducir el ID \nIngrese el ID de forma correcta");
            }
                   
        }
    }                       
            

        
    public static void main(String args[]){
        Actualizar ventanaactualizar = new Actualizar();
        ventanaactualizar.setBounds(0,0,640,600);
        ventanaactualizar.setVisible(true);
        ventanaactualizar.setResizable(false);
        ventanaactualizar.setLocationRelativeTo(null);
    }

}