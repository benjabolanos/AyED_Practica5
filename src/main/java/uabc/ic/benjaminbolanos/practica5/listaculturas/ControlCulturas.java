package uabc.ic.benjaminbolanos.practica5.listaculturas;

import uabc.ic.benjaminbolanos.practica5.Cultura;
import uabc.ic.benjaminbolanos.practica5.Dios;
import uabc.ic.benjaminbolanos.practica5.listascirculares.ListaCircularDoble;
import uabc.ic.benjaminbolanos.practica5.listascirculares.Nodo;
import uabc.ic.benjaminbolanos.practica5.listascirculares.NodoDoble;

/**
 *
 * @author benjabolanos
 */
public class ControlCulturas {
    private ListaCircularDoble<Cultura> culturas;
    private NodoDoble<Cultura> culturaActual;
    private Nodo<Dios> diosActual;
    
    public ControlCulturas(){
        iniciar();
    }
    
    private void iniciar(){
        culturas = Cultura.obtenerListaCulturas();
        culturaActual = culturas.getInicio();
        diosActual = culturas.getInicio().getInfo().getDioses().getInicio();
    }
    
    public void avanzarCultura(){
        culturaActual = culturaActual.getSig();
        diosActual = culturaActual.getInfo().getDioses().getInicio();
    }
    
    public void retrocederCultura(){
        culturaActual = culturaActual.getAnt();
        diosActual = culturaActual.getInfo().getDioses().getInicio();
    }
    
    public void avanzarDios(){
        diosActual = diosActual.getSig();
    }
    
    public Cultura getCulturaActual(){
        return culturaActual.getInfo();
    }
    
    public Dios getDiosActual(){
        return diosActual.getInfo();
    }
}
