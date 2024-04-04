package fleetmanagement.actions;

import com.opensymphony.xwork2.ActionSupport;
import fleetmanagement.dao.HistoryDAO;
import fleetmanagement.dao.TripsDAO;
import fleetmanagement.pojo.HistoryPojo;
import fleetmanagement.pojo.TripsPojo;
import jakarta.persistence.Lob;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@Action(value = "/updateTrip", results = {
        @Result(name = "success", type = "redirectAction", params = {"actionName", "historyPage"}),
        @Result(name = "input", location = "/listOfTrips.jsp"),
        @Result(name = "error",location = "/error.jsp"),
})
public class UpdateTrip extends ActionSupport {

    private Long id;
    private String passengerNames;
    private String numberOfPassengers;
    private String phone;
    private String email;
    private String departure;
    private String destination;
    private String pickUpDate;
    private String pickUpTime;
    private String endDate;
    private String endTime;
    private String vehicleCategory;
    private String vehicleType;
    private String serviceType;
    private String additionalServices;
    private String numberOfDays;
    private String pricePerDay;
    private String additionalInformation;
    private String personnelType;
    private String personnelName;
    private String vehicle;
    private String resourceAvailability;
    private String totalAmount;
    private boolean isAdded = true;
    private String fileName;
    private File fileInput;
    private byte[] file;

    private TripsDAO tripsDAO = new TripsDAO();

    public String execute() throws IOException {

        InputStream inputStream = new FileInputStream(fileInput);
        byte[] file = new byte[(int)fileInput.length()];
        inputStream.read(file);
        System.out.println("file read");

        try {
            if (id != null) {
                TripsPojo trip = new TripsPojo(id, passengerNames, numberOfPassengers, phone, email,
                        departure, destination, pickUpDate, pickUpTime, endDate, endTime, vehicleCategory,
                        vehicleType, serviceType, additionalServices, numberOfDays, pricePerDay,
                        additionalInformation, personnelType, personnelName, vehicle, resourceAvailability,
                        totalAmount, true, fileName, file);

                int recordUpdated = tripsDAO.updateTrip(trip);

                String user = ServletActionContext.getRequest().getSession().getAttribute("loggedInUser").toString();
                HistoryPojo historyPojo = new HistoryPojo(
                        trip, new Date(), "update" , user
                );
                new HistoryDAO().addHistoryEvent(trip.getId(), historyPojo);

                if (recordUpdated == 1) {
                    return SUCCESS;
                } else {
                    addActionError("Failed to update trip. Please try again.");
                    return INPUT;
                }
            } else {
                addActionError("Invalid data for updating trip.");
                return INPUT;
            }
        } catch (Exception e) {
            addActionError("An error occurred while updating the trip. Please try again.");
            return INPUT;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassengerNames() {
        return passengerNames;
    }

    public void setPassengerNames(String passengerNames) {
        this.passengerNames = passengerNames;
    }

    public String getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(String numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(String additionalServices) {
        this.additionalServices = additionalServices;
    }

    public String getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(String numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(String pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getPersonnelType() {
        return personnelType;
    }

    public void setPersonnelType(String personnelType) {
        this.personnelType = personnelType;
    }

    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getResourceAvailability() {
        return resourceAvailability;
    }

    public void setResourceAvailability(String resourceAvailability) {
        this.resourceAvailability = resourceAvailability;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }

    public TripsDAO getTripsDAO() {
        return tripsDAO;
    }

    public void setTripsDAO(TripsDAO tripsDAO) {
        this.tripsDAO = tripsDAO;
    }
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File getFileInput() {
        return fileInput;
    }

    public void setFileInput(File fileInput) {
        this.fileInput = fileInput;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
