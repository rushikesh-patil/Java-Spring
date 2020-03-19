package com.infotool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotool.model.Defect;

@Repository
public class DefectManagementDaoImpl {

	@Transactional
	public void saveDefect(Defect defect) {
		// TODO Auto-generated method stub
		
		System.out.println("Creating car records...");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();   
        
        session.beginTransaction();
        session.saveOrUpdate(defect);
        session.getTransaction().commit();
        session.close();
    	
	}

	@SuppressWarnings("unchecked")
	public List<Defect> getDefectList() {
		// TODO Auto-generated method stub
		
		System.out.println("getting records...");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
             
        session.beginTransaction();
        List<Defect> defects = session.createQuery("FROM Defect").list(); 
        session.getTransaction().commit();
        session.close();
		return defects;
	}

	public boolean deleteDefect(String id) {
		// TODO Auto-generated method stub
		System.out.println("deleting records...");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Defect where id=" + id).executeUpdate(); 
        session.getTransaction().commit();
        session.close();
		return true;
	}
	
}
