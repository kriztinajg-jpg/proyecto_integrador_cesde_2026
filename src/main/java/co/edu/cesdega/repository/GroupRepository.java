package co.edu.cesdega.repository;

import co.edu.cesdega.models.Group;
import java.util.List;

public interface GroupRepository {
    Group save(Group group);
    List<Group> findAll();
    Group findById(Long groupId);
}
