package dmc.tm.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.Repository;

import dmc.tm.entity.Item;

public interface ItemDao extends Repository<Item, String> {

	void delete(Item entity);

	List<Item> findAll();

	Optional<Item> findOne(String id);

	Item save(Item entity);

	@Query(value = "{ $and: [{ idUser: ?0 }, {start: { $gte: ?1, $lte: ?2 }}] }")
	List<Item> find(String idUser, Date start, Date end);

}
