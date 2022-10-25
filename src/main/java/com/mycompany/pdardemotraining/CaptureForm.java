/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdardemotraining;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamException;
//import com.songkhlaf.pdar.util.ScreenUtil;

/**
 *
 * @author Computer
 */
public class CaptureForm extends javax.swing.JDialog {

    private static JLabel jlabelStatus;

    /**
     * Creates new form NewJFrame
     */
    Webcam webcam;
    Boolean running = false;
    boolean ONLINE;
    BufferedImage image = null;
    byte[] imageInByte;
    public static String photo_person = "";
    public static ImageIcon imageIcon;
    public static ArrayList<BufferedImage> imagesList = new ArrayList<>();
    public static ArrayList<BufferedImage> imagesPaperList = new ArrayList<>();

    public CaptureForm(JFrame parrent) {
        super(parrent, true);

        initComponents();
        ImageIcon img = new ImageIcon("./Master/pdaricon.png");
        setIconImage(img.getImage());
        setTitle("ระบบประจำวันอิเล็คทรอนิกส์สถานีตำรวจ");
        UIManager.put("OptionPane.messageFont", new Font("TH SarabunPSK", Font.PLAIN, 20));
        UIManager.put("OptionPane.buttonFont", new Font("TH SarabunPSK", Font.PLAIN, 18));

        List<Webcam> webcamlist = Webcam.getWebcams();
        String str[] = new String[webcamlist.size()];
        try {
            for (int i = 0; i < webcamlist.size(); i++) {
                str[i] = webcamlist.get(i).getName() + "";
                chooseWebcam.setModel(new DefaultComboBoxModel<>(str));
                System.out.println("Webcam:" + webcamlist.get(i).getName());
            }

        } catch (WebcamException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        webcam = Webcam.getWebcamByName(str[0]);
        webcam.setViewSize(new Dimension(320, 240));
        webcam.open();
        running = true;
        new videoTaker().start();

//        if (ScreenUtil.getNumberOfScreen() > 1) {
//            FunctionMain.WebcamPreviewShow(webcam);
//        }

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                webcam.close();
                FunctionMain.WebcamPreviewClose();

            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelPhoto = new javax.swing.JLabel();
        chooseWebcam = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnTakePhoto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelPhoto.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPhoto.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelPhoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );

        chooseWebcam.setFont(new java.awt.Font("TH SarabunPSK", 0, 18)); // NOI18N
        chooseWebcam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chooseWebcamItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 0, 18)); // NOI18N
        jLabel2.setText("เลือก");

        btnTakePhoto.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        btnTakePhoto.setText("กดถ่าย");
        btnTakePhoto.setFocusable(false);
        btnTakePhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTakePhotoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chooseWebcam, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 38, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(btnTakePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseWebcam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTakePhoto)
                .addGap(74, 74, 74))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   public static BufferedImage resize(BufferedImage image, int width, int height) {

        // reads input image
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        webcam.close();
    }//GEN-LAST:event_formWindowClosed

    private void chooseWebcamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chooseWebcamItemStateChanged
        if (evt.getStateChange() == 1) {
            webcam.close();
            webcam = Webcam.getWebcamByName(chooseWebcam.getSelectedItem() + "");
            webcam.setViewSize(new Dimension(320, 240));
            webcam.open();
            running = true;
            new videoTaker().start();
        }
    }//GEN-LAST:event_chooseWebcamItemStateChanged

    private void btnTakePhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTakePhotoMouseClicked
        System.out.println("runing:" + running);
        if (running) {
            try {
//                BufferedImage bi = webcam.getImage(); 
                Graphics2D graphics = image.createGraphics();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateTime = sdf.format(Calendar.getInstance().getTime()); // reading local time in the system                
                Font font = new Font("TH SarabunPSK", Font.BOLD, 18);
                graphics.setFont(font);
                graphics.drawString(dateTime, 170, 220);
                image.flush();
                jLabelPhoto.setIcon(new ImageIcon(image));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "camera:" + e.getMessage());
            }
            running = false;
        } else {
            running = true;
            new videoTaker().start();
        }
        try {
            System.out.println("image:" + image);
            if (image != null) {
                BufferedImage originalImage = image;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(originalImage, "jpg", baos);
                baos.flush();
                imageInByte = baos.toByteArray();
//        System.out.println("ima:"+imageInByte);
                photo_person = Base64.getEncoder().encodeToString(imageInByte);
//        System.out.println("encodedSigfile:"+photo_person);
                baos.close();
                imagesList.removeAll(imagesList);
                imagesList.add(resize(image, 320, 240));
                
            } else {
                JOptionPane.showMessageDialog(this, "กรุณาถ่ายรูปก่อนกดบันทึก");
            }
        } catch (Exception c) {
            JOptionPane.showMessageDialog(this, "camera true:" + c.getMessage());
        }
        webcam.close();
        setVisible(false);
        FunctionMain.WebcamPreviewClose();
    }//GEN-LAST:event_btnTakePhotoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CaptureForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaptureForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaptureForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaptureForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new CaptureFormTest().setVisible(true);
            }
        });
    }

    class videoTaker extends Thread {

        @Override
        public void run() {

            while (true && running) {
                try {
                    image = webcam.getImage();
                    jLabelPhoto.setIcon(new ImageIcon(image));
                    Thread.sleep(60);
                } catch (InterruptedException e) {
                    webcam.close();
                    running = false;
                    System.out.println("SAs" + e);
                }
            }

        }
    }

    public static void write_jpg_image(BufferedImage bad_image, String image_name) throws IOException {
        BufferedImage good_image = new BufferedImage(bad_image.getWidth(), bad_image.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D B2G = good_image.createGraphics();
        B2G.drawImage(bad_image, 0, 0, null);
        B2G.dispose();
        ImageIO.write(good_image, "jpg", new File(image_name));
    }

    public class StatusSecondfScreen implements Runnable {

        private JLabel status;

        public StatusSecondfScreen(JLabel input) {
            status = input;
        }

        @Override
        public void run() {

            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            if (ScreenUtil.getNumberOfScreen() > 1) {
//                ONLINE = true;
//                status.setText("เชื่อมต่อจอ2");
//                status.setIcon(new javax.swing.ImageIcon("./Master/online.png"));
//                status.setForeground(Color.GREEN);
//
//            } else {
//                ONLINE = false;
//                status.setIcon(new javax.swing.ImageIcon("./Master/offline.png"));
//                status.setText("ไม่ได้เชื่อมต่อ");
//                status.setForeground(Color.RED);
//            }
        }

    }

    public static JLabel getjLabelStatus() {
        return jlabelStatus;
    }

    public static void setjLabelStatus(JLabel jlabelStatus) {
        CaptureForm.jlabelStatus = jlabelStatus;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTakePhoto;
    private javax.swing.JComboBox<String> chooseWebcam;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabelPhoto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
