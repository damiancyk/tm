package dmc.tm.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.Repository;

import dmc.tm.entity.Day;

public interface DayDao extends Repository<Day, String> {

	void delete(Day deleted);

	List<Day> findAll();

	Optional<Day> findOne(String id);

	Day save(Day saved);

	@Query(value = "{ $and: [{ idUser: ?0 }, {start: { $gte: ?1, $lte: ?2 }}] }")
	List<Day> find(String idUser, Date start, Date end);

}
