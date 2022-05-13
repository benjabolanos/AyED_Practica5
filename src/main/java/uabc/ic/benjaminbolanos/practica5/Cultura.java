package uabc.ic.benjaminbolanos.practica5;

import uabc.ic.benjaminbolanos.practica5.listascirculares.ListaCircular;
import uabc.ic.benjaminbolanos.practica5.listascirculares.ListaCircularDoble;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author benjabolanos
 */
public class Cultura {

    private String nombre, areaGeografica, ciudadPrincipal, añoAparicion, añoExtincion;
    private ListaCircular<Dios> dioses;

    public Cultura(String nombre, String areaGeografica, String ciudadPrincipal, 
            String añoAparicion, String añoExtincion, ListaCircular dioses) {
        this.nombre = nombre;
        this.areaGeografica = areaGeografica;
        this.ciudadPrincipal = ciudadPrincipal;
        this.añoAparicion = añoAparicion;
        this.añoExtincion = añoExtincion;
        this.dioses = dioses;
    }

    public static ListaCircularDoble<Cultura> obtenerListaCulturas() {
        ListaCircularDoble<Cultura> culturas = new ListaCircularDoble();
        try {
            //Archivos de culturas y dioses
            File archivoCulturas = new File("src/main/resources/textos/culturas.txt");
            File archivoDioses = new File("src/main/resources/textos/dioses.txt");
            
            //Lectores de archivos
            BufferedReader lectorDioses = new BufferedReader(new FileReader(archivoDioses));
            BufferedReader lectorCulturas = new BufferedReader(new FileReader(archivoCulturas));
            
            //Linea leida de un archivo
            String lineaCultura;
            String lineaDios;
            
            while ((lineaCultura = lectorCulturas.readLine()) != null) {
                String[] psLineaCultura = lineaCultura.split(",");
                for (String p : psLineaCultura) p = p.trim();
                ListaCircular<Dios> dioses = new ListaCircular();
                while ((lineaDios = lectorDioses.readLine()) != null) {
                    if (lineaDios.equals("|")) break;//Cuando haya un '|' es cambio de cultura
                    String[] ps = lineaDios.split(",");
                    for (int i = 0; i<ps.length;i++) ps[i] = ps[i].trim();
                    dioses.insertarFin(new Dios(ps[0],ps[1],ps[2],ps[3]));
                }
                culturas.insertarFin(new Cultura(psLineaCultura[0], psLineaCultura[1], 
                        psLineaCultura[2], psLineaCultura[3], psLineaCultura[4],dioses));
            }
            lectorCulturas.close();
            lectorDioses.close();

        } catch (IOException e) {
            System.out.println("Error al leer archivo culturas.");
        }

        return culturas;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nArea Geografica: " + areaGeografica
                + "\nCiudad Principal: " + ciudadPrincipal + "\nEpoca: "
                + añoAparicion + " - " + añoExtincion + '\n' + dioses.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAreaGeografica() {
        return areaGeografica;
    }

    public void setAreaGeografica(String areaGeografica) {
        this.areaGeografica = areaGeografica;
    }

    public String getCiudadPrincipal() {
        return ciudadPrincipal;
    }

    public void setCiudadPrincipal(String ciudadPrincipal) {
        this.ciudadPrincipal = ciudadPrincipal;
    }

    public String getAñoAparicion() {
        return añoAparicion;
    }

    public void setAñoAparicion(String añoAparicion) {
        this.añoAparicion = añoAparicion;
    }

    public String getAñoExtincion() {
        return añoExtincion;
    }

    public void setAñoExtincion(String añoExtincion) {
        this.añoExtincion = añoExtincion;
    }

    public ListaCircular<Dios> getDioses() {
        return dioses;
    }

    public void setDioses(ListaCircular<Dios> dioses) {
        this.dioses = dioses;
    }
}
