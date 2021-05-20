/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisimagenes2021.pkg2;

import espacial.EspacialUno;
import espacial.Histograma;
import espacial.UmbralAutomatico;
import herramientas.Grafica;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author working
 */
public class AnalisisImagenes20212 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       // visualización de la imagen dentro de la GUI
//        Image imagen = herramientas.HerramientasImagen.abrirImagen();
//        // para cuantización de la imagen vamos a un ocupar BufferedImage
//        //BufferedImage bImagen = herramientas.HerramientasImagen.toBufferedImage(imagen);
//        Image grises = EspacialUno.convertirAGrises(imagen);
//        Histograma h = new Histograma(grises);
//        h.calcularHistogramas();
//        Grafica g = new Grafica("Tono","Frecuencia","Histograma de Frecuencias");
//        g.agregarSerie("Rojo", h.getR());
//        g.agregarSerie("Azul", h.getB());
//        g.agregarSerie("Verde", h.getG());
//        g.crearGrafica();
//        g.muestraGrafica();
//        
//        int ua = UmbralAutomatico.metodoIterativo(h.getR());
//        int uao = UmbralAutomatico.otsu(h.getR());
//        
        // (Math.pow(1+z,pixel.getRed())/z))
        // ecualización del histograma
        double v = 0;
        int alpha = 255;
        for (int x =0; x<=255 ;x++){
        v =((alpha*Math.log(1+x))/(Math.log(1+alpha)));
        System.out.println("x:"+x+" v: "+(int)v);
    }
        
      
    }
    
}
