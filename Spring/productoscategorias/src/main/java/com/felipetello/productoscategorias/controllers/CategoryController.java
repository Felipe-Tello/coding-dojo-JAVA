package com.felipetello.productoscategorias.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.felipetello.productoscategorias.models.Category;
import com.felipetello.productoscategorias.models.CategoryProduct;
import com.felipetello.productoscategorias.models.Product;
import com.felipetello.productoscategorias.service.CategoryService;
import com.felipetello.productoscategorias.service.ProductCategoryService;
import com.felipetello.productoscategorias.service.ProductService;

@Controller
public class CategoryController {

	private final CategoryService categoryService;
	private final ProductService productService;
	private final ProductCategoryService productCategoryService;

	public CategoryController(CategoryService categoryService, ProductService productService, ProductCategoryService productCategoryService) {
		this.categoryService = categoryService;
		this.productService = productService;
		this.productCategoryService = productCategoryService;
	}
	
	@GetMapping("/categories/new")
	public String newCategories(@ModelAttribute("categories") Category category) {
		return "newcategory.jsp";
	}
	@PostMapping("/categories/new")
	public String createCategories(@Valid @ModelAttribute("categories") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "newcategory.jsp";
		}
		else {
			categoryService.createCategory(category);
			return "redirect:/categories/new";
		}
	}
	@RequestMapping("/categories/{id}")
	public String details(@PathVariable("id") Long id,@ModelAttribute("prodCat") CategoryProduct categoryProduct, Model model) {
		Category category = categoryService.findCategory(id);
		if (category == null) {
			return "/products/new";
		} else {
			List<Product> product = productService.productsAvailables(category);
			model.addAttribute("productos", product);
			model.addAttribute("category", category);
			return "showcategory.jsp";
		}
	}
	@PostMapping("/categories/{idCategory}")
	public String addProduct(@PathVariable("idCategory") Long idCategory ,@ModelAttribute("prodCat") CategoryProduct categoryProduct, BindingResult result) {
		if (result.hasErrors()) {
			return "showcategory.jsp";
		}
		else {
		Category category = categoryService.findCategory(idCategory);
		categoryProduct.setCategory(category);
		productCategoryService.addThings(categoryProduct);
		return "redirect:/categories/"+idCategory;
		}
	}
}
