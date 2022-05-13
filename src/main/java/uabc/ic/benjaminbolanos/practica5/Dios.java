package uabc.ic.benjaminbolanos.practica5;

/**
 * Clase que modela un Dios de una Cultura Mesoamericana
 * @author benjabolanos
 */
public class Dios {

    private String nombre, simbolizaba, nombreTemplo, imagenRespresentativa;

    /**
     * Constructor que recibe todos los datos del dios.
     * @param nombre Nombre del dios
     * @param simbolizaba Lo que este dios simbolizaba
     * @param nombreTemplo Templo donde se le veneraba
     * @param rutaImagenRespresentativa Ruta donde se encuentra la imagen representativa
     */
    public Dios(String nombre, String simbolizaba, String nombreTemplo, String rutaImagenRespresentativa) {
        this.nombre = nombre;
        this.simbolizaba = simbolizaba;
        this.nombreTemplo = nombreTemplo;
        this.imagenRespresentativa = rutaImagenRespresentativa;
    }
    
    @Override
    public String toString(){
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolizaba() {
        return simbolizaba;
    }

    public void setSimbolizaba(String simbolizaba) {
        this.simbolizaba = simbolizaba;
    }

    public String getNombreTemplo() {
        return nombreTemplo;
    }

    public void setNombreTemplo(String nombreTemplo) {
        this.nombreTemplo = nombreTemplo;
    }
    
    public String getRutaImagenRespresentativa() {
        return imagenRespresentativa;
    }

    public void setImagenRespresentativa(String imagenRespresentativa) {
        this.imagenRespresentativa = imagenRespresentativa;
    }
}
