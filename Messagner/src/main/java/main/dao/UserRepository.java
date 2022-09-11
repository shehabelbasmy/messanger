package main.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import main.entity.Person;

public interface UserRepository extends JpaRepository<Person, Long> {

	Optional<Person> findByEmail(String email);

	Boolean existsByEmail(String value);

}
