package uabc.ic.benjaminbolanos.practica5.listascirculares;

/**
 *
 * @author benjabolanos
 * @param <T>
 */
public class ListaCircular<T> {
    private Nodo<T> inicio;
    private Nodo<T> fin;
    
    public Nodo<T> getInicio(){
        return inicio;
    }
    
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
    
    private String mostrarRecursivo(Nodo<T> x){
        if(inicio == null){
            return "Lista vacia";
        } else if(x.getSig() != inicio){
            return x.toString() + " " + mostrarRecursivo(x.getSig());
        } else {
            return x.toString();
        }
    }
    
    @Override
    public String toString(){
        return mostrarRecursivo(inicio);
    }
    
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