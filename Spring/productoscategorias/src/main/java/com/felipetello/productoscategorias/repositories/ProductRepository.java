package com.felipetello.productoscategorias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.felipetello.productoscategorias.models.Category;
import com.felipetello.productoscategorias.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
	List<Product> findByCategoriesNotContaining(Category category);
}
