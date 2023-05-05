package db_conection_package;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author gnuno
 */
public class UsuarioDAO extends Db_Conection{
    public UsuarioDAO()
    {
        super();
    }
    
    public boolean RegistrarUsuario(Usuario usuario) 
    {
        try
        {
        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO usuario (nombre, username, password, correo, pregunta_respaldo, estado) values (?,?,?,?,?,?)");
        
        ps.setString(1, usuario.nombre);
        ps.setString(2, usuario.username);
        ps.setString(3, usuario.password);
        ps.setString(4, usuario.correo);
        ps.setString(5, usuario.pregunta_respaldo);
        ps.setInt(6, usuario.estado);
        
        return ps.executeUpdate()>0;
        } 
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean IniciarSesion(String username, String password)
    {
        try 
        {
            PreparedStatement ps =  getConnection().prepareStatement("SELECT * FROM usuario WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery(); 
            
            //Si las credenciales son correctas
            if(rs.next())
            {
                //Aqui necesitamos poner esta variable global o en algun cache para guardarla
                int id_usuario = rs.getInt("id_usuario");
                return true;
            }
            //Si las credenciales son incorrectas
            else
            {
                return false;
            }          
        }
        catch(SQLException es)
        {
            System.out.println(es.getMessage());
        }
        return false;
    }
}
