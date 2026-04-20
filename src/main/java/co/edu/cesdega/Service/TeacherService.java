package co.edu.cesdega.Service;

import co.edu.cesdega.models.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher registrarProfesor(Teacher teacher);

    // Obtener la lista de todos los profes (para el directorio del colegio)
    List<Teacher> listarProfesores();

    // Buscar un profesor específico por su ID
    Teacher buscarPorId(Long id);

    // Eliminar un profesor del sistema
    boolean eliminarProfesor(Long id);
}
