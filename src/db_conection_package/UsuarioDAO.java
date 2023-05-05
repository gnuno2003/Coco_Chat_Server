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
        PreparedStatement ps;
        ps = getConnection().prepareStatement("INSERT INTO usuario (nombre, registro) values (?,?)");
        /*
            a cada signo de interrogación se le asiga un numero coorespondiente
            a su posicion 
                    values ( ? , ? )
                             1   2
        
            ps.setString(numero de signo de interrogacion, valor); 
            ps.setInt(numero de signo de interrogacion, valor); 
            ps.setDouble(numero de signo de interrogacion, valor); 
        
            aqui tambien se escoje el tipo de dato a asignar.        
        */
        
        // Sustituye al primer signo de interrogacion, por el valor de persona.nombre
        ps.setString(1, persona.nombre); 
        
        // Sustituye al segundo signo de interrogacion, por el valor de persona.registro
        ps.setInt(2, persona.registro); 
        
        return ps.executeUpdate()>0; //Ejecuta la instrucción SQL
        } 
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
