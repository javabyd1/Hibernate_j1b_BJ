package model.dao;

import model.Standing;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utility.HibernateUtility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StandingDao {

    public List<Standing> getStandings() {
        List<Standing> standings = new ArrayList<Standing>();

        Session session = HibernateUtility.getHibernateSession().getSessionFactory().openSession();

        try {
            session.beginTransaction();
            standings = session.createQuery("FROM Standing").list();
            for (Iterator<Standing> iterator = standings.iterator(); iterator.hasNext();) {
                Standing standing = iterator.next();
                System.out.println("Stanowisko: " + standing.getName());
            }
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        session.close();
        return standings;
    }

    public Standing addStanding(Standing standing) {

        Session session = HibernateUtility.getHibernateSession().getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.save(standing);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        session.close();
        return standing;
    }

    public void deleteStanding(int standingId) {

        Session session = HibernateUtility.getHibernateSession().getSessionFactory().openSession();

        try {
            session.beginTransaction();
            Standing standing = session.get(Standing.class, standingId);
            session.delete(standing);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        session.close();
    }
}
