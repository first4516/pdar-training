/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdardemotraining;

import javax.swing.JPanel;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class MyJasperViewer extends JasperViewer {



        public MyJasperViewer(JasperPrint jasperPrint, boolean isExitOnClose) {
        super(jasperPrint, isExitOnClose);

        try {
            ((JPanel) this.viewer.getComponent(0)).remove(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
