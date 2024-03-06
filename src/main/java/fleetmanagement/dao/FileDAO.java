package fleetmanagement.dao;

import fleetmanagement.dbutil.HibernateUtil;
import fleetmanagement.pojo.FilePojo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class FileDAO {


    public void uploadFile(FilePojo file) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(file);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public List<FilePojo> getAllFiles() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<FilePojo> query = session.createQuery("FROM FilePojo", FilePojo.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public FilePojo getFileById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(FilePojo.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
