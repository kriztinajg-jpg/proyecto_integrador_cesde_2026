package co.edu.cesdega.repository.impl;

import co.edu.cesdega.models.Group;
import co.edu.cesdega.repository.GroupRepository;
import java.util.ArrayList;
import java.util.List;

public class GroupRepositoryinMemory implements GroupRepository {
    private final List<Group> groups = new ArrayList<>();
    private Long currentId = 1L;

    @Override
    public Group save(Group group) {
        if (group.getGroupId() == null) {
            group.setGroupId(currentId++);
        }
        groups.add(group);
        return group;
    }

    @Override
    public List<Group> findAll() {
        return groups;
    }

    @Override
    public Group findById(Long groupId) {
        for (Group g : groups) {
            if (g.getGroupId().equals(groupId)) {
                return g;
            }
        }
        return null;
    }
}