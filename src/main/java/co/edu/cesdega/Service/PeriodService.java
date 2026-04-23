package co.edu.cesdega.Service;
import co.edu.cesdega.models.Period;
import java.util.List;

public interface PeriodService {
    Period save(Period period);
    List<Period> findAll();
}