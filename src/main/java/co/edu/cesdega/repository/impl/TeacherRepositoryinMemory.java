package co.edu.cesdega.repository.impl;

import co.edu.cesdega.models.Teacher;
import co.edu.cesdega.repository.TeacherRepository;
import java.util.ArrayList;
import java.util.List;


public class TeacherRepositoryinMemory implements TeacherRepository {
    
    private List<Teacher> teachers = new ArrayList<>();
    private Long currentId = 1L;

    @Override
    public Teacher create(Teacher teacher) {
        teacher.setUserId(currentId++);
        teachers.add(teacher);
        return teacher;
    }

    @Override
    public boolean delete(Long teacherId) {
        // RemoveIf busca y borra si encuentra el ID, devuelve true si borró algo
        return teachers.removeIf(t -> t.getUserId().equals(teacherId));
    }

    @Override
    public boolean update(Teacher teacherUpdate) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getUserId().equals(teacherUpdate.getUserId())) {
                teachers.set(i, teacherUpdate);
                return true;
            }
        }
        return false;
    }

    @Override
    public Teacher findById(Long teacherId) {
        for (Teacher t : teachers) {
            if (t.getUserId().equals(teacherId)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public boolean findByDocumentNumber(String documentNumber) {
        for (Teacher t : teachers) {
            if (t.getDocumentNumber().equals(documentNumber)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Teacher> findAll() {
        return teachers;
    }

    @Override
    public boolean existsById(Long teacherId) {
        return findById(teacherId) != null;
    }
}