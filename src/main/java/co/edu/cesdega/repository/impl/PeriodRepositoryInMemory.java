package co.edu.cesdega.repository.impl;

import co.edu.cesdega.models.Period;
import co.edu.cesdega.repository.PeriodRepository;
import java.util.ArrayList;
import java.util.List;

public class PeriodRepositoryInMemory implements PeriodRepository {
    private final List<Period> periods = new ArrayList<>();
    private Long currentId = 1L;

    @Override
    public Period save(Period period) {
        if (period.getPeriodId() == null) {
            period.setPeriodId(currentId++);
        }
        periods.add(period);
        return period;
    }

    @Override
    public List<Period> findAll() {
        return periods;
    }
}