package co.edu.cesdega.models;

public class Student extends Person {
    private Long studentId;
    private String birthDate;

    // Constructor vacío
    public Student() {
        super();
    }

    // Constructor lleno - Asegúrate que el orden coincida con Person
    // Person(userId, code, documentNumber, firstName, lastName, status)
    public Student(Long userId, String code, String documentNumber, String firstName, String lastName, Boolean status, String birthDate) {
        super(userId, code, documentNumber, firstName, lastName, status);
        this.birthDate = birthDate;
        this.studentId = studentId;
    }

    // Getters y Setters
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", status=" + getStatus() +
                '}';
    }
}