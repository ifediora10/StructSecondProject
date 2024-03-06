package fleetmanagement.dao;

import fleetmanagement.dbutil.HibernateUtil;
import fleetmanagement.pojo.HistoryPojo;
import fleetmanagement.pojo.TripsPojo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HistoryDAO {

    public void addHistoryEvent(Long tripId, HistoryPojo historyEvent) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                TripsPojo trip = session.get(TripsPojo.class, tripId);
                if (trip != null) {
                    historyEvent.setTripsPojo(trip);
                    session.persist(historyEvent);
                }

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace(); // Handle the exception appropriately
            } finally {
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public List<HistoryPojo> getHistoryForTrip(Long tripId) {
        List<HistoryPojo> historyList = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM HistoryPojo WHERE tripsPojo.id = :tripId";
            Query<HistoryPojo> query = session.createQuery(hql, HistoryPojo.class);
            query.setParameter("tripId", tripId);
            historyList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        return historyList;
    }
}
