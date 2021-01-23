package io.viveksolutions.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import io.viveksolutions.databasedemo.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager em;

	public Person findById(int id) {
		return em.find(Person.class, id);
	}

	public Person update(Person person) {
		return em.merge(person);
	}

	public Person insert(Person person) {
		return em.merge(person);
	}

	public void deleteById(int id) {
		Person person = findById(id);
		em.remove(person);
	}

	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = em.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}

}
