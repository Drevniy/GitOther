package db;

public class FactoryDAO {

	 private static DAO_MySQL_Hibernate daoHibernate = null;
	    
	    static {
	        try {
	        	daoHibernate = new DAO_MySQL_Hibernate();
	        } catch (Exception e) {
	              e.printStackTrace();
	        }
	    }

	    public static DAO_MySQL_Hibernate getDaoHibernate() {
	        return daoHibernate;
	    }
}
