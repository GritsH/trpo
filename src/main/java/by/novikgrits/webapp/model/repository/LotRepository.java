package by.novikgrits.webapp.model.repository;

import by.novikgrits.webapp.model.Lot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotRepository extends CrudRepository<Lot, Long> {
}
