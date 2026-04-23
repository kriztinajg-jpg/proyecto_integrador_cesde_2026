package co.edu.cesdega.Service;

import co.edu.cesdega.models.Program;

import java.util.List;

public interface ProgramService {
    Program save(Program program);

    List<Program> findAll();
}
