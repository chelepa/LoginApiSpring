package br.com.livelo.login.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.livelo.login.entities.*;

@Repository
public interface UserRepository extends MongoRepository<UsersEntity, String>{

	@Query("{ 'login' : ?0 }")
	UsersEntity findByLogin(String login);
	
	@Query("{ 'cpf' : ?0 }")
	UsersEntity findByCpf(String CPF);
}
