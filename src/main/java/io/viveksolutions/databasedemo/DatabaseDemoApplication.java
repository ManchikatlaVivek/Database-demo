package io.viveksolutions.databasedemo;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.viveksolutions.databasedemo.entity.Person;
import io.viveksolutions.databasedemo.jdbc.PersonJdbcDAO;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	@Autowired
	PersonJdbcDAO dao;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("All Users -> {} ", dao.findAll().toString());
		logger.info("Get User with id 10001 -> {} ", dao.findById(10001));
		logger.info("Delete user with id 10002 -> Number of rows deleted {} ", dao.deleteById(10002));
		logger.info("Insert  10004 -> {} ", dao.insert(new Person(10004, "manchu", "thane", new Timestamp(0))));
		logger.info("Update 10003 -> {}", dao.update(new Person(10003, "laxmi", "goa", new Timestamp(0))));
	}

}
