package io.viveksolutions.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import io.viveksolutions.databasedemo.entity.Person;

@Repository
public class PersonJdbcDAO {

	@Autowired
	JdbcTemplate jdbctemplate;

	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			return person;
		}

	}

	// select * from Person;
	public List<Person> findAll() {
		return jdbctemplate.query("select * from person", new PersonRowMapper());
	}

	public Person findById(int id) {
		return jdbctemplate.queryForObject(" select * from person where id=? ", new Object[] { id },
				new PersonRowMapper());
	}

	public int deleteById(int id) {
		return jdbctemplate.update("delete from person where id=?", new Object[] { id });
	}

	public int insert(Person person) {
		return jdbctemplate.update("insert into person(id,name,location,birth_date)" + "values(?,?,?,?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(),
						new Timestamp(person.getBirthDate().getTime()) });
	}

	public int update(Person person) {
		return jdbctemplate.update("update person " + " set name=?, location=?, birth_date=? " + " where id=?",
				new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()),
						person.getId() });
	}

}
