package co.edu.cesdega.Service.impl;
import co.edu.cesdega.models.GroupSubject;
import co.edu.cesdega.repository.GroupSubjectRepository;
import co.edu.cesdega.Service.GroupSubjectService;
import java.util.List;

public class GroupSubjectServiceImpl implements GroupSubjectService {
    private final GroupSubjectRepository groupSubjectRepository;

    public GroupSubjectServiceImpl(GroupSubjectRepository groupSubjectRepository) {
        this.groupSubjectRepository = groupSubjectRepository;
    }

    @Override
    public GroupSubject save(GroupSubject groupSubject) {
        return groupSubjectRepository.save(groupSubject);
    }

    @Override
    public List<GroupSubject> findAll() {
        return groupSubjectRepository.findAll();
    }
}