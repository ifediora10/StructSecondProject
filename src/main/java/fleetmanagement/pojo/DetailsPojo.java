package fleetmanagement.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "details")


public class DetailsPojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String office;
    private String vehicle;
    private String driver;
    private String faultType;
    private String client;
    private String millage;
    private String date;
    private String time;
    private String location;
    private String complaint;
    private String comment;
    private String assign;
    private String notify;

    public DetailsPojo(Long id, String office, String vehicle, String driver, String faultType, String client, String millage, String date, String time, String location, String complaint, String comment, String assign, String notify) {
        this.id = id;
        this.office = office;
        this.vehicle = vehicle;
        this.driver = driver;
        this.faultType = faultType;
        this.client = client;
        this.millage = millage;
        this.date = date;
        this.time = time;
        this.location = location;
        this.complaint = complaint;
        this.comment = comment;
        this.assign = assign;
        this.notify = notify;
    }

    public DetailsPojo() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getMillage() {
        return millage;
    }

    public void setMillage(String millage) {
        this.millage = millage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }
}