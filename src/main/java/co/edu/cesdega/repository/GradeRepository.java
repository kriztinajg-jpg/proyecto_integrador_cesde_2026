package co.edu.cesdega.repository;

import co.edu.cesdega.models.Grade;

import java.util.List;

public interface GradeRepository { Grade save(Grade grade);

    // Ver todas las notas registradas
    List<Grade> findAll();

    // Buscar todas las notas de un estudiante específico
    List<Grade> findByStudentId(Long studentId);
}
