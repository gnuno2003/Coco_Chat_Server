package db_conection_package;

import java.util.Date;
/**
 *
 * @author gnuno
 */
public class MensajeUsuario {
    public int id_mensaje_usuario;
    public int  remitente_usuario;
    public int  destinatario_usuario;
    public Date fecha_mensaje;
    public String mensaje_usuario;
    
    public MensajeUsuario()
    {
        id_mensaje_usuario = 0;
        remitente_usuario = 0;
        destinatario_usuario = 0;
        fecha_mensaje = new Date();
        mensaje_usuario = "";
    }
    
    public MensajeUsuario(int remitente_usuario, int destinatario_usuario, Date fecha_mensaje, String mensaje_usuario)
    {
        this.id_mensaje_usuario = id_mensaje_usuario;
        this.remitente_usuario = remitente_usuario;
        this.destinatario_usuario = destinatario_usuario;
        this.fecha_mensaje = fecha_mensaje;
        this.mensaje_usuario = mensaje_usuario;
    }
}
