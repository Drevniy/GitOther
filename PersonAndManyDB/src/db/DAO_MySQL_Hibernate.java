package db;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

public class DAO_MySQL_Hibernate {

	public static void add(Person person) {
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

	public static ArrayList<Person> read(Person person) {
		ArrayList<Person> personList = new ArrayList<Person>();
		
		if(person==null){
	          Session session = null;
	            try {
	                session = HibernateUtil.getSessionFactory().openSession();
	                List<Person> list = session.createCriteria(Person.class).list();
	                for (int i = 0; i < list.size(); i++) {
	                	personList.add(list.get(i));
					}
	                
	            } catch (Exception e) {
	                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
	            } finally {
	                if (session != null && session.isOpen()) {
	                    session.close();
	                }
	            }
		}else{
			
		}
		
		return  personList;
	}

	public static void update(Person person) {
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

	public static void delete(int id) {
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
