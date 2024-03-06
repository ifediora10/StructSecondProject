package fleetmanagement.actions;

import com.opensymphony.xwork2.ActionSupport;
import fleetmanagement.dao.TripsDAO;
import fleetmanagement.pojo.TripsPojo;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Action("/viewTrip")
@Results({@Result(name = "success", location = "/viewRequest.jsp"),
        @Result(name = "error",location = "/error.jsp")
})
public class ViewTrip extends ActionSupport {

    private Long id;
    private TripsPojo trip;
    private TripsDAO tripsDAO = new TripsDAO();


    public String view() {
        // Load the trip from the database using the ID
        trip = tripsDAO.getTripById(id);

        if (trip != null) {
            return "success";
        } else {
            // Handle the case where the trip with the specified ID is not found
            return "error";
        }
    }

    // Other getters and setters as needed

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TripsPojo getTrip() {
        return trip;
    }
}
