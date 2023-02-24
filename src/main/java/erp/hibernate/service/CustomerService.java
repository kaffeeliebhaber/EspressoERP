package erp.hibernate.service;

import erp.hibernate.HibernateUtil;
import erp.hibernate.entities.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerService {

    public void saveOrUpdate(final Customer customer) {

        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(customer);
            tx.commit();
        } catch (HibernateException e) {
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Customer getCustomer(final long customerID) {

        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Customer customer = null;

        try {
            tx = session.beginTransaction();
            //customer = (Customer) session.load(Customer.class, customerID);
            customer = (Customer) session.get(Customer.class, customerID);

            tx.commit();
        } catch (HibernateException e) {
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return customer;
    }

}
