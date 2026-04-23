package co.edu.cesdega.repository;
import co.edu.cesdega.models.Period;
import java.util.List;

public interface PeriodRepository {
    Period save(Period period);
    List<Period> findAll();
}