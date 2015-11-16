/**
 * 
 */
package com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * @author nchintha
 *
 */
public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	
	{
		String everything=null;
		BufferedReader br = new BufferedReader(new FileReader("C:\\sso\\encrypt.txt"));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		     everything = sb.toString();
		} finally {
		    br.close();
		}
		
		byte[] decoded = Base64.decodeBase64(everything);
		 System.out.println(new String(decoded, "UTF-8") + "\n");

	}

}
