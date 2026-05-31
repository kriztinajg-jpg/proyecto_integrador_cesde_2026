package co.edu.cesdega.Service.impl;

import co.edu.cesdega.Service.GradeService;
import co.edu.cesdega.models.Grade;
import co.edu.cesdega.repository.GradeRepository;
// 1. IMPORTANTE: Importamos nuestras excepciones personalizadas
import co.edu.cesdega.exceptions.ValidationException;
import co.edu.cesdega.exceptions.ResourceNotFoundException;

import java.util.List;

public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public Grade registrarNota(Grade grade) {
        // Validación A: Nota nula
        if (grade == null) {
            throw new ValidationException("Error: La nota no puede ser un objeto nulo.");
        }

        // Validación B: Rango de la nota (0.0 a 5.0)
        if (grade.getFinalScore() < 0.0 || grade.getFinalScore() > 5.0) {
            throw new ValidationException("Error: La nota " + grade.getFinalScore() + " no es válida. Debe estar entre 0.0 y 5.0.");
        }

        // Validación C: ID del estudiante obligatorio
        if (grade.getStudentId() == null) {
            throw new ValidationException("Error: No se puede registrar la nota porque el ID del estudiante es obligatorio.");
        }

        // Si pasa todas las validaciones, se guarda con éxito
        System.out.println("[SERVICIO] Nota registrada con éxito para el estudiante: " + grade.getStudentId());
        return gradeRepository.save(grade);
    }

    @Override
    public List<Grade> consultarBoletin(Long studentId) {
        if (studentId == null) {
            throw new ValidationException("Error: El ID del estudiante es obligatorio para consultar el boletín.");
        }

        List<Grade> notas = gradeRepository.findByStudentId(studentId);

        // Validación D: Si el estudiante no tiene ninguna nota, o no existe en los registros de notas
        if (notas == null || notas.isEmpty()) {
            throw new ResourceNotFoundException("No se encontraron notas registradas para el estudiante con ID: " + studentId);
        }

        return notas;
    }
}