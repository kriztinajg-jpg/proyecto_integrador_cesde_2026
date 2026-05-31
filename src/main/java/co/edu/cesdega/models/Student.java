package co.edu.cesdega.models;

public class Student extends Person {

    private Long studentId;
    private String birthDate;

    public Student() {
        super();
    }

    public Student(Long studentId, String code, String documentType, String documentNumber,
                   String firstName, String lastName, String status, String birthDate) {

        super(studentId, code, documentType, documentNumber, firstName, lastName, status);

        this.studentId = studentId;
        this.birthDate = birthDate;
    }

    // GETTERS Y SETTERS
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", code='" + code + '\'' +
                ", name='" + firstName + " " + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}