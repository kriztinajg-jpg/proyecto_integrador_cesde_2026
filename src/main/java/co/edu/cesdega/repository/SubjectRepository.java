package co.edu.cesdega.repository;
import co.edu.cesdega.models.Subject;
import java.util.List;

public interface SubjectRepository {
    Subject save(Subject subject);
    List<Subject> findAll();
    Subject findById(Long id);
}