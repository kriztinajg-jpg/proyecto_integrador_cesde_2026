package co.edu.cesdega.repository;

import co.edu.cesdega.models.Program;

import java.util.List;

public interface ProgramRepository {


        Program save(Program program);
        List<Program> findAll();
        Program findById(Long id);
    }
