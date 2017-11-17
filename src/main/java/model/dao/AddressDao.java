package model.dao;

import model.Address;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utility.HibernateUtility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddressDao {

    public List<Address> getAdresses() {

        Session session = HibernateUtility.getHibernateSession().getSessionFactory().openSession();
        List<Address> addresses = new ArrayList<Address>();

        try {
            session.beginTransaction();
            addresses = session.createQuery("FROM Address").list();
            for (Iterator<Address> iterator = addresses.iterator(); iterator.hasNext();) {
                Address address = iterator.next();
                System.out.println(address.getCountry()+" "+address.getCity()+" "+address.getStreet()+" "+address.getHomeNumber()
                        +"/"+address.getFlatNumber()+" "+address.getProvince());
            }
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        session.close();
        return addresses;
    }

    public Address addAdress(Address address) {

        Session session = HibernateUtility.getHibernateSession().getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        session.close();
        return address;
    }

    public void deleteAdress(int addressId) {

        Session session = HibernateUtility.getHibernateSession().getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Address address = session.get(Address.class, addressId);
            session.delete(address);
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
