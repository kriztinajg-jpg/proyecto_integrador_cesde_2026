package co.edu.cesdega.models;

public class Person {
   private Long userId;
   private String code;
   private String documentNumber;
   private String firstName;
   private String lastName;
   private Boolean status;
    //constructor vacio - debe estar siempre los dos constructores, uno para actualzar o otro para llenar
public Person(){
}
//constructor lleno
    public Person(Long userId, String code, String documentNumber, String firstName, String lastName, Boolean status) {
        this.userId = userId;
        this.code = code;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString(){
    return "User Id="+ userId + " " +
            "code" + code + " " +
            "document number" + documentNumber + " " +
            "fist name" + firstName + " " +
            "last name" + lastName + " " +
            "status" + status;
    }
}