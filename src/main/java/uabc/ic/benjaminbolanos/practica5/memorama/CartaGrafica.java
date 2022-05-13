package uabc.ic.benjaminbolanos.practica5.memorama;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.imgscalr.Scalr;

/**
 * Clase para una Carta Grafica que contiene dos caras, la frontal y la trasera
 * @author benjabolanos
 */
public class CartaGrafica extends javax.swing.JPanel {

    private boolean viendoReverso;
    private boolean esImagen;

    /**
     * Constructor que inicializa componentes, crea reverso y frontal de la carta.
     */
    public CartaGrafica() {
        initComponents();
        crearReverso();
        crearFrontal();
        viendoReverso = true;
    }
    
    /**
     * Método para obtener si la carta muestra una imagen.
     * @return 
     */
    public boolean esImagen() {
        return esImagen;
    }

    /**
     * Método que crea la parte frontal de la carta, sin imagen puesta ni texto.
     */
    private void crearFrontal() {
        try {
            File archivoImagen = new File("src/main/resources/imagenes/iconos/carta_frontal.png");
            BufferedImage imagenOriginal = ImageIO.read(archivoImagen);
            BufferedImage imagenReescalada = Scalr.resize(imagenOriginal, 150, 200);
            contenidoFrontal.setIcon(new ImageIcon(imagenReescalada));
        } catch (IOException e) {
            System.out.println("Error al formatear imagen");
        }
    }

    /**
     * Método que crea la parte trasera de la carta.
     */
    private void crearReverso() {
        try {
            File archivoImagen = new File("src/main/resources/imagenes/iconos/carta_reverso.png");
            BufferedImage imagenOriginal = ImageIO.read(archivoImagen);
            BufferedImage imagenReescalada = Scalr.resize(imagenOriginal, 150, 200);
            labelReverso.setIcon(new ImageIcon(imagenReescalada));
        } catch (IOException e) {
            System.out.println("Error al formatear imagen");
        }
    }

    /**
     * Método que une el fondo frontal con la imagen de un dios. Reescala la imagen
     * del dios para que quede centrada por encima del fondo.
     * @param rutaDios Ruta donde se encuentra la imagen del dios.
     */
    private void unirFondoConDios(String rutaDios) {
        try {
            //Archivo donde se encuentran las imagenes
            File archivoDios = new File(rutaDios);
            File archivoFondo = new File("src/main/resources/imagenes/iconos/carta_frontal.png");
            
            //Imagen nueva donde se dibujaran las otras dos imagenes
            BufferedImage res = new BufferedImage(150, 200, BufferedImage.TYPE_INT_ARGB);
            
            //Imagenes rescaladas 
            BufferedImage fondoImgRees = Scalr.resize(ImageIO.read(archivoFondo), 150, 200);
            BufferedImage diosImgReesc = Scalr.resize(ImageIO.read(archivoDios), 100);
            
            //Se pintan las imagenes en la nueva imagen.
            Graphics g = res.getGraphics();
            g.drawImage(fondoImgRees, 0, 0, null);
            g.drawImage(
                    diosImgReesc,
                    //Se calcula la diferencia para colocarla en el centro
                    (fondoImgRees.getWidth() - diosImgReesc.getWidth()) / 2,
                    (fondoImgRees.getHeight() - diosImgReesc.getHeight()) / 2,
                    null);
            //Se cambia el icono del label frontal.
            contenidoFrontal.setIcon(new ImageIcon(res));
        } catch (IOException e) {
            System.out.println("Error al formatear imagen");
        }
    }

    /**
     * Método para cambiar los datos de la carta grafica a partir del modelo de
     * una carta.
     * @param model 
     */
    public void setContenido(CartaModel model) {
        esImagen = model.getEsImagen();
        //Si es imagen, une el dios con el fondo y el texto vacio
        if (esImagen) {
            contenidoFrontal.setText("");
            unirFondoConDios(model.getContenido());
        } else {
            //Si no, crea un frontal sin dios y el texto es el nombre del dios.
            crearFrontal();
            contenidoFrontal.setText(model.getContenido());
        }
    }

    /**
     * Método para mostrar el contenido de la carta o la parte frontal
     */
    public void mostrarContenido() {
        if (viendoReverso) {
            CardLayout cl = (CardLayout) cardsPanel.getLayout();
            cl.show(cardsPanel, "frontal");
            viendoReverso = false;
        }
    }

    /**
     * Método para mostrar el reverso de la carta.
     */
    public void mostrarReverso() {
        if (!viendoReverso) {
            CardLayout cl = (CardLayout) cardsPanel.getLayout();
            cl.show(cardsPanel, "reverso");
            viendoReverso = true;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardsPanel = new javax.swing.JPanel();
        panelReverso = new javax.swing.JPanel();
        labelReverso = new javax.swing.JLabel();
        panelFrontal = new javax.swing.JPanel();
        contenidoFrontal = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(150, 200));
        setPreferredSize(new java.awt.Dimension(150, 200));

        cardsPanel.setLayout(new java.awt.CardLayout());

        panelReverso.setBackground(new java.awt.Color(228, 214, 167));
        panelReverso.setMaximumSize(new java.awt.Dimension(150, 200));
        panelReverso.setMinimumSize(new java.awt.Dimension(150, 200));
        panelReverso.setPreferredSize(new java.awt.Dimension(150, 200));
        panelReverso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelReverso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelReverso.add(labelReverso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 200));

        cardsPanel.add(panelReverso, "reverso");

        panelFrontal.setBackground(new java.awt.Color(228, 214, 167));
        panelFrontal.setMaximumSize(new java.awt.Dimension(150, 200));
        panelFrontal.setMinimumSize(new java.awt.Dimension(150, 200));
        panelFrontal.setPreferredSize(new java.awt.Dimension(150, 200));
        panelFrontal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenidoFrontal.setForeground(new java.awt.Color(0, 0, 0));
        contenidoFrontal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contenidoFrontal.setToolTipText("");
        contenidoFrontal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelFrontal.add(contenidoFrontal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 200));

        cardsPanel.add(panelFrontal, "frontal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(cardsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardsPanel;
    private javax.swing.JLabel contenidoFrontal;
    private javax.swing.JLabel labelReverso;
    private javax.swing.JPanel panelFrontal;
    private javax.swing.JPanel panelReverso;
    // End of variables declaration//GEN-END:variables
}
