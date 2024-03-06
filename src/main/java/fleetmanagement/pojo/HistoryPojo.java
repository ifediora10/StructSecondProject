package fleetmanagement.pojo;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class HistoryPojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date eventTime;
    private String eventType;  // "CREATE" or "UPDATE"
    private String eventUser;  // User who performed the action
    @ManyToOne
    @JoinColumn(name = "trips_id")
    private TripsPojo tripsPojo;


    public HistoryPojo() {
    }

    public HistoryPojo(TripsPojo tripsPojo, Date eventTime, String eventType, String eventUser) {
        this.tripsPojo = tripsPojo;
        this.eventTime = eventTime;
        this.eventType = eventType;
        this.eventUser = eventUser;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventUser() {
        return eventUser;
    }

    public void setEventUser(String eventUser) {
        this.eventUser = eventUser;
    }

    public TripsPojo getTripsPojo() {
        return tripsPojo;
    }

    public void setTripsPojo(TripsPojo tripsPojo) {
        this.tripsPojo = tripsPojo;
    }
}
