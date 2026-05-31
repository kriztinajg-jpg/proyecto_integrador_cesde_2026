package co.edu.cesdega.Service.impl;

import co.edu.cesdega.Service.StudentService;
import co.edu.cesdega.models.Student;
import co.edu.cesdega.repository.StudentRepository;
// IMPORTANTE: Asegúrate de importar tus nuevas excepciones
import co.edu.cesdega.exceptions.ValidationException;
import co.edu.cesdega.exceptions.ResourceNotFoundException;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student student) {
        // 1. Si el estudiante es nulo o faltan campos, lanzamos excepción de validación
        if (isInvalidStudent(student)) {
            throw new ValidationException("Error de validación: Todos los campos del estudiante (código, documento, nombre, apellido, estado y fecha de nacimiento) son obligatorios.");
        }

        // 2. Si ya existe un estudiante con ese mismo número de documento, lanzamos otra excepción
        if (studentRepository.existsByDocumentNumber(student.getDocumentNumber())) {
            throw new ValidationException("Error: Ya existe un estudiante registrado con el número de documento: " + student.getDocumentNumber());
        }

        return studentRepository.create(student);
    }

    @Override
    public boolean delete(Long studentId) {
        // Si no existe, en vez de solo retornar false, avisamos con propiedad
        if (!studentRepository.existsById(studentId)) {
            throw new ResourceNotFoundException("No se puede eliminar. El estudiante con ID " + studentId + " no existe.");
        }
        return studentRepository.delete(studentId);
    }

    @Override
    public boolean update(Student studentUpdate) {
        // 1. Validamos que los datos nuevos no sean inválidos
        if (isInvalidStudent(studentUpdate)) {
            throw new ValidationException("Error de validación al actualizar: Verifique que ningún campo esté vacío.");
        }

        // 2. Validamos si el estudiante realmente existe
        if (!studentRepository.existsById(studentUpdate.getStudentId())) {
            throw new ResourceNotFoundException("No se puede actualizar. El estudiante con ID " + studentUpdate.getStudentId() + " no existe.");
        }

        return studentRepository.update(studentUpdate);
    }

    @Override
    public Student findById(Long studentId) {
        Student student = studentRepository.findById(studentId);
        // Si el repositorio nos devuelve un null, lanzamos nuestra excepción personalizada
        if (student == null) {
            throw new ResourceNotFoundException("El estudiante con ID " + studentId + " no fue encontrado en el sistema.");
        }
        return student;
    }

    @Override
    public boolean existsByDocumentNumber(String documentNumber) {
        return studentRepository.existsByDocumentNumber(documentNumber);
    }

    @Override
    public List<Student> findAll() {
        // Nota: Aquí luego deberías retornar lo que venga del repo, por ahora lo dejo como lo tenías
        return studentRepository.findAll();
    }

    private boolean isInvalidStudent(Student student){
        return student == null
                || !isNotBlank(student.getCode())
                || !isNotBlank(student.getDocumentNumber())
                || !isNotBlank(student.getFirstName())
                || !isNotBlank(student.getLastName())
                || !isNotBlank(student.getStatus())
                || !isNotBlank(student.getBirthDate());
    }

    private boolean isNotBlank(String values){
        return values != null && !values.isBlank();
    }

    @Override
    public boolean existsById(Long studentId) {
        return studentRepository.existsById(studentId);
    }
}