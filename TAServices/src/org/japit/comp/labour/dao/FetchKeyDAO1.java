package org.japit.comp.labour.dao;

public interface FetchKeyDAO1 {
	
	public int fecthActivationKey(String key);

	public int updateValidateKeyStatus(String key);

	public String fetchNewActivationKey();

}
