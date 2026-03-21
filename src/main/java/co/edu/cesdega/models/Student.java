package co.edu.cesdega.models;

public class Student extends Person {

    private String birthDate;

    public Student() { super(); }

    public Student(Long userId, String code, String documentType, String documentNumber,
                   String firstName, String lastName, String status, String birthDate) {
        super(userId, code, documentType, documentNumber, firstName, lastName, status);
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "userId=" + userId +
                ", name=" + firstName +
                ", birthDate=" + birthDate +
                '}';
    }
}