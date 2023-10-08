package com.app.poseidon.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.poseidon.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>, JpaSpecificationExecutor<User> {

	User findByUsername(String username);

}
