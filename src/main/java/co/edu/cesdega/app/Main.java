package co.edu.cesdega.app;

import co.edu.cesdega.models.Student;
import co.edu.cesdega.models.Teacher;

public class Main {
    public static void main(String[] args) {

        Teacher teacher = new Teacher(1L, "T-100", "CC", "1122334455", "Alice", "Johnson", "ACTIVE");

        Student student = new Student(2L, "S-200", "TI", "6677889900", "Charlie", "Brown", "ACTIVE", "2000-01-01");
        System.out.println("=== PROYECTO OK ===");
        System.out.println(teacher);
        System.out.println(student);
    }
}