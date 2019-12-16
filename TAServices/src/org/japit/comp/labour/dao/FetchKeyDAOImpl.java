package org.japit.comp.labour.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techhub.common.spring.utility.UtilityFunction;

@Repository("fetchKeyDAO")
public class FetchKeyDAOImpl implements FetchKeyDAO{
	
	@Autowired  
	private SessionFactory sessionFactory;

	@Override
	public int fecthActivationKey(String key) {
		int result=0;	
		String status=null;
		try {
			String queryString = "SELECT id FROM ProductKeyModel WHERE key = :key "
							 + " AND used_st = :used_st ";
			Session session;
			try {
				session = sessionFactory.getCurrentSession();
			}
			catch(HibernateException e) {
			    session = sessionFactory.openSession();
			}
			Query query = session.createQuery(queryString);
			query.setParameter("key", key);
			query.setInteger("used_st", 2);			
			
			try {
				status= (String)query.uniqueResult().toString();
				System.out.println("status::::::::::::::::"+status);
				if(status != "")
					result = 1;
			} catch(NonUniqueResultException ne) {
				status="NA";
				result = -2;
		    }
			catch(NoResultException  nre) {
				status="NA";
				result = -1;
		    }
			catch (NullPointerException e) {
				status="NA";
				result = -3;
	        }
			
		}
		catch(Exception e){
			System.out.println("ERROR WHILE FETCHING PRODUCT KEY: \n");
			e.printStackTrace();
		}

		return result;
	
	}

	@Override
	public int updateValidateKeyStatus(String key,int value) {
		
		String status = null;
		Transaction tx=null;
		int result=0;
		try {
			 Session session;
				try {
					session = sessionFactory.getCurrentSession();
				}
				catch(HibernateException e) {
				    session = sessionFactory.openSession();
				}
			
             tx = session.beginTransaction();
		
          Query query = session.createQuery("UPDATE ProductKeyModel SET used_st = :used_st ,activation_date =:activation_date  WHERE key = :key AND used_st=2");
          query.setInteger("used_st", value);
          query.setParameter("key", key);
          query.setDate("activation_date",UtilityFunction.getCurrentDate());
          query.executeUpdate();
		  tx.commit();result=1;
		
	}catch(Exception e){
			e.printStackTrace();			
		}
		return result;
		

	}

	@Override
	public String fetchNewActivationKey() {

		
		String key=null;
		try {
			String queryString = "SELECT key FROM ProductKeyModel WHERE  used_st = :used_st ORDER BY id";
			Session session;
			try {
				session = sessionFactory.getCurrentSession();
			}
			catch(HibernateException e) {
			    session = sessionFactory.openSession();
			}
			Query query = session.createQuery(queryString);
			query.setInteger("used_st", 0);	
			query.setFirstResult(0);
			query.setMaxResults(1);
			if(query.list().size() > 0) {
				List list = query.list();
				key = list.get(0).toString();
			}
			
		}
		catch(Exception e){
			System.out.println("ERROR WHILE FETCHING PRODUCT KEY: \n");
			e.printStackTrace();
		}

		return key;	
	}

	@Override
	public int updateValidateKeyStatus(String key, int value, String email) {
		String status = null;
		Transaction tx=null;
		int result=0;
		try {
			 Session session;
				try {
					session = sessionFactory.getCurrentSession();
				}
				catch(HibernateException e) {
				    session = sessionFactory.openSession();
				}
			
             tx = session.beginTransaction();
		
          Query query = session.createQuery("UPDATE ProductKeyModel SET used_st = :used_st ,email =:email WHERE key = :key");
          query.setInteger("used_st", value);
          query.setParameter("key", key);
          query.setParameter("email", email);
          query.executeUpdate();
		  tx.commit();
		
	}catch(Exception e){
			e.printStackTrace();			
		}
		return result;
	}
	
	
}
