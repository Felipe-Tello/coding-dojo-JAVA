package com.felipetello.productoscategorias.repositories;

import org.springframework.data.repository.CrudRepository;

import com.felipetello.productoscategorias.models.CategoryProduct;

public interface ProductCategoryRepository extends CrudRepository<CategoryProduct, Long>{
}
