package co.edu.cesdega.repository;

import co.edu.cesdega.models.Student; // Importamos el MODELO
import java.util.List;

public interface StudentRepository {

    // Crear: Recibe un objeto Student y devuelve el Student creado
    Student create(Student student);

    // Borrar: Recibe el ID y devuelve si fue exitoso
    boolean delete(Long studentId);

    // Actualizar: ¡OJO! Recibe un Student, NO un StudentRepository
    boolean update(Student studentUpdate);

    // Buscar por ID
    Student findById(Long studentId);

    // Buscar por documento
    boolean findByDocumentNumber(String documentNumber);

    // Listar todos: Devuelve una lista de objetos Student
    List<Student> findAll();
    boolean existsById(Long StudentId);
}