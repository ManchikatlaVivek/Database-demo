package io.viveksolutions.databasedemo;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.viveksolutions.databasedemo.entity.Person;
import io.viveksolutions.databasedemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class SpringJpaDemoApp implements CommandLineRunner {

	@Autowired
	PersonJpaRepository repository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		logger.info("Get User with id 10001 -> {} ", repository.findById(10001));
		
		logger.info("Insert  10004 -> {} ", repository.insert(new Person(10004, "manchu", "thane", new Timestamp(0))));
		logger.info("Update 10003 -> {}", repository.update(new Person(10003, "laxmi", "goa", new Timestamp(0))));
		
		repository.deleteById(10002);
		logger.info("All Users -> {} ", repository.findAll().toString());
	
	}

}
