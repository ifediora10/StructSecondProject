package fleetmanagement.report;

import com.opensymphony.xwork2.ActionSupport;
import fleetmanagement.dao.TripsDAO;
import fleetmanagement.dbutil.HibernateUtil;
import fleetmanagement.pojo.TripsPojo;
import fleetmanagement.report.DetailsReportDataSource;
import net.sf.jasperreports.engine.*;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.Session;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

@Action("/generatePdfAction")
@Results({
        @Result(name = "error", location = "/error.jsp")
})
public class RequestListReport extends ActionSupport {

    public String execute() {
        try
                (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            List<TripsPojo> tripList = TripsDAO.getAllTrips();
            TripsReportDataSource dataSource = new TripsReportDataSource(detailsList);

            InputStream templateStream = getClass().getResourceAsStream("/newRequestReport.jrxml");

            if (templateStream != null) {
                JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

                // JasperExportManager.exportReportToPdfFile(jasperPrint, "path/to/output/details_report.pdf");

                HttpServletResponse response = ServletActionContext.getResponse();
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment;filename=list_of_request.pdf");

                JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

                return "none";
            }else{
                System.out.println("templateStream is null");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
}
