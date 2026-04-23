package co.edu.cesdega.Service.impl;
import co.edu.cesdega.models.Program;
import co.edu.cesdega.repository.ProgramRepository;
import co.edu.cesdega.Service.ProgramService;
import java.util.List;

public class ProgramServiceImpl implements ProgramService {
    private final ProgramRepository programRepository;

    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public Program save(Program program) { return programRepository.save(program); }

    @Override
    public List<Program> findAll() { return programRepository.findAll(); }
}