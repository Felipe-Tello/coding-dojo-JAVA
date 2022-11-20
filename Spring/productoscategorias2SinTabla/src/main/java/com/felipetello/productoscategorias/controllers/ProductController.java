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
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newproduct.jsp";
	}
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "newproduct.jsp";
		}
		else {
			productService.createProduct(product);
			return "redirect:/products/"+ product.getId();
		}
	}
	@RequestMapping("/products/{idProduct}")
	public String details(@PathVariable("idProduct") Long idProduct,Model model) {
		Product productor = productService.findProduct(idProduct);
			List<Category> categories = categoryService.categoriesAvailables(productor);
			model.addAttribute("categorias", categories);
			model.addAttribute("product", productor);
			return "showproduct.jsp";
	}
	@PostMapping("/products/{idProduct}")
	public String addCategory(@PathVariable("idProduct") Long idProduct ,@RequestParam("pantillaCategory")Long idCategory) {
		Product product = productService.findProduct(idProduct);
		Category category = categoryService.findCategory(idCategory);
		List<Category> categories = product.getCategories();
		categories.add(category);
		productService.createProduct(product);
		return "redirect:/products/"+idProduct;
	}
}
