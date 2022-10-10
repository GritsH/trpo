package by.novikgrits.webapp.model.repository;

import by.novikgrits.webapp.model.LotStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotStatusRepository extends CrudRepository<LotStatus, Integer> {
}
