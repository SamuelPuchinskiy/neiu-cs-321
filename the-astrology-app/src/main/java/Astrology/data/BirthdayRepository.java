package Astrology.data;

import Astrology.Birthday;
import org.springframework.data.repository.CrudRepository;

public interface BirthdayRepository extends CrudRepository<Birthday, String> {
}
