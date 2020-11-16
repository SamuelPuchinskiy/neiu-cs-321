package Astrology.data;

import Astrology.Birthday;
import Astrology.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface BirthdayRepository extends CrudRepository<Birthday, String> {

    public List<Birthday> findAllByUser(User user, Pageable pageable);

    public Birthday findById(long id);

    public void deleteById(long id);
}
