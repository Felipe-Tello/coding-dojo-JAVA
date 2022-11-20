package com.felipetello.productoscategorias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.felipetello.productoscategorias.models.Category;
import com.felipetello.productoscategorias.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
	List<Category> findByProductsNotContaining(Product product);
}
