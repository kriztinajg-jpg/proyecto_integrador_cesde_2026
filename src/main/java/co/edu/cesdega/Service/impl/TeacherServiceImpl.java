package co.edu.cesdega.Service.impl;

import co.edu.cesdega.Service.TeacherService;
import co.edu.cesdega.models.Teacher;
import co.edu.cesdega.repository.TeacherRepository;
import co.edu.cesdega.exceptions.ValidationException;
import co.edu.cesdega.exceptions.ResourceNotFoundException;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher registrarProfesor(Teacher teacher) {
        // 1. Validación: Datos nulos
        if (teacher == null) {
            throw new ValidationException("Error: Los datos del profesor están vacíos.");
        }

        // 2. Validación: Documento vacío
        if (teacher.getDocumentNumber() == null || teacher.getDocumentNumber().trim().isEmpty()) {
            throw new ValidationException("Error de validación: El profesor debe tener un número de documento.");
        }

        if (teacherRepository.findByDocumentNumber(teacher.getDocumentNumber())) {
            throw new ValidationException("Error: Ya existe un profesor registrado con el documento " + teacher.getDocumentNumber());
        }

        System.out.println("[SERVICIO] Profesor registrado con éxito: " + teacher.getFirstName());
        return teacherRepository.create(teacher); // Mantiene tu método .create() original
    }

    @Override
    public List<Teacher> listarProfesores() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher buscarPorId(Long id) {
        // Validación de ID inválido
        if (id == null || id <= 0) {
            throw new ValidationException("Error: El ID ingresado (" + id + ") no es válido.");
        }

        Teacher teacher = teacherRepository.findById(id);

        // Si no se encuentra en el repositorio, disparamos nuestra excepción personalizada
        if (teacher == null) {
            throw new ResourceNotFoundException("El profesor con ID " + id + " no existe en el sistema.");
        }

        return teacher;
    }

    @Override
    public boolean eliminarProfesor(Long id) {
        if (teacherRepository.existsById(id)) {
            return teacherRepository.delete(id);
        }
        // En lugar de un print silencioso, lanzamos la excepción de que no existe
        throw new ResourceNotFoundException("Error: No se puede borrar, el profesor con ID " + id + " no existe.");
    }
}