package Astrology.data;

import Astrology.Day;
import org.springframework.data.repository.CrudRepository;

public interface DayRepository extends CrudRepository<Day, String> {
}
