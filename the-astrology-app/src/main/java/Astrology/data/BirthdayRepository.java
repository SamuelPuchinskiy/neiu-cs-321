package Astrology.data;

import Astrology.Birthday;
import Astrology.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BirthdayRepository extends CrudRepository<Birthday, String> {

    //@Query("Select ALL From Birthday  where Birthday.user = id")
    public List<Birthday> findAllByUser(User user);

}
