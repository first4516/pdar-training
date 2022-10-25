/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdardemotraining;

import com.github.sarxos.webcam.Webcam;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author user
 */
public class FunctionMain {
    boolean ONLINE;
    public static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    public static ImageIcon photo_person = null;
    public static CameraPreview cameraPreview = null;
    public static PhotoPreview photoPreview = null;
    public static PDFViewerCustomer customer = null;
    public static PDFViewerMain main = null;
    
    public void setDisplayConnect(JLabel jLabelStatus) {
        jLabelStatus.setIcon(new javax.swing.ImageIcon("./Master/desktop_access.png"));
        scheduler.scheduleAtFixedRate(new StatusSecondfScreen(jLabelStatus), 1, 1, TimeUnit.SECONDS);
    }
    
    public static void WebcamPreviewShow(Webcam webcam) {
        System.out.println("Pass Data");
        cameraPreview = new CameraPreview(webcam);
        cameraPreview.setVisible(true);
    }
    
    public static void WebcamPreviewClose() {
        if (cameraPreview != null) {
            cameraPreview.setVisible(false);
            cameraPreview.dispose();
            cameraPreview = null;
        }
    }
    
    public static void PersonImagePreviewShow() {
        photoPreview = new PhotoPreview();
        photoPreview.setVisible(true);

    }

    public static void PersonImagePreviewClose() {
        if (photoPreview != null) {
            photoPreview.setVisible(false);
            photoPreview.dispose();
            photoPreview = null;
        }
    }
    
    public static void CustomerPDFViewer(String filePath) {
        customer = new PDFViewerCustomer();
        customer.buildMainPage(filePath);
        main = new PDFViewerMain();
        main.buildMainPage(filePath, customer);
    }

    public static void CustomerPDFViewerClose() {
        customer.close();
        main.close();
    }
    
    public static void setPersonImage(Image image, JComponent input) {
        if (photoPreview != null) {
            photoPreview.setPreviewImage(image, input);
        }
    }
    
    public class StatusSecondfScreen implements Runnable {

        public JLabel status;
        public JLabel jlabelStatus;

        public StatusSecondfScreen(JLabel input) {
            status = input;
        }

        @Override
        public void run() {

            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            if (ScreenUtil.getNumberOfScreen() > 1) {
                ONLINE = true;
                status.setText("เชื่อมต่อจอ2");
                status.setIcon(new javax.swing.ImageIcon("./Master/desktop_access.png"));
                status.setFont(new Font("TH SarabunPSK", Font.PLAIN, 20));
                status.setForeground(new Color(0,128,0));

            } else {
                ONLINE = false;
                status.setIcon(new javax.swing.ImageIcon("./Master/desktop_no_access.png"));
                status.setText("ไม่ได้เชื่อมต่อ");
                status.setFont(new Font("TH SarabunPSK", Font.PLAIN, 20));
                status.setForeground(Color.RED);
            }
        }
    }
    
    public static String DateBCyyyyMMdd(String dateC) {
        String yyyyMMdd = "";
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
            if (dateC.equals("")) {
                return yyyyMMdd;
            } else {
                Date date = inputFormat.parse(dateC);

                String formattedDate = outputFormat.format(date);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                Date datecard = outputFormat.parse(formattedDate);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(datecard);
                calendar.add(Calendar.YEAR, -543);
                System.out.println("yyyyMMdd" + calendar.getTime());
                Date newBd = calendar.getTime();
                yyyyMMdd = sdf.format(newBd);
                System.out.println("yyyyMMdd:" + yyyyMMdd);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return yyyyMMdd;
    }
    
    public static String NewDateADtoBE(String dateold) {
        try {
            Locale lc = new Locale("th", "TH");

            //DateTimeFormatter  inputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("d/MM/yyyy", new Locale("th", "TH"));
            SimpleDateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy", new Locale("th", "TH"));
            //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));

            if (dateold.equals("")) {
                String a = "";
                return a;

            } else {
                LocalDateTime dateTime = LocalDateTime.parse(dateold, inputFormat);
                dateTime = dateTime.plusYears(543);

                String dateThai = dateTime.format(outputFormat);
                return dateThai;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public static String NewDateTime(String dateold) {
        try {
            Locale lc = new Locale("th", "TH");
            DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("HH:mm", new Locale("th", "TH"));

            if (dateold.equals("")) {
                String a = " ";
                return a;

            } else {
                LocalDateTime dateTime = LocalDateTime.parse(dateold, inputFormat);
//             dateTime = dateTime.plusYears(543);

                String dateThai = dateTime.format(outputFormat);
                return dateThai;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
