package co.edu.cesdega.models;

public abstract class Person {

    protected Long userId;
    protected String code;
    protected String documentType;
    protected String documentNumber;
    protected String firstName;
    protected String lastName;
    protected String status;

    public Person() {}

    public Person(Long userId, String code, String documentType, String documentNumber,
                  String firstName, String lastName, String status) {
        this.userId = userId;
        this.code = code;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }
}