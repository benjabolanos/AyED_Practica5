package uabc.ic.benjaminbolanos.practica5.listaculturas;

import javax.swing.ImageIcon;
import uabc.ic.benjaminbolanos.practica5.Dios;

/**
 * Clase que modela el ambiente gráfico donde se muestra la informacion
 * de un Dios.
 * @author benjabolanos
 */
public class PanelDioses extends javax.swing.JPanel {

    /**
     * Constructor que inicializa los componentes
     */
    public PanelDioses() {
        initComponents();
    }
    
    /**
     * Método que cambia los valores de los labels para mostrar la 
     * información de un Dios.
     * @param dios Cultura de la cual se mostrarán sus datos.
     */
    public void setDios(Dios dios){
        imgDios.setIcon(new ImageIcon(dios.getRutaImagenRespresentativa()));
        labelNombre.setText(dios.getNombre());
        txtTemplo.setText(dios.getNombreTemplo());
        txtRepresenta.setText(dios.getSimbolizaba());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelDioses = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        imgDios = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelTemplo = new javax.swing.JLabel();
        labelRepresenta = new javax.swing.JLabel();
        txtTemplo = new javax.swing.JLabel();
        txtRepresenta = new javax.swing.JLabel();

        setBackground(new java.awt.Color(28, 17, 10));
        setMaximumSize(new java.awt.Dimension(400, 800));
        setMinimumSize(new java.awt.Dimension(400, 800));
        setPreferredSize(new java.awt.Dimension(400, 800));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelDioses.setFont(new java.awt.Font("Hardenburg Demo", 1, 36)); // NOI18N
        labelDioses.setForeground(new java.awt.Color(228, 214, 167));
        labelDioses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDioses.setText("Dioses");
        labelDioses.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(labelDioses, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 70));

        labelNombre.setFont(new java.awt.Font("Hardenburg Demo", 1, 45)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(228, 214, 167));
        labelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNombre.setText("Dragon Olmeca");
        labelNombre.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        labelNombre.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 400, 70));

        imgDios.setBackground(new java.awt.Color(0, 0, 0));
        imgDios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add(imgDios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 380, 400));

        jPanel1.setBackground(new java.awt.Color(228, 214, 167));
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 380, 400));

        labelTemplo.setFont(new java.awt.Font("Cinzel Decorative", 1, 14)); // NOI18N
        labelTemplo.setForeground(new java.awt.Color(228, 214, 167));
        labelTemplo.setText("Templo:");
        add(labelTemplo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, -1, -1));

        labelRepresenta.setFont(new java.awt.Font("Cinzel Decorative", 1, 14)); // NOI18N
        labelRepresenta.setForeground(new java.awt.Color(228, 214, 167));
        labelRepresenta.setText("Representa:\n");
        add(labelRepresenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        txtTemplo.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        txtTemplo.setForeground(new java.awt.Color(228, 214, 167));
        txtTemplo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTemplo.setText("El Templo Aquel");
        add(txtTemplo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, 400, -1));

        txtRepresenta.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        txtRepresenta.setForeground(new java.awt.Color(228, 214, 167));
        txtRepresenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRepresenta.setText("Fuego y Muchas cosas wu");
        add(txtRepresenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 400, 90));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgDios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelDioses;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelRepresenta;
    private javax.swing.JLabel labelTemplo;
    private javax.swing.JLabel txtRepresenta;
    private javax.swing.JLabel txtTemplo;
    // End of variables declaration//GEN-END:variables
}
