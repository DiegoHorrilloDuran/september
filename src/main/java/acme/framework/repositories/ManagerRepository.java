package acme.framework.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.entities.Manager;

@Repository
public interface ManagerRepository extends AbstractRepository {

	@Query("select m from Manager m ")
	Collection<Manager> findMany();
	
	@Query("select m from Manager m where m.id = ?1")
	Manager findOneManagerById(int id);
}