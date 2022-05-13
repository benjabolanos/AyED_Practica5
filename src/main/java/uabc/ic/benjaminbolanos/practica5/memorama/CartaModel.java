package uabc.ic.benjaminbolanos.practica5.memorama;

/**
 *
 * @author benjabolanos
 */
public class CartaModel {
    private String contenido;
    private Boolean esImagen;
    private CartaModel par;

    public CartaModel(String contenido, Boolean esImagen) {
        this.contenido = contenido;
        this.esImagen = esImagen;
    }
    
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
