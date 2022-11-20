package com.kathy.examen.repositories;

import org.springframework.stereotype.Repository;

import com.kathy.examen.models.User;

@Repository
public interface UserRepository extends BaseRepository<User>{
    User findByEmail(String email);
    Boolean existsByEmail(String email);
}
