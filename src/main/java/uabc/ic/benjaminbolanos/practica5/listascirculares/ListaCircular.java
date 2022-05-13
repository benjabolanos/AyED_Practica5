package uabc.ic.benjaminbolanos.practica5.listascirculares;

/**
 * Clase que modela una Lista Circular.
 * @author benjabolanos
 * @param <T>
 */
public class ListaCircular<T> {
    private Nodo<T> inicio;
    private Nodo<T> fin;
    
    /**
     * Método para obtener el nodo de inicio y poder recorrer la lista.
     * @return Nodo inicio de la lista.
     */
    public Nodo<T> getInicio(){
        return inicio;
    }
    
    /**
     * Método que inserta un nuevo dato al inicio de la lista.
     * @param dato Dato a insertar
     */
    public void insertarInicio(T dato){
        Nodo<T> n = new Nodo(dato, null);
        
        if(inicio == null){
            inicio = fin = n;
        } else {
            n.setSig(inicio);
            inicio = n;
            fin.setSig(inicio);
        }
    }
    
    /**
     * Método para insertar un nuevo dato al final de la lista.
     * @param dato Dato a insertar
     */
    public void insertarFin(T dato){
        Nodo<T> n = new Nodo(dato, null);
        if(inicio == null){
            inicio = fin = n;
            n.setSig(inicio);
        } else {
            n.setSig(inicio);
            fin.setSig(n);
            fin = n;
        }
    }
    
    /**
     * Método para eliminar el dato que está al inicio de la lista.
     * @return Retorna dato eliminado.
     */
    public T eliminarInicio(){
        T dato = null;
        if(inicio == null){
            System.out.println("Lista vacia");
        } else {
            dato = inicio.getInfo();
            if(inicio == fin){
                inicio = fin = null;
            } else {
                fin.setSig(inicio.getSig());
                inicio = inicio.getSig();
            }
        }
        return dato;
    }
    
    /**
     * Método para eliminar el dato que está al final de la lista.
     * @return Retorna dato eliminado.
     */
    public T eliminarFin(){
        T dato = null;
        if(inicio == null){
            System.out.println("Lista vacia");
        } else {
            dato = fin.getInfo();
            if(inicio == fin){
                inicio = fin = null;
            } else {
                Nodo r = inicio;
                while(r.getSig() != fin){
                    r = r.getSig();
                }
                fin = r;
                fin.setSig(inicio);
            }
        }
        return dato;
    }
    
    /**
     * Método que recorre la lista con un ciclo while y crea un string con toda
     * la informacion de esta.
     * @return String que contiene la información de la lista.
     */
    public String recorrer(){
        String rec = new String();
        Nodo<T> r = inicio;
        while(r!=fin){
            rec += r.getInfo().toString();
            r = r.getSig();
        }
        rec += r.getInfo().toString();
        return rec;
    }
    
    /**
     * Método que recorre la lista de manera recursiva y crea un String con
     * toda la información
     * @param x 
     * @return String con la información del nodo actual
     */
    private String mostrarRecursivo(Nodo<T> x){
        if(inicio == null){
            return "Lista vacia";
        } else if(x.getSig() != inicio){
            return x.toString() + " " + mostrarRecursivo(x.getSig());
        } else {
            return x.toString();
        }
    }
    
    /**
     * Método toString que recorre la lista recursivamente desde el inicio.
     * @return String con la información de la lista.
     */
    @Override
    public String toString(){
        return mostrarRecursivo(inicio);
    }
    
    /**
     * Método que cuenta la cantidad de nodos que hay en la lista
     * @return Cantidad de nodos que hay en la lista.
     */
    public int size(){
        if(inicio == null){
            return 0;
        } else {
            int size = 1;
            Nodo r = inicio;
            while(r.getSig() != inicio){
                size++;
                r = r.getSig();
            }
            return size;
        }
    }
    
    /**
     * Método para obtener el elemento en 'i' posicion
     * @param i Posicion del elemento buscado
     * @return Elemento en la posicion i
     */
    public T buscar(int i){
        if(i >= 0 && i < size()){
            Nodo<T> r = inicio;
            for(int j = 0; j < i; j++)
                r = r.getSig();
            return r.getInfo();
        }
        return null;
    }
}