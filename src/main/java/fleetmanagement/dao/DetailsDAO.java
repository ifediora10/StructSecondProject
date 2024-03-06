package fleetmanagement.dao;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import fleetmanagement.dbutil.HibernateUtil;
import fleetmanagement.pojo.DetailsPojo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DetailsDAO {

    // Example log statement in a DAO class
    private static final Logger log = LoggerFactory.getLogger(DetailsDAO.class);

    public void saveDetails(DetailsPojo details) {

        try {
            log.info("Opening session...");
            Session session = HibernateUtil.getSessionFactory().openSession();
            log.info("Session opened successfully.");

            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                // Perform database operations
                session.save(details);

                transaction.commit();
            } catch (Exception e) {
                log.error("Error during transaction.", e);
                if (transaction != null) {
                    transaction.rollback();
                }
            } finally {
                log.info("Closing session...");
                session.close();
                log.info("Session closed.");
            }
        } catch (Exception e) {
            log.error("Error opening session.", e);
        }

    }

    public static List<DetailsPojo> getAllDetails(Session session) {
        List<DetailsPojo> detailsList = null;

        try
        {

            String hql = "FROM DetailsPojo ";
            Query<DetailsPojo> query = session.createQuery(hql, DetailsPojo.class);

            detailsList = query.list();

            //  } catch (Exception e) {
        } catch (HibernateException e) {
            log.error("Error fetching details from database ", e);
        }

        return detailsList;
    }

    public static List<DetailsPojo> searchDetails(Long id, String office, String owner, String clientType, Session sessioner) {
        List<DetailsPojo> searchResults = null;

        try {
            StringBuilder hqlBuilder = new StringBuilder("FROM DetailsPojo WHERE 1 = 1");

            if (id != null) {
                hqlBuilder.append(" AND id = :id");
            }

            if (office != null && !office.isEmpty()) {
                hqlBuilder.append(" AND office = :office");
            }

            if (owner != null && !owner.isEmpty()) {
                hqlBuilder.append(" AND client = :client");
            }

            if (clientType != null && !clientType.isEmpty()) {
                hqlBuilder.append(" AND vehicle = :vehicle");
            }

            String hql = hqlBuilder.toString();

            Query<DetailsPojo> query = sessioner.createQuery(hql, DetailsPojo.class);

            if (id != null) {
                query.setParameter("id", id);
            }

            if (office != null && !office.isEmpty()) {
                query.setParameter("office", office);
            }

            if (clientType != null && !clientType.isEmpty()) {
                query.setParameter("client", clientType);
            }

            if (owner != null && !owner.isEmpty()) {
                query.setParameter("vehicle", owner);
            }

            searchResults = query.list();
        } catch (HibernateException e) {
            log.error("Error performing search in the database", e);
        }

        return searchResults;
    }

    public static int updateDetails(DetailsPojo updatedDetails) {
        int stat = 0;
        try {
            log.info("Opening session for update...");
            Session session = HibernateUtil.getSessionFactory().openSession();
            log.info("Update Session opened successfully.");

            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                // database operations
                DetailsPojo existingDetails = session.load(DetailsPojo.class, updatedDetails.getId());

                existingDetails.setOffice(updatedDetails.getOffice());
                existingDetails.setOwner(updatedDetails.getOwner());
                existingDetails.setClientType(updatedDetails.getClientType());
                existingDetails.setDate(updatedDetails.getDate());
                existingDetails.setName(updatedDetails.getName());
                existingDetails.setNewContactName(updatedDetails.getNewContactName());
                existingDetails.setExistingContact(updatedDetails.getExistingContact());
                existingDetails.setEmail(updatedDetails.getEmail());
                existingDetails.setPhone(updatedDetails.getPhone());
                existingDetails.setRemark(updatedDetails.getRemark());
                existingDetails.setComments(updatedDetails.getComments());

                session.update(existingDetails);

                transaction.commit();
            } catch (Exception e) {
                log.error("Error during transaction Update.", e);
                if (transaction != null) {
                    transaction.rollback();
                }
            } finally {
                log.info("Closing session...");
                session.close();
                log.info("Session closed.");
            }
        } catch (Exception e) {
            log.error("Error opening session.", e);
        }

        return stat;
    }

    public static DetailsPojo getDetailsById(Long id) {
        DetailsPojo detailsPojo = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Using HQL (Hibernate Query Language) to retrieve the product by id
            String hql = "FROM DetailsPojo WHERE id = :id";
            Query<DetailsPojo> query = session.createQuery(hql, DetailsPojo.class);
            query.setParameter("id", id);
            detailsPojo = query.uniqueResult();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching product by ID", e);
        }
        return detailsPojo;
    }

    public static int updateItem(DetailsPojo detailsPojo) {
        int status = 0;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            String hql = "UPDATE DetailsPojo SET office = :office, " +
                    "owner = :owner, clientType = :clientType, name = :name, " +
                    "email = :email, phone = :phone, " +
                    //"date = :date, time = :time, " +
                    "newContactName = :newContactName, comments = :comments, " +
                    "remark = :remark " +
                    "WHERE id = :id";



            Query query = session.createQuery(hql);
            query.setParameter("office", detailsPojo.getOffice());
            query.setParameter("owner", detailsPojo.getOwner());
            query.setParameter("clientType", detailsPojo.getClientType());
            query.setParameter("name", detailsPojo.getName());
            query.setParameter("newContactName", detailsPojo.getNewContactName());
            query.setParameter("email", detailsPojo.getEmail());
            query.setParameter("phone", detailsPojo.getPhone());
            query.setParameter("comment", detailsPojo.getComments());
            query.setParameter("remark", detailsPojo.getRemark());
            query.setParameter("id", detailsPojo.getId());

            status = query.executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException("Error updating details", e);
        }

        return status;
    }
}
