package com.felipetello.productoscategorias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.felipetello.productoscategorias.models.Category;
import com.felipetello.productoscategorias.models.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
	List<Product> findByCategoriesNotContaining(Category category);
}
