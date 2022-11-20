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
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;
	private final ProductCategoryService productCategoryService;
	
	public ProductController(ProductService productService, CategoryService categoryService, ProductCategoryService productCategoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
		this.productCategoryService = productCategoryService;
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
	@RequestMapping("/products/{id}")
	public String details(@PathVariable("id") Long id, @ModelAttribute("prodCat")CategoryProduct categoryProduct,Model model) {
		Product product = productService.findProduct(id);
		if (product == null) {
			return "/products/new";
		} else {
			List<Category> categories = categoryService.categoriesAvailables(product);
			model.addAttribute("categorias", categories);
			model.addAttribute("product", product);
			return "showproduct.jsp";
		}
	}
	@PostMapping("/products/{idProduct}")
	public String addCategory(@PathVariable("idProduct") Long idProduct ,@ModelAttribute("prodCat") CategoryProduct categoryProduct, BindingResult result) {
		if (result.hasErrors()) {
			return "showproduct.jsp";
		}
		else {
		Product product = productService.findProduct(idProduct);
		categoryProduct.setProduct(product);
		productCategoryService.addThings(categoryProduct);
		return "redirect:/products/"+idProduct;
		}
	}
}
