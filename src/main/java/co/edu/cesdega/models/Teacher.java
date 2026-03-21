package co.edu.cesdega.models;

public class Teacher extends Person {

    public Teacher() { super(); }

    public Teacher(Long userId, String code, String documentType, String documentNumber,
                   String firstName, String lastName, String status) {
        super(userId, code, documentType, documentNumber, firstName, lastName, status);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "userId=" + userId +
                ", name=" + firstName + " " + lastName +
                '}';
    }
}