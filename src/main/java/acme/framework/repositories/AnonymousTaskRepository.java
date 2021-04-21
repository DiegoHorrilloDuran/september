package acme.framework.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.entities.Task;

@Repository
public interface AnonymousTaskRepository extends AbstractRepository {

	@Query("select t from Task t where t.privacy = true")
	Collection<Task> findManyPublic();
	
	@Query("select t from Task t where t.id = ?1")
	Task findOneTaskById(int id);
}