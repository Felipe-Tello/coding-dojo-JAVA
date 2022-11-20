package com.felipetello.templateExamen.repositories;

import org.springframework.stereotype.Repository;

import com.felipetello.templateExamen.models.User;

@Repository
public interface UserRepository extends BaseRepository<User>{
	User findByEmail(String email);
	boolean existsByEmail(String email);
}
