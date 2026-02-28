package co.edu.cesdega.models;

public class Student extends Person{
    private String birthyear;
    //constructor vacio
    public Student(){};

    public String getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(String birthyear) {
        this.birthyear = birthyear;
    }

    //constructor lleno
    public Student(Long userId, String code, String documentNumber, String firstName, String lastName, Boolean status, String birthyear) {
        super(userId, code, documentNumber, firstName, lastName, status);
        this.birthyear = birthyear;

    }
    @Override
    public String toString() {
        return "Student= " + super.toString() +
                " birthday = " + birthyear;
    }
}
