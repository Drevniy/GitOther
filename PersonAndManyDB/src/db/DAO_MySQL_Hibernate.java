package db;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

public class DAO_MySQL_Hibernate implements DAO{

	public void add(Person person) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }		
	}

	public List<Person> read(Person person) {
		List<Person> list  = new ArrayList<>();
		
		if(person==null){
	          Session session = null;
	            try {
	                session = HibernateUtil.getSessionFactory().openSession();
	                session.beginTransaction();
	                list = session.createCriteria(Person.class).list();
	                session.getTransaction().commit();
	            } catch (Exception e) {
	                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O read", JOptionPane.OK_OPTION);
	            } finally {
	                //if (session != null && session.isOpen()) {
	                  //  session.close();
	               // }
	            }
		}else{
			
		}
		
		return  list;
	}

	public void update(Person person) {
		 Session session = null;
         try {
             session = HibernateUtil.getSessionFactory().openSession();
             session.beginTransaction();
             session.update(person);
             session.getTransaction().commit();
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
         } finally {
             if (session != null && session.isOpen()) {
                 session.close();
             }
         }		
	}

	public void delete(int id) {
		Person person = new Person();
		
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }		
	}

}
