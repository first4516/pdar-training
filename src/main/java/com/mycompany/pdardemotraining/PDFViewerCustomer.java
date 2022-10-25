/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdardemotraining;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.util.PropertiesManager;


/**
 *
 * @author khunp
 */
public class PDFViewerCustomer {
    JFrame applicationFrame;
    SwingController controller = new SwingController();
    public static void main(String[] args) {
        // Get a file from the command line to open
        String filePath = "D:/MISSINGDOC.pdf";
//        org.icepdf.ri.common.views.DocumentViewController vcMain = buildMainPage(filePath);
//        org.icepdf.ri.common.views.DocumentViewController vcMain2 = buildMainPage(filePath);
        // build a component controller
        
    }
    
    public org.icepdf.ri.common.views.DocumentViewController buildMainPage(String filePath){
        //SwingController controller = new SwingController();

        //SwingViewBuilder factory = new SwingViewBuilder(controller);
        SwingViewBuilder factory = new SwingViewBuilder(controller){

            @Override
            public JToolBar buildAnnotationUtilityToolBar() {
                JToolBar toolbar = new JToolBar();
                commonToolBarSetup(toolbar, false);
                return toolbar;
            }
            @Override
            public JToolBar buildAnnotationlToolBar() {
                JToolBar toolbar = new JToolBar();
                commonToolBarSetup(toolbar, false);
                return toolbar;
            }
            @Override
            public JToolBar buildDemoToolBar() {
                JToolBar toolbar = new JToolBar();
                commonToolBarSetup(toolbar, false);
                return toolbar;
            }
            @Override
            public JToolBar buildFitToolBar() {
                JToolBar toolbar = new JToolBar();
                commonToolBarSetup(toolbar, false);
                return toolbar;
            }
            @Override
            public JToolBar buildFormsToolBar() {
                JToolBar toolbar = new JToolBar();
                commonToolBarSetup(toolbar, false);
                return toolbar;
            }
            @Override
            public JToolBar buildPageNavigationToolBar() {
                JToolBar toolbar = new JToolBar();
                commonToolBarSetup(toolbar, false);
                return toolbar;
            }
            @Override
            public JToolBar buildRotateToolBar() {
                JToolBar toolbar = new JToolBar();
                commonToolBarSetup(toolbar, false);
                return toolbar;
            }
            @Override
            public JToolBar buildToolToolBar() {
                JToolBar toolbar = new JToolBar();
                commonToolBarSetup(toolbar, false);
                return toolbar;
            }
            @Override
            public JToolBar buildUtilityToolBar(boolean b) {
                JToolBar toolbar = new JToolBar();
                commonToolBarSetup(toolbar, false);
                //addToToolBar(toolbar, buildPrintButton());
                return toolbar;
            }
            
            @Override
            public JToolBar buildUtilityToolBar(boolean b,PropertiesManager p) {
                JToolBar toolbar = new JToolBar();
                commonToolBarSetup(toolbar, false);
                //addToToolBar(toolbar, buildPrintButton());
                return toolbar;
            }
            @Override
            public JToolBar buildZoomToolBar() {
                JToolBar toolbar = new JToolBar();
                commonToolBarSetup(toolbar, false);
                JButton zoomin = buildZoomInButton();
//                zoomin.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        System.out.println("CUSTOMER - do zoom IN at " + controller.getDocumentViewController().getZoom());
//                    }
//                });
                addToToolBar(toolbar, zoomin);
                JButton zoomout = buildZoomOutButton();
//                zoomout.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        System.out.println("CUSTOMER - do zoom OUT at " + controller.getDocumentViewController().getZoom());
//                    }
//                });
                addToToolBar(toolbar, zoomout);
                return toolbar;
            }            
        };

        JPanel viewerComponentPanel = factory.buildViewerPanel();
        controller.setUtilityPaneVisible(false);
        // add interactive mouse link annotation support via callback
        controller.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                        controller.getDocumentViewController()));
//        controller.getDocumentViewController().getViewPort().addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                JViewport jvp = (JViewport)e.getSource();
//                System.out.println("CUSTOMER - "+jvp.getViewPosition().getX() +" - "+ jvp.getViewPosition().getY());
//            }
//        });
        applicationFrame = new JFrame("ตัวอย่างเอกสารสั่งพิมพ์");
        //applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationFrame.getContentPane().add(viewerComponentPanel);

        // Now that the GUI is all in place, we can try openning a PDF
        controller.openDocument(filePath);
        // show the component
        //applicationFrame.pack();
        ImageIcon img = new ImageIcon("./Master/pdaricon.png");
        applicationFrame.setIconImage(img.getImage());
        ScreenUtil.showOnScreenWithMinResolution(ScreenUtil.getSecondaryScreen(),applicationFrame);
        applicationFrame.setAlwaysOnTop(true);
        applicationFrame.setResizable(false);
        applicationFrame.setVisible(true);
        return controller.getDocumentViewController();
    }
    
    public void setZoom(float zoomlevel){
        controller.getDocumentViewController().setZoom(zoomlevel);
    }
    
    public void doZoomIn(){
        controller.getDocumentViewController().setZoomIn();
    }
    
    public void doZoomOut(){
        controller.getDocumentViewController().setZoomOut();
    }
    
    public void setViewPosition(java.awt.Point p){
        controller.getDocumentViewController().getViewPort().setViewPosition(p);
    }
    
    public void close(){
        applicationFrame.dispose();
    }
    
    public void setDocumentViewType(int docmode,int fitmode,int pagenum){
        controller.getDocumentViewController().setCurrentPageIndex(pagenum);
        controller.getDocumentViewController().setDocumentViewType(docmode, fitmode);
    }
}
