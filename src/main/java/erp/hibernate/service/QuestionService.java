package erp.hibernate.service;

import erp.hibernate.entities.Question;
import erp.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class QuestionService {

    public static void saveOrUpdate(final Question question) {

        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(question);
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

    public static Question getQuestion(final long questionID) {

        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Question question = null;

        try {
            tx = session.beginTransaction();
            question = (Question) session.get(Question.class, questionID);

            tx.commit();
        } catch (HibernateException e) {
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return question;
    }

}