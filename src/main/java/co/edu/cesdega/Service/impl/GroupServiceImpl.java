package co.edu.cesdega.Service.impl;

import co.edu.cesdega.Service.GroupService;
import co.edu.cesdega.models.Group;
import co.edu.cesdega.repository.GroupRepository;
// Importamos tus excepciones personalizadas
import co.edu.cesdega.exceptions.ValidationException;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group crearGrupo(Group group) {
        // 1. VALIDACIÓN: Que el objeto no sea nulo por completo
        if (group == null) {
            throw new ValidationException("Error: Los datos del grupo no pueden estar vacíos.");
        }

        // 2. VALIDACIÓN: El código es obligatorio
        if (group.getCode() == null || group.getCode().trim().isEmpty()) {
            throw new ValidationException("Error de validación: El código del grupo es obligatorio.");
        }

        // 3. VALIDACIÓN: La jornada (shift) es obligatoria
        if (group.getShift() == null || group.getShift().trim().isEmpty()) {
            throw new ValidationException("Error de validación: Debe especificar la jornada (Mañana/Tarde/Noche).");
        }

        System.out.println("[SERVICIO] Grupo creado con éxito: " + group.getCode());
        return groupRepository.save(group);
    }

    @Override
    public List<Group> listarGrupos() {
        return groupRepository.findAll();
    }
}