package co.edu.cesdega.Service;

import co.edu.cesdega.models.Grade;
import java.util.List;

public interface GradeService {

    Grade registrarNota(Grade grade);

    List<Grade> consultarBoletin(Long studentId);
}