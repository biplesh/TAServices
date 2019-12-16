package org.japit.comp.labour.dao;

public interface FetchKeyDAO {
	public int fecthActivationKey(String key);

	public int updateValidateKeyStatus(String key,int value);

	public String fetchNewActivationKey();

	public int updateValidateKeyStatus(String key, int value, String email);
}
