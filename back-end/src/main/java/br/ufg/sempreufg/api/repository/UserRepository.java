package br.ufg.sempreufg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.sempreufg.api.security.entity.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User u where u.email = ?1")
	User findByEmail(String email);

}
