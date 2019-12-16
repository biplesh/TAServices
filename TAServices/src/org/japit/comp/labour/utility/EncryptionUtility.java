package org.japit.comp.labour.utility;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.japit.comp.labour.sso.AESDemo;

public class EncryptionUtility extends DriverManagerDataSource {
	
	 AESDemo aesDemo =null;
	public String getPassword() {
		try {
			String password = super.getPassword();
			return new AESDemo().decrypt(password);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
}
