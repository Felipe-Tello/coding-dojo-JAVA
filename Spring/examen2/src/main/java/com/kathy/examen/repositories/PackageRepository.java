package com.kathy.examen.repositories;


import org.springframework.stereotype.Repository;

import com.kathy.examen.models.Pack;

@Repository
public interface PackageRepository extends BaseRepository<Pack>{
    Pack findByNameContaining(String name);
}
