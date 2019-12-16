package com.techhub.common.spring.utility;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import sun.misc.BASE64Decoder;


public class WebServiceUtility {
	 public static ResourceBundle bundle = getResourceBundle();	
	
	public static boolean isUserAuthenticated(String authString) {
		boolean st = false;
		String authContent = "", server = "", decodedAuth = "";
		try {
			// Header is in the format "Basic 5tyc0uiDat4"
			// We need to extract data before decoding it back to original
			// string
			String[] authParts = authString.split("\\s+");
			String authInfo = authParts[1];
			// String encoding = new
			// sun.misc.BASE64Encoder().encode(authString.getBytes());
			// Decode the data back to original string
			byte[] bytes = null;
			try {
				bytes = new BASE64Decoder().decodeBuffer(authInfo);
			} catch (IOException e) {
				e.printStackTrace();
			}
			decodedAuth = new String(bytes);
			System.out.println(decodedAuth);

			/**
			 * here you include your logic to validate user authentication. it
			 * can be using ldap, or token exchange mechanism or your custom
			 * authentication mechanism.
			 */
			if (bundle != null) {
				server = bundle.getString("server");
				authContent = bundle.getString(server + "authenticate.userpass");
				if (decodedAuth.equals(authContent)) {
					st = true;
				}
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}

		return st;
	}

	
	public static int fetchCurrentVersion() {
		String  server = "";
		String version="";
		try {		
			
			if (bundle != null) {
				server = bundle.getString("server");
				version = bundle.getString(server + "version");
				System.out.println("version:: "+version);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Integer.parseInt(version);
	}
	
	
	private static ResourceBundle getResourceBundle() {
		ResourceBundle bundle = ResourceBundle.getBundle("projectinfo");		
		return bundle;
	}
}