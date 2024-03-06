package fleetmanagement.report;

import fleetmanagement.pojo.TripsPojo;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import java.util.List;

public class TripsReportDataSource implements JRDataSource {

    private List<TripsPojo> tripsList;
    private int index = -1;


    public TripsReportDataSource(List<TripsPojo> tripsList) {
        this.tripsList = tripsList;
    }


    @Override
    public boolean next() throws JRException {

        index++;
        return index < tripsList.size();
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {

        TripsPojo tripsPojo = tripsList.get(index);

        switch (jrField.getName()) {
            case "id":
                return tripsPojo.getId();
            case "passengerNames":
                return tripsPojo.getPassengerNames();
            case "vehicle":
                return tripsPojo.getVehicle();
            case "phone":
                return tripsPojo.getPhone();
            case "email":
                return tripsPojo.getEmail();
            case "file":
                return tripsPojo.getFileName();
            case "pickUpDate":
                return tripsPojo.getPickUpDate();
            case "endDate":
                return tripsPojo.getEndDate();
            case "serviceType":
                return tripsPojo.getServiceType();
            case "numberOfDays":
                return tripsPojo.getNumberOfDays();
            case "personnelName":
                return tripsPojo.getPersonnelName();
            case "totalAmount":
                return tripsPojo.getTotalAmount();
            default:
                return null;
        }
    }
    public List<TripsPojo> getTripsList() {
        return tripsList;
    }
    public void setTripsList(List<TripsPojo> tripsList) {
        this.tripsList = tripsList;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
