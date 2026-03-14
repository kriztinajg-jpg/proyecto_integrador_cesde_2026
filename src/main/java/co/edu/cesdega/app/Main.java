package co.edu.cesdega.app;
import co.edu.cesdega.models.Person;
import co.edu.cesdega.models.Student;
import co.edu.cesdega.models.Teacher;

public static void main(String[] args) {
    Teacher teacher = new Teacher(1L, null, "CC", "1122334455", "Alice", "Johnson", "ACTIVE");

    Student student = new Student(null, "TI", "6677889900", "Charlie", "Brown", "ACTIVE", "2000-01-01");
    student.setStudentId(1L);

    System.out.println("=== DEMO FASE 1 ===");
    System.out.println(teacher);
    System.out.println(student);
}