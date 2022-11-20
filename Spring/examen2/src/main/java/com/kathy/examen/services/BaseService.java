package com.kathy.examen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kathy.examen.repositories.BaseRepository;


@Service
public abstract class BaseService <T>{
   private final BaseRepository<T> baseRepository;

    public BaseService(BaseRepository<T> baseRepository) {
    this.baseRepository = baseRepository;
    }

    public List<T> lista(){
        return baseRepository.findAll();
    }
    
    public T crear(T c) {
        return baseRepository.save(c);
    }
    
    public T findUserById(Long id){
        Optional<T> optional = baseRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }else {
            return null;
        }
    }
    
    public T update(T a) {
         return baseRepository.save(a);
    }
    
    public void delete(T d) {
        baseRepository.delete(d);
    }

}
