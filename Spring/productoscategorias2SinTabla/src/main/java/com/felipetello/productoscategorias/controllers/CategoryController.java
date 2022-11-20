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
import org.springframework.web.bind.annotation.RequestParam;

import com.felipetello.productoscategorias.models.Category;
import com.felipetello.productoscategorias.models.Product;
import com.felipetello.productoscategorias.service.CategoryService;
import com.felipetello.productoscategorias.service.ProductService;

@ControllerImage
public class CategoryController {

	private final CategoryService categoryService;
	private final ProductService productService;

	public CategoryController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;

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
	@RequestMapping("/categories/{idCategory}")
	public String details(@PathVariable("idCategory") Long idCategory, Model model) {
		Category categoryr = categoryService.findCategory(idCategory);
			List<Product> product = productService.productsAvailables(categoryr);
			model.addAttribute("productos", product);
			model.addAttribute("category", categoryr);
			return "showcategory.jsp";
	}
	@PostMapping("/categories/{idCategory}")
	public String addProduct(@PathVariable("idCategory") Long idCategory, @RequestParam("platillaProduct")Long idProduct) {
		Category category = categoryService.findCategory(idCategory);
		Product product = productService.findProduct(idProduct);
		List<Product> productos = category.getProducts();
		productos.add(product);
		categoryService.createCategory(category);
		return "redirect:/categories/"+idCategory;
	}
}
