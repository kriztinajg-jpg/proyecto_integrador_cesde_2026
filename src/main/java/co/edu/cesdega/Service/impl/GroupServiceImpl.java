package co.edu.cesdega.Service.impl;

import co.edu.cesdega.Service.GroupService;
import co.edu.cesdega.models.Group;
import co.edu.cesdega.repository.GroupRepository;
import java.util.List;

public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group crearGrupo(Group group) {
        // Validamos que tenga un código y una jornada
        if (group.getCode() == null || group.getCode().isEmpty()) {
            System.out.println("Error: El código del grupo es obligatorio.");
            return null;
        }
        if (group.getShift() == null || group.getShift().isEmpty()) {
            System.out.println("Error: Debe especificar la jornada (Mañana/Tarde/Noche).");
            return null;
        }
        return groupRepository.save(group);
    }

    @Override
    public List<Group> listarGrupos() {
        return groupRepository.findAll();
    }
}