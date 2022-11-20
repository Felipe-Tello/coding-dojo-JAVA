package com.felipetello.productoscategorias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.felipetello.productoscategorias.models.Category;
import com.felipetello.productoscategorias.models.Product;
import com.felipetello.productoscategorias.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}
	public Category createCategory(Category c) {
		return categoryRepository.save(c);
	}
	public Category findCategory(Long id) {
		Optional<Category> categoryOptional = categoryRepository.findById(id);
		if(categoryOptional.isPresent()) {
			return categoryOptional.get();
		}
		else {
			return null;
		}
	}
	public List<Category> categoriesAvailables(Product product){
		return categoryRepository.findByProductsNotContaining(product);
	}
}
