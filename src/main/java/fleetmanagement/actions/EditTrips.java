package fleetmanagement.actions;

import com.opensymphony.xwork2.ActionSupport;
import fleetmanagement.dao.TripsDAO;
import fleetmanagement.pojo.TripsPojo;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Action("/editTrip")
@Results({
        @Result(name = "success", location = "/editRequest.jsp"),
        @Result(name = "error", location = "/error.jsp")
})
public class EditTrips extends ActionSupport {

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
    private boolean isAdded;
    private String fileName;
    private byte[] fileContent;
    private TripsDAO tripsDAO = new TripsDAO();

    private TripsPojo trp;

    public String execute() {


        // Load the trip from the database using the ID
        TripsPojo trip = TripsDAO.getTripById(id);

        if (trip != null) {
            // Set fields based on the loaded trip
            id = trip.getId();
            passengerNames = trip.getPassengerNames();
            numberOfPassengers = trip.getNumberOfPassengers();
            phone = trip.getPhone();
            email = trip.getEmail();
            departure = trip.getDeparture();
            destination = trip.getDestination();
            pickUpDate = trip.getPickUpDate();
            pickUpTime = trip.getPickUpTime();
            endDate = trip.getEndDate();
            endTime = trip.getEndTime();
            vehicleCategory = trip.getVehicleCategory();
            vehicleType = trip.getVehicleType();
            serviceType = trip.getServiceType();
            additionalServices = trip.getAdditionalServices();
            numberOfDays = trip.getNumberOfDays();
            pricePerDay = trip.getPricePerDay();
            additionalInformation = trip.getAdditionalInformation();
            personnelType = trip.getPersonnelType();
            personnelName = trip.getPersonnelName();
            vehicle = trip.getVehicle();
            resourceAvailability = trip.getResourceAvailability();
            totalAmount = trip.getTotalAmount();
            isAdded = trip.isAdded();
            fileName = trip.getFileName();
            fileContent = trip.getFileContent();
            return "success";

        } else {
            // Handle the case where the trip with the specified ID is not found
            System.out.println("Executing EditTrips action for ID: " + id);

            return ERROR;
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

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }
}
