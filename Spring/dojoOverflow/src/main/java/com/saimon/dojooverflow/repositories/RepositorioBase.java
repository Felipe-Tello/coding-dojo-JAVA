package com.saimon.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;


@NoRepositoryBean
public interface RepositorioBase<T> extends PagingAndSortingRepository<T, Long>{

	List<T> findAll();
}