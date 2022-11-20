package com.felipetello.repasoexamen.repositories;

import org.springframework.stereotype.Repository;

import com.felipetello.repasoexamen.models.User;
@Repository
public interface UserRepository extends BaseRepository<User>{
	User findByEmail(String email);
	boolean existsByEmail(String email);
}
