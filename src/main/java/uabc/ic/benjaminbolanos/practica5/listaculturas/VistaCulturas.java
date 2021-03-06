package uabc.ic.benjaminbolanos.practica5.listaculturas;

import javax.swing.ImageIcon;

/**
 * Clase que modela la Vista del Listado de Culturas. Une ambos paneles de 
 * Culturas y Dioses. Une esos paneles con el control para mostrar los datos.
 * @author bbola
 */
public class VistaCulturas extends javax.swing.JPanel {
    private final ControlCulturas control;

    /**
     * Constructor que inicializa componentes, control y actualiza los paneles
     * para mostrar los datos.
     */
    public VistaCulturas() {
        initComponents();
        control = new ControlCulturas();
        actualizar();
    }
    
    /**
     * Método para obtener cultura y dios actual y mostrarlos.
     */
    private void actualizar(){
        panelCulturas1.setCultura(control.getCulturaActual());
        panelDioses2.setDios(control.getDiosActual());
    }
    
    /**
     * Método que avanza la cultura y actualiza.
     */
    private void avanzarCultura(){
        control.avanzarCultura();
        actualizar();
    }
    
    /**
     * Método que retrocede la cultura y actualiza.
     */
    private void retrocederCultura(){
        control.retrocederCultura();
        actualizar();
    }
    
    /**
     * Método que avana el dios y actualiza.
     */
    private void avanzarDios(){
        control.avanzarDios();
        actualizar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonCulturaSig = new uabc.ic.benjaminbolanos.practica5.BotonLabel();
        botonCulturaAnt = new uabc.ic.benjaminbolanos.practica5.BotonLabel();
        botonDiosSig = new uabc.ic.benjaminbolanos.practica5.BotonLabel();
        panelDioses2 = new uabc.ic.benjaminbolanos.practica5.listaculturas.PanelDioses();
        panelCulturas1 = new uabc.ic.benjaminbolanos.practica5.listaculturas.PanelCulturas();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonCulturaSig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonCulturaSig.setIcon(new ImageIcon("src/main/resources/imagenes/iconos/abajo.png"));
        botonCulturaSig.setImgHovered(new ImageIcon("src/main/resources/imagenes/iconos/abajo_hover.png"));
        botonCulturaSig.setImgOriginal(new ImageIcon("src/main/resources/imagenes/iconos/abajo.png"));
        botonCulturaSig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCulturaSigMouseClicked(evt);
            }
        });
        jPanel1.add(botonCulturaSig, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 480, 140, 100));

        botonCulturaAnt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonCulturaAnt.setIcon(new ImageIcon("src/main/resources/imagenes/iconos/arriba.png"));
        botonCulturaAnt.setImgHovered(new ImageIcon("src/main/resources/imagenes/iconos/arriba_hover.png"));
        botonCulturaAnt.setImgOriginal(new ImageIcon("src/main/resources/imagenes/iconos/arriba.png"));
        botonCulturaAnt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCulturaAntMouseClicked(evt);
            }
        });
        jPanel1.add(botonCulturaAnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 140, 100));

        botonDiosSig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonDiosSig.setIcon(new ImageIcon("src/main/resources/imagenes/iconos/derecha.png"));
        botonDiosSig.setImgHovered(new ImageIcon("src/main/resources/imagenes/iconos/derecha_hover.png"));
        botonDiosSig.setImgOriginal(new ImageIcon("src/main/resources/imagenes/iconos/derecha.png"));
        botonDiosSig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonDiosSigMouseClicked(evt);
            }
        });
        jPanel1.add(botonDiosSig, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 730, 60, 40));
        jPanel1.add(panelDioses2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, -1, -1));
        jPanel1.add(panelCulturas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonCulturaAntMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCulturaAntMouseClicked
        retrocederCultura();
    }//GEN-LAST:event_botonCulturaAntMouseClicked

    private void botonCulturaSigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCulturaSigMouseClicked
        avanzarCultura();
    }//GEN-LAST:event_botonCulturaSigMouseClicked

    private void botonDiosSigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonDiosSigMouseClicked
        avanzarDios();
    }//GEN-LAST:event_botonDiosSigMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private uabc.ic.benjaminbolanos.practica5.BotonLabel botonCulturaAnt;
    private uabc.ic.benjaminbolanos.practica5.BotonLabel botonCulturaSig;
    private uabc.ic.benjaminbolanos.practica5.BotonLabel botonDiosSig;
    private javax.swing.JPanel jPanel1;
    private uabc.ic.benjaminbolanos.practica5.listaculturas.PanelCulturas panelCulturas1;
    private uabc.ic.benjaminbolanos.practica5.listaculturas.PanelDioses panelDioses2;
    // End of variables declaration//GEN-END:variables
}
