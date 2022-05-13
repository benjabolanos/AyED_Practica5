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
 * Clase para modelar el control del memorama.
 * @author benjabolanos
 */
public class ControlMemorama {

    private final CartaModel[] cartas;//Cartas creadas a partir de 4 dioses
    private final ListaCircularDoble<Cultura> culturas;//Lista de culturas y dioses
    private ListaCircular<CartaModel> cartasAceptadas;//Lista de cartas a como fueron siendo adivinadas

    /**
     * Constructor que inicializa el array de cartas y las listas.
     */
    public ControlMemorama() {
        cartas = new CartaModel[8];
        culturas = Cultura.obtenerListaCulturas();
        cartasAceptadas = new ListaCircular<>();
    }
    
    /**
     * Método para saber si el juego fue terminado.
     * @return True si las cartas aceptadas son 8.
     */
    public boolean juegoTerminado(){
        return cartasAceptadas.size() == 8;
    }

    /**
     * Método para crear las 8 cartas del memorama a partir de 4 dioses.
     */
    public void crearCartas() {
        //Reinicia las cartas aceptadas
        cartasAceptadas = new ListaCircular<>();
        
        //Dioses que tendrán las cartas
        HashSet<Dios> dioses = new HashSet(4);
        //Se intentará agregar un nuevo dios hasta que sean 4 diferentes
        while (dioses.size() < 4) {
            dioses.add(diosAleatorio());
        }
        int index = 0;
        //Se crean dos cartas con cada dios y se guardan en el array.
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

    /**
     * Método para obtener un dios aleatorio de una cultura aleatoria.
     * @return Dios aleatorio de una cultura aleatoria
     */
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
    
    /**
     * Método para mezclar cartas. Se utiliza el algoritmo de Fisher-Yates
     */
    private void mezclarCartas(){
        Random r = new Random();
        for(int i = cartas.length - 1; i > 0 ; i--){
            int index = r.nextInt(i+1);
            CartaModel aux = cartas[index];
            cartas[index] = cartas[i];
            cartas[i] = aux;
        }
    }
    
    /**
     * Método que compara si dos cartas son pares, en ese caso las agrega a la 
     * lista de cartas aceptadas.
     * @param c1 Posicion de la carta1
     * @param c2 Posicion de la carta2
     * @return True si las dos cartas son pares
     */
    public boolean sonPares(int c1, int c2){
        if(cartas[c1].esParCon(cartas[c2])){
            cartasAceptadas.insertarFin(cartas[c1]);
            cartasAceptadas.insertarFin(cartas[c2]);
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
