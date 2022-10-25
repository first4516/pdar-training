/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdardemotraining;

import com.songkhlaf.pdar.sslservices.SSLServiceTemplate;
import com.topaz.sigplus.SigPlus;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.swing.JRViewerToolbar;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Computer
 */
public class JasperCrimeandEvi {

    static org.apache.logging.log4j.Logger log = LogManager.getLogger(JasperCrimeandEvi.class.getName());

    public static void main(String[] args) throws Exception {
//        FunctionMain.userdata();
        // Oracle Database connexion
//      String url = "jdbc:oracle:thin:@192.168.57.141:1521:db12c";
//      String login = "dw";
//      String password = "1";
//      Connection connection = null;
        try {

//          Driver monDriver = new oracle.jdbc.driver.OracleDriver();
//          DriverManager.registerDriver(monDriver);
// 
//          connection = DriverManager.getConnection(url, login, password);
            JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\Computer\\JaspersoftWorkspace\\Jasper\\sample.jrxml");

            Map parameters = new HashMap();
            parameters.put("Parameter1", "333333");

            JRDataSource jds = new JREmptyDataSource();
            // Fill the Jasper Report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jds);

            // Creation of the HTML Jasper Reports
            JasperViewer.viewReport(jasperPrint);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "D:/TemplateJasper/MyJasperReport.pdf");
            System.out.println("Done with pdf.");
        } catch (JRException e) {
            e.printStackTrace();
        }

    }

    public static void ExportPrintEvidencDoc(String orgname, String bk, String bh, String no,
            String informDate, String informTime, String list, String dailyrecordbooknumyear,
            String dailyrecordpageno, String microtext, String dailynumber, Boolean draf, String ip, String machineid, String registername,
            String refer_id, String editdate) {
        ExportPrintEvidencMain(orgname, bk, bh, no,
                informDate, informTime, list, dailyrecordbooknumyear,
                dailyrecordpageno, microtext, dailynumber, draf, ip, machineid, registername,
                refer_id, editdate, true);
    }

    public static String ExportPrintEvidencPDF(String orgname, String bk, String bh, String no,
            String informDate, String informTime, String list, String dailyrecordbooknumyear,
            String dailyrecordpageno, String microtext, String dailynumber, Boolean draf, String ip, String machineid, String registername,
            String refer_id, String editdate) {
        return ExportPrintEvidencMain(orgname, bk, bh, no,
                informDate, informTime, list, dailyrecordbooknumyear,
                dailyrecordpageno, microtext, dailynumber, draf, ip, machineid, registername,
                refer_id, editdate, false);
    }

    public static String ExportPrintEvidencMain(String orgname, String bk, String bh, String no,
            String informDate, String informTime, String list, String dailyrecordbooknumyear,
            String dailyrecordpageno, String microtext, String dailynumber, Boolean draf, String ip, String machineid, String registername,
            String refer_id, String editdate, boolean isShowForm) {
//        public static void ExportPDF(String firstname,String lastname,String personId,String age,String texttest){
        String result = "";
        try {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy", new Locale("th", "TH"));
            Date timeReq = new Date();
            String printTime = timeFormat.format(timeReq);
            String printDate = dateFormat.format(timeReq);
            
            ArrayList<ItemSign> signreport = new ArrayList<>();
            signreport.add(new ItemSign(3, "ทดสอบ คำดีบุญ", "นาย", "ผู้เสียหาย/ผู้ร้องทุกข์", null, null, null, null, null, null));
            signreport.add(new ItemSign(2, "ทัศชัย ไวยลาภ  (ผู้ดูแลระบบสงขลา)", "นาย", "พนักงานสอบสวน", null, null, null, null, null, null));
            signreport.add(new ItemSign(1, "พรชัย สอนสำโรง (เจ้าหน้าที่สงขลา)", "นาย", "ผู้บันทึก", null, null, null, null, null, null));

            ArrayList<ItemSign> signreport2 = new ArrayList<>();
            signreport2.add(new ItemSign(3, "ทดสอบ คำดีบุญ", "นาย", "ผู้เสียหาย/ผู้ร้องทุกข์", null, null, null, null, null, null));
            signreport2.add(new ItemSign(2, "ทัศชัย ไวยลาภ  (ผู้ดูแลระบบสงขลา)", "นาย", "พนักงานสอบสวน", null, null, null, null, null, null));
            signreport2.add(new ItemSign(1, "พรชัย สอนสำโรง (เจ้าหน้าที่สงขลา)", "นาย", "ผู้บันทึก", null, null, null, null, null, null));

            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(signreport, false);

            JasperReport jasperReport = JasperCompileManager.compileReport("./Jasper/EVIDEANCEFORPDAR_.jrxml");
            JasperReport jasperReport2 = JasperCompileManager.compileReport("./Jasper/EVIDENCE_SIGNNAME.jrxml");
            JasperReport jasperReportSign = JasperCompileManager.compileReport("./Jasper/EVIDEANCEFORPDAR_P2_.jrxml");
            JasperReport subjasperReportSign = JasperCompileManager.compileReport("./Jasper/EVIDENCE_SIGNNAME2.jrxml");
            SigPlus sigObj = null;
//          Map parameters = new HashMap();
            HashMap<String, Object> parameters = new HashMap<String, Object>();
            HashMap<String, Object> parameters2 = new HashMap<String, Object>();

            parameters.put("policestationname", orgname);
            parameters.put("policestationprovince", bk);
            parameters.put("policestationregion", bh);
            parameters.put("No", no + "");
            parameters.put("dailydatestr", ToDate(informDate));
            parameters.put("dailytimestr", informTime);
            parameters.put("list", list);
            parameters.put("InvestigatorRank", "");
            parameters.put("RankPolice", "");
            parameters.put("dailyrecordbooknumyear", dailyrecordbooknumyear);
            parameters.put("dailyrecordpageno", dailyrecordpageno);
            parameters.put("microtext", microtext);
            parameters.put("dailynumber", dailynumber);
            parameters.put("SUBREPORT_DIR", jasperReport2);
            parameters.put("signreport", signreport2);
            parameters.put("REFER_ID", refer_id);
            parameters.put("EDITDAILYDATE", ToDate(FunctionMain.NewDateADtoBE(editdate)));
            parameters.put("EDITDAILYTIME", FunctionMain.NewDateTime(editdate));
            
            System.out.println("Date : " +ToDate(FunctionMain.NewDateADtoBE(editdate)));
            System.out.println("Time : " +FunctionMain.NewDateTime(editdate));

            Boolean IsWitness;
            Boolean IsInterpreter;
            File fl = new File("./Master/12.png");
            BufferedImage imagedd = ImageIO.read(fl);
            int watermark = list.length() % 7;
            System.out.println("watermark:" + watermark);
            File f2 = new File("");
            if (SSLServiceTemplate.trainstatus == 1) {
                f2 = new File("./Master/PoliceWaterMarkCode/background" + watermark + ".png");
            } else {
                f2 = new File("./Master/PoliceWaterMarkCode/backgroundTraining.png");
            }
            File f3 = new File("./Master/draf.png");

            parameters.put("logourl", imagedd);
            if (draf) {
                BufferedImage imagewater = ImageIO.read(f2);
                parameters.put("bgimage", imagewater);
                parameters.put("PRINTDATE", printDate);
                parameters.put("PRINTTIME", printTime);
                parameters.put("IP", ip);
                parameters.put("MACHINE_ID", machineid);
                parameters.put("REGISTER_NAME", registername);
                parameters.put("qrcode", "");

            } else {
                BufferedImage imagewater = ImageIO.read(f3);
                parameters.put("bgimage", imagewater);
                parameters.put("PRINTDATE", printDate);
                parameters.put("PRINTTIME", printTime);
                parameters.put("IP", "");
                parameters.put("MACHINE_ID", "");
                parameters.put("REGISTER_NAME", "");
            }

            //---------------------------------------parameter2---------------------------------------------------
            parameters2.put("SUBREPORT_DIR", subjasperReportSign);
            parameters2.put("signreport", signreport);
            parameters2.put("policestationname", orgname);
            parameters2.put("policestationprovince", bk);
            parameters2.put("policestationregion", bh);
            parameters2.put("No", no + "");
            parameters2.put("dailydatestr", ToDate(informDate));
            parameters2.put("dailytimestr", informTime);
            parameters2.put("dailyrecordbooknumyear", dailyrecordbooknumyear);
            parameters2.put("dailyrecordpageno", dailyrecordpageno);
            parameters2.put("MICROTEXT", microtext);
            parameters2.put("dailynumber", dailynumber);
            parameters2.put("REFER_ID", refer_id);
            parameters2.put("EDITDAILYDATE", ToDate(FunctionMain.NewDateADtoBE(editdate)));
            parameters2.put("EDITDAILYTIME", FunctionMain.NewDateTime(editdate));
            parameters2.put("logourl", imagedd);
            if (draf) {
                BufferedImage imagewater = ImageIO.read(f2);
                parameters2.put("bgimage", imagewater);
                parameters2.put("PRINTDATE", printDate);
                parameters2.put("PRINTTIME", printTime);
                parameters2.put("IP", ip);
                parameters2.put("MACHINE_ID", machineid);
                parameters2.put("REGISTER_NAME", registername);
                parameters2.put("qrcode", "");
            } else {
                BufferedImage imagewater = ImageIO.read(f3);
                parameters2.put("PRINTDATE", printDate);
                parameters2.put("PRINTTIME", printTime);
                parameters2.put("IP", "");
                parameters2.put("MACHINE_ID", "");
                parameters2.put("REGISTER_NAME", "");
                parameters2.put("bgimage", imagewater);
            }
            System.out.println("f2:" + f2);
            JRDataSource jds = new JREmptyDataSource();
            // Fill the Jasper Report
            System.out.println("signreport.size()" + signreport.size());
            if (signreport.size() > 4) {
                JasperPrint jp1 = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
                JasperPrint jp2 = JasperFillManager.fillReport(jasperReportSign, parameters2, jds);
                List pages = jp2.getPages();
                for (int j = 0; j < pages.size(); j++) {
                    JRPrintPage object = (JRPrintPage) pages.get(j);
                    jp1.addPage(object);
                }

                //byte[] outputfile =  JasperExportManager.exportReportToPdf(jp1);
                if (isShowForm) {
                    MyJasperViewer mjsview = new MyJasperViewer(jp1, false);
                    mjsview.setVisible(true);
                    result = "";
                } else {
                    byte[] outputfile = JasperExportManager.exportReportToPdf(jp1);
                    String savedir = System.getProperty("java.io.tmpdir");
                    File f = new File(savedir + "/pdar_temp.pdf");
                    FileOutputStream fo = new FileOutputStream(f);
                    fo.write(outputfile);
                    fo.flush();
                    fo.close();
                    result = f.getAbsolutePath();
                }
                //JasperViewer.viewReport(jp1,false);
            } else {
                System.out.println("One page");
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
                //JasperViewer.viewReport(jasperPrint,false);
                if (isShowForm) {
                    MyJasperViewer mjsview = new MyJasperViewer(jasperPrint, false);
                    mjsview.setVisible(true);
                    result = "";
                } else {
                    byte[] outputfile = JasperExportManager.exportReportToPdf(jasperPrint);
                    String savedir = System.getProperty("java.io.tmpdir");
                    File f = new File(savedir + "/pdar_temp.pdf");
                    FileOutputStream fo = new FileOutputStream(f);
                    fo.write(outputfile);
                    fo.flush();
                    fo.close();
                    result = f.getAbsolutePath();
                }
            }
            System.out.println("Done with show ThaiExp.");
        } catch (Exception e) {
            log.error("Exp Jasper Evi:" + e.getMessage());
            log.info("Exp Jasper Evi:" + e.getMessage());
            Logger.getLogger(JasperCrimeandEvi.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("" + e.getMessage());
//          e.printStackTrace();
        }
        return result;
    }

    private void adjustViewerLayoutAndLookAndShow(JasperViewer viewer) {
        Container contentPane = viewer.getContentPane();
        JRViewerToolbar toolbar = (JRViewerToolbar) ((JRViewer) ((JPanel) contentPane.getComponents()[0]).getComponent(0)).getComponent(0);

        JButton btnSave = (JButton) toolbar.getComponent(0);
        btnSave.setEnabled(false);

        JButton btnPrint = (JButton) toolbar.getComponent(1);
        btnPrint.setEnabled(false);

        viewer.setVisible(true);
    }

    private static String getThaiNumber(String amount) {
        if (amount == null || amount.isEmpty()) {
            return "";
        }
        String[] DIGIT_TH = {"๐", "๑", "๒", "๓", "๔", "๕", "๖", "๗", "๘", "๙"};
        StringBuilder sb = new StringBuilder();
        for (char c : amount.toCharArray()) {
            if (Character.isDigit(c)) {
                String index = DIGIT_TH[Character.getNumericValue(c)].toString();
                sb.append(index);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static String ToDate(String strDate) {
        String ResultDate = "";
        try {
            if (strDate == null || strDate.equals("") || strDate.equals("null")) {
                return "";
            } else {
                SimpleDateFormat df = new SimpleDateFormat("d/MM/yyyy", new Locale("th", "TH"));
                SimpleDateFormat dateto = new SimpleDateFormat("d MMM yyyy", new Locale("th", "TH"));
                Date date = null;

                date = df.parse(strDate);
                ResultDate = dateto.format(date.getTime());
            }
        } catch (ParseException ex) {
            Logger.getLogger(JasperCrimeandEvi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ResultDate;
    }

    public static String Checknull(String input) {
        if (input == null || input == "" || input == "null") {
            return "-";
        }
        return getThaiNumber(input);
    }

    private static class MyJasperViewer extends JasperViewer {

        public MyJasperViewer(JasperPrint jasperPrint, boolean isExitOnClose) {
            super(jasperPrint, isExitOnClose);

            try {
                ((JPanel) this.viewer.getComponent(0)).remove(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
