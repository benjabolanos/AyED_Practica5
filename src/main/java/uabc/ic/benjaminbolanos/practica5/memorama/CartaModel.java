package uabc.ic.benjaminbolanos.practica5.memorama;

/**
 * Clase que modela una Carta del memorama con su contenido, si es imagen y 
 * su carta par.
 * @author benjabolanos
 */
public class CartaModel {
    private String contenido;
    private Boolean esImagen;
    private CartaModel par;

    /**
     * Constructor que recibe su contenido y si es imagen.
     * @param contenido
     * @param esImagen 
     */
    public CartaModel(String contenido, Boolean esImagen) {
        this.contenido = contenido;
        this.esImagen = esImagen;
    }
    
    /**
     * Método para comparar esta carta con otra para saber si son pares.
     * @param otraCarta Carta con la que se comparará
     * @return True si las cartas son pares.
     */
    public boolean esParCon(CartaModel otraCarta){
        return this.par == otraCarta;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Boolean getEsImagen() {
        return esImagen;
    }

    public void setEsImagen(Boolean esImagen) {
        this.esImagen = esImagen;
    }

    public CartaModel getPar() {
        return par;
    }

    public void setPar(CartaModel par) {
        this.par = par;
    }
}
