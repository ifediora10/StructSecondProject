package fleetmanagement.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Action("/logoutAction")
@Result(name = "input", location = "/login.jsp")
public class LogoutAction extends ActionSupport {

    public String execute(){
        ServletActionContext.getRequest().getSession().invalidate();
        return "input";
    }
}
