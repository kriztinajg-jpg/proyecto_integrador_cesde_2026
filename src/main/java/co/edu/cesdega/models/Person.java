package co.edu.cesdega.models;

public abstract class Person {

    protected String code;
    protected String documentNumber;
    protected String firstName;
    protected String lastName;
    protected Boolean status;
    //constructor vacio - debe estar siempre los dos constructores, uno para actualzar o otro para llenar
 protected Person(){}
//constructor lleno
protected Person(Long userId, String code, String documentNumber, String firstName, String lastName, Boolean status) {
        this.code = code;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
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
    return
            "code" + code + " " +
            "document number" + documentNumber + " " +
            "fist name" + firstName + " " +
            "last name" + lastName + " " +
            "status" + status;
    }
}