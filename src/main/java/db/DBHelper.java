package db;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBHelper {

    private static Transaction transaction;
    private static Session session;

    public static void saveOrUpdate(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        }
        catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    public static void delete(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        }
        catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
    }

        public static <T> List<T> getList(Criteria criteria) {
            List<T> results = null;
            try {
                transaction = session.beginTransaction();
                results = criteria.list();
                transaction.commit();
            }
            catch (HibernateException e) {
                transaction.rollback();
                e.printStackTrace();
            }
            finally {
                session.close();
            }
            return results;
        }

        public static <T> T getUniqueResult(Criteria criteria){
            T result  = null;
            try{
                transaction = session.beginTransaction();
                result = (T)criteria.uniqueResult();
                transaction.commit();
            }
            catch (HibernateException e) {
                transaction.rollback();
                e.printStackTrace();
            }
            finally {
                session.close();
            }
            return result;
        }

    public static <T> T find(Class classtype, int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        Criteria criteria = session.createCriteria(classtype);
        criteria.add(Restrictions.idEq(id));
        result = getUniqueResult(criteria);
        return result;
    }

    public static <T> List<T> getAll(Class classtype){
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        Criteria cr = session.createCriteria(classtype);
        results = getList(cr);
        return results;
    }

    public static <T> void deleteAll(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(classType);
            List<T> results = cr.list();
            for (T result : results) {
                session.delete(result);
            }
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }


}
