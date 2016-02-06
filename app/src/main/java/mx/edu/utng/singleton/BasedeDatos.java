package mx.edu.utng.singleton;

/**
 * Created by Diego on 05/02/2016.
 */
public class BasedeDatos {
    private static BasedeDatos bd;
    private String nombre;
    private String host;
    private String puerto;

    private BasedeDatos(){
        this.nombre = "BD_Unica";
        this.host = "127.0.0.1";
        this.puerto = "5432";

    }

    public static BasedeDatos getBd() {
        if(bd==null){
            bd = new BasedeDatos();
        }
        return bd;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }
}
