package com.lyt.webtemp.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * 
 * 使用hibernate连接数据库
 * @author lyt
 *
 */

public class HibernateUtil {

	private static final Configuration CONFIGURATION;

	private static final SessionFactory SESSION_FACTORY;

	static {

		CONFIGURATION = new Configuration().configure();

		SESSION_FACTORY = CONFIGURATION.buildSessionFactory();
	}

	public static Session openSession() {

		return SESSION_FACTORY.openSession();

	}

	// 查询（获得单个对象）
	public static Object get(Class<?> clazz, Integer id) {
		Session session = null;
		
		try {
			session = HibernateUtil.openSession();
			Object obj = session.get(clazz, id);
			return obj;
		}catch(Exception e){
			
			return null;
			
		}finally {
			if (session != null)
				session.close();
		}
	}
	
	//查询多条
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> sqlQuery(String sql){
		
		List<T> list = new ArrayList<T>();
		
		Session session = null;
		try {
			
			session = HibernateUtil.openSession();
			
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			
			list = sqlQuery.list();
			
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}finally{
			session.close();
		}
		
		
	}

	// 添加

	public static boolean addObject(Object enity) {
		Session session = null;

		Transaction transaction = null;

		try {
			session = HibernateUtil.openSession();

			transaction = session.beginTransaction();

			session.save(enity);

			transaction.commit();

			return true;

		} catch (Exception e) {
			// TODO: handle exception
			
			transaction.rollback();
			return false;
		} finally {

			session.close();
		}
	}

	// 修改1完全修改
	public static boolean updateObject(Object enity) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.openSession();

			transaction = session.beginTransaction();

			session.update(enity);

			transaction.commit();

			return true;

		} catch (Exception e) {
			// TODO: handle exception

			transaction.rollback();
			return false;
		} finally {

			session.close();
		}

	}

	/**
	 * 删除对象
	 * @param enity
	 * @return
	 */
	public static boolean deleteObject(Object enity) {

		Session session = null;

		Transaction transaction = null;

		try {
			session = HibernateUtil.openSession();

			transaction = session.beginTransaction();

			session.delete(enity);

			transaction.commit();

			return true;

		} catch (Exception e) {
			// TODO: handle exception

			transaction.rollback();
			return false;
		} finally {

			session.close();
		}
	}

}
