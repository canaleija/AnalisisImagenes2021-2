/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author working
 */
public class EspacialUno {
    
    // By Oscar
    public static Image convertirANegativo(Image imagenOriginal){
        
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        
        for(int x=0; x<bi.getWidth();x++){
            for(int y=0; y< bi.getHeight();y++){
               int p=bi.getRGB(x, y);
               int a=(p>>24)&0xff;
               int r=(p>>16)&0xff;
               int g=(p>>8)&0xff;
               int b=p&0xff; 
               r=255-r;
               g=255-g;
               b=255-b;
               
               p=(a<<24)|(r<<16)|(g<<8)|b;
               bi.setRGB(x,y,p);
            }
                  
        }
     return herramientas.HerramientasImagen.toImage(bi);
    }
    
    // By  Dávila
    public static Image convertirAGrises(Image imagenOriginal){
        
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        Color color ;
                int i,j,aux;
                for(j = 0; j< bi.getHeight(); j++){
                    for(i = 0; i < bi.getWidth(); i++){
                     color = new Color(bi.getRGB(i,j));
                     aux = (color.getRed()+color.getBlue()+color.getGreen())/3;
                     color = new Color(aux,aux,aux);
                     bi.setRGB(i, j, color.getRGB());
                    }
                }
     return herramientas.HerramientasImagen.toImage(bi);
    }
    
    public static Image modificarIluminacion (Image imagenOriginal, int valor){
            
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        Color color ;
                int i,j,aux;
                for(j = 0; j< bi.getHeight(); j++){
                    for(i = 0; i < bi.getWidth(); i++){
                     color = new Color(bi.getRGB(i,j));
                     int r = color.getRed()+valor;
                     int g = color.getGreen()+valor;
                     int b = color.getBlue()+valor;
                     
                     color = new Color(verificar(r),verificar(g),verificar(b));
                     bi.setRGB(i, j, color.getRGB());
                    }
                }
     return herramientas.HerramientasImagen.toImage(bi);
    }
    
    public static int verificar(int valor){
        if(valor>255) return 255;
        if(valor<0) return 0;
        return valor;
    }
    
    
    
}
