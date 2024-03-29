/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frecuencias;

import espacial.EspacialUno;
import gui.FFTJFrame;
import herramientas.HerramientasImagen;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author working
 */
public class FrecuenciasMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Image imagen = herramientas.HerramientasImagen.abrirImagen();
        Image grises = EspacialUno.convertirAGrises(imagen);
        
        FFTJFrame frame = new FFTJFrame(grises);
        frame.setTitle("Imagen Original");
        frame.setVisible(true);
        
        BufferedImage bImage = HerramientasImagen.toBufferedImage(grises);
       
        Gestor gestor = new Gestor();
        
        NumeroComplejo[][] imagenOriginal = gestor.obtenerDatosPorCanal(bImage, HerramientasColor.CanalColor.ROJO);
        
        BufferedImage biRes = gestor.obtenerImagenFrecuencias(imagenOriginal, bImage.getWidth(),
                 bImage.getHeight(), true);
        
        Image iRes = herramientas.HerramientasImagen.toImage(biRes);
        FFTJFrame frame2 = new FFTJFrame(iRes);
        frame2.setVisible(true);
        frame2.setTitle("Espectro");
        
        // imagenOriginal se le aplica el filtro
      
        
        // despues con imagenOriginal se calcula la fft Inversa
        BufferedImage res = gestor.obtenerImagenEspacial();
        Image iRes2 = herramientas.HerramientasImagen.toImage(res);
        FFTJFrame frame3 = new FFTJFrame(iRes2);
        frame3.setTitle("Inversa");
        frame3.setVisible(true);
        
        
        
    }
    
}
