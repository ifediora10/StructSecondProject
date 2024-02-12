package fleetmanagement.pojo;


import jakarta.persistence.*;

//@Entity
//@Table(name = "login_info")
public class LoginInfoPojo {

   // @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;

    public LoginInfoPojo(){

    }

    public LoginInfoPojo(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
