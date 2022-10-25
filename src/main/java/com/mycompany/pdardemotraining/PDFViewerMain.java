/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdardemotraining;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JViewport;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.util.PropertiesManager;

/**
 *
 * @author khunp
 */
public class PDFViewerMain {
    JFrame applicationFrame;
    public static void main(String[] args) {
        // Get a file from the command line to open
        String filePath = "D:/MISSINGDOC.pdf";
//        org.icepdf.ri.common.views.DocumentViewController vcMain = buildMainPage(filePath);
//        org.icepdf.ri.common.views.DocumentViewController vcMain2 = buildMainPage(filePath);
        // build a component controller
        
    }
    
    public org.icepdf.ri.common.views.DocumentViewController buildMainPage(String filePath,PDFViewerCustomer customerForm){
        SwingController controller = new SwingController();

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
                addToToolBar(toolbar, buildPrintButton());
                return toolbar;
            }
            
            @Override
            public JToolBar buildUtilityToolBar(boolean b,PropertiesManager p) {
                JToolBar toolbar = new JToolBar();
                commonToolBarSetup(toolbar, false);
                addToToolBar(toolbar, buildPrintButton());
                return toolbar;
            }
            @Override
            public JToolBar buildZoomToolBar() {
                JToolBar toolbar = new JToolBar();
                commonToolBarSetup(toolbar, false);
                JButton zoomin = buildZoomInButton();
                zoomin.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("do zoom IN at " + controller.getDocumentViewController().getZoom());
                        customerForm.doZoomIn();
                    }
                });
                addToToolBar(toolbar, zoomin);
                JButton zoomout = buildZoomOutButton();
                zoomout.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("do zoom OUT at " + controller.getDocumentViewController().getZoom());
                        customerForm.doZoomOut();
                    }
                });
                addToToolBar(toolbar, zoomout);
                return toolbar;
            }     
            
            @Override
            public JToggleButton buildPageViewFacingPageConToggleButton(){
                JToggleButton btn = super.buildPageViewFacingPageConToggleButton();
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        customerForm.setDocumentViewType(controller.getDocumentViewController().getViewMode(),
                                controller.getDocumentViewController().getFitMode(),controller.getDocumentViewController().getCurrentPageIndex());
                    }
                });
                return btn;
            }
            @Override
            public JToggleButton buildPageViewFacingPageNonConToggleButton(){
                JToggleButton btn = super.buildPageViewFacingPageNonConToggleButton();
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        customerForm.setDocumentViewType(controller.getDocumentViewController().getViewMode(),
                                controller.getDocumentViewController().getFitMode(),controller.getDocumentViewController().getCurrentPageIndex());
                    }
                });
                return btn;
            }
            @Override
            public JToggleButton buildPageViewSinglePageConToggleButton(){
                JToggleButton btn = super.buildPageViewSinglePageConToggleButton();
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        customerForm.setDocumentViewType(controller.getDocumentViewController().getViewMode(),
                                controller.getDocumentViewController().getFitMode(),controller.getDocumentViewController().getCurrentPageIndex());
                    }
                });
                return btn;
            }
            @Override
            public JToggleButton buildPageViewSinglePageNonConToggleButton(){
                JToggleButton btn = super.buildPageViewSinglePageNonConToggleButton();
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        customerForm.setDocumentViewType(controller.getDocumentViewController().getViewMode(), 
                                controller.getDocumentViewController().getFitMode(),controller.getDocumentViewController().getCurrentPageIndex());
                    }
                });
                return btn;
            }
        };
        

        JPanel viewerComponentPanel = factory.buildViewerPanel();

        // add interactive mouse link annotation support via callback
        controller.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                        controller.getDocumentViewController()));
        controller.getDocumentViewController().getViewPort().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JViewport jvp = (JViewport)e.getSource();
                System.out.println(jvp.getViewPosition().getX() +" - "+ jvp.getViewPosition().getY());
                customerForm.setViewPosition(jvp.getViewPosition());
                customerForm.setZoom(controller.getDocumentViewController().getZoom());
//                customerForm.setDocumentViewType(controller.getDocumentViewController().getViewMode(), 
//                                controller.getDocumentViewController().getFitMode(),controller.getDocumentViewController().getCurrentPageIndex());
            }
        });
        applicationFrame = new JFrame("หน้าจอแสดงผลข้อมูลให้ประชาชน");
        applicationFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.out.println("main close");
                applicationFrame.dispose();
                customerForm.close();
            }
        });
        
        //applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationFrame.getContentPane().add(viewerComponentPanel);

        // Now that the GUI is all in place, we can try openning a PDF
        controller.openDocument(filePath);
        // show the component
        //applicationFrame.pack();
        ImageIcon img = new ImageIcon("./Master/pdaricon.png");
        applicationFrame.setIconImage(img.getImage());
        ScreenUtil.showOnScreenWithMinResolution(ScreenUtil.getPrimaryScreen(),applicationFrame);
        applicationFrame.setAlwaysOnTop(true);
        applicationFrame.setResizable(false);
        applicationFrame.setVisible(true);
        return controller.getDocumentViewController();
    }
    
    public void close(){
        applicationFrame.dispose();
    }
}
