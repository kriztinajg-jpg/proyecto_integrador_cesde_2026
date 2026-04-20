package co.edu.cesdega.Service;

import co.edu.cesdega.models.Subject;
import java.util.List;

public interface SubjectService {
    Subject crearMateria(Subject subject);
    List<Subject> listarMaterias();
}