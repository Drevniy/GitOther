package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry;
    
    static {
        try {
                //creates the session factory from hibernate.cfg.xml
        	Configuration configuration = new Configuration();
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();  
                sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
              e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
