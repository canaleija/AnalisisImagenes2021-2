/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import gui.JFramePrincipal;
import gui.JInternalFrameImagen;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author working
 */
public class InternalFrameListener implements ActionListener{
     
    private  JFramePrincipal framePrincipal;

    public InternalFrameListener(JFramePrincipal framePrincipal) {
        this.framePrincipal = framePrincipal;
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
       Image imagen = herramientas.HerramientasImagen.abrirImagen();
       JInternalFrameImagen nuevo = new JInternalFrameImagen(imagen);
       nuevo.setVisible(true);
       this.framePrincipal.getjDesktopPanePrincipal().add(nuevo);
    }
    
}
