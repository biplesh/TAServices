package org.japit.comp.labour.service;

public interface FetchKeyService {
	
	int fecthActivationKey(String key);
	int updateValidateKeyStatus(String key,int value);
	int updateValidateKeyStatus(String key,int value,String email);
	String fetchNewActivationKey();
	
	

}
