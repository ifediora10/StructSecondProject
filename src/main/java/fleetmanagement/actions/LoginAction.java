package fleetmanagement.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import fleetmanagement.dao.LoginDAO;
import fleetmanagement.pojo.LoginInfoPojo;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;


@Action("/loginAction")
//@Result(name = "success", location = "/success.jsp")
@Results({@Result(name = "success", location = "/welcome.jsp"),
        @Result(name = "input", location = "/login.jsp")
})
@Validations(
        requiredStrings = {
                @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "username", message = "Input Name"),
                @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "password", message = "Password Required")

        }
)
@InterceptorRef(value = "customInterceptor")
@ParentPackage(value = "fleet")
public class LoginAction extends ActionSupport {

    String username;
    Long id;
    String password;

    public String execute(){
       String statusCode = "";
       boolean isUserValid = LoginDAO.isUserValid(new LoginInfoPojo(null, username,password));
        ServletActionContext.getRequest().getSession().setAttribute("loggedInUser", username);


       if (isUserValid){
           statusCode = "success";
       } else {
           addActionError("Account does not exist. Please register or check your credentials.");
           statusCode = "input";
       }
       return statusCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
