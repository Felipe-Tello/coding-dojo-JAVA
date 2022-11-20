package com.felipetello.productoscategorias.service;

import org.springframework.stereotype.Service;

import com.felipetello.productoscategorias.models.CategoryProduct;
import com.felipetello.productoscategorias.repositories.ProductCategoryRepository;

@Service
public class ProductCategoryService {
	private final ProductCategoryRepository productCategoryRepository;
	
	public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
		this.productCategoryRepository = productCategoryRepository;
	}
	public CategoryProduct addThings(CategoryProduct categoryProduct) {
		return productCategoryRepository.save(categoryProduct);
	}
}
