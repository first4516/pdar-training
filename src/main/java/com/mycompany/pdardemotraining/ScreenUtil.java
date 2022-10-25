/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdardemotraining;

import java.awt.Color;
import java.awt.Container;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.JFrame;
//import com.topaz.sigplus.SigPlus;

/**
 *
 * @author khunp
 */
public class ScreenUtil {

    public static void main(String args[]) {
//        try {
//            createSignImageFile("D:/test01.png", "3132340D0A310D0A393832203137300D0A393731203137320D0A393535203137340D0A393335203137370D0A393131203138310D0A383934203138320D0A383831203138330D0A383731203138330D0A383635203138320D0A383632203138300D0A383539203137340D0A383535203136380D0A383531203135380D0A383438203134380D0A383436203133370D0A383435203132340D0A383436203131320D0A383438203130300D0A3835312039310D0A3835362038320D0A3836342037350D0A3837312036390D0A3838302036330D0A3838392036300D0A3839372035390D0A3930362035390D0A3931352036310D0A3932382036350D0A3934312037330D0A3935362038320D0A3936392039330D0A393738203130340D0A393836203131340D0A393931203132360D0A393936203134300D0A31303030203135380D0A31303032203138300D0A31303031203230320D0A393936203232360D0A393931203234350D0A393830203236350D0A393639203238330D0A393534203330310D0A393334203332300D0A393136203333350D0A383935203335300D0A383736203336320D0A383630203337320D0A383434203338300D0A383332203338370D0A383231203339320D0A383131203339360D0A383033203430310D0A373937203430340D0A373933203430370D0A373931203431310D0A373838203431360D0A373837203432300D0A373836203432370D0A373835203433360D0A373837203434380D0A373930203435390D0A373934203436390D0A383031203437390D0A383037203438350D0A383134203439300D0A383230203439350D0A383237203439370D0A383337203439380D0A383535203439390D0A383738203439380D0A393131203439340D0A393438203438380D0A393930203437360D0A31303331203436340D0A31303637203434390D0A31313035203433300D0A31313339203431300D0A31313738203338380D0A31323137203336330D0A31323530203334340D0A31323735203332390D0A31323934203332300D0A31333035203331370D0A31333131203331380D0A31333137203332320D0A31333233203333300D0A31333330203334330D0A31333430203336300D0A31333532203338300D0A31333632203430300D0A31333735203432320D0A31333933203434350D0A31343131203436360D0A31343239203438340D0A31343432203439340D0A31343438203439370D0A31343536203439330D0A31343634203438370D0A31343735203437360D0A31343933203435380D0A31353138203433330D0A31353531203339380D0A31353933203335370D0A31363335203331360D0A31363732203238320D0A31373031203235360D0A31373139203234310D0A31373330203233360D0A31373335203233360D0A31373339203234330D0A31373434203235330D0A31373437203236370D0A31373530203238360D0A31373534203330360D0A31373537203332350D0A31373631203334330D0A31373635203335360D0A31373638203336350D0A31373731203337330D0A31373732203337360D0A31373732203337370D0A31373732203337380D0A31373732203337370D0A300D0A00000000000000000000000000000000000000000000000000000000000000000000");
//        } catch (ClassNotFoundException | IOException ex) {
//            Logger.getLogger(ScreenUtil.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public static boolean isDuplicateScreen() {
        //GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        return true;
    }

    public static int getNumberOfScreen() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gd = ge.getScreenDevices();
        //System.out.println(ge.getDefaultScreenDevice().getIDstring());
        return gd.length;
    }

    public static int getPrimaryScreen() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gd = ge.getScreenDevices();
        int result = -1;
        for (int i = 0; i < gd.length; i++) {
            if (gd[i].getIDstring().equals(ge.getDefaultScreenDevice().getIDstring())) {
                return i;
            }
        }
        return result;
    }

    public static int getSecondaryScreen() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gd = ge.getScreenDevices();
        int i = 0;
        for (GraphicsDevice gditem : gd) {
            if (!gditem.getIDstring().equals(ge.getDefaultScreenDevice().getIDstring())) {//not first screen
                return i;
            }
            i++;
        }
        return gd.length - 1;
    }

    public static void showOnScreen(int screen, JFrame frame, String typeScreen, int inputWidth, int inputHeight) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gd = ge.getScreenDevices();

        System.out.println("found " + gd.length + " screen");
        if (screen > -1 && screen < gd.length) {
            int x = gd[screen].getDefaultConfiguration().getBounds().x;
            int y = gd[screen].getDefaultConfiguration().getBounds().y;
            int width = gd[screen].getDefaultConfiguration().getBounds().width;
            int height = gd[screen].getDefaultConfiguration().getBounds().height;
            System.out.println("showon screen " + screen + " at " + x + "," + 0 + " w " + gd[screen].getDisplayMode().getWidth() + " h " + gd[screen].getDisplayMode().getHeight());
            System.out.println("X : " + x + " Y : " + y + " Width : " + width + " Height : " + height);

            if (typeScreen.equals("custom")) {
                frame.setSize(width, height);
                Container c = frame.getContentPane();
                c.setBackground(Color.lightGray);
            } else if (typeScreen.equals("default")) {
                frame.setSize(width, height);
            }

            frame.setLocation(
                    ((width / 2) - (frame.getSize().width / 2)) + x,
                    ((height / 2) - (frame.getSize().height / 2)) + y
            );

            System.out.println("Frame : " + frame.getSize().toString());
            System.out.println("Location : " + frame.getLocation().toString());

        } else if (gd.length > 0) {
            int x = gd[0].getDefaultConfiguration().getBounds().x;
            System.out.println("showon " + 0 + " at " + x + "," + 0 + " w " + gd[0].getDisplayMode().getWidth() + " h " + gd[0].getDisplayMode().getHeight());
            frame.setBounds(x, 0, gd[0].getDisplayMode().getWidth(), gd[0].getDisplayMode().getWidth());
        } else {
            throw new RuntimeException("No Screens Found");
        }
    }

    public static void showOnScreenWithMinResolution(int screen, JFrame frame) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gd = ge.getScreenDevices();
        Rectangle r = getMinResolution();
        System.out.println("found " + gd.length + " screen");
        if (screen > -1 && screen < gd.length) {
            int x = gd[screen].getDefaultConfiguration().getBounds().x;
            System.out.println("showon " + screen + " at " + x + "," + 0 + " w " + r.width + " h " + r.height);
            frame.setBounds(x, 0, r.width, r.height);
        } else if (gd.length > 0) {
            int x = gd[0].getDefaultConfiguration().getBounds().x;
            System.out.println("showon " + 0 + " at " + x + "," + 0 + " w " + r.width + " h " + r.height);
            frame.setBounds(x, 0, r.width, r.height);
        } else {
            throw new RuntimeException("No Screens Found");
        }
    }

    public static Rectangle getMinResolution() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gd = ge.getScreenDevices();
        int width = -1;
        int height = -1;
        for (GraphicsDevice gditem : gd) {
            if (width == -1) {
                width = gditem.getDisplayMode().getWidth();
            } else if (width > gditem.getDisplayMode().getWidth()) {
                width = gditem.getDisplayMode().getWidth();
            }

            if (height == -1) {
                height = gditem.getDisplayMode().getHeight();
            } else if (height > gditem.getDisplayMode().getHeight()) {
                height = gditem.getDisplayMode().getHeight();
            }
        }
        return new Rectangle(width, height);
    }
}
