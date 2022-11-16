package by.novikgrits.webapp.repository;

import by.novikgrits.webapp.model.Lot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotRepository extends CrudRepository<Lot, Integer> {
}
