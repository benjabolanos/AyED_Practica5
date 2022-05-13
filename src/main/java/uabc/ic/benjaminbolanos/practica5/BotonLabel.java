package uabc.ic.benjaminbolanos.practica5;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase que extiende de JLabel, modela un boton con efecto de hover.
 * @author benjabolanos
 */
public class BotonLabel extends JLabel{
    
    private ImageIcon imgOriginal;
    private ImageIcon imgHovered;

    public BotonLabel(){
        super();
        crearListeners();
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g.create();
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.dispose();
        super.paintComponent(g);
    }
    
    /**
     * Método que crea los listeners de cuando el mouse entra y sale del area
     * del boton.
     */
    private void crearListeners(){
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseExited(MouseEvent e){
                setIcon(imgOriginal);
                repaint();
            }
            @Override
            public void mouseEntered(MouseEvent e){
                setIcon(imgHovered);
                repaint();
            }
        });
    }

    public void setImgOriginal(ImageIcon imgOriginal) {
        this.imgOriginal = imgOriginal;
    }

    public void setImgHovered(ImageIcon imgHovered) {
        this.imgHovered = imgHovered;
    }
}
