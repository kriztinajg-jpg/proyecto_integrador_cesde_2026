package co.edu.cesdega.Service.impl;

import co.edu.cesdega.Service.GradeService;
import co.edu.cesdega.models.Grade;
import co.edu.cesdega.repository.GradeRepository;
import java.util.List;

public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;
    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public Grade registrarNota(Grade grade) {

        if (grade == null) {
            System.out.println("Error: La nota es nula.");
            return null;
        }

        if (grade.getFinalScore() < 0.0 || grade.getFinalScore() > 5.0) {
            System.out.println("Error: La nota " + grade.getFinalScore() + " no es válida. Debe ser entre 0.0 y 5.0");
            return null;
        }


        if (grade.getStudentId() == null) {
            System.out.println("Error: No se puede registrar nota sin ID de estudiante.");
            return null;
        }


        System.out.println("Nota registrada con éxito para el estudiante: " + grade.getStudentId());
        return gradeRepository.save(grade);
    }

    @Override
    public List<Grade> consultarBoletin(Long studentId) {

        return gradeRepository.findByStudentId(studentId);
    }
}