//package fleetmanagement.actions;
//
//import com.opensymphony.xwork2.ActionSupport;
//import fleetmanagement.dao.FileDAO;
//import fleetmanagement.pojo.FilePojo;
//import org.apache.struts2.convention.annotation.Action;
//import org.apache.struts2.convention.annotation.Result;
//
//
//import javax.servlet.http.Part;
//import java.io.*;
//import java.util.UUID;
//
//@Action(value = "/fileUploadAction",
//        results = {@Result (name = "success", type = "redirectAction",
//                    params = {"actionName", "viewUpload"}
//),                  @Result(name = "input", location = "/uploadFile.jsp")
//})
//public class UploadFileAction extends ActionSupport {
//
//    private File fileInput;
//    private String fileName;
//
//
//    public String execute() {
//
//        try (InputStream inputStream = new FileInputStream(fileInput)) {
//            byte[] file = new byte[(int) fileInput.length()];
//            inputStream.read(file);
//
//
//            FilePojo filePojo = new FilePojo();
//            filePojo.setFileName(fileName);
//            filePojo.setFileContent(file);
//
//            FileDAO fileDAO = new FileDAO();
//            fileDAO.uploadFile(filePojo);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "success";
//    }
//
//    public File getFileInput() {
//        return fileInput;
//    }
//
//    public void setFileInput(File fileInput) {
//        this.fileInput = fileInput;
//    }
//
//    public String getFileName() {
//        return fileName;
//    }
//
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
//}