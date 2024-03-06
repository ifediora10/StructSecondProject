package fleetmanagement.actions;

import com.opensymphony.xwork2.ActionSupport;
import fleetmanagement.dao.TripsDAO;
import fleetmanagement.dbutil.HibernateUtil;
import fleetmanagement.pojo.TripsPojo;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.Session;

import java.util.List;

@Action("/historyPage")
@Results({
        @Result(name = "success", location = "/listOfTrips.jsp")
})
public class TripList extends ActionSupport {

    private List<TripsPojo> tripsList;
    private List<TripsPojo> addedTripsList;  // New property

    public List<TripsPojo> getTripsList() {
        return tripsList;
    }

    public void setTripsList(List<TripsPojo> tripsList) {
        this.tripsList = tripsList;
    }

    public List<TripsPojo> getAddedTripsList() {
        return addedTripsList;
    }

    public void setAddedTripsList(List<TripsPojo> addedTripsList) {
        this.addedTripsList = addedTripsList;
    }

    public String execute() {
        // Open session
        Session openSession = HibernateUtil.getSessionFactory().openSession();

        // Retrieve the list of trips for history
        tripsList = TripsDAO.getAllTrips();

        // Retrieve the list of added trips
        // This logic should be adapted based on how you are adding trips
        addedTripsList = TripsDAO.getAddedTrips();

        // Close session
        openSession.close();

        return SUCCESS;
    }
}
