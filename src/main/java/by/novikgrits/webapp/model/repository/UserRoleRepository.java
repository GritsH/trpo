package by.novikgrits.webapp.model.repository;

import by.novikgrits.webapp.model.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {
}
