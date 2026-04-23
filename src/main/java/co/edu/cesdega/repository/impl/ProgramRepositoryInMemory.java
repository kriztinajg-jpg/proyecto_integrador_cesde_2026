package co.edu.cesdega.repository.impl;

import co.edu.cesdega.models.Program;
import co.edu.cesdega.repository.ProgramRepository;
import java.util.ArrayList;
import java.util.List;

public class ProgramRepositoryInMemory implements ProgramRepository {
    private final List<Program> programs = new ArrayList<>();
    private Long currentId = 1L;

    @Override
    public Program save(Program program) {
        if (program.getProgramId() == null) {
            program.setProgramId(currentId++);
        }
        programs.add(program);
        return program;
    }

    @Override
    public List<Program> findAll() {
        return programs;
    }

    @Override
    public Program findById(Long id) {
        return programs.stream()
                .filter(p -> p.getProgramId().equals(id))
                .findFirst()
                .orElse(null);
    }
}