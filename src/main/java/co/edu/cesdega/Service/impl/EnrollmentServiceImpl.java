package co.edu.cesdega.Service.impl;

import co.edu.cesdega.Service.EnrollmentService;
import co.edu.cesdega.models.Enrollment;
import co.edu.cesdega.repository.EnrollmentRepository;
import co.edu.cesdega.exceptions.ValidationException;
import co.edu.cesdega.exceptions.ResourceNotFoundException;

import java.util.List;

public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public Enrollment matricularEstudiante(Enrollment enrollment) {
        // 1. Validación: El objeto matrícula completo no puede ser nulo
        if (enrollment == null) {
            throw new ValidationException("Error: Los datos de la matrícula no pueden estar vacíos.");
        }

        // 2. Validación: Es obligatorio que la matrícula tenga un estudiante y un grupo asignado
        if (enrollment.getStudent() == null || enrollment.getGroup() == null) {
            throw new ValidationException("Error de validación: No se puede procesar la matrícula sin un estudiante o sin un grupo.");
        }

        // 3. Asignación por defecto: Si el estado viene vacío, lo dejamos como ACTIVO
        if (enrollment.getStatus() == null || enrollment.getStatus().isBlank()) {
            enrollment.setStatus("ACTIVO");
        }

        System.out.println("[SERVICIO] Matrícula procesada con éxito: " + enrollment.getStudent().getFirstName() +
                " en el grupo " + enrollment.getGroup().getCode());

        return enrollmentRepository.save(enrollment);
    }

    @Override
    public List<Enrollment> listarMatriculas() {
        List<Enrollment> matriculas = enrollmentRepository.findAll();

        // Opcional: Si quieres que lance error cuando no hay nadie matriculado en todo el colegio
        if (matriculas == null || matriculas.isEmpty()) {
            throw new ResourceNotFoundException("No se encontraron matrículas registradas en el sistema.");
        }

        return matriculas;
    }
}