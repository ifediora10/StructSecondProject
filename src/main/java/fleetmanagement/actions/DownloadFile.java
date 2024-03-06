package fleetmanagement.actions;

import com.opensymphony.xwork2.ActionSupport;
import fleetmanagement.dao.DetailsDAO;
import fleetmanagement.dao.FileDAO;
import fleetmanagement.dao.TripsDAO;
import fleetmanagement.pojo.DetailsPojo;
import fleetmanagement.pojo.FilePojo;
import fleetmanagement.pojo.TripsPojo;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;



@Results({
        @Result(name = "success", type = "stream", params = {
                "contentType", "application/octet-stream",
                "inputName", "fileInputStream",
                "contentDisposition", "attachment;filename=\"${fileName}\"",
                "bufferSize", "1024"
        }),
        @Result(name = "error", location = "/error.jsp")
        // @Result(name = "input", location = "/viewUpload")
})
public class DownloadFile extends ActionSupport {

    private Long id;
    private InputStream fileInputStream;
    private String fileName;

    @Action("downloadFileAction")
    public String details() {
        System.out.println("Executing DownloadFile action for id: " + id);

        TripsPojo trips = TripsDAO.getTripById(id);
        System.out.println( "gotten" + id );
        if (trips != null){
            fileInputStream = new ByteArrayInputStream(trips.getFileContent());
            fileName = trips.getFileName();
            System.out.println("prony" + id );
            return "success";
        } else
            return "error";
    }

//    @Action("downloadHistoryAction")
//    public String history() {
//        System.out.println("Executing DownloadFile action for id: " + id);
//
//        HistoryPojo history = HistoryDAO.getHistoryFileById(id);
//        if (history != null) {
//            fileInputStream = new ByteArrayInputStream(history.getFileContent());
//            fileName = history.getFileName();
//            return "success";
//        } else
//            return "error";
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(InputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
