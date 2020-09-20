package Astrology.data;

import Astrology.Birth_Month;
import org.springframework.data.repository.CrudRepository;

public interface MonthRepository extends CrudRepository<Birth_Month, String> {
}
