package com.felipetello.dojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseRepository<T> extends PagingAndSortingRepository<T, Long>{
	List<T> findAll();
}
