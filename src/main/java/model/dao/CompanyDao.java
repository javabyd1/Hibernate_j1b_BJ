package model.dao;

import model.Company;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utility.HibernateUtility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompanyDao {

    public List<Company> getCompanies() {

        Session session = HibernateUtility.getHibernateSession().getSessionFactory().openSession();
        List<Company> companies = new ArrayList<Company>();

        try {
            session.beginTransaction();
            companies = session.createQuery("FROM Company").list();
            for (Iterator<Company> iterator = companies.iterator(); iterator.hasNext();) {
                Company company = iterator.next();
                System.out.println(company.getName()+" "+company.getStreet()+" "+company.getHome_number()+"/"+company.getFlat_number()
                +" NIP: "+company.getNip());
            }
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return companies;
    }

    public Company addCompany(Company company) {

        Session session = HibernateUtility.getHibernateSession().getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(company);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return company;
    }

    public void updateCompany(int id, String name, String street, String home_number,  String nip) {

        Session session = HibernateUtility.getHibernateSession().getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Company company = session.get(Company.class, id);
            company.setName(name);
            company.setStreet(street);
            company.setHome_number(home_number);
            company.setNip(nip);
            session.update(company);
            session.getTransaction().commit();
        }
        catch (HibernateException e) {
            if (session.getTransaction()!=null) session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteCompany(int companyId) {

        Session session = HibernateUtility.getHibernateSession().getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Company company = session.get(Company.class, companyId);
            session.delete(company);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }
}
