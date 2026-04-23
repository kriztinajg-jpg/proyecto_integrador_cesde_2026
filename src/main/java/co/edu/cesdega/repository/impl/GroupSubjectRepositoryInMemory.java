package co.edu.cesdega.repository.impl;

import co.edu.cesdega.models.GroupSubject;
import co.edu.cesdega.repository.GroupSubjectRepository;
import java.util.ArrayList;
import java.util.List;

public class GroupSubjectRepositoryInMemory implements GroupSubjectRepository {
    private final List<GroupSubject> groupSubjects = new ArrayList<>();
    private Long currentId = 1L;

    @Override
    public GroupSubject save(GroupSubject groupSubject) {
        if (groupSubject.getGroupSubjectId() == null) {
            groupSubject.setGroupSubjectId(currentId++);
        }
        groupSubjects.add(groupSubject);
        return groupSubject;
    }

    @Override
    public List<GroupSubject> findAll() {
        return groupSubjects;
    }
}