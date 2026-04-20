package co.edu.cesdega.repository;

import co.edu.cesdega.models.Enrollment;
import java.util.List;

public interface EnrollmentRepository {
    Enrollment save(Enrollment enrollment);
    List<Enrollment> findAll();
    // Útil para saber en qué grupos está metido un estudiante
    List<Enrollment> findByStudentId(Long studentId);
}