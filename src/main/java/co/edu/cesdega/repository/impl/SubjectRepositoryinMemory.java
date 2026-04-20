package co.edu.cesdega.repository.impl;

import co.edu.cesdega.models.Subject;
import co.edu.cesdega.repository.SubjectRepository;
import java.util.ArrayList;
import java.util.List;

public class SubjectRepositoryinMemory implements SubjectRepository {
    private final List<Subject> subjects = new ArrayList<>();
    private Long currentId = 1L;

    @Override
    public Subject save(Subject subject) {
        if (subject.getSubjectId() == null) {
            subject.setSubjectId(currentId++);
        }
        subjects.add(subject);
        return subject;
    }

    @Override
    public List<Subject> findAll() {
        return subjects;
    }

    @Override
    public Subject findById(Long id) {
        for (Subject s : subjects) {
            if (s.getSubjectId().equals(id)) return s;
        }
        return null;
    }
}