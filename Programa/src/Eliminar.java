import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Eliminar extends JFrame implements ActionListener{

    private JLabel lbtitulo, lbinfo;
    private JTextField txtid;
    private JButton btid, btatras;

    String buscar = "";
    boolean numero;

    int id;


    public Eliminar(){
        setLayout(null);
        setTitle("Programa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(27,20,20));
        setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());

        lbtitulo = new JLabel("Eliminar", SwingConstants.CENTER);
        lbtitulo.setBounds(25,10,100,23);
        lbtitulo.setFont(new Font("Andale Mono", 1, 18));
        lbtitulo.setForeground(new Color(255,255,255));
        lbtitulo.setOpaque(false);
        add(lbtitulo);

        lbinfo = new JLabel("Ingresa el ID del usuario a eliminar:");
        lbinfo.setBounds(40,60,280,23);
        lbinfo.setFont(new Font("Andale Mono", 1, 14));
        lbinfo.setForeground(new Color(255,255,255));
        lbinfo.setOpaque(false);
        add(lbinfo);

        txtid = new JTextField();
        txtid.setBounds(40,100,80,23); 
        txtid.setFont(new Font("Andale Mono", 1, 14));
        txtid.setForeground(new Color(0,0,0));
        add(txtid);

        btid = new JButton("Eliminar");
        btid.setBounds(140,100,100,23);
        btid.setBackground(new Color(255,255,255));
        btid.setFont(new Font("Andale Mono", 1, 14));
        btid.addActionListener(this);
        add(btid);

        btatras = new JButton("Atras");
        btatras.setBounds(250,100,100,23);
        btatras.setBackground(new Color(255,255,255));
        btatras.setFont(new Font("Andale Mono", 1, 14));
        btatras.addActionListener(this);
        add(btatras);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btid){

            buscar = txtid.getText().trim();
            numero = buscar.matches("[+-]?\\d*(\\.\\d+)?");
        
            if(numero == true){
                
                try{
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_programa", "root", "");
                    PreparedStatement pst = cn.prepareStatement("select * from usuarios where ID = ?");
                    pst.setString(1, buscar);

                    ResultSet rs = pst.executeQuery();

                    if(rs.next()){
                        JOptionPane.showMessageDialog(null,"Usuario encontrado y eliminado");
                        PreparedStatement psn = cn.prepareStatement("delete from usuarios where ID = ?");
                        psn.setString(1, buscar);
                        psn.executeUpdate();
                        Tabla ventanatabla = new Tabla();
                        ventanatabla.setBounds(0,0,700,400);
                        ventanatabla.setVisible(true);
                        ventanatabla.setResizable(false);
                        ventanatabla.setLocationRelativeTo(null);
                        this.setVisible(false);

                        id = Integer.parseInt(buscar);

                    }else{
                        JOptionPane.showMessageDialog(null,"No se encontro nada");
                    }

                }catch(Exception evt){
                    JOptionPane.showMessageDialog(null, "Ingrese el ID");
                }
                    
                    
            }else if(numero == true && txtid.getText().length()==0){
                JOptionPane.showMessageDialog(null, "Algo ingreso mal");
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese el ID del usuario correctamente");
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
    }

    public static void main(String args[]){
        Eliminar ventanaeliminar = new Eliminar();
        ventanaeliminar.setBounds(0,0,380,190);
        ventanaeliminar.setVisible(true);
        ventanaeliminar.setResizable(false);
        ventanaeliminar.setLocationRelativeTo(null);
    }

}
