/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import espacial.Histograma;
import gui.JFramePrincipal;
import gui.JInternalFrameBinario;
import gui.JInternalFrameImagen;
import gui.JInternalFrameModificar;
import herramientas.Grafica;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author working
 */
public class MenuItemsImagenListener implements ActionListener{
    
     
    private  JFramePrincipal framePrincipal;

    public MenuItemsImagenListener(JFramePrincipal framePrincipal) {
        this.framePrincipal = framePrincipal;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem)e.getSource();
        if (item.getText().equals("Modificar Pixeles")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            JInternalFrameModificar internalNuevo = new JInternalFrameModificar(internal);
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
        //Escala de Grises
        if (item.getText().equals("Escala de Grises")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            Image i = internal.getImagenOriginal();
            // convertimos a escala de grises
            Image grises = espacial.EspacialUno.convertirAGrises(i);
            
            JInternalFrameImagen internalNuevo = new JInternalFrameImagen(grises);
                       
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
        // Binarizacion
        
        if (item.getText().equals("Binarizacion")){
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
                       
            JInternalFrameBinario internalNuevo = new JInternalFrameBinario(internal);
                       
            internalNuevo.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(internalNuevo);
        }
        
        // Histograma
        if (item.getText().equals("Histograma")){
           
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            // se puede extraer la imagen orginal         
            Image imagen = internal.getImagenOriginal();
            //Grafica grafica = new Grafica("Tono", "Frecuencia","Histograma");
            Histograma his = new Histograma(imagen);
            his.calcularHistogramas();
            his.graficar();

        }
        
        // Iluminacion
        if (item.getText().equals("Iluminacion")){
           
            JInternalFrameImagen internal = (JInternalFrameImagen) this.framePrincipal.getjDesktopPanePrincipal().getSelectedFrame();
            // se puede extraer la imagen orginal         
            Image imagen = internal.getImagenOriginal();
           
            Image nueva = espacial.EspacialUno.modificarIluminacion(imagen, -25);
            
            JInternalFrameImagen i = new JInternalFrameImagen(nueva);
            i.setVisible(true);
            this.framePrincipal.getjDesktopPanePrincipal().add(i);

        }
        
        
    }
    
}
