package fleetmanagement.pojo;

import jakarta.persistence.*;

@Entity
public class FilePojo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

   private String fileName;
   @Lob
   private byte[] fileContent;


   public FilePojo(){

   }

    public FilePojo(Long id, String fileName, byte[] fileContent) {
        this.id = id;
        this.fileName = fileName;
        this.fileContent = fileContent;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
