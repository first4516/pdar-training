/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdardemotraining;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Computer
 */
public class ItemSign {
    int    OrderSign;
    String fullname;
    String rank;
    String statussign;
    String signCode;
    ImageIcon signIcon;
    BufferedImage signimage;    
    String FMD;
    BufferedImage finger;    
    String SIGNTYPE;

    public ItemSign(int OrderSign,String fullname, String rank, String statussign, String signCode, ImageIcon signIcon, BufferedImage signimage, String FMD, BufferedImage finger, String SIGNTYPE) {
        this.fullname = fullname;
        this.rank = rank;
        this.statussign = statussign;
        this.signCode = signCode;
        this.signIcon = signIcon;
        this.signimage = signimage;
        this.FMD = FMD;
        this.finger = finger;
        this.SIGNTYPE = SIGNTYPE;
        this.OrderSign=OrderSign;
    }
//    public ItemSign(String fullname, String rank, String statussign, BufferedImage signimage, BufferedImage finger) {
//        this.fullname = fullname;
//        this.rank = rank;
//        this.statussign = statussign;
//        this.signimage = signimage;
//        this.finger = finger;
//    }

    public String getSIGNTYPE() {
        return SIGNTYPE;
    }


    public void setSIGNTYPE(String SIGNTYPE) {
        this.SIGNTYPE = SIGNTYPE;
    }

    public int getOrderSign() {
        return OrderSign;
    }

    public void setOrderSign(int OrderSign) {
        this.OrderSign = OrderSign;
    }
  
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getStatussign() {
        return statussign;
    }

    public void setStatussign(String statussign) {
        this.statussign = statussign;
    }

    public String getSignCode() {
        return signCode;
    }

    public void setSignCode(String signCode) {
        this.signCode = signCode;
    }

    public ImageIcon getSignIcon() {
        return signIcon;
    }

    public void setSignIcon(ImageIcon signIcon) {
        this.signIcon = signIcon;
    }

    public BufferedImage getSignimage() {
        return signimage;
    }

    public void setSignimage(BufferedImage signimage) {
        this.signimage = signimage;
    }

    public String getFMD() {
        return FMD;
    }

    public void setFMD(String FMD) {
        this.FMD = FMD;
    }

    public BufferedImage getFinger() {
        return finger;
    }

    public void setFinger(BufferedImage finger) {
        this.finger = finger;
    }

   

  


    
}
