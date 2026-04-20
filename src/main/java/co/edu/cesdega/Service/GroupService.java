package co.edu.cesdega.Service;

import co.edu.cesdega.models.Group;
import java.util.List;

public interface GroupService {
    Group crearGrupo(Group group);
    List<Group> listarGrupos();
}