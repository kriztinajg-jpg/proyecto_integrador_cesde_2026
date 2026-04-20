package co.edu.cesdega.Service;

import co.edu.cesdega.models.Enrollment;
import java.util.List;

public interface EnrollmentService {
    Enrollment matricularEstudiante(Enrollment enrollment);
    List<Enrollment> listarMatriculas();
}