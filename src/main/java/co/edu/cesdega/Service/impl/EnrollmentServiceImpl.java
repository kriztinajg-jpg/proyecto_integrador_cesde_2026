package co.edu.cesdega.Service.impl;

import co.edu.cesdega.Service.EnrollmentService;
import co.edu.cesdega.models.Enrollment;
import co.edu.cesdega.repository.EnrollmentRepository;
import java.util.List;

public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public Enrollment matricularEstudiante(Enrollment enrollment) {
        // VALIDACIONES
        if (enrollment.getStudent() == null || enrollment.getGroup() == null) {
            System.out.println("Error: No se puede matricular sin estudiante o sin grupo.");
            return null;
        }

        // Estado por defecto si viene vacío
        if (enrollment.getStatus() == null) {
            enrollment.setStatus("ACTIVO");
        }

        System.out.println("Matrícula exitosa: " + enrollment.getStudent().getFirstName() +
                " en el grupo " + enrollment.getGroup().getCode());
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public List<Enrollment> listarMatriculas() {
        return enrollmentRepository.findAll();
    }
}