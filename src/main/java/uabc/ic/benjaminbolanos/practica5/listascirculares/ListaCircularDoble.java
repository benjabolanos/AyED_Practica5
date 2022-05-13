package uabc.ic.benjaminbolanos.practica5.listascirculares;

/**
 *
 * @author benjabolanos
 * @param <T>
 */
public class ListaCircularDoble<T> {
    private NodoDoble<T> inicio;
    private NodoDoble<T> fin;
    
    public ListaCircularDoble(){
        inicio = fin = null;
    }
    
    public NodoDoble<T> getInicio(){
        return inicio;
    }
    
    public void insertarInicio(T dato){
        NodoDoble<T> n = new NodoDoble(dato);
        if(inicio == null){
            inicio = fin = n;
            n.setSig(inicio);
            n.setAnt(inicio);
        } else {
            n.setSig(inicio);
            inicio.setAnt(n);
            inicio = n;
            fin.setSig(inicio);
            n.setAnt(fin);
        }
    }
    
    public void insertarFin(T dato){
        NodoDoble<T> n = new NodoDoble(dato);
        if(inicio == null){
            inicio = fin = n;
            n.setSig(inicio);
            n.setAnt(inicio);
        } else {
            n.setSig(inicio);
            inicio.setAnt(n);
            fin.setSig(n);
            n.setAnt(fin);
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
                inicio.setAnt(fin);
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
                NodoDoble r = fin.getAnt();
                r.setSig(inicio);
                inicio.setAnt(r);
                fin = r;
            }
        }
        return dato;
    }
    
    public String recorrer(){
        String rec = new String();
        if(inicio == null){
            rec = "Lista vacia";
        } else {
            NodoDoble<T> r = inicio;
            while(r != fin){
                rec += r.toString() + " ";
                r = r.getSig();
            }
            rec += r.toString();
        }
        return rec;
    }
    
    private String mostrarRecursivo(NodoDoble x){
        if(inicio == null){
            return "Lista vacia";
        } else if(x.getSig() != inicio){
            return x.toString() + "\n\n" + mostrarRecursivo(x.getSig());
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
            NodoDoble<T> r = inicio;
            int size = 1;
            while(r.getSig() != inicio){
                size++;
                r = r.getSig();
            }
            return size;
        }
    }
    
    public T buscar(int i){
        if(i >= 0 && i < size()){
            NodoDoble<T> r = inicio;
            for(int j = 0; j < i; j++){
                r = r.getSig();
            }
            return r.getInfo();
        }
        return null;
    }
}
