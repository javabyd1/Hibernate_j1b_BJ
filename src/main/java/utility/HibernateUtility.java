package utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

    private final static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    private static Session session = sessionFactory.openSession();

    private HibernateUtility() {
    }

    public static Session getHibernateSession() {
        if (session == null) {
            session = (Session) new HibernateUtility();
        }
        return session;
    }
}
