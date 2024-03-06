package fleetmanagement.dao;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import fleetmanagement.dbutil.HibernateUtil;
import fleetmanagement.pojo.TripsPojo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TripsDAO {

    private static final Logger log = LoggerFactory.getLogger(TripsDAO.class);

    public void saveTrip(TripsPojo trip) {
        try {
            log.info("Opening session for saving trip...");
            Session session = HibernateUtil.getSessionFactory().openSession();
            log.info("Save Session opened successfully.");

            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.save(trip);
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

    public static List<TripsPojo> getAllTrips() {
        List<TripsPojo> tripsList = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM TripsPojo";
            Query<TripsPojo> query = session.createQuery(hql, TripsPojo.class);
            tripsList = query.list();
        } catch (HibernateException e) {
            log.error("Error fetching trips from database ", e);
        }

        return tripsList;
    }

    public static List<TripsPojo> getAddedTrips() {
        List<TripsPojo> tripsList = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM TripsPojo WHERE isAdded = true";
            Query<TripsPojo> query = session.createQuery(hql, TripsPojo.class);
            tripsList = query.list();
        } catch (HibernateException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        return tripsList;
    }

    public List<TripsPojo> searchTrips(Long id, String passengerNames, String destination) {
        List<TripsPojo> searchResults = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            StringBuilder hqlBuilder = new StringBuilder("FROM TripsPojo WHERE 1 = 1");

            if (id != null) {
                hqlBuilder.append(" AND id = :id");
            }

            if (passengerNames != null && !passengerNames.isEmpty()) {
                hqlBuilder.append(" AND passengerNames = :passengerNames");
            }

            if (destination != null && !destination.isEmpty()) {
                hqlBuilder.append(" AND destination = :destination");
            }

            String hql = hqlBuilder.toString();

            Query<TripsPojo> query = session.createQuery(hql, TripsPojo.class);

            if (id != null) {
                query.setParameter("id", id);
            }

            if (passengerNames != null && !passengerNames.isEmpty()) {
                query.setParameter("passengerNames", passengerNames);
            }

            if (destination != null && !destination.isEmpty()) {
                query.setParameter("destination", destination);
            }

            searchResults = query.list();
        } catch (HibernateException e) {
            log.error("Error performing search in the database", e);
        }

        return searchResults;
    }

    public int updateTrip(TripsPojo updatedTrip) {
        int status = 0;

        try {
            log.info("Opening session for updating trip...");
            Session session = HibernateUtil.getSessionFactory().openSession();
            log.info("Update Session opened successfully.");

            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                TripsPojo existingTrip = session.load(TripsPojo.class, updatedTrip.getId());

                // Update the properties of existingTrip with the values from updatedTrip
                existingTrip.setPassengerNames(updatedTrip.getPassengerNames());
                existingTrip.setNumberOfPassengers(updatedTrip.getNumberOfPassengers());
                existingTrip.setPhone(updatedTrip.getPhone());
                existingTrip.setEmail(updatedTrip.getEmail());
                existingTrip.setDeparture(updatedTrip.getDeparture());
                existingTrip.setDestination(updatedTrip.getDestination());
                existingTrip.setPickUpDate(updatedTrip.getPickUpDate());
                existingTrip.setPickUpTime(updatedTrip.getPickUpTime());
                existingTrip.setEndDate(updatedTrip.getEndDate());
                existingTrip.setEndTime(updatedTrip.getEndTime());
                existingTrip.setVehicleCategory(updatedTrip.getVehicleCategory());
                existingTrip.setVehicleType(updatedTrip.getVehicleType());
                existingTrip.setServiceType(updatedTrip.getServiceType());
                existingTrip.setAdditionalServices(updatedTrip.getAdditionalServices());
                existingTrip.setNumberOfDays(updatedTrip.getNumberOfDays());
                existingTrip.setPricePerDay(updatedTrip.getPricePerDay());
                existingTrip.setAdditionalInformation(updatedTrip.getAdditionalInformation());
                existingTrip.setPersonnelType(updatedTrip.getPersonnelType());
                existingTrip.setPersonnelName(updatedTrip.getPersonnelName());
                existingTrip.setVehicle(updatedTrip.getVehicle());
                existingTrip.setResourceAvailability(updatedTrip.getResourceAvailability());
                existingTrip.setTotalAmount(updatedTrip.getTotalAmount());
                existingTrip.setAdded(updatedTrip.isAdded());
                existingTrip.setFileName(updatedTrip.getFileName());
                existingTrip.setFileContent(updatedTrip.getFileContent());


                session.update(existingTrip);
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

        return status;
    }

    public static TripsPojo getTripById(Long id) {
        TripsPojo trip = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM TripsPojo WHERE id = :id";
            Query<TripsPojo> query = session.createQuery(hql, TripsPojo.class);
            query.setParameter("id", id);
            trip = query.uniqueResult();
        } catch (Exception e) {
            log.error("Error fetching trip by ID", e);
        }
        return trip;
    }
}
