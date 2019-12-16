package org.japit.comp.labour.service;


import org.japit.comp.labour.dao.FetchKeyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;




@Service("fetchKeyService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FetchKeyServiceImpl implements FetchKeyService {
	

	@Autowired
	private FetchKeyDAO fetchKeyDAO;

	@Override
	public int fecthActivationKey(String key) {
		return fetchKeyDAO.fecthActivationKey(key);
	}

	@Override
	public int updateValidateKeyStatus(String key,int value) {
		return fetchKeyDAO.updateValidateKeyStatus(key,value);
	}

	@Override
	public String fetchNewActivationKey() {
		return fetchKeyDAO.fetchNewActivationKey();
	}

	@Override
	public int updateValidateKeyStatus(String key, int value, String email) {
		return fetchKeyDAO.updateValidateKeyStatus(key,value,email);
	}
	
	

}
