package Astrology.data;

import Astrology.Birth_Year;
import org.springframework.data.repository.CrudRepository;

public interface YearRepository extends CrudRepository<Birth_Year, String> {
}
