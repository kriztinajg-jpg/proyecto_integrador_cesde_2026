package co.edu.cesdega.Service;
import co.edu.cesdega.models.GroupSubject;
import java.util.List;

public interface GroupSubjectService {
    GroupSubject save(GroupSubject groupSubject);
    List<GroupSubject> findAll();
}