package co.edu.cesdega.Service.impl;
import co.edu.cesdega.models.Period;
import co.edu.cesdega.repository.PeriodRepository;
import co.edu.cesdega.Service.PeriodService;
import java.util.List;

public class PeriodServiceImpl implements PeriodService {
    private final PeriodRepository periodRepository;

    public PeriodServiceImpl(PeriodRepository periodRepository) {
        this.periodRepository = periodRepository;
    }

    @Override
    public Period save(Period period) { return periodRepository.save(period); }

    @Override
    public List<Period> findAll() { return periodRepository.findAll(); }
}