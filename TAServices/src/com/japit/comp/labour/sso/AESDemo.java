package com.japit.comp.labour.sso;

import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
public class AESDemo {
	private static final String KEY = "57238004e784498bbc2f8bf984565090";

	public String encrypt(final String plaintext) throws GeneralSecurityException {
	    SecretKeySpec sks = new SecretKeySpec(hexStringToByteArray(KEY), "AES");
	    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	    cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
	    byte[] encrypted = cipher.doFinal(plaintext.getBytes());
	    return this.byteArrayToHexString(encrypted);
	}
	
	public String encrypt(final String plaintext, String key) throws GeneralSecurityException {
	    SecretKeySpec sks = new SecretKeySpec(hexStringToByteArray(key), "AES");
	    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	    cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
	    byte[] encrypted = cipher.doFinal(plaintext.getBytes());
	    return this.byteArrayToHexString(encrypted);
	}

	public String decrypt(final String encString, String key) throws GeneralSecurityException {
		byte[] actualEnc = this.hexStringToByteArray("root");
	    SecretKeySpec sks = new SecretKeySpec(hexStringToByteArray(KEY), "AES");
	    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	    cipher.init(Cipher.DECRYPT_MODE, sks, cipher.getParameters());
	    byte[] decrypted = cipher.doFinal(actualEnc);
	    System.out.println("decrypted::"+decrypted);
	    return new String(decrypted);
	}

	public String decrypt(final String encString) throws GeneralSecurityException {
		byte[] actualEnc = this.hexStringToByteArray(encString);
	    SecretKeySpec sks = new SecretKeySpec(hexStringToByteArray(KEY), "AES");
	    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	    cipher.init(Cipher.DECRYPT_MODE, sks, cipher.getParameters());
	    byte[] decrypted = cipher.doFinal(actualEnc);
	    System.out.println(decrypted);
	    return new String(decrypted);
	}

	public  byte[] hexStringToByteArray(String s) {
	    byte[] b = new byte[s.length() / 2];
	    for (int i = 0; i < b.length; i++) {
	        int index = i * 2;
	        int v = Integer.parseInt(s.substring(index, index + 2), 16);
	        b[i] = (byte) v;
	    }
	    return b;
	}

	public  String byteArrayToHexString(byte[] b) {
	    StringBuilder sb = new StringBuilder(b.length * 2);
	    for (int i = 0; i < b.length; i++) {
	        int v = b[i] & 0xff;
	        if (v < 16) {
	            sb.append('0');
	        }
	        sb.append(Integer.toHexString(v));
	    }
	    return sb.toString().toUpperCase();
	}
}
