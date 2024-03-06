package fleetmanagement.actions;

import com.opensymphony.xwork2.ActionSupport;
import fleetmanagement.dao.DetailsDAO;
import fleetmanagement.dao.TripsDAO;
import fleetmanagement.dbutil.HibernateUtil;
import fleetmanagement.pojo.DetailsPojo;
import fleetmanagement.pojo.TripsPojo;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.Session;

import java.util.List;


@Action("/details")
@Results({
        @Result(name = "success", location = "/success.jsp"),
        @Result(name = "error", location = "/error.jsp")
})
//@Namespace("newrequest")
public class AddDetails extends ActionSupport {

    private Long id;
    private String office;
    private String owner;
    private String clientType;
    private String date;
    private String name;
    private String newContactName;
    private String existingContact;
    private String email;
    private String phone;
    private String remark;
    private String comments;

    public String execute(){

        DetailsPojo details = new DetailsPojo(id, office, owner, clientType, date, name, newContactName, existingContact, email,
                phone, remark, comments);

        DetailsDAO detailsDAO = new DetailsDAO();
        detailsDAO.saveDetails(details);

        return "success";
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewContactName() {
        return newContactName;
    }

    public void setNewContactName(String newContactName) {
        this.newContactName = newContactName;
    }

    public String getExistingContact() {
        return existingContact;
    }

    public void setExistingContact(String existingContact) {
        this.existingContact = existingContact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
