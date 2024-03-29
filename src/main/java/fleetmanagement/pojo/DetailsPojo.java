package fleetmanagement.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "details")
public class DetailsPojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    public DetailsPojo() {

    }

    public DetailsPojo(Long id, String office, String owner, String clientType, String date,
                       String name, String newContactName, String existingContact, String email,
                       String phone, String remark, String comments) {
        this.id = id;
        this.office = office;
        this.owner = owner;
        this.clientType = clientType;
        this.date = date;
        this.name = name;
        this.newContactName = newContactName;
        this.existingContact = existingContact;
        this.email = email;
        this.phone = phone;
        this.remark = remark;
        this.comments = comments;
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