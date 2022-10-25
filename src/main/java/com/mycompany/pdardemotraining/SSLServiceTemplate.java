package com.mycompany.pdardemotraining;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

public class SSLServiceTemplate {
 public static int trainstatus = 1;// 0 เครื่องเทรน 1 เครื่องจริง
    /**
     * Path to the clients keystore
     */
//    private final String CLIENT_KEYSTORE_PATH = "jks/pdar.jks";

    /**
     * Password for the clients keystore
     */
//    private final String CLIENT_KEYSTORE_PASSWORD = "P@$$w0rd";

    /**
     * The servers certificate's alias within the clients keystore.
     */
//    private final String SERVER_CERTIFICATE_ALIAS = "pdar_cert";

    /**
     * URL to our SOAP UI service
     */
 // เครื่องจริง
    public static String SERVERIP="pdarapps.crimespolice.com";
    public static String SERVERPORT="443";
    protected final String SOAP_URI = "https://pdarapps.crimespolice.com/";
    
    //IP เครื่องเทรน
//     protected final String SOAP_URI = "https://pdarappstest.crimespolice.com/";
//     public static String SERVERIP="pdarappstest.crimespolice.com";
//     public static String SERVERPORT="443";
    
    
    
 //ไม่ได้ใช้   
    
// protected final String SOAP_URI = "http://172.17.4.178:8080/";

    //private static final String URN = "urn:examples:helloservice";
//    private KeyStore loadKeystore(String filePath, char[] password)
//            throws NoSuchAlgorithmException, CertificateException, IOException,
//            KeyStoreException {
//
//        FileInputStream is = new FileInputStream(new File(filePath));
//
//        final KeyStore keystore = KeyStore.getInstance(KeyStore
//                .getDefaultType());
//
//        keystore.load(is, password);
//
//        return keystore;
//    }

    public SSLServiceTemplate() throws NoSuchAlgorithmException, CertificateException,
            KeyStoreException, IOException, KeyManagementException,
            UnrecoverableKeyException, SOAPException {

        /*
             * Load the keystore
         */
//        char[] password = CLIENT_KEYSTORE_PASSWORD.toCharArray();
//        KeyStore keystore = loadKeystore(CLIENT_KEYSTORE_PATH, password);

        /*
             * Get the servers trusted certificate.
         */
//        final Certificate trusted = keystore
//                .getCertificate(SERVER_CERTIFICATE_ALIAS);

        /*
             * Create a trust manager that validates the servers certificate
         */
        TrustManager[] trustManager = new TrustManager[]{new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs,
                    String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs,
                    String authType) throws CertificateException {

//                if (certs == null || certs.length == 0) {
//                    throw new IllegalArgumentException(
//                            "null or zero-length certificate chain");
//                }
//
//                if (authType == null || authType.length() == 0) {
//                    throw new IllegalArgumentException(
//                            "null or zero-length authentication type");
//                }
//
//                // check if certificate sent is your CA's
//                if (!certs[0].equals(trusted)) {
//
//                    // check if its been signed by the CA
//                    try {
//                        certs[0].verify(trusted.getPublicKey());
//                    } catch (InvalidKeyException | NoSuchAlgorithmException
//                            | NoSuchProviderException | SignatureException e) {
//                        throw new CertificateException(e);
//                    }
//                }
//
//                certs[0].checkValidity();
            }
        }};

//        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory
//                .getDefaultAlgorithm());
//
//        kmf.init(keystore, password);

        // set the trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustManager,
                new java.security.SecureRandom());

        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());


        // create an all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

        // setup an example soap message
    }

    protected String createSoapResponse(SOAPMessage soapResponse) throws Exception {
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        System.out.println("\n----------SOAP Response-----------");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        StreamResult result = new StreamResult(bos);
        transformer.transform(sourceContent, result);
        System.out.println("\n bos :" + bos.toString("UTF-8"));
        return bos.toString("UTF-8");
    }

    protected String getElementByTagName(String XMLData, String TAGNAME) {
        String TAGSTART = "<" + TAGNAME + ">";
        String TAGEND = "</" + TAGNAME + ">";
        int startindex = XMLData.indexOf(TAGSTART);
        int endindex = XMLData.indexOf(TAGEND);

        if (startindex > 0 && endindex > 0) {
            return XMLData.substring(startindex + TAGSTART.length(), endindex);
        } else {
            return XMLData;
        }
    }
}
