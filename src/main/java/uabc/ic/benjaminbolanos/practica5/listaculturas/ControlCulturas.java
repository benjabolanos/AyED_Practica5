package uabc.ic.benjaminbolanos.practica5.listaculturas;

import uabc.ic.benjaminbolanos.practica5.Cultura;
import uabc.ic.benjaminbolanos.practica5.Dios;
import uabc.ic.benjaminbolanos.practica5.listascirculares.ListaCircularDoble;
import uabc.ic.benjaminbolanos.practica5.listascirculares.Nodo;
import uabc.ic.benjaminbolanos.practica5.listascirculares.NodoDoble;

/**
 * Clase que modela el control del listado de culturas.
 * @author benjabolanos
 */
public class ControlCulturas {
    private ListaCircularDoble<Cultura> culturas;
    private NodoDoble<Cultura> culturaActual;
    private Nodo<Dios> diosActual;
    
    public ControlCulturas(){
        iniciar();
    }
    
    /**
     * Método que inicia la lista de culturas y pone la primer cultura como la actual
     * y su primero dios como el actual.
     */
    private void iniciar(){
        culturas = Cultura.obtenerListaCulturas();
        culturaActual = culturas.getInicio();
        diosActual = culturas.getInicio().getInfo().getDioses().getInicio();
    }
    
    /**
     * Método que avanza hacia la siguiente cultura, la siguiente cultura ahora
     * es la actual y su primer dios es el nuevo dios actual.
     */
    public void avanzarCultura(){
        culturaActual = culturaActual.getSig();
        diosActual = culturaActual.getInfo().getDioses().getInicio();
    }
    
    /**
     * Método que retrocede hacia la anterior cultura, la anterior 
     * cultura ahora es la actual y su primer dios es el nuevo dios actual.
     */
    public void retrocederCultura(){
        culturaActual = culturaActual.getAnt();
        diosActual = culturaActual.getInfo().getDioses().getInicio();
    }
    
    /**
     * Método que avanza hacia el siguiente dios, el siguiente dios es el nuevo
     * dios actual.
     */
    public void avanzarDios(){
        diosActual = diosActual.getSig();
    }
    
    /**
     * Método para obtener la cultura actual
     * @return Cultura actual
     */
    public Cultura getCulturaActual(){
        return culturaActual.getInfo();
    }
    
    /**
     * Método para obtener el dios actual
     * @return Dios actual
     */
    public Dios getDiosActual(){
        return diosActual.getInfo();
    }
}
