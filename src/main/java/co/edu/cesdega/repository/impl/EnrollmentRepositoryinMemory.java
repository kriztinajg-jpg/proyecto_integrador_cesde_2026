package co.edu.cesdega.repository.impl;

import co.edu.cesdega.models.Enrollment;
import co.edu.cesdega.repository.EnrollmentRepository;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepositoryinMemory implements EnrollmentRepository {
    private final List<Enrollment> enrollments = new ArrayList<>();
    private Long currentId = 1L;

    @Override
    public Enrollment save(Enrollment enrollment) {
        if (enrollment.getEnrollmentId() == null) {
            enrollment.setEnrollmentId(currentId++);
        }
        enrollments.add(enrollment);
        return enrollment;
    }

    @Override
    public List<Enrollment> findAll() {
        return enrollments;
    }

    @Override
    public List<Enrollment> findByStudentId(Long studentId) {
        List<Enrollment> studentEnrollments = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudent() != null && e.getStudent().getStudentId().equals(studentId)) {
                studentEnrollments.add(e);
            }
        }
        return studentEnrollments;
    }
}