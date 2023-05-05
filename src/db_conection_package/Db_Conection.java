package db_conection_package;

/**
 *
 * @author gnuno
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_Conection {
    private Connection c;
    
    public Db_Conection()
    {
        try
        {
            Class.forName("com.mySQL.Jdbc.Driver");
            
            c = DriverManager.getConnection("jdbc:mysql://localhost/basededatos","root","");
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println("Driver no cargado: " + ex.getMessage());
        }
        catch (SQLException ex)
        {
            System.out.println("Error de conexion a la bd: " + ex.getMessage());
        }
    }
}
