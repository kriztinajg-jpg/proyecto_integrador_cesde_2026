package co.edu.cesdega.repository.impl;
import co.edu.cesdega.models.Grade;
import co.edu.cesdega.models.Student;
import co.edu.cesdega.repository.GradeRepository;
import java.util.ArrayList;
import java.util.List;

public class GradeRepositoryinMemory implements GradeRepository {

    private final List<Grade> grades = new ArrayList<>();
    private Long currentId = 1L;

    @Override
    public Grade save(Grade grade) {
        grade.setGradeId(currentId++); // Asignamos ID automático
        grades.add(grade);
        return grade;
    }

    @Override
    public List<Grade> findAll() {
        return grades;
    }

    @Override
    public List<Grade> findByStudentId(Long studentIdRecibido) {
        List<Grade> listaDeNotasEncontradas = new ArrayList<>();

        for (Grade notaActual : grades) {

            Long idDelEstudianteEnLaNota = notaActual.getStudentId();

            if (idDelEstudianteEnLaNota != null) {

                if (idDelEstudianteEnLaNota.equals(studentIdRecibido)) {
                    listaDeNotasEncontradas.add(notaActual);
                }
            }
        }
        return listaDeNotasEncontradas;
    }
}