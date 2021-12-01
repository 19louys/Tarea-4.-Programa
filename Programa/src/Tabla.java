import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Tabla extends JFrame implements ActionListener{

    private JLabel lbtitulo;
    private JButton btnuevo, btactualizar, bteliminar, btcerrar;

    String[] columnas = {"ID" ,"Nombre","Apellido", "Telefono", "Correo electronico", "Usuario"};
    String nombre,apellido,telefono,correo,usuario;
    int id;

    private JTable tabla;
    private JScrollPane scroll;
    private DefaultTableModel modelo = new DefaultTableModel(null,columnas);

    public Tabla(){
        setLayout(null);
        setTitle("Programa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(27,20,20));
        setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());

        lbtitulo = new JLabel("Usuarios registrados", SwingConstants.CENTER);
        lbtitulo.setBounds(240,10,200,23);
        lbtitulo.setFont(new Font("Andale Mono", 1, 18));
        lbtitulo.setForeground(new Color(255,255,255));
        lbtitulo.setOpaque(false);
        add(lbtitulo);

        btnuevo = new JButton("Nuevo");
        btnuevo.setBounds(40,300,120,30);
        btnuevo.setBackground(new Color(255,255,255));
        btnuevo.setFont(new Font("Andale Mono", 1, 14));
        btnuevo.addActionListener(this);
        add(btnuevo);

        btactualizar = new JButton("Actualizar");
        btactualizar.setBounds(200,300,120,30);
        btactualizar.setBackground(new Color(255,255,255));
        btactualizar.setFont(new Font("Andale Mono", 1, 14));
        btactualizar.addActionListener(this);
        add(btactualizar);

        bteliminar = new JButton("Eliminar");
        bteliminar.setBounds(360,300,120,30);
        bteliminar.setBackground(new Color(255,255,255));
        bteliminar.setFont(new Font("Andale Mono", 1, 14));
        bteliminar.addActionListener(this);
        add(bteliminar);

        btcerrar = new JButton("Cerrar");
        btcerrar.setBounds(520,300,120,30);
        btcerrar.setBackground(new Color(255,255,255));
        btcerrar.setFont(new Font("Andale Mono", 1, 14));
        btcerrar.addActionListener(this);
        add(btcerrar);

        tabla = new JTable(modelo);
        tabla.setEnabled(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        scroll = new JScrollPane(tabla);
        scroll.setBounds(40,60,610,150);
        add(scroll);

        try{
            Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bd_programa", "root", "");
			Statement st = (Statement) conexion.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery("select * from usuarios");
            while(rs.next()){
                id = rs.getInt("ID");
				nombre = rs.getString("Nombre");
				apellido = rs.getString("Apellido");
				telefono = rs.getString("Teléfono");
				correo = rs.getString("Correo");
				usuario = rs.getString("NombreUsuario");
				modelo.addRow(new Object[]{id,nombre,apellido,telefono,correo,usuario});
			}
        }catch(Exception evt){

        }

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnuevo){
            Nuevo ventananuevo = new Nuevo();
            ventananuevo.setBounds(0,0,640,600);
            ventananuevo.setVisible(true);
            ventananuevo.setResizable(false);
            ventananuevo.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        if(e.getSource() == btactualizar){
            Actualizar ventanaactualizar = new Actualizar();
            ventanaactualizar.setBounds(0,0,640,600);
            ventanaactualizar.setVisible(true);
            ventanaactualizar.setResizable(false);
            ventanaactualizar.setLocationRelativeTo(null);
            this.setVisible(false);

        }
        if(e.getSource() == bteliminar){
            Eliminar ventanaeliminar = new Eliminar();
            ventanaeliminar.setBounds(0,0,380,190);
            ventanaeliminar.setVisible(true);
            ventanaeliminar.setResizable(false);
            ventanaeliminar.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        if(e.getSource() == btcerrar){
            Login ventanalogin = new Login();
            ventanalogin.setBounds(0,0,300,350);
            ventanalogin.setVisible(true);
            ventanalogin.setResizable(false);
            ventanalogin.setLocationRelativeTo(null);
            this.setVisible(false);
        }
    }


    public static void main(String args[]){
        Tabla ventanatabla = new Tabla();
        ventanatabla.setBounds(0,0,700,400);
        ventanatabla.setVisible(true);
        ventanatabla.setResizable(false);
        ventanatabla.setLocationRelativeTo(null);
    }
}