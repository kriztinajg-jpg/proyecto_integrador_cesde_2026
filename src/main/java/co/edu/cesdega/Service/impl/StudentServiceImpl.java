package co.edu.cesdega.Service.impl;

import co.edu.cesdega.Service.StudentService;
import co.edu.cesdega.models.Student;
import co.edu.cesdega.repository.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student student) {
        if (isInvalidStudent(student)|| studentRepository.existsByDocumentNumber(student.getDocumentNumber())){
        return null;
    }
    return studentRepository.create(student);
}

    @Override
    public boolean delete(Long studentId) {
        if (studentRepository.existsById(studentId)) {
            return studentRepository.delete(studentId);
        }
        return false;
    }

    @Override
    public boolean update(Student studentUpdate) {
        // 1. Validamos que los datos nuevos no sean inválidos
        if (isInvalidStudent(studentUpdate)) {
            return false;
        }

        // 2. Validamos que el estudiante realmente exista en nuestra "base de datos"
        if (studentRepository.existsById(studentUpdate.getStudentId())) {
            return studentRepository.update(studentUpdate);
        }

        return false;
    }
    @Override
    public Student findById(Long studentId) {
        // que el repo lo busque
        return studentRepository.findById(studentId);
    }

    @Override
    public boolean existsByDocumentNumber(String documentNumber) {
        return studentRepository.existsByDocumentNumber(documentNumber);
    }

    @Override
    public List<Student> findAll() {
        return List.of();
    }
    private boolean isInvalidStudent(Student student){
        return student == null
                ||!isNotBlank(student.getCode())
                ||!isNotBlank(student.getDocumentNumber())
                ||!isNotBlank(student.getFirstName())
                ||!isNotBlank(student.getLastName())
                ||!isNotBlank(student.getStatus())
                ||!isNotBlank(student.getBirthDate());
    }

    private boolean isNotBlank(String values){
        return values != null && !values.isBlank();
    }

    @Override
    public boolean existsById(Long studentId) {
        return studentRepository.existsById(studentId);
    }
    }

