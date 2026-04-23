package co.edu.cesdega.repository;
import co.edu.cesdega.models.GroupSubject;
import java.util.List;

public interface GroupSubjectRepository {
    GroupSubject save(GroupSubject groupSubject);
    List<GroupSubject> findAll();
}