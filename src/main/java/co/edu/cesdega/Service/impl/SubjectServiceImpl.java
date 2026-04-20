package co.edu.cesdega.Service.impl;

import co.edu.cesdega.Service.SubjectService;
import co.edu.cesdega.models.Subject;
import co.edu.cesdega.repository.SubjectRepository;
import java.util.List;

public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject crearMateria(Subject subject) {
        if (subject.getName() == null || subject.getName().isEmpty()) {
            System.out.println("Error: El nombre de la materia es obligatorio.");
            return null;
        }
        if (subject.getCredits() <= 0) {
            System.out.println("Error: Los créditos deben ser mayores a 0.");
            return null;
        }
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> listarMaterias() {
        return subjectRepository.findAll();
    }
}