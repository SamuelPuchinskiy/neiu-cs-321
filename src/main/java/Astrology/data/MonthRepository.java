package Astrology.data;

import Astrology.BirthMonth;
import org.springframework.data.repository.CrudRepository;

public interface MonthRepository extends CrudRepository<BirthMonth, String> {
    
}
