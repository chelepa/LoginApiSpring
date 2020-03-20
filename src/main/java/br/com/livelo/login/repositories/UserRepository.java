package br.com.livelo.login.repositories;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.livelo.login.entities.*;

@Repository
public interface UserRepository extends MongoRepository<Users, String>{

	@Query("{ 'login' : ?0 }")
	List<Users> findByLogin(String login);
	
	@Query("{ 'cpf' : ?0 }")
	List<Users> findByCpf(String CPF);
}
