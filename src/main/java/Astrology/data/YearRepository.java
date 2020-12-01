package Astrology.data;

import Astrology.BirthYear;
import org.springframework.data.repository.CrudRepository;

public interface YearRepository extends CrudRepository<BirthYear, String> {
}
