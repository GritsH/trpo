package by.novikgrits.webapp.model.repository;

import by.novikgrits.webapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
