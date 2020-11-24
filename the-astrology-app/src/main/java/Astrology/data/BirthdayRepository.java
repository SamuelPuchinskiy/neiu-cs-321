package Astrology.data;

import Astrology.Birthday;
import Astrology.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface BirthdayRepository extends CrudRepository<Birthday, String> {
    List<Birthday> findAllByUser(User user, Pageable pageable);
    Birthday findById(long id);
}
