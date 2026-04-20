package co.edu.cesdega.Service.impl;

import co.edu.cesdega.Service.TeacherService;
import co.edu.cesdega.models.Teacher;
import co.edu.cesdega.repository.TeacherRepository;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {


    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher registrarProfesor(Teacher teacher) {

        if (teacher == null) {
            System.out.println("Error: Los datos del profesor están vacíos.");
            return null;
        }

        if (teacher.getDocumentNumber() == null || teacher.getDocumentNumber().isEmpty()) {
            System.out.println("Error: El profesor debe tener un número de documento.");
            return null;
        }

        if (teacherRepository.findByDocumentNumber(teacher.getDocumentNumber())) {
            System.out.println("Error: Ya existe un profesor registrado con ese documento.");
            return null;
        }

        return teacherRepository.create(teacher);
    }

    @Override
    public List<Teacher> listarProfesores() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher buscarPorId(Long id) {
        if (id == null || id <= 0) {
            return null;
        }
        return teacherRepository.findById(id);
    }

    @Override
    public boolean eliminarProfesor(Long id) {
        if (teacherRepository.existsById(id)) {
            return teacherRepository.delete(id);
        }
        System.out.println("Error: No se puede borrar, el profesor no existe.");
        return false;
    }
}
