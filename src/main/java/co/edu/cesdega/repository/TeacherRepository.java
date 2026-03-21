package co.edu.cesdega.repository;

import co.edu.cesdega.models.Student;
import co.edu.cesdega.models.Teacher;
import java.util.List;


public interface TeacherRepository {
    // Crear: Recibe un objeto  y devuelve  creado
    Teacher create(Teacher teacher);

    // Borrar: Recibe el ID y devuelve si fue exitoso
    boolean delete(Long teacherId);

    // Actualizar: ¡OJO! Recibe  NO un StudentRepository
    boolean update(Teacher teacherUpdate);

    // Buscar por ID
    Teacher findById(Long teacherId);

    // Buscar por documento
    boolean findByDocumentNumber(String documentNumber);

    // Listar todos: Devuelve una lista de objetos
    List<Teacher> findAll();
    boolean existsById(Long teacherId);
}

