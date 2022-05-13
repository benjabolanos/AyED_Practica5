package uabc.ic.benjaminbolanos.practica5.memorama;

import java.util.HashSet;
import java.util.Random;
import uabc.ic.benjaminbolanos.practica5.Cultura;
import uabc.ic.benjaminbolanos.practica5.Dios;
import uabc.ic.benjaminbolanos.practica5.listascirculares.ListaCircular;
import uabc.ic.benjaminbolanos.practica5.listascirculares.ListaCircularDoble;
import uabc.ic.benjaminbolanos.practica5.listascirculares.Nodo;
import uabc.ic.benjaminbolanos.practica5.listascirculares.NodoDoble;

/**
 *
 * @author benjabolanos
 */
public class ControlMemorama {

    private final CartaModel[] cartas;
    private final ListaCircularDoble<Cultura> culturas;
    private ListaCircular<CartaModel> cartasAceptadas;

    public ControlMemorama() {
        cartas = new CartaModel[8];
        culturas = Cultura.obtenerListaCulturas();
        cartasAceptadas = new ListaCircular<>();
    }
    
    public boolean juegoTerminado(){
        return cartasAceptadas.size() == 8;
    }

    public void crearCartas() {
        cartasAceptadas = new ListaCircular<>();
        HashSet<Dios> dioses = new HashSet(4);
        while (dioses.size() < 4) {
            dioses.add(diosAleatorio());
        }
        int index = 0;
        for (Dios dios : dioses) {
            CartaModel c1, c2;
            c1 = new CartaModel(dios.getNombre(), false);
            c2 = new CartaModel(dios.getRutaImagenRespresentativa(), true);
            c1.setPar(c2);
            c2.setPar(c1);
            cartas[index++] = c1;
            cartas[index++] = c2;
        }
        mezclarCartas();
    }

    private Dios diosAleatorio() {
        Random r = new Random();
        NodoDoble<Cultura> nodo = culturas.getInicio();
        int r1 = r.nextInt(16);
        for (int i = 0; i < r1; i++) {
            nodo = nodo.getSig();
        }
        ListaCircular<Dios> dioses = nodo.getInfo().getDioses();
        Nodo<Dios> nodoDios = dioses.getInicio();
        r1 = r.nextInt(culturas.size()*2);
        for (int i = 0; i < dioses.size(); i++) {
            nodoDios = nodoDios.getSig();
        }
        return nodoDios.getInfo();
    }
    
    private void mezclarCartas(){
        Random r = new Random();
        for(int i = cartas.length - 1; i > 0 ; i--){
            int index = r.nextInt(i+1);
            CartaModel aux = cartas[index];
            cartas[index] = cartas[i];
            cartas[i] = aux;
        }
    }
    
    public boolean sonPares(int c1, int c2){
        if(cartas[c1].esParCon(cartas[c2])){
            cartasAceptadas.insertarFin(cartas[c1]);
            cartasAceptadas.insertarFin(cartas[c2]);
            System.out.println("Cartas aceptadas: " + cartasAceptadas.size());
            return true;
        }
        return false;
    }

    public CartaModel[] getCartas() {
        return cartas;
    }
    
    public ListaCircular<CartaModel> getCartasAceptadas(){
        return cartasAceptadas;
    }
}
