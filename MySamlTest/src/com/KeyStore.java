/**
 * 
 */
package com;

import java.io.FileInputStream;
import java.io.FileOutputStream;



/**
 * @author nchintha
 *
 */
public class KeyStore {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//pkcs12 keystore 
		KeyStore ks = KeyStore.getInstance("pkcs12");
		//jks keystore
		KeyStore ks2 = KeyStore.getInstance("jks");

		// load the pkcs12 file
		ks.load(new FileInputStream("C:\\insurance.p12"),"insurance123".toCharArray());
		// load the jks file (have to have an existing one)
		ks2.load(new FileInputStream("C:\\.temp"),"temp123".toCharArray());

		//read the p12 certificate
		java.security.cert.Certificate [] cc = ks.getCertificateChain("1");


		//gets the private key having as alias "1" and as password "insurance123"
		Key k = ks.getKey("1", "insurance123".toCharArray());

		// add to keystore and save
		ks2.setKeyEntry("insurance", k, "insurance123".toCharArray(),cc);
		FileOutputStream out = new FileOutputStream("C:\\newstore.keystore");
		ks2.store(out, "insurance123".toCharArray());
		out.close();


	}

}
